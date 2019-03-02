package pizzeria.business;

import pizzeria.data.CalmPizza;
import pizzeria.data.CheesePizza;
import pizzeria.data.GreekPizza;
import pizzeria.data.PepperoniPizza;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;
import pizzeria.data.VeggiePizza;

/**
 * Factory Class to help us create different types of Pizzas.
 *
 * @author Marines Lopez Soliz
 */
public class SimplePizzaFactory {

    /**
     * Create a pizza from pizza type.
     *
     * @param type PizaType
     * @return Pizza
     */
    public Pizza createPizza(final PizzaTypes type) {
        switch (type) {
        case CHEESE_PIZZA:
            return new CheesePizza();
        case GREEK_PIZZA:
            return new GreekPizza();
        case PEPPERONI_PIZZA:
            return new PepperoniPizza();
        case CALM_PIZZA:
            return new CalmPizza();
        case VEGGIE_PIZZA:
            return new VeggiePizza();
        default:
            return null;
        }
    }

}
