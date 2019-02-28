package main.java.pizzeria.negocio;

import main.java.pizzeria.datos.Pizza;
import main.java.pizzeria.datos.PizzaTypes;

/**
 * Class to represent a store of pizzas or pizzeria.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaStore {

    /**
     * Create a pizza with the pizzaType.
     * 
     * @param type PizzaType
     * @return Pizza
     */
    public Pizza orderPizza(PizzaTypes type) {
        return (new SimplePizzaFactory()).createPizza(type);
    }
}
