package main.java.pizzeria.negocio;

import main.java.pizzeria.datos.PizzaTypes;

/**
 * This class represent a order item that have the quantity and pizza type.
 *
 * @author Marines Lopez Soliz
 */
public class OrderItem {

    private int quantity;
    private PizzaTypes type;

    /**
     * Parameterized constructor.
     *
     * @param quantity
     * @param type
     */
    public OrderItem(int quantity, PizzaTypes type) {
        super();
        this.quantity = quantity;
        this.type = type;
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
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * @param type PizzaType
     */
    public void setType(PizzaTypes type) {
        this.type = type;
    }
}
