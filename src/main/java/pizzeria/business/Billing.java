/**
 * Info about this package doing something for package-info.java file.
 */
package pizzeria.business;

import java.util.ArrayList;
import java.util.List;

import pizzeria.data.Pizza;

/**
 * Contains the total cost of an order and the pizzas for it.
 *
 * @author Marines Lopez Soliz
 */
public class Billing {

    /** Total cost of the billing. **/
    private double totalCost = 0;

    /** Pizzas list of the billing. **/
    private List<Pizza> pizzas = new ArrayList<Pizza>();

    /**
     * Parameterized constructor.
     *
     * @param newTotalCost double
     * @param newPizzas    List<Pizza>
     */
    public Billing(final double newTotalCost, final List<Pizza> newPizzas) {
        this.totalCost = newTotalCost;
        this.pizzas = newPizzas;
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
     * Getter of pizzas.
     *
     * @return pizzas
     */
    public List<Pizza> getPizzas() {
        return pizzas;
    }
}
