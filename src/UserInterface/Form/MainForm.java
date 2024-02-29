package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainForm extends JFrame{
    MenuPanel pnlMenu = new MenuPanel();
    JPanel pnlMain      = new MainPanel();
    
    public MainForm(String tilteApp) {
        customizeComponent(tilteApp);
        
        pnlMenu.btn_Home.addActionListener       (e -> setPanel(new MainPanel())); 

        pnlMenu.btn_AntBot.addActionListener  (e -> setPanel (new AntBotPanel()));
        pnlMenu.btn_HormigaTipo.addActionListener  (e -> setPanel (new HormigaTipoPanel()));
        //pnlMenu.btn_Regalo.addActionListener  (e -> setPanel (new RegaloPanel()));
        //pnlMenu.btn_RegaloTipo.addActionListener  (e -> setPanel (new RegaloTipoPanel()));
        // //pnlMenu.btn_Persona.addActionListener  (e -> setPanel (new PersonaPanel()));
        // pnlMenu.btn_Sexo.addActionListener  (e -> setPanel (new SexoPanel()));
        // pnlMenu.btn_EnviarRegalo.addActionListener  (e -> setPanel (new EnviarRegaloPanel()));
        //pnlMenu.btn_RelacionTipo.addActionListener  (e -> setPanel (new RelacionTipoPanel()));
        //pnlMenu.btn_Relacion.addActionListener  (e -> setPanel (new RelacionPanel()));
        //pnlMenu.btn_PersonaRol.addActionListener  (e -> setPanel (new PersonaRolPanel()));
        //agregar
        pnlMenu.btn_IAMatriz.addActionListener(e -> setPanel(new IAMatrizPanel()));
        pnlMenu.btn_PersonaSexo.addActionListener(e -> setPanel(new PersonaSexoPanel()));
        pnlMenu.btn_PersonaTipo.addActionListener(e -> setPanel(new PersonaTipoPanel()));
    }
    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void  customizeComponent(String title){
        this.setTitle(title);
        this.setSize(1000,850);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contenedorPrincipal =this.getContentPane();
        contenedorPrincipal.setLayout (new BorderLayout());
        contenedorPrincipal.add(pnlMenu , BorderLayout.WEST );
        contenedorPrincipal.add(pnlMain , BorderLayout.CENTER); 

        setVisible(true);
    }
}
