package UserInterface.GUI;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SplashScreen extends JWindow {
    private final int duration;

    public SplashScreen(int duration) {
        this.duration = duration;
    }

    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        int width = 425;
        int height = 600;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        JLabel label = new JLabel(new ImageIcon(getSplashImage()));
        content.add(label, BorderLayout.CENTER);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        content.add(progressBar, BorderLayout.SOUTH);

        content.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        setVisible(true);

        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(duration / 100);
                progressBar.setValue(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
    }

    private Image getSplashImage() {
        // Cambia la ubicación y el nombre del archivo de imagen según tu necesidad
        URL imageURL = getClass().getResource("/UserInterface/Resources/Img/Splash.jpg");
        if (imageURL != null) {
            return new ImageIcon(imageURL).getImage();
        } else {
            System.err.println("No se puede cargar la imagen de splash.");
            return null;
        }
    }
}
