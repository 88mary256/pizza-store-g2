package pizzeria.business;

import java.util.Collections;
import java.util.List;

import pizzeria.data.IngredientType;
import pizzeria.data.PizzaTypes;
import pizzeria.data.ProductType;

/**
 * Specification of OrderItem to order pizzas.
 *
 * @author Marines Lopez Soliz
 *
 */
public class OrderPizzaItem extends OrderItem {

    /** Type of pizza. **/
    private final PizzaTypes pizzaType;

    /** Ingredients to add. **/
    private final List<IngredientType> additionalIngredients;

    /** Ingredients to remove. **/
    private final List<IngredientType> removedIngredients;

    /**
     * Parameterized constructor.
     *
     * @param newQuantity              int, quantity of products.
     * @param newPizzaType             PizzaTypes, type of pizza.
     * @param newAdditionalIngredients List, list of additional ingredients.
     * @param newRemovedIngredients    List, list of ingredients to be removed.
     */
    public OrderPizzaItem(final int newQuantity, final PizzaTypes newPizzaType,
            final List<IngredientType> newAdditionalIngredients,
            final List<IngredientType> newRemovedIngredients) {
        super(newQuantity, ProductType.PIZZA);
        this.pizzaType = newPizzaType;
        this.additionalIngredients = newAdditionalIngredients;
        this.removedIngredients = newRemovedIngredients;
    }

    /**
     * Parameterized constructor.
     *
     * @param newQuantity  int, quantity of products.
     * @param newPizzaType PizzaTypes, type of pizza.
     */
    public OrderPizzaItem(final int newQuantity,
            final PizzaTypes newPizzaType) {
        super(newQuantity, ProductType.PIZZA);
        this.pizzaType = newPizzaType;
        this.additionalIngredients = Collections.EMPTY_LIST;
        this.removedIngredients = Collections.EMPTY_LIST;
    }

    /**
     * Getter of pizza type.
     *
     * @return type of pizza.
     */
    public PizzaTypes getPizzaType() {
        return pizzaType;
    }

    /**
     * Getter of additional ingredients.
     *
     * @return IngredientType list.
     */
    public List<IngredientType> getAdditionalIngredients() {
        return additionalIngredients;
    }

    /**
     * Getter of ingredients to remove.
     *
     * @return IngredientType list.
     */
    public List<IngredientType> getRemovedIngredients() {
        return removedIngredients;
    }
}
