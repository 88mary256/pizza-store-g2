package pizzeria.data;

/**
 * This class represent the products that store can sale.
 *
 * @author Marines Lopez Soliz
 *
 */
public class Product {

    /** Type of Product. **/
    protected ProductType productType;

    /** Cost of product. **/
    protected double cost;

    /**
     * Get the product cost.
     *
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Getter of the product type.
     *
     * @return ProductType.
     */
    public ProductType getProductType() {
        return productType;
    }
}
