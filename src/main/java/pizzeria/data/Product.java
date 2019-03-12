package pizzeria.data;

/**
 * This class represent the products that store can sale.
 *
 * @author Marines Lopez Soliz
 *
 */
public class Product {

    protected ProductType productType;
    protected double cost;

    /**
     * Get the product cost.
     *
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    public ProductType getProductType() {
        return productType;
    }
}
