package pizzeria.business;

import pizzeria.data.ProductType;

/**
 * This class represent a order item that have the quantity and product type.
 *
 * @author Marines Lopez Soliz
 */
public class OrderItem {

    /** Quantity of product. **/
    private int quantity;

    /** Type of product. **/
    private ProductType productType;

    /**
     * Parameterized constructor.
     *
     * @param newQuantity int
     * @param newType     ProductType
     */
    public OrderItem(final int newQuantity, final ProductType newType) {
        super();
        this.quantity = newQuantity;
        this.productType = newType;
    }

    /**
     * Getter of quantity.
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter of quantity.
     *
     * @param newQuantity int.
     */
    public void setQuantity(final int newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * Getter of product Type.
     *
     * @return product type
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Setter of product type.
     *
     * @param newType ProductType
     */
    public void setProductType(final ProductType newType) {
        this.productType = newType;
    }
}
