package UserInterface.CustomerControl;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import UserInterface.PTStyleUI;

import javax.swing.ImageIcon;

public class PatButton extends  JButton implements MouseListener {
    public PatButton(String text){
        customizeComponent(text);
    }
    public PatButton(String text, String iconPath){
        customizeComponent(text, iconPath);
    }

    public void customizeComponent(String text, String iconPath){ 
        
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 90, 20); 
        
        setIcon(new ImageIcon(iconPath));
        setFont(PTStyleUI.FONT_TEXT);
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(PTStyleUI.COLOR_FONT);
        setHorizontalAlignment(PTStyleUI.ALIGNMENT_RIGHT);
        setFont(PTStyleUI.FONT_TEXT);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void setIcon(String iconPath){
        
    } 
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
