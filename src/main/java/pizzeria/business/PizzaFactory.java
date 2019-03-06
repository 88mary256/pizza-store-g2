package pizzeria.business;

import java.util.ArrayList;
import java.util.List;

import pizzeria.data.CalmPizza;
import pizzeria.data.CheesePizza;
import pizzeria.data.GreekPizza;
import pizzeria.data.Ingredient;
import pizzeria.data.PepperoniPizza;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;
import pizzeria.data.VeggiePizza;

/**
 * Factory Class to help us create different types of Pizzas.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaFactory {

    /** Ingredients per store. **/
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    /**
     * Parameterized constructor.
     *
     * @param newIngredients ingredient list
     */
    public PizzaFactory(final List<Ingredient> newIngredients) {
        this.ingredients = newIngredients;
    }

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
