package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import pizzeria.data.IngredientType;

/**
 * Dialog to set extra ingredients and ingredients to be removed.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaDetails extends JDialog {

    /** This dialog. **/
    private final JDialog me = this;

    /** Main Panel. **/
    private final JPanel contentPanel = new JPanel();

    /** Panel for extra ingredients. **/
    private final JPanel extraIngredientsPanel = new JPanel();

    /** Panel for ingredients to be removed. **/
    private final JPanel toRemoveIngredientsPanel = new JPanel();

    /** Combobox for add ingredient. **/
    private final JComboBox toAddCombobox = new JComboBox();

    /** Combobox for to be removed ingredients. **/
    private final JComboBox toRemoveCombobox = new JComboBox();

    /**
     * Launch the application.
     *
     * @param args arguments to run.
     */
    public static void main(final String[] args) {
        try {
            final PizzaDetails dialog = new PizzaDetails();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public PizzaDetails() {
        setTitle("Pizza Details");
        setBounds(100, 100, 516, 383);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        final JButton addButton = new JButton("+");
        addButton.setBounds(204, 11, 41, 23);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                new IngredientPanel(
                        (IngredientType) toAddCombobox.getSelectedItem(),
                        extraIngredientsPanel);
            }
        });
        contentPanel.setLayout(null);
        contentPanel.add(addButton);

        final JLabel lblExtraIngredients = new JLabel(
                "Ingredients to be added");
        lblExtraIngredients.setBounds(17, 15, 189, 14);
        contentPanel.add(lblExtraIngredients);

        final JLabel lblIngredientsToRemove = new JLabel(
                "Ingredients to be removed");
        lblIngredientsToRemove.setBounds(17, 166, 189, 14);
        contentPanel.add(lblIngredientsToRemove);

        extraIngredientsPanel.setBounds(17, 45, 473, 106);
        final JScrollPane scrollPane1 = new JScrollPane(extraIngredientsPanel);
        scrollPane1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane1.setBounds(17, 45, 473, 106);

        contentPanel.add(scrollPane1);
        extraIngredientsPanel.setLayout(new GridLayout(0, 2));
        // new BoxLayout(extraIngredientsPanel, BoxLayout.X_AXIS));

        toRemoveIngredientsPanel.setBounds(17, 190, 473, 106);
        final JScrollPane scrollPane2 = new JScrollPane(
                toRemoveIngredientsPanel);
        scrollPane2.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane2.setBounds(17, 190, 473, 106);
        contentPanel.add(scrollPane2);
        toRemoveIngredientsPanel.setLayout(new GridLayout(0, 2));

        final JButton toRemoveButton = new JButton("-");
        toRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new IngredientPanel(
                        (IngredientType) toRemoveCombobox.getSelectedItem(),
                        toRemoveIngredientsPanel);
            }
        });
        toRemoveButton.setBounds(204, 162, 41, 23);
        contentPanel.add(toRemoveButton);

        toAddCombobox.setBounds(255, 12, 160, 20);
        contentPanel.add(toAddCombobox);
        toAddCombobox
                .setModel(new DefaultComboBoxModel(IngredientType.values()));
        toAddCombobox.setSelectedIndex(0);

        toRemoveCombobox
                .setModel(new DefaultComboBoxModel(IngredientType.values()));
        toRemoveCombobox.setSelectedIndex(0);
        toRemoveCombobox.setBounds(255, 163, 160, 20);
        contentPanel.add(toRemoveCombobox);

        final JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        final JButton okButton = new JButton("Save");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println("extra ingredients ");
                System.out.println(getExtraIngredientList());
                System.out.println("to remove ingredients");
                System.out.println(getToRemoveIngredientList());
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        final JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                me.dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

    }

    /**
     * Getter of extra ingredient list.
     *
     * @return IngredientType list
     */
    public List<IngredientType> getExtraIngredientList() {
        return getIngredientTypeList(extraIngredientsPanel);
    }

    /**
     * Getter of ingredient list to remove.
     *
     * @return IngredientType list
     */
    public List<IngredientType> getToRemoveIngredientList() {
        return getIngredientTypeList(toRemoveIngredientsPanel);
    }

    /**
     * Get IngredientType list from panel.
     *
     * @param panel JPanel
     * @return IngredientType list
     */
    private List<IngredientType> getIngredientTypeList(final JPanel panel) {
        final List<IngredientType> result = new ArrayList<IngredientType>();
        for (final Component component : panel.getComponents()) {
            if (component instanceof IngredientPanel) {
                result.add(((IngredientPanel) component).getIname());
            }
        }
        return result;
    }
}
