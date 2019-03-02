package pizzeria.datos;

import static pizzeria.datos.Ingredient.ARTICHOKES;
import static pizzeria.datos.Ingredient.BASIL;
import static pizzeria.datos.Ingredient.MOZZARELLA_CHEESE;
import static pizzeria.datos.Ingredient.OLIVES;
import static pizzeria.datos.Ingredient.RED_PEPPER;
import static pizzeria.datos.Ingredient.TOMATOES;

/**
 * Concrete Greek Pizza.
 *
 * @author David Mamani
 */
public class GreekPizza extends Pizza {
    /**
     * Cost of GreekPizza.
     */
    private static final double GREEK_COST = 84.99;

    /**
     * Default constructor.
     */
    public GreekPizza() {
        super(PizzaTypes.GREEK_PIZZA, GREEK_COST);
        addIngredients(TOMATOES);
        addIngredients(MOZZARELLA_CHEESE);
        addIngredients(RED_PEPPER);
        addIngredients(ARTICHOKES);
        addIngredients(OLIVES);
        addIngredients(BASIL);
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }

    @Override
    public void box() {

    }
}
