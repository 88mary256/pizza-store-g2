package pizzeria.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import pizzeria.data.PizzaTypes;

public class PizzaOffer extends JPanel implements ActionListener {
    JComboBox comboBox;

    public PizzaOffer() {
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(PizzaTypes.values()));
        comboBox.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
