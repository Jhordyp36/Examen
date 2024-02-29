package UserInterface.GUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlMenu extends JFrame {
    private JLabel imagenLabel;

    public PnlMenu() {
        setTitle("PoliMenú");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Hacer que la ventana no sea redimensionable

        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/UserInterface/Resource/Logo.png"));
        setIconImage(icono);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        placeComponents(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new BorderLayout());

        // Panel izquierdo para botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Usar BoxLayout con alineación vertical

        // Agregar espacio a la izquierda
        panelBotones.add(Box.createRigidArea(new Dimension(20, 0)));

        // Agregar espaciador en la parte superior
        panelBotones.add(Box.createVerticalStrut(20));

        JButton buscarCitaButton = new JButton("Buscar Cita");
        estiloBoton(buscarCitaButton);
        buscarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad: Buscar Cita");
            }
        });
        panelBotones.add(buscarCitaButton);

        // Agregar espacio entre los botones con centrado vertical
        panelBotones.add(Box.createVerticalStrut(10)); // Ajusta el tamaño del espacio entre los botones

        JButton enviarRegaloButton = new JButton("Enviar Regalo");
        estiloBoton(enviarRegaloButton);
        enviarRegaloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad: Enviar Regalo");
            }
        });
        panelBotones.add(enviarRegaloButton);

        // Agregar espacio entre los botones con centrado vertical
        panelBotones.add(Box.createVerticalStrut(10)); // Ajusta el tamaño del espacio entre los botones

        JButton cerrarSesionButton = new JButton("Cerrar Sesión");
        estiloBoton(cerrarSesionButton);
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad: Cerrar Sesión");
                // Aquí podrías realizar las acciones necesarias para cerrar la sesión.
                // Por ejemplo, cerrar la ventana actual y mostrar la pantalla de inicio de sesión.
            }
        });
        panelBotones.add(cerrarSesionButton);

        // Agregar espaciador en la parte inferior
        panelBotones.add(Box.createVerticalStrut(20));

        // Agregar panel de botones al lado izquierdo
        panel.add(panelBotones, BorderLayout.WEST);

        // Panel derecho para la imagen
        JPanel panelImagen = new JPanel();
        imagenLabel = new JLabel();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/UserInterface/Resource/ImgMenu2.jpg")); // Usa getResource
        if (imagen.getImageLoadStatus() == MediaTracker.COMPLETE) {
            // La imagen se cargó correctamente
            imagen.setImage(imagen.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)); // Ajusta el tamaño de la imagen
            imagenLabel.setIcon(imagen);
            panelImagen.add(imagenLabel);
        } else {
            // Hubo un error al cargar la imagen
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Agregar panel de imagen al lado derecho
        panel.add(panelImagen, BorderLayout.EAST);
    }

    private void estiloBoton(JButton button) {
        button.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinear los botones a la izquierda
        button.setPreferredSize(new Dimension(150, 40)); // Establecer el tamaño preferido
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height)); // Hacer que todos los botones tengan el mismo ancho
        button.setFont(new Font("Arial", Font.PLAIN, 14));
    }
}
