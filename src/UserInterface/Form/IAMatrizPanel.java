package UserInterface.Form;

import javax.swing.*;

import BussinessLogic.IAMatrizBL;
import DataAccess.DTO.IAMatrizDTO;


import UserInterface.PTStyleUI;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IAMatrizPanel extends JPanel implements ActionListener {
    private Integer idIAMatriz = 0, idMaxIAMatriz=0;
    private IAMatrizBL iAMatrizBL = null;
    private IAMatrizDTO iAMatriz = null;

    public IAMatrizPanel() {
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
        idIAMatriz      = 1;
        iAMatrizBL      = new IAMatrizBL();
        iAMatriz        = iAMatrizBL.getBy(idIAMatriz);
        idMaxIAMatriz   = iAMatrizBL.getMaxRow();
    }

    private void showRow() {
        boolean iaMatrizNull = (iAMatriz == null);
        txtIdHormigaTipo.setText((iaMatrizNull) ? " " : iAMatriz.getIdIAMatriz().toString());
        txtNombre.setText((iaMatrizNull) ? " " : iAMatriz.getNombre());
        lblTotalReg.setText(idIAMatriz.toString() + " de " + idMaxIAMatriz.toString());
    }

    private void btnNuevoClick() {
        iAMatriz = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean iaMatrizNull = (iAMatriz == null);
        try {
            if (PTStyleUI.showConfirmYesNo("¿Seguro que desea " + ((iaMatrizNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (iaMatrizNull)
                    iAMatriz = new IAMatrizDTO(txtNombre.getText());
                else
                    iAMatriz.setNombre(txtNombre.getText());
    
                if(!((iaMatrizNull) ? iAMatrizBL.create(iAMatriz) : iAMatrizBL.update(iAMatriz)))
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

                if (!iAMatrizBL.delete(iAMatriz.getIdIAMatriz()))
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
            if(iAMatriz == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idIAMatriz = 1;
        if (e.getSource() == btnRowAnt && (idIAMatriz > 1))
            idIAMatriz--;
        if (e.getSource() == btnRowSig && (idIAMatriz < idMaxIAMatriz))
            idIAMatriz++;
        if (e.getSource() == btnRowFin)
            idIAMatriz = idMaxIAMatriz;
        try {
            iAMatriz    = iAMatrizBL.getBy(idIAMatriz);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre"};
        Object[][] data = new Object[iAMatrizBL.getAll().size()][2];
        int index = 0;
        for (IAMatrizDTO s : iAMatrizBL.getAll()) {
            data[index][0] = s.getIdIAMatriz();
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
                    String strIdMatriz = table.getModel().getValueAt(row, 0).toString();
                    idIAMatriz = Integer.parseInt(strIdMatriz);
                    try {
                        iAMatriz = iAMatrizBL.getBy(idIAMatriz);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdMatriz);
                }
            }
        });
    }

/***************************
 * FormDesing : mateitopro *
 ***************************/ 
    private PatLabel 
            lblTitulo          = new PatLabel("IAMatriz"),
            lblIdHormigaTipo   = new PatLabel(" Codigo:      "),
            lblNombre          = new PatLabel("*Descripción: "),
            lblTotalReg        = new PatLabel(" 0 de 0 ");
    private PatTextBox 
            txtIdHormigaTipo   = new PatTextBox(),
            txtNombre          = new PatTextBox();
    private PatButton 
            btnPageIni  = new PatButton(" |< "),
            btnPageAnt  = new PatButton(" << "),
            btnPageSig  = new PatButton(" >> "),
            btnPageFin  = new PatButton(" >| "),

            btnRowIni   = new PatButton(" |< "),
            btnRowAnt   = new PatButton(" << "),
            btnRowSig   = new PatButton(" >> "),
            btnRowFin   = new PatButton(" >| "),

            btnNuevo    = new PatButton("Nuevo"),
            btnGuardar  = new PatButton("Guardar"),
            btnCancelar = new PatButton("Cancelar"),
            btnEliminar = new PatButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdHormigaTipo.setEnabled(false);
        txtIdHormigaTipo.setBorderLine();
        txtNombre.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new PatLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new PatLabel(" ) "));
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
        add(lblIdHormigaTipo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdHormigaTipo, gbc);

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
