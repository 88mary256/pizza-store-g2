package pizzeria.data;

import static pizzeria.data.Ingredient.EGG_PLANT;
import static pizzeria.data.Ingredient.GROUND;
import static pizzeria.data.Ingredient.MUSHRROOMS;
import static pizzeria.data.Ingredient.ONION;
import static pizzeria.data.Ingredient.RED_PEPPER;

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
