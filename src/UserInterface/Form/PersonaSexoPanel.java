package UserInterface.Form;

import javax.swing.*;

import BussinessLogic.PersonaSexoBL;
import DataAccess.DTO.PersonaSexoDTO;
import UserInterface.PTStyleUI;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonaSexoPanel extends JPanel implements ActionListener {
    private Integer idPersonaSexo = 0, idMaxPersonaSexo=0;
    private PersonaSexoBL personaSexoBL = null;
    private PersonaSexoDTO personaSexo = null;

    public PersonaSexoPanel() {
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
        idPersonaSexo      = 1;
        personaSexoBL      = new PersonaSexoBL();
        personaSexo        = personaSexoBL.readBy(idPersonaSexo);
        idMaxPersonaSexo   = personaSexoBL.getMaxRow();
    }

    private void showRow() {
        boolean personaSexoNull = (personaSexo == null);
        txtIdSexo.setText((personaSexoNull) ? " " : personaSexo.getIdPersonaSexo().toString());
        txtNombre.setText((personaSexoNull) ? " " : personaSexo.getNombre());
        lblTotalReg.setText(idPersonaSexo.toString() + " de " + idMaxPersonaSexo.toString());
    }

    private void btnNuevoClick() {
        personaSexo = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean personaSexoNull = (personaSexo == null);
        try {
            if (PTStyleUI.showConfirmYesNo("¿Seguro que desea " + ((personaSexoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
                if (personaSexoNull)
                    personaSexo = new PersonaSexoDTO(txtNombre.getText());
                else
                    personaSexo.setNombre(txtNombre.getText());
    
                if(!((personaSexoNull) ? personaSexoBL.create(personaSexo) : personaSexoBL.update(personaSexo)))
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

                if (!personaSexoBL.delete(personaSexo.getIdPersonaSexo()))
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
            if(personaSexo == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idPersonaSexo = 1;
        if (e.getSource() == btnRowAnt && (idPersonaSexo > 1))
            idPersonaSexo--;
        if (e.getSource() == btnRowSig && (idPersonaSexo < idMaxPersonaSexo))
            idPersonaSexo++;
        if (e.getSource() == btnRowFin)
            idPersonaSexo = idMaxPersonaSexo;
        try {
            personaSexo    = personaSexoBL.readBy(idPersonaSexo);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Nombre", "Estado"};
        Object[][] data = new Object[personaSexoBL.readAll().size()][3];
        int index = 0;
        for (PersonaSexoDTO s : personaSexoBL.readAll()) {
            data[index][0] = s.getIdPersonaSexo();
            data[index][1] = s.getNombre();
            data[index][2] = s.getEstado();
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
                    idPersonaSexo = Integer.parseInt(strIdMatriz);
                    try {
                        personaSexo = personaSexoBL.readBy(idPersonaSexo);
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
            lblTitulo   = new PatLabel("PersonaSexo"),
            lblIdSexo   = new PatLabel(" Codigo:      "),
            lblNombre   = new PatLabel("*Descripción: "),
            lblTotalReg = new PatLabel(" 0 de 0 ");
    private PatTextBox 
            txtIdSexo   = new PatTextBox(),
            txtNombre   = new PatTextBox();
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
        
        txtIdSexo.setEnabled(false);
        txtIdSexo.setBorderLine();
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
        add(lblIdSexo, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdSexo, gbc);

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
