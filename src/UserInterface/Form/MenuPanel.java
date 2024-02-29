package UserInterface.Form;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import UserInterface.CustomerControl.PatButton;

public class MenuPanel extends JPanel {
    //crear boton de acuerdo a lo q se necesite 
    public PatButton 
            btn_Home            = new PatButton("Home"),
<<<<<<< HEAD
            btn_AntBot          = new PatButton("AntBot"),
            btn_HormigaTipo     = new PatButton("HormigaTipo"),
            btn_Citas           = new PatButton("Citas"),
            btn_Regalo          = new PatButton("Regalos"),
            btn_RegaloTipo      = new PatButton("Tipos de Regalo"),
            btn_Persona         = new PatButton("Usuarios"),
            btn_Sexo            = new PatButton("Generos"),
            btn_EnviarRegalo    = new PatButton("Enviar Regalo"),
            btn_RelacionTipo    = new PatButton("Tipos de Relaciones"),
            btn_Relacion        = new PatButton("Relaciones"),
            btn_PersonaRol      = new PatButton("Roles"), 
            btn_IAMatriz        = new PatButton("IAMatriz");
=======
            btn_IAMatriz        = new PatButton("IAMatriz"),
<<<<<<< HEAD
            btn_PersonaSexo     = new PatButton("PersonaSexo"),
            btn_PersonaTipo     = new PatButton("PersonaTipo");
=======
            btn_PersonaSexo     = new PatButton("PersonaSexo");
>>>>>>> fa7cfe9d372f2a06c85b6cba6380ed8e8f7ce2d9
>>>>>>> a38aecce5a2c1342db53d89d4a1b0951cd3fdfd1

            //btn_Home.setIcon("/Resource/"); 
            public MenuPanel(){
                customizeComponent();
            }
        
            private void customizeComponent() {
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                setPreferredSize(new Dimension(250, getHeight())); 
        
                // add-logo

                // try {
                    // Image logo = ImageIO.read(PTStyleUI.);
                    // logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    // add(new JLabel(new ImageIcon(logo)));
                // } catch (IOException e) {
                    // e.printStackTrace();
                // }
        
                // add-botones

                add(btn_Home);
                add(btn_AntBot);
                add(btn_HormigaTipo);
                add(btn_Persona);
                add(btn_Sexo);
                add(btn_PersonaRol);
                add(btn_Citas);
                add(btn_RegaloTipo);
                add(btn_Regalo);
                add(btn_EnviarRegalo);
                add(btn_RelacionTipo);
                add(btn_Relacion);
                add(btn_IAMatriz);
                add(btn_PersonaSexo);
                add(btn_PersonaTipo);


                // add-copyright
                //add(new JLabel("\u00A9 2024 pat_mic"));
            }



}
