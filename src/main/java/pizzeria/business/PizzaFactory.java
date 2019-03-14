package pizzeria.business;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import pizzeria.data.CalmPizza;
import pizzeria.data.CheesePizza;
import pizzeria.data.GreekPizza;
import pizzeria.data.Ingredient;
import pizzeria.data.IngredientType;
import pizzeria.data.PepperoniPizza;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;
import pizzeria.data.VeggiePizza;

/**
 * Factory Class to help us create different types of Pizzas.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaFactory {

    /** Ingredients per store. **/
    private final Map<IngredientType, Ingredient> storeIngredients;

    /** Ingredient types per pizza in one store. **/
    private final Map<PizzaTypes, Collection<IngredientType>> menuDetail;

    /**
     * Parameterized constructor.
     *
     * @param newStoreIngredients ingredient collection for store.
     * @param newMenuDetail       pizza with ingredient types for store.
     */
    public PizzaFactory(
            final Map<IngredientType, Ingredient> newStoreIngredients,
            final Map<PizzaTypes, Collection<IngredientType>> newMenuDetail) {
        this.storeIngredients = newStoreIngredients;
        this.menuDetail = newMenuDetail;
    }

    /**
     * Create a pizza from pizza type.
     *
     * @param type PizaType
     * @return Pizza
     */
    public Pizza createPizza(final PizzaTypes type) {
        Pizza pizza = new Pizza(type);
        switch (type) {
        case CHEESE_PIZZA:
            pizza = new CheesePizza();
            break;
        case GREEK_PIZZA:
            pizza = new GreekPizza();
            break;
        case PEPPERONI_PIZZA:
            pizza = new PepperoniPizza();
            break;
        case CALM_PIZZA:
            pizza = new CalmPizza();
            break;
        case VEGGIE_PIZZA:
            pizza = new VeggiePizza();
            break;
        }
        addIngredients(pizza, getDefaultIngredients(pizza.getPizzaType()));
        return pizza;
    }

    /**
     * Create a pizza from pizza type.
     *
     * @param type       PizaType
     * @param additional ingredients
     * @param toRemove   ingredients
     * @return Pizza
     */
    public Pizza createPizza(final PizzaTypes type,
            final List<IngredientType> ingredients) {
        Pizza pizza = new Pizza(type);
        switch (type) {
        case CHEESE_PIZZA:
            pizza = new CheesePizza();
            break;
        case GREEK_PIZZA:
            pizza = new GreekPizza();
            break;
        case PEPPERONI_PIZZA:
            pizza = new PepperoniPizza();
            break;
        case CALM_PIZZA:
            pizza = new CalmPizza();
            break;
        case VEGGIE_PIZZA:
            pizza = new VeggiePizza();
            break;
        }
        addIngredients(pizza, ingredients);
        if (ingredients.isEmpty()) {
            addIngredients(pizza, getDefaultIngredients(pizza.getPizzaType()));
        }
        return pizza;
    }

    /**
     * Method that add extra ingredients to a pizza.
     *
     * @param pizza      pizza
     * @param additional ingredient list
     */
    private void addIngredients(final Pizza pizza,
            final Collection<IngredientType> additional) {
        for (final IngredientType ingredientType : additional) {
            pizza.addIngredients(storeIngredients.get(ingredientType));
        }
    }

    public Collection<IngredientType> getDefaultIngredients(
            final PizzaTypes type) {
        return menuDetail.containsKey(type) ? menuDetail.get(type)
                : Collections.EMPTY_LIST;
    }
}
