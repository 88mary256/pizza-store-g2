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
    private final List<IngredientType> ingredients;

    /**
     * Parameterized constructor.
     *
     * @param newQuantity    int, quantity of products.
     * @param newPizzaType   PizzaTypes, type of pizza.
     * @param newIngredients List, list of ingredients.
     */
    public OrderPizzaItem(final int newQuantity, final PizzaTypes newPizzaType,
            final List<IngredientType> newIngredients) {
        super(newQuantity, ProductType.PIZZA);
        this.pizzaType = newPizzaType;
        this.ingredients = newIngredients;
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
        this.ingredients = Collections.EMPTY_LIST;
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
     * Getter of ingredients.
     *
     * @return IngredientType list.
     */
    public List<IngredientType> getIngredients() {
        return ingredients;
    }
}
