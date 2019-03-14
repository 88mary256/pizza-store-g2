package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pizzeria.business.Billing;
import pizzeria.business.BillingItem;
import pizzeria.business.OrderItem;
import pizzeria.business.Store;

/**
 * Dialog to make order, contains order detail.
 *
 * @author David Mamani
 */
public class OrderDialog extends JDialog {

    /** Current store. **/
    private final Store store;

    /** Main panel. **/
    private final JPanel contentPanel = new JPanel();

    /** Table for detail order. **/
    private final JTable table;

    /** This component. **/
    private final OrderDialog me = this;

    /** Billing for order. **/
    private final Billing billing = new Billing();

    /** Model of the table. **/
    private final DefaultTableModel dtm = new DefaultTableModel(0, 0);

    /** Total cost label. **/
    private final JLabel lblTotalCost = new JLabel("0");

    /**
     * Create the dialog.
     *
     * @param newStore store where order.
     */
    public OrderDialog(final Store newStore) {
        store = newStore;
        setTitle(store.getName() + ": New Order");
        setBounds(100, 100, 600, 543);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // create object of table and table model
        table = new JTable();
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));

        // add header of the table
        final String header[] = new String[] {"Nro.", "Product", "Unit price",
                "Quantity", "Partial Cost", "Actions" };

        // add header in table model
        dtm.setColumnIdentifiers(header);
        contentPanel.setLayout(null);
        // set model into the table object
        table.setModel(dtm);

        final JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(56, 10, 471, 406);
        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.add(scrollPane);

        final JLabel lblCost = new JLabel("Total Cost: ");
        lblCost.setBounds(56, 428, 113, 16);
        contentPanel.add(lblCost);

        lblTotalCost.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotalCost.setBounds(415, 428, 91, 16);
        contentPanel.add(lblTotalCost);

        final JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        final JButton okButton = new JButton("Add product");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JDialog dialog = new AddOrderPage(me);
                dialog.setVisible(true);
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        final JButton btnRemoveSelected = new JButton("Remove Selected");
        btnRemoveSelected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int i = table.getSelectedRow();
                if (i > 0) {
                    dtm.removeRow(i);
                    billing.removeProduct();
                    lblTotalCost.setText(billing.getTotalCost() + "");
                } else {
                    JOptionPane.showMessageDialog(null, "No row selected");
                }
            }
        });
        buttonPane.add(btnRemoveSelected);

        final JButton submitOrderButton = new JButton("Placed an Order");
        submitOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                System.out.println(billing.getItems());
            }
        });
        submitOrderButton.setActionCommand("Submit");
        buttonPane.add(submitOrderButton);
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
     * Add product on the billing from an orderItem.
     *
     * @param orderItem order Item.
     */
    public void addProduct(final OrderItem orderItem) {
        final BillingItem billingItem = store.createBillingItem(orderItem);
        billing.addProduct(billingItem);
        dtm.addRow(new Object[] {billing.getItemsSize(),
                billingItem.getProductType(),
                billingItem.getProduct().getCost(), billingItem.getQuantity(),
                billingItem.getCost(), "remove" });
        lblTotalCost.setText(billing.getTotalCost() + "");
        this.revalidate();
        this.repaint();
        System.out.println(billing.getItemsSize());
    }

    /**
     * Get current Store.
     *
     * @return Store
     **/
    public Store getStore() {
        return store;
    }
}
