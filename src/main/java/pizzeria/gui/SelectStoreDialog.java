package pizzeria.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 * Main dialog to select in wich store you are.
 *
 * @author David Mamani.
 */
public class SelectStoreDialog extends JDialog {

    /** Company information. **/
    private final Company company = XmlParser
            .getCompany("resources/loadStores.xml");

    /** Main panel. **/
    private final JPanel contentPanel = new JPanel();

    /** Combobox to select store. **/
    private final JComboBox storeSelection = new JComboBox();

    /**
     * Launch the application.
     *
     * @param args arguments to run.
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

        final JFormattedTextField lblWelcome = new JFormattedTextField();
        lblWelcome.setForeground(new Color(210, 105, 30));
        lblWelcome.setBackground(new Color(192, 192, 192));
        lblWelcome.setFont(new Font("Roboto", Font.PLAIN, 14));
        lblWelcome.setText("WELCOME TO JALA PIZZA COMPANY");
        contentPanel.add(lblWelcome);
        final JPanel buttonPane = new JPanel();
        buttonPane.setBounds(0, 223, 434, 38);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane);
        final JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Store store = (Store) storeSelection.getSelectedItem();
                final OrderDialog orderDialog = new OrderDialog(store);
                orderDialog.setVisible(true);
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        final List<Store> stores = company.getStores();
        storeSelection.setModel(new DefaultComboBoxModel(stores.toArray()));
        storeSelection.setBounds(85, 113, 271, 26);
        getContentPane().add(storeSelection);

        final JFormattedTextField lbl2 = new JFormattedTextField();
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lbl2.setBackground(new Color(192, 192, 192));
        lbl2.setForeground(new Color(210, 105, 30));
        lbl2.setText("<<A pizza for every client style>>");
        lbl2.setBounds(0, 151, 434, 60);
        getContentPane().add(lbl2);

        final JLabel lblToStartSelect = new JLabel("To start select a store");
        lblToStartSelect.setHorizontalAlignment(SwingConstants.CENTER);
        lblToStartSelect.setBounds(85, 85, 271, 16);
        getContentPane().add(lblToStartSelect);
    }
}
