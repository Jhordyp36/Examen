package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import UserInterface.PTStyleUI;

public class PatLabel extends JLabel{
    public PatLabel(){
        customizeComponent();
    }
    public PatLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), PTStyleUI.FONT_TEXT, PTStyleUI.COLOR_FONT_LIGHT, PTStyleUI.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}