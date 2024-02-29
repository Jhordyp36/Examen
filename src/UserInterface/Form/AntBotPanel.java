/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| edison.vera02@epn.edu.ec   dsn_vr      |
|----------------------------------------|
Autor: dsn_vr
Fecha: 26.feb.2k24
src: Creacion de la clase AntBotPanel
*/
package UserInterface.Form;

import javax.swing.*;

import BussinessLogic.AntBotBL;
import DataAccess.DTO.AntBotDTO;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
// import UserInterface.CustomerControl.PatStyle;
import UserInterface.CustomerControl.PatTextBox;
import UserInterface.PAStyle;
import UserInterface.PTStyleUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AntBotPanel extends JPanel implements ActionListener {
    private Integer       idAntBot    = 0,
                          idMaxAntBot = 0;
    private AntBotBL  abBL;
    private AntBotDTO abDTO;

    public AntBotPanel(){
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
        idAntBot = 1;
        abBL       = new AntBotBL();
        abDTO         = abBL.getBy(idAntBot);
        // idMaxAntBot    = abBL.getMaxRow();
    }

    private void showRow() {
        boolean regaloTipoNull = (abDTO == null);
        txtIdAntBot.setText((regaloTipoNull) ? " " : abDTO.getIdAntBot().toString());
        txtNombre.setText((regaloTipoNull) ? " " : abDTO.getNombre());
        txtIdHormiga.setText((regaloTipoNull) ? " " : abDTO.getIdHormiga().toString());
        txtIdIaMatriz.setText((regaloTipoNull) ? " " : abDTO.getIdIAMatriz().toString());
        txtIdExpertoIngles.setText((regaloTipoNull) ? " " : abDTO.getIdExpertoIngles().toString());
        txtIdExpertoRuso.setText((regaloTipoNull) ? " " : abDTO.getIdExpertoRuso().toString());
        lblTotalReg.setText(idAntBot.toString() + " de " + idMaxAntBot.toString());
    }
    
    private void btnNuevoClick() {
        abDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean regaloTipoNull = (abDTO == null);
        Integer auxIdHor = Integer.parseInt(txtIdHormiga.getText());
        Integer auxIdMatr = Integer.parseInt(txtIdIaMatriz.getText());
        Integer auxIdExpIng = Integer.parseInt(txtIdExpertoIngles.getText());
        Integer auxIdExpRus = Integer.parseInt(txtIdExpertoRuso.getText());
        try {
            if (PTStyleUI.showConfirmYesNo("¿Seguro que desea " + ((regaloTipoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (regaloTipoNull)
                    abDTO = new AntBotDTO(auxIdHor, auxIdMatr, auxIdExpIng, auxIdExpRus, txtNombre.getText());
                else
                    abDTO.setNombre(txtNombre.getText());
                    abDTO.setIdHormiga(auxIdHor);
                    abDTO.setIdIAMatriz(auxIdMatr);
                    abDTO.setIdExpertoIngles(auxIdExpIng);
                    abDTO.setIdExpertoRuso(auxIdExpRus);
                if(!((regaloTipoNull) ? abBL.add(abDTO) : abBL.update(abDTO)))
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

                if (!abBL.delete(abDTO.getIdAntBot()))
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
            if(abDTO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idAntBot = 1;
        if (e.getSource() == btnRowAnt && (idAntBot > 1))
            idAntBot--;
        if (e.getSource() == btnRowSig && (idAntBot < idMaxAntBot))
            idAntBot++;
        if (e.getSource() == btnRowFin)
            idAntBot = idMaxAntBot;
        try {
            abDTO    = abBL.getBy(idAntBot);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "IdHorimiga", "IdIaMatriz", "IdExpertoIngles", "IdExpertoRuso"};
        Object[][] data = new Object[abBL.getAll().size()][6];
        int index = 0;
        for (AntBotDTO s : abBL.getAll()) {
            data[index][0] = s.getIdAntBot();
            data[index][1] = s.getNombre();
            data[index][2] = s.getIdHormiga();
            data[index][3] = s.getIdIAMatriz();
            data[index][4] = s.getIdExpertoIngles();
            data[index][5] = s.getIdExpertoRuso();
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
                    String strIdAntBot = table.getModel().getValueAt(row, 0).toString();
                    idAntBot = Integer.parseInt(strIdAntBot);
                    try {
                        abDTO = abBL.getBy(idAntBot);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdAntBot);
                }
            }
        });
    }
/***************************
 * FormDesing : mateitopro *
 ***************************/ 
    private Label 
            lblTitulo           = new Label("RegaloTipo"),
            lblIdAntBot         = new Label(" Codigo:      "),
            lblNombre           = new Label("Nombre: "),
            lblIdHormiga        = new Label("Hormiga: "),
            lblIdIaMatriz       = new Label("IA Matriz: "),
            lblIdExpertoIngles  = new Label("Experto Ingles: "),
            lblIdExpertoRuso    = new Label("Experto Ruso: "),
            lblTotalReg         = new Label(" 0 de 0 ");
    PatTextBox 
            txtIdAntBot     = new PatTextBox(),
            txtNombre           = new PatTextBox(),
            txtIdHormiga        = new PatTextBox(),
            txtIdIaMatriz       = new PatTextBox(),
            txtIdExpertoIngles  = new PatTextBox(),
            txtIdExpertoRuso    = new PatTextBox();
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
        
        txtIdAntBot.setEnabled(false);
        txtIdAntBot.setBorderLine();
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
        add(lblIdAntBot, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdAntBot, gbc);

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
        add(lblIdHormiga, gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdHormiga, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        add(lblIdIaMatriz, gbc);
        gbc.gridy = 8;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdIaMatriz, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(lblIdExpertoIngles, gbc);
        gbc.gridy = 9;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(lblIdExpertoIngles ,gbc);

        gbc.gridy = 10;
        gbc.gridx = 0;
        add(lblIdExpertoRuso, gbc);
        gbc.gridy = 10;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdExpertoRuso, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}
