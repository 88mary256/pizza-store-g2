package pizzeria.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    
    public Frame() {
	Toolkit myScreen = Toolkit.getDefaultToolkit();
	Dimension sizeScreen = myScreen.getScreenSize();
	setBounds(sizeScreen.width/8,sizeScreen.height/8,sizeScreen.width/2,sizeScreen.height/2);
	//setResizable(false);
	//setExtendedState(JFrame.MAXIMIZED_BOTH);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Jala Pizza Co.");
	Image favicon = myScreen.getImage("resources/favicon.png");
	setIconImage(favicon);
	Panel main = new Panel();
	add(main);
    }

}
