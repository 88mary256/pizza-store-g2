package main.java.pizzeria.negocio;

import java.util.ArrayList;
import java.util.List;

import main.java.pizzeria.datos.Pizza;

/**
 * Contains the total cost of an order and the pizzas for it.
 *
 * @author Marines Lopez Soliz
 */
public class Billing {

    private double totalCost = 0;

    private List<Pizza> pizzas = new ArrayList<Pizza>();

    /**
     * Parameterized constructor.
     *
     * @param totalCost double
     * @param pizzas    List<Pizza>
     */
    public Billing(final double totalCost, final List<Pizza> pizzas) {
        this.totalCost = totalCost;
        this.pizzas = pizzas;
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