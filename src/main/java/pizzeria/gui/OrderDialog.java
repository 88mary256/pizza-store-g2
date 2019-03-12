package pizzeria.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class OrderDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        try {
            final OrderDialog dialog = new OrderDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public OrderDialog() {
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            final String[] columnNames = { "Product", "Unit price", "Quantity",
                    "Partial Cost", "Actions" };
            final Object[][] data = {};
            contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            table = new JTable(data, columnNames);
            table.setShowVerticalLines(true);
            table.setShowHorizontalLines(true);
            table.setBorder(
                    UIManager.getBorder("List.focusCellHighlightBorder"));
            final JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setVerticalScrollBarPolicy(
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            contentPanel.add(scrollPane);
        }

        {
            final JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                final JButton okButton = new JButton("Add product");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }

            {
                final JButton submitOrderButton = new JButton(
                        "Placed an Order");
                submitOrderButton.setActionCommand("Submit");
                buttonPane.add(submitOrderButton);
            }
            {
                final JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
