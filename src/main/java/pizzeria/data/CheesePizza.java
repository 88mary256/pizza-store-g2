package pizzeria.data;

import static pizzeria.data.IngredientType.CALM;
import static pizzeria.data.IngredientType.GREEN_PEPPER;
import static pizzeria.data.IngredientType.MOZZARELLA_CHEESE;
import static pizzeria.data.IngredientType.PARMESAN_CHEESE;

/**
 * Concrete Cheese Pizza.
 *
 * @author David Mamani
 */
public class CheesePizza extends Pizza {

    /**
     * Default constructor.
     */
    public CheesePizza() {
        super(PizzaTypes.CHEESE_PIZZA);
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
