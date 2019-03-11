package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pizzeria.business.Billing;
import pizzeria.business.Company;
import pizzeria.business.OrderItem;
import pizzeria.business.PizzaStore;
import pizzeria.data.IngredientType;
import pizzeria.data.PizzaTypes;
import pizzeria.util.XmlParser;

/**
 * Displayed main panel.
 * 
 * @author Admin
 *
 */
public class Paneles extends JPanel implements ActionListener {
    JButton submitOrdenButton = new JButton("Registrar Orden");
    JButton addPizzaButton = new JButton("Add Pizza");
    JButton addIngredientButton = new JButton("Add Ingredient");
    JComboBox pizzaSelectionTypes;
    ImageIcon[] images;
    JTextField quantityField;

    /**
     * Default constructor.
     */
    public Paneles() {

        /** Setting layout. */
        setBackground(SystemColor.window);
        // setLayout(new FlowLayout(FlowLayout.RIGHT));
        setLayout(new BorderLayout(10, 10));

        /** Setting North layout. */
        final JLabel pizzaListTitleLabel = new JLabel("Available pizzas ");
        final JLabel quantityLabel = new JLabel("Number of pizzas : ");
        quantityLabel.setVisible(true);
        final JTextField quantityField = new JTextField();
        quantityField.setSize(10, 10);
        quantityField.setVisible(true);
        final JComboBox pizzaTypeSelection = new JComboBox();
        pizzaTypeSelection
                .setModel(new DefaultComboBoxModel(PizzaTypes.values()));
        pizzaTypeSelection.setSelectedIndex(0);
        pizzaTypeSelection.addActionListener(this);
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5));
        northPanel.add(pizzaListTitleLabel);
        northPanel.add(quantityLabel);
        northPanel.add(quantityField);
        northPanel.add(pizzaTypeSelection);
        northPanel.add(addPizzaButton);
        add(northPanel, BorderLayout.NORTH);

        /** Setting West layout. */

        final JComboBox Ingredients = new JComboBox();
        Ingredients.setModel(new DefaultComboBoxModel(IngredientType.values()));
        Ingredients.setSelectedIndex(0);
        Ingredients.addActionListener(this);
        final JPanel westPanel = new JPanel();
        final JLabel ingredientsListTitleLabel = new JLabel(
                "List of extra ingredients. ");
        final JLabel ingredientsListSubTitleLabel = new JLabel(
                "Incremental cost of a pizza.");
        westPanel.setLayout(new GridLayout(6, 1));
        westPanel.add(ingredientsListTitleLabel);
        westPanel.add(ingredientsListTitleLabel);
        westPanel.add(ingredientsListTitleLabel);
        westPanel.add(ingredientsListSubTitleLabel);
        westPanel.add(Ingredients);
        westPanel.add(addIngredientButton);
        add(westPanel, BorderLayout.WEST);

        /** Setting east layout. */
        // add(submitOrdenButton, BorderLayout.EAST);
        // submitOrdenButton.addActionListener(this);

        /** Setting South layout. */
        add(submitOrdenButton, BorderLayout.SOUTH);
        submitOrdenButton.addActionListener(this);
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponents(g);
        g.drawString("Welcome to Jala Pizza", 200, 100);
        g.drawRect(185, 85, 200, 20);
    }

    /** Setting actions performed. */
    @Override
    public void actionPerformed(final ActionEvent e) {

        final Company company = XmlParser
                .getCompany("resources/loadStores.xml");

        final Object whichButton = e.getSource();
        final ArrayList<OrderItem> order = new ArrayList<OrderItem>();
        /** Identify action to execute based on clicked button. */
        if (whichButton == addPizzaButton) {
            final String test = pizzaSelectionTypes.getSelectedItem()
                    .toString();
            final OrderItem currentOrder = new OrderItem(
                    Integer.parseInt(quantityField.getText()),
                    PizzaTypes.valueOf(test));
            order.add(currentOrder);
            System.out.println(test);
            System.out.println("Item Added");
        } else if (whichButton == addIngredientButton) {
            final String test = pizzaSelectionTypes.getSelectedItem()
                    .toString();
            final OrderItem currentOrder = new OrderItem(1,
                    PizzaTypes.valueOf(test));
            order.add(currentOrder);
            System.out.println(test);
            System.out.println("Item Added");
        } else if (whichButton == submitOrdenButton) {
            final PizzaStore store = company.getStore(0);
            final Billing billing = store.orderPizza(order);
            System.out.println(billing.getTotalCost());
            System.out.println(billing.getPizzas());
            System.out.println("Calculate cost and Billing");

        }
    }

}
