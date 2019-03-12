package pizzeria.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pizzeria.business.Company;
import pizzeria.business.Store;
import pizzeria.util.XmlParser;

public class SelectStoreDialog extends JDialog {
    final Company company = XmlParser.getCompany("resources/loadStores.xml");
    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        try {
            final SelectStoreDialog dialog = new SelectStoreDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public SelectStoreDialog() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 434, 46);
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);

        final JFormattedTextField frmtdtxtfldWelcome = new JFormattedTextField();
        frmtdtxtfldWelcome.setForeground(new Color(210, 105, 30));
        frmtdtxtfldWelcome.setBackground(new Color(192, 192, 192));
        frmtdtxtfldWelcome.setFont(new Font("Roboto", Font.PLAIN, 14));
        frmtdtxtfldWelcome.setText("WELCOME TO JALA PIZZA COMPANY");
        contentPanel.add(frmtdtxtfldWelcome);
        {
            final JPanel buttonPane = new JPanel();
            buttonPane.setBounds(0, 223, 434, 38);
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane);
            {
                final JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
        }
        {
            final JComboBox storeSelection = new JComboBox();

            final List<Store> stores = company.getStores();

            storeSelection.setModel(new DefaultComboBoxModel(stores.toArray()));
            storeSelection.setBounds(85, 113, 271, 26);
            getContentPane().add(storeSelection);
        }

        final JFormattedTextField frmtdtxtfldAPizzaFor = new JFormattedTextField();
        frmtdtxtfldAPizzaFor.setHorizontalAlignment(SwingConstants.CENTER);
        frmtdtxtfldAPizzaFor.setFont(new Font("SansSerif", Font.PLAIN, 18));
        frmtdtxtfldAPizzaFor.setBackground(new Color(192, 192, 192));
        frmtdtxtfldAPizzaFor.setForeground(new Color(210, 105, 30));
        frmtdtxtfldAPizzaFor.setText("<<A pizza for every client style>>");
        frmtdtxtfldAPizzaFor.setBounds(0, 151, 434, 60);
        getContentPane().add(frmtdtxtfldAPizzaFor);

        final JLabel lblToStartSelect = new JLabel("To start select a store");
        lblToStartSelect.setHorizontalAlignment(SwingConstants.CENTER);
        lblToStartSelect.setBounds(85, 85, 271, 16);
        getContentPane().add(lblToStartSelect);
    }
}
