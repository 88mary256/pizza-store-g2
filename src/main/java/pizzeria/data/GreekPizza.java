package pizzeria.data;

import static pizzeria.data.Ingredient.ARTICHOKES;
import static pizzeria.data.Ingredient.BASIL;
import static pizzeria.data.Ingredient.MOZZARELLA_CHEESE;
import static pizzeria.data.Ingredient.OLIVES;
import static pizzeria.data.Ingredient.RED_PEPPER;
import static pizzeria.data.Ingredient.TOMATOES;

/**
 * Concrete Greek Pizza.
 *
 * @author David Mamani
 */
public class GreekPizza extends Pizza {

    /**
     * Default constructor.
     */
    public GreekPizza() {
        super(PizzaTypes.GREEK_PIZZA);
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
