package main.java.pizzeria.datos;

/**
 *
 * Define common activities for different Pizza products.
 *
 * @author David Mamani
 *
 */

public abstract class Pizza {

    private final PizzaTypes type;
    private final double cost;

    /**
     * Parameterized constructor.
     *
     * @param cost double
     * @param type PizzaType
     */
    public Pizza(final PizzaTypes type, final double cost) {
        this.type = type;
        this.cost = cost;
    }

    /**
     * Method that prepare the pizza.
     */
    public void prepare() {
    }

    /**
     * Method that bake the pizza.
     */
    public void bake() {
    }

    /**
     * Method that cut the pizza.
     */
    public void cut() {
    }

    /**
     * Method that box the pizza.
     */
    public void box() {
    }

    /**
     * Getter of cost.
     *
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Pizza " + type + " cost:" + cost;
    }
}
