package pizzeria.datos;

import static main.java.pizzeria.datos.Ingredient.CALM;
import static main.java.pizzeria.datos.Ingredient.MOZZARELLA_CHEESE;
import static main.java.pizzeria.datos.Ingredient.PARMESAN_CHEESE;
import static main.java.pizzeria.datos.Ingredient.RED_PEPPER;

/**
 * Concrete Calm Pizza.
 *
 * @author David Mamani
 */
public class CalmPizza extends Pizza {
    /**
     * Cost of CalmPizza.
     */
    private static final double CALM_COST = 94.99;

    /**
     * Default constructor.
     */
    public CalmPizza() {
        super(PizzaTypes.CALM_PIZZA, CALM_COST);
        addIngredients(PARMESAN_CHEESE);
        addIngredients(CALM);
        addIngredients(MOZZARELLA_CHEESE);
        addIngredients(RED_PEPPER);
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
