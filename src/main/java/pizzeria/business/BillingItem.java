package pizzeria.business;

import pizzeria.data.Pizza;
import pizzeria.data.Product;
import pizzeria.data.ProductType;

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
     */
    public BillingItem(final int newQuantity, final Product newProduct) {
        super();
        this.quantity = newQuantity;
        this.product = newProduct;
        this.cost = this.product.getCost() * this.quantity;
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

    /**
     * Getter of product type as string.
     *
     * @return string
     */
    public String getProductType() {
        return product.getProductType() == ProductType.PIZZA
                ? ((Pizza) product).getPizzaType().name()
                : product.getProductType().name();
    }

    /**
     * Get ingredient types as string.
     *
     * @return ingredientType list.
     */
    public String getIngredients() {
        return product.getProductType() == ProductType.PIZZA
                ? ((Pizza) product).getIngredientTypes().toString()
                : "";
    }
}
