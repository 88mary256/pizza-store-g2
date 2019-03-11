package pizzeria.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        final Toolkit myScreen = Toolkit.getDefaultToolkit();
        final Dimension sizeScreen = myScreen.getScreenSize();
        setBounds(sizeScreen.width / 8, sizeScreen.height / 8,
                sizeScreen.width / 2, sizeScreen.height / 4);
        setResizable(true);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Jala Pizza Co.");
        final Image favicon = myScreen.getImage("resources/favicon.png");
        setIconImage(favicon);
        final Paneles main = new Paneles();
        add(main);
    }

}
