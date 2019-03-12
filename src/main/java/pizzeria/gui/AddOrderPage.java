package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pizzeria.data.PizzaTypes;

public class AddOrderPage extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        try {
            final AddOrderPage dialog = new AddOrderPage();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AddOrderPage() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            final JLabel lblSelectAProduct = new JLabel(
                    "Select a product to add");
            lblSelectAProduct.setFont(new Font("SansSerif", Font.PLAIN, 14));
            lblSelectAProduct.setBackground(new Color(192, 192, 192));
            lblSelectAProduct.setForeground(new Color(0, 0, 0));
            lblSelectAProduct.setHorizontalAlignment(SwingConstants.CENTER);
            lblSelectAProduct.setBounds(0, 6, 434, 31);
            contentPanel.add(lblSelectAProduct);
        }

        final JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(PizzaTypes.values()));
        comboBox.setBounds(180, 58, 202, 20);
        contentPanel.add(comboBox);

        final JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(
                new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        comboBox_1.setBounds(83, 58, 67, 20);
        contentPanel.add(comboBox_1);

        final JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuantity.setBounds(83, 39, 67, 14);
        contentPanel.add(lblQuantity);

        final JLabel lblProduct = new JLabel("Product");
        lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
        lblProduct.setBounds(180, 39, 202, 14);
        contentPanel.add(lblProduct);

        final JLabel lblIngredients = new JLabel("Ingredients");
        lblIngredients.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblIngredients.setHorizontalAlignment(SwingConstants.CENTER);
        lblIngredients.setBounds(0, 89, 434, 23);
        contentPanel.add(lblIngredients);

        final JCheckBox addedIngredient = new JCheckBox("Some ingredient");
        addedIngredient.setBounds(88, 115, 126, 23);
        contentPanel.add(addedIngredient);
        {
            final JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                final JButton okButton = new JButton("OK");
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
    }
}
