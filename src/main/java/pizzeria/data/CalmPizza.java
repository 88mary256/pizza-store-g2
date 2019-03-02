/**
 * Info about this package doing something for package-info.java file.
 */
package pizzeria.data;

import static pizzeria.data.Ingredient.CALM;
import static pizzeria.data.Ingredient.MOZZARELLA_CHEESE;
import static pizzeria.data.Ingredient.PARMESAN_CHEESE;
import static pizzeria.data.Ingredient.RED_PEPPER;

/**
 * Concrete Calm Pizza.
 *
 * @author David Mamani
 */
public class CalmPizza extends Pizza {

    /**
     * Default constructor.
     */
    public CalmPizza() {
        super(PizzaTypes.CALM_PIZZA);
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
