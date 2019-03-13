package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

import pizzeria.data.PizzaTypes;
import pizzeria.data.ProductType;

public class AddOrderPage extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private final JLabel pizzaTypeLbl = new JLabel("Pizza Type");
    private final JComboBox pizzaTypeCombobox = new JComboBox();
    private final JSpinner spinner = new JSpinner();
    private final JDialog me = this;
    private final OrderDialog parent;

    /**
     * Create the dialog.
     */
    public AddOrderPage(final OrderDialog newParent) {
        this.parent = newParent;
        setTitle("Add Product");
        setBounds(100, 100, 450, 251);
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

        final JComboBox comboBox = new JComboBox();
        comboBox.setBounds(124, 99, 123, 35);
        comboBox.setModel(new DefaultComboBoxModel(ProductType.values()));
        comboBox.setSelectedIndex(1);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent event) {
                final JComboBox comboBox = (JComboBox) event.getSource();

                final ProductType item = (ProductType) event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    setPizzaTypeVisible(item == ProductType.PIZZA);
                    me.revalidate();
                    me.repaint();
                }
            }
        });
        contentPanel.add(comboBox);

        final JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(18, 80, 67, 14);
        lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(lblQuantity);

        final JLabel lblProduct = new JLabel("Product");
        lblProduct.setBounds(131, 80, 116, 14);
        lblProduct.setHorizontalAlignment(SwingConstants.LEFT);
        contentPanel.add(lblProduct);

        pizzaTypeCombobox
                .setModel(new DefaultComboBoxModel(PizzaTypes.values()));
        pizzaTypeCombobox.setSelectedIndex(0);
        pizzaTypeCombobox.setBounds(259, 99, 123, 35);
        contentPanel.add(pizzaTypeCombobox);

        pizzaTypeLbl.setHorizontalAlignment(SwingConstants.LEFT);
        pizzaTypeLbl.setBounds(266, 79, 116, 14);
        contentPanel.add(pizzaTypeLbl);

        spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1),
                null, new Integer(1)));
        spinner.setBounds(18, 99, 73, 34);
        contentPanel.add(spinner);
        {
            final JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                final JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        final ProductType productType = (ProductType) comboBox
                                .getSelectedItem();
                        final PizzaTypes pizzaType = (PizzaTypes) pizzaTypeCombobox
                                .getSelectedItem();
                        final int quantity = (int) spinner.getValue();
                        parent.addProduct(productType, quantity, pizzaType);
                        System.out.println(
                                productType + " " + quantity + " " + pizzaType);
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                final JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent arg0) {

                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
        setPizzaTypeVisible(false);
    }

    private void setPizzaTypeVisible(final boolean visible) {
        pizzaTypeLbl.setVisible(visible);
        pizzaTypeCombobox.setVisible(visible);
    }

    public OrderDialog getOrderItem() {
        return parent;
    }
}
