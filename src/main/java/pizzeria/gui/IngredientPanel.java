package pizzeria.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pizzeria.data.IngredientType;

/**
 * Ingredient Component that can be added/deleted of its parent.
 *
 * @author Marines Lopez Soliz
 */
public class IngredientPanel extends JPanel {

    /** Ingredient type. **/
    private IngredientType iname = IngredientType.TOMATOES;

    /** Parent component. **/
    private final JPanel parent;

    /** This component. **/
    private final IngredientPanel me;

    /**
     * Create the panel.
     *
     * @param newIname  ingredient type.
     * @param newParent parent component.
     */
    public IngredientPanel(final IngredientType newIname,
            final JPanel newParent) {
        iname = newIname;
        parent = newParent;
        me = this;
        this.setSize(204, 20);
        setLayout(null);

        final JLabel lblIname = new JLabel(iname.name());
        lblIname.setBounds(0, 0, 160, 20);
        add(lblIname);

        final JButton btnX = new JButton("x");
        btnX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                parent.remove(me);
                parent.revalidate();
                parent.repaint();
            }
        });
        btnX.setToolTipText("Remove ingredient");
        btnX.setLocation(161, 0);
        btnX.setHorizontalAlignment(SwingConstants.TRAILING);
        btnX.setSize(41, 20);
        add(btnX);
        this.repaint();
        parent.add(this);
        parent.revalidate();
        parent.repaint();
    }

    /**
     * Getter of ingredient.
     *
     * @return Ingredient type
     **/
    public IngredientType getIname() {
        return iname;
    }

}
