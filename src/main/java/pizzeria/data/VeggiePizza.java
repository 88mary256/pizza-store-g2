package pizzeria.data;

import static pizzeria.data.IngredientType.EGG_PLANT;
import static pizzeria.data.IngredientType.GROUND;
import static pizzeria.data.IngredientType.MUSHRROOMS;
import static pizzeria.data.IngredientType.ONION;
import static pizzeria.data.IngredientType.RED_PEPPER;

/**
 * Concrete Veggie Pizza.
 *
 * @author David Mamani
 */
public class VeggiePizza extends Pizza {

    /**
     * Default constructor.
     */
    public VeggiePizza() {
        super(PizzaTypes.VEGGIE_PIZZA);
        addIngredients(EGG_PLANT);
        addIngredients(MUSHRROOMS);
        addIngredients(ONION);
        addIngredients(RED_PEPPER);
        addIngredients(GROUND);
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
