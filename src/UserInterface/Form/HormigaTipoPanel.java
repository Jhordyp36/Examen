/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| mateo.simbana@epn.edu.ec   mateitopro  |
|----------------------------------------|
Autor: mateitopro
Fecha: 26.feb.2k24
Script: Creacion de la clase HormigaTipoPanel
*/
package UserInterface.Form;

import javax.swing.*;

import BussinessLogic.HormigaTipoBL;
import DataAccess.DTO.HormigaTipoDTO;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.PTStyleUI;
import UserInterface.CustomerControl.PatTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HormigaTipoPanel extends JPanel implements ActionListener {
    private Integer       idHormigaTipo    = 0,
                          idMaxHormigaTipo = 0;
    private HormigaTipoBL  htBL;
    private HormigaTipoDTO htDTO;

    public HormigaTipoPanel(){
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> btnNuevoClick());
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            PTStyleUI.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        idHormigaTipo = 1;
        htBL       = new HormigaTipoBL();
        htDTO         = htBL.readBy(idHormigaTipo);
        idMaxHormigaTipo    = htBL.getMaxRow();
    }

    private void showRow() {
        boolean regaloTipoNull = (htDTO == null);
        txtIdRegaloTipo.setText((regaloTipoNull) ? " " : htDTO.getIdHormigaTipo().toString());
        txtNombre.setText((regaloTipoNull) ? " " : htDTO.getNombre());
        lblTotalReg.setText(idHormigaTipo.toString() + " de " + idMaxHormigaTipo.toString());
    }
    
    private void btnNuevoClick() {
        htDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean regaloTipoNull = (htDTO == null);
        try {
            if (PTStyleUI.showConfirmYesNo("¿Seguro que desea " + ((regaloTipoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (regaloTipoNull)
                    htDTO = new HormigaTipoDTO(txtNombre.getText());
                else
                    htDTO.setNombre(txtNombre.getText());
    
                if(!((regaloTipoNull) ? htBL.create(htDTO) : htBL.update(htDTO)))
                    PTStyleUI.showMsgError("Error al guardar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            PTStyleUI.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (PTStyleUI.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!htBL.delete(htDTO.getIdHormigaTipo()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            PTStyleUI.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(htDTO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idHormigaTipo = 1;
        if (e.getSource() == btnRowAnt && (idHormigaTipo > 1))
            idHormigaTipo--;
        if (e.getSource() == btnRowSig && (idHormigaTipo < idMaxHormigaTipo))
            idHormigaTipo++;
        if (e.getSource() == btnRowFin)
            idHormigaTipo = idMaxHormigaTipo;
        try {
            htDTO    = htBL.readBy(idHormigaTipo);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Estado"};
        Object[][] data = new Object[htBL.readAll().size()][2];
        int index = 0;
        for (HormigaTipoDTO s : htBL.readAll()) {
            data[index][0] = s.getIdHormigaTipo();
            data[index][1] = s.getNombre();
            // data[index][2] = s.getEstado();
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strIdSexo = table.getModel().getValueAt(row, 0).toString();
                    idHormigaTipo = Integer.parseInt(strIdSexo);
                    try {
                        htDTO = htBL.readBy(idHormigaTipo);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdSexo);
                }
            }
        });
    }
/***************************
 * FormDesing : mateitopro *
 ***************************/ 
    private Label 
            lblTitulo       = new Label("RegaloTipo"),
            lblIdRegaloTipo = new Label(" Codigo:      "),
            lblNombre       = new Label("Nombre: "),
            lblTotalReg     = new Label(" 0 de 0 ");
    private PatTextBox 
            txtIdRegaloTipo = new PatTextBox(),
            txtNombre       = new PatTextBox();
    private Button 
            btnPageIni  = new Button(" |< "),
            btnPageAnt  = new Button(" << "),
            btnPageSig  = new Button(" >> "),
            btnPageFin  = new Button(" >| "),

            btnRowIni   = new Button(" |< "),
            btnRowAnt   = new Button(" << "),
            btnRowSig   = new Button(" >> "),
            btnRowFin   = new Button(" >| "),

            btnNuevo    = new Button("Nuevo"),
            btnGuardar  = new Button("Guardar"),
            btnCancelar = new Button("Cancelar"),
            btnEliminar = new Button("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdRegaloTipo.setEnabled(false);
        txtIdRegaloTipo.setBorderLine();
        txtNombre.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new Label(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new Label(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(PTStyleUI.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdRegaloTipo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdRegaloTipo, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}
