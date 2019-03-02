package pizzeria.datos;

import static pizzeria.datos.Ingredient.EGG_PLANT;
import static pizzeria.datos.Ingredient.GROUND;
import static pizzeria.datos.Ingredient.MUSHRROOMS;
import static pizzeria.datos.Ingredient.ONION;
import static pizzeria.datos.Ingredient.RED_PEPPER;

/**
 * Concrete Veggie Pizza.
 *
 * @author David Mamani
 */
public class VeggiePizza extends Pizza {

    /**
     * Cost of VeggiePizza.
     */
    private static final double VEGGI_COST = 74.49;

    /**
     * Default constructor.
     */
    public VeggiePizza() {
        super(PizzaTypes.VEGGIE_PIZZA, VEGGI_COST);
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
