package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pizzeria.business.OrderItem;
import pizzeria.business.OrderPizzaItem;
import pizzeria.data.IngredientType;
import pizzeria.data.PizzaTypes;
import pizzeria.data.ProductType;

/**
 * Dialog to add products for an order.
 *
 * @author David Mamani
 * @author Marines Lopez Soliz
 */
public class AddOrderPage extends JDialog {

    /** Main panel. **/
    private final JPanel contentPanel = new JPanel();

    /** Pizza label. **/
    private final JLabel pizzaTypeLbl = new JLabel("Pizza Type");

    /** Combobox for products. **/
    private final JComboBox comboBox = new JComboBox();

    /** Combobox for pizzas. **/
    private final JComboBox pizzaTypeCombobox = new JComboBox();

    /** Quantity spinner. **/
    private final JSpinner spinner = new JSpinner();

    /** This dialog. **/
    private final JDialog me = this;

    /** Parent dialog. **/
    private final OrderDialog parent;

    /** Panel for ingredients detail. **/
    private final PizzaDetails pizzaDetailPnl = new PizzaDetails();

    /** Panel for not customized products. **/
    private final JPanel productDetailPnl = new JPanel();

    /**
     * Create the dialog.
     *
     * @param newParent parent component.
     */
    public AddOrderPage(final OrderDialog newParent) {
        this.parent = newParent;
        setTitle(parent.getStore().getName() + ": Add Product");
        setBounds(100, 100, 547, 481);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        final JLabel lblSelectAProduct = new JLabel("Select a product to add");
        lblSelectAProduct.setBounds(0, 6, 434, 31);
        lblSelectAProduct.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblSelectAProduct.setBackground(new Color(192, 192, 192));
        lblSelectAProduct.setForeground(new Color(0, 0, 0));
        lblSelectAProduct.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(lblSelectAProduct);

        comboBox.setBounds(148, 78, 133, 35);
        comboBox.setModel(new DefaultComboBoxModel(ProductType.values()));
        comboBox.setSelectedIndex(1);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    final ProductType item = (ProductType) event.getItem();
                    setPizzaTypeVisible(item == ProductType.PIZZA);
                    me.revalidate();
                    me.repaint();
                }
            }
        });
        contentPanel.add(comboBox);

        final JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(10, 59, 67, 14);
        lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
        contentPanel.add(lblQuantity);

        final JLabel lblProduct = new JLabel("Product");
        lblProduct.setBounds(148, 59, 133, 14);
        lblProduct.setHorizontalAlignment(SwingConstants.LEFT);
        contentPanel.add(lblProduct);

        pizzaTypeCombobox
                .setModel(new DefaultComboBoxModel(PizzaTypes.values()));
        pizzaTypeCombobox.setBounds(326, 78, 189, 35);
        pizzaTypeCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    final PizzaTypes type = (PizzaTypes) event.getItem();
                    loadIngredientsOnPizzaDetailPnl(type);
                }
            }
        });
        pizzaTypeCombobox.setSelectedIndex(0);
        contentPanel.add(pizzaTypeCombobox);

        pizzaTypeLbl.setHorizontalAlignment(SwingConstants.LEFT);
        pizzaTypeLbl.setBounds(326, 58, 114, 14);
        contentPanel.add(pizzaTypeLbl);

        spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1),
                null, new Integer(1)));
        spinner.setBounds(10, 78, 73, 34);
        contentPanel.add(spinner);

        pizzaDetailPnl.setBounds(14, 135, 501, 263);
        loadIngredientsOnPizzaDetailPnl(
                (PizzaTypes) pizzaTypeCombobox.getSelectedItem());
        contentPanel.add(pizzaDetailPnl);

        productDetailPnl.setBounds(14, 135, 501, 263);
        contentPanel.add(productDetailPnl);
        productDetailPnl.setLayout(new GridLayout(0, 1, 0, 0));

        final JLabel lblNewLabel = new JLabel(
                "This product doesn't have custom ingredients");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productDetailPnl.add(lblNewLabel);

        final JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        final JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                parent.addProduct(createOrderItem());
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        final JButton cancelButton = new JButton("Close");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                me.dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        setPizzaTypeVisible(false);
    }

    /**
     * Setter of visible pizza elements.
     *
     * @param visible boolean
     */
    private void setPizzaTypeVisible(final boolean visible) {
        pizzaTypeLbl.setVisible(visible);
        pizzaTypeCombobox.setVisible(visible);
        pizzaDetailPnl.setVisible(visible);
        productDetailPnl.setVisible(!visible);
    }

    /**
     * Create order item with current dialog information.
     *
     * @return order item.
     */
    private OrderItem createOrderItem() {
        final int quantity = (int) spinner.getValue();
        final ProductType productType = (ProductType) comboBox
                .getSelectedItem();
        if (productType == ProductType.PIZZA) {
            final PizzaTypes pizzaType = (PizzaTypes) pizzaTypeCombobox
                    .getSelectedItem();
            final List<IngredientType> ingredients = pizzaDetailPnl
                    .getIngredientList();
            return new OrderPizzaItem(quantity, pizzaType, ingredients);
        } else {
            return new OrderItem(quantity, productType);
        }
    }

    /**
     * Load ingredients to pizzaDetailPanel from a pizza type.
     *
     * @param type pizza type.
     */
    private void loadIngredientsOnPizzaDetailPnl(final PizzaTypes type) {
        final Collection<IngredientType> ingredients = parent.getStore()
                .getDefaultIngredients(type);
        pizzaDetailPnl.clearIngredients();
        for (final IngredientType ingredientType : ingredients) {
            pizzaDetailPnl.addIngredient(ingredientType);
        }
    }
}
