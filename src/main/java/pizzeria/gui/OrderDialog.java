package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pizzeria.business.OrderItem;
import pizzeria.business.OrderPizzaItem;
import pizzeria.business.Store;
import pizzeria.data.PizzaTypes;
import pizzeria.data.ProductType;

public class OrderDialog extends JDialog {

    private final Store store;
    private final JPanel contentPanel = new JPanel();
    private final JTable table;
    private final OrderDialog me = this;
    final List<OrderItem> order = new ArrayList<OrderItem>();
    private final DefaultTableModel dtm = new DefaultTableModel(0, 0);

    /**
     * Create the dialog.
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
        final String header[] = new String[] { "Nro.", "Product", "Unit price",
                "Quantity", "Partial Cost", "Actions" };

        // add header in table model
        dtm.setColumnIdentifiers(header);
        // set model into the table object
        table.setModel(dtm);
        // add row dynamically into the table

        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        final JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPanel.add(scrollPane);

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

        final JButton submitOrderButton = new JButton("Placed an Order");
        submitOrderButton.setActionCommand("Submit");
        buttonPane.add(submitOrderButton);
        final JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }

    public void addProduct(final ProductType productType, final int quantity,
            final PizzaTypes pizzaType) {
        if (productType == ProductType.PIZZA) {
            order.add(new OrderPizzaItem(quantity, pizzaType));
            dtm.addRow(new Object[] { order.size(), pizzaType, "data", quantity,
                    "data", "remove" });
        } else {
            order.add(new OrderItem(quantity, productType));
            dtm.addRow(new Object[] { order.size(), productType, "data",
                    quantity, "data", "remove" });
        }

        this.revalidate();
        this.repaint();
        System.out.println(order.size());
    }
}
