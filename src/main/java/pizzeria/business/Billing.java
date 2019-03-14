/**
 * Info about this package doing something for package-info.java file.
 */
package pizzeria.business;

import java.util.ArrayList;
import java.util.List;

import pizzeria.data.Product;

/**
 * Contains the total cost of an order and the products for it.
 *
 * @author Marines Lopez Soliz
 */
public class Billing {

    /** Total cost of the billing. **/
    private double totalCost = 0;

    /** Detail of billing list. **/
    private List<BillingItem> items = new ArrayList<BillingItem>();

    /** Default constructor. **/
    public Billing() {

    }

    /**
     * Parameterized constructor.
     *
     * @param newTotalCost double
     * @param newItems     List<BillingItem>
     */
    public Billing(final double newTotalCost,
            final List<BillingItem> newItems) {
        this.totalCost = newTotalCost;
        this.items = newItems;
    }

    /**
     * Getter of total cost.
     *
     * @return totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Getter of BillingItem list.
     *
     * @return items
     */
    public List<BillingItem> getItems() {
        return items;
    }

    /**
     * Add product to billing.
     *
     * @param quantity int.
     * @param product  Product.
     */
    public void addProduct(final int quantity, final Product product) {
        items.add(new BillingItem(quantity, product));
        totalCost += product.getCost() * quantity;
    }

    /**
     * Add product to billing.
     *
     * @param item billing item.
     */
    public void addProduct(final BillingItem item) {
        items.add(item);
        totalCost += item.getCost();
    }

    public void removeProduct(final BillingItem item) {
        items.remove(item);
        totalCost -= item.getCost();
    }

    /**
     * Get amount of products.
     *
     * @return amount of products.
     */
    public int getAmountOfProducts() {
        int amount = 0;
        for (final BillingItem billingItem : items) {
            amount += billingItem.getQuantity();
        }
        return amount;
    }

    /**
     * Getter of items size.
     *
     * @return items size.
     */
    public int getItemsSize() {
        return this.items.size();
    }
}
