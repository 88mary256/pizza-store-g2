package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pizzeria.business.Billing;
import pizzeria.business.Company;
import pizzeria.business.OrderItem;
import pizzeria.business.OrderPizzaItem;
import pizzeria.business.Store;
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
    private final JButton submitOrdenButton = new JButton("Registrar Orden");
    private final JButton addPizzaButton = new JButton("Add Pizza");
    private final JButton addIngredientButton = new JButton("Add Ingredient");
    public JComboBox pizzaSelectionTypes;
    public JComboBox ingredients;
    private final JTextField quantityField;
    static final int TEN = 10;
    static final int ZERO = 0;
    List<OrderItem> order;

    Billing billing;

    /**
     * Default constructor.
     */
    public Paneles() {

        /** Setting layout. */
        setBackground(SystemColor.window);
        // setLayout(new FlowLayout(FlowLayout.RIGHT));
        setLayout(new BorderLayout(TEN, TEN));

        /** Setting North layout. */
        final JLabel pizzaListTitleLabel = new JLabel("Available pizzas ");
        final JLabel quantityLabel = new JLabel("Number of pizzas : ");
        quantityLabel.setVisible(true);
        quantityField = new JTextField();
        quantityField.setSize(TEN, TEN);
        quantityField.setVisible(true);
        pizzaSelectionTypes = new JComboBox();
        pizzaSelectionTypes
                .setModel(new DefaultComboBoxModel(PizzaTypes.values()));
        pizzaSelectionTypes.setSelectedIndex(ZERO);
        addPizzaButton.addActionListener(this);
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 5));
        northPanel.add(pizzaListTitleLabel);
        northPanel.add(quantityLabel);
        northPanel.add(quantityField);
        northPanel.add(pizzaSelectionTypes);
        northPanel.add(addPizzaButton);
        add(northPanel, BorderLayout.NORTH);

        /** Setting West layout. */

        ingredients = new JComboBox();
        ingredients.setModel(new DefaultComboBoxModel(IngredientType.values()));
        ingredients.setSelectedIndex(ZERO);
        addIngredientButton.addActionListener(this);
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
        westPanel.add(ingredients);
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
        System.out.println("ActionEvent");
        final Company company = XmlParser
                .getCompany("resources/loadStores.xml");

        final Object whichButton = e.getSource();
        order = new ArrayList<OrderItem>();
        /** Identify action to execute based on clicked button. */
        if (whichButton == addPizzaButton) {
            final String pizzaSelected = pizzaSelectionTypes.getSelectedItem()
                    .toString();
            final OrderItem currentOrder = new OrderPizzaItem(
                    Integer.parseInt(quantityField.getText()),
                    PizzaTypes.valueOf(pizzaSelected));
            order.add(currentOrder);
            System.out.println("Q:" + Integer.parseInt(quantityField.getText())
                    + "I:" + pizzaSelected);
            System.out.println("Item Added");
        } else if (whichButton == addIngredientButton) {
            final String ingredientSelected = ingredients.getSelectedItem()
                    .toString();
            final OrderItem currentOrder = new OrderPizzaItem(
                    Integer.parseInt(quantityField.getText()),
                    PizzaTypes.valueOf(ingredientSelected));
            order.add(currentOrder);
            System.out.println(ingredientSelected);
            System.out.println("Item Added");
        } else if (whichButton == submitOrdenButton) {
            final Store store = company.getStore(ZERO);
            billing = store.orderProducts(order);
            System.out.println("Print Order1");

            for (final OrderItem model : order) {
                System.out.println("Print Order2");
                System.out.println(model.getProductType());
            }
            System.out.println(billing.getTotalCost());
            System.out.println(billing.getProducts());

        }
    }

}
