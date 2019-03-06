package pizzeria.data;

import static pizzeria.data.IngredientType.ARTICHOKES;
import static pizzeria.data.IngredientType.BASIL;
import static pizzeria.data.IngredientType.MOZZARELLA_CHEESE;
import static pizzeria.data.IngredientType.OLIVES;
import static pizzeria.data.IngredientType.RED_PEPPER;
import static pizzeria.data.IngredientType.TOMATOES;

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
