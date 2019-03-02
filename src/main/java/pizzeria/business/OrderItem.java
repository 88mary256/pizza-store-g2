package pizzeria.business;

import pizzeria.data.PizzaTypes;

/**
 * This class represent a order item that have the quantity and pizza type.
 *
 * @author Marines Lopez Soliz
 */
public class OrderItem {

    /** Quantity of pizzas. **/
    private int quantity;

    /** Type of pizza. **/
    private PizzaTypes type;

    /**
     * Parameterized constructor.
     *
     * @param newQuantity int
     * @param newType     PizzaType
     */
    public OrderItem(final int newQuantity, final PizzaTypes newType) {
        super();
        this.quantity = newQuantity;
        this.type = newType;
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
     * Getter of Pizza Type.
     *
     * @return pizza type
     */
    public PizzaTypes getType() {
        return type;
    }

    /**
     * Setter of Pizza Type.
     *
     * @param newType PizzaType
     */
    public void setType(final PizzaTypes newType) {
        this.type = newType;
    }
}
