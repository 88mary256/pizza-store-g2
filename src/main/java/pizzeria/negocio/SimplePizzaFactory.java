package main.java.pizzeria.negocio;

import main.java.pizzeria.datos.CalmPizza;
import main.java.pizzeria.datos.CheesePizza;
import main.java.pizzeria.datos.GreekPizza;
import main.java.pizzeria.datos.PepperoniPizza;
import main.java.pizzeria.datos.Pizza;
import main.java.pizzeria.datos.PizzaTypes;
import main.java.pizzeria.datos.VeggiePizza;

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
    public Pizza createPizza(PizzaTypes type) {
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
        }
        return null;
    }

}
