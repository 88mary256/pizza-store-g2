package pizzeria.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Frame of work.
 * 
 * @author Admin
 *
 */
public class Frame extends JFrame {

    /**
     * Default constructor.
     */
    static final int EIGHT = 8;
    static final int TWO = 2;
    static final int FOUR = 4;

    public Frame() {
        final Toolkit myScreen = Toolkit.getDefaultToolkit();
        final Dimension sizeScreen = myScreen.getScreenSize();
        setBounds(sizeScreen.width / EIGHT, sizeScreen.height / EIGHT,
                sizeScreen.width / TWO, sizeScreen.height / FOUR);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Jala Pizza Co.");
        final Image favicon = myScreen.getImage("resources/favicon.png");
        setIconImage(favicon);
        final Paneles main = new Paneles();
        add(main);
    }

}
