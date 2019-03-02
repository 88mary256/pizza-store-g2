package pizzeria.datos;

import static pizzeria.datos.Ingredient.CALM;
import static pizzeria.datos.Ingredient.GREEN_PEPPER;
import static pizzeria.datos.Ingredient.MOZZARELLA_CHEESE;
import static pizzeria.datos.Ingredient.PARMESAN_CHEESE;

/**
 * Concrete Cheese Pizza.
 *
 * @author David Mamani
 */
public class CheesePizza extends Pizza {
    /**
     * Cost of CheesePizza.
     */
    private static final double CHEESE_COST = 98.49;

    /**
     * Default constructor.
     */
    public CheesePizza() {
        super(PizzaTypes.CHEESE_PIZZA, CHEESE_COST);
        addIngredients(PARMESAN_CHEESE);
        addIngredients(MOZZARELLA_CHEESE);
        addIngredients(GREEN_PEPPER);
        addIngredients(CALM);
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
