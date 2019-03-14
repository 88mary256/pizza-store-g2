package pizzeria.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pizzeria.data.IngredientType;

/**
 * Dialog to set extra ingredients and ingredients to be removed.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaDetails extends JPanel {

    /** This Panel. **/
    private final JPanel me = this;
    /** Panel for extra ingredients. **/
    private final JPanel ingredientsPanel = new JPanel();

    /** Combobox for add ingredient. **/
    private final JComboBox toAddCombobox = new JComboBox();

    /**
     * Create the dialog.
     */
    public PizzaDetails() {
        this.setBounds(14, 135, 501, 263);
        this.setLayout(null);

        final JLabel lblPizzaDetail = new JLabel("Ingredients");
        lblPizzaDetail.setBounds(0, 15, 126, 14);
        this.add(lblPizzaDetail);

        ingredientsPanel.setBounds(0, 40, 500, 212);
        ingredientsPanel.setLayout(new GridLayout(0, 2));
        toAddCombobox.setBounds(204, 12, 160, 20);
        toAddCombobox
                .setModel(new DefaultComboBoxModel(IngredientType.values()));
        toAddCombobox.setSelectedIndex(0);
        final JButton addButton = new JButton("+");
        addButton.setToolTipText("Add Ingredient");
        addButton.setBounds(153, 11, 41, 23);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                addIngredient((IngredientType) toAddCombobox.getSelectedItem());
            }
        });
        this.add(ingredientsPanel);
        this.add(toAddCombobox);
        this.add(addButton);
    }

    public void addIngredient(final IngredientType ingredient) {
        new IngredientPanel(ingredient, ingredientsPanel);
    }

    public void clearIngredients() {
        ingredientsPanel.removeAll();
    }

    /**
     * Getter of extra ingredient list.
     *
     * @return IngredientType list
     */
    public List<IngredientType> getIngredientList() {
        final List<IngredientType> result = new ArrayList<IngredientType>();
        for (final Component component : ingredientsPanel.getComponents()) {
            if (component instanceof IngredientPanel) {
                result.add(((IngredientPanel) component).getIname());
            }
        }
        return result;
    }

}
