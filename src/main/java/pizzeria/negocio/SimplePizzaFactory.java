package pizzeria.negocio;

import pizzeria.datos.CalmPizza;
import pizzeria.datos.CheesePizza;
import pizzeria.datos.GreekPizza;
import pizzeria.datos.PepperoniPizza;
import pizzeria.datos.Pizza;
import pizzeria.datos.PizzaTypes;
import pizzeria.datos.VeggiePizza;

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
