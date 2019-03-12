package pizzeria.business;

import pizzeria.data.Product;

/** Billing Item is to get detail of billing per product. **/
public class BillingItem {
    /** Quantity of product. **/
    private final int quantity;

    /** Product. **/
    private final Product product;

    /** Partial cost. **/
    private final double cost;

    /**
     * Parameterized constructor.
     *
     * @param newQuantity Quantity of product.
     * @param newProduct  Product.
     * @param newCost     Partial cost.
     */
    public BillingItem(final int newQuantity, final Product newProduct,
            final double newCost) {
        super();
        this.quantity = newQuantity;
        this.product = newProduct;
        this.cost = newCost;
    }

    /**
     * Getter of quantity.
     *
     * @return int quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Getter of product.
     *
     * @return Product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Getter of partial cost.
     *
     * @return double cost.
     */
    public double getCost() {
        return cost;
    }

    /** Customized toString method. **/
    @Override
    public String toString() {
        return "Item[quantity=" + quantity + ", partialCost=" + cost
                + ", product=" + product + "]";
    }
}
