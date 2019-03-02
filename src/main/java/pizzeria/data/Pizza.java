package pizzeria.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Define common activities for different Pizza products.
 *
 * @author David Mamani
 *
 */

public class Pizza {
    /**
     * Cost of base customPizza.
     */
    private static final double CUSTOM_COST = 44.99;

    /** Type of the pizza. **/
    private final PizzaTypes type;

    /** cost of the pizza. **/
    private double cost;

    /** ingredients of a pizza. **/
    private final List<Ingredient> ingredients = new ArrayList<Ingredient>();

    /** Default Constructor. **/
    private Pizza() {
        this.type = PizzaTypes.CUSTOM_PIZZA;
        this.cost = CUSTOM_COST;
    }

    /**
     * Parameterized constructor.
     *
     * @param newType This is the type.
     */
    public Pizza(final PizzaTypes newType) {
        this.type = newType;
        this.cost = CUSTOM_COST;
    }

    /**
     * Method that prepare the pizza.
     */
    public void prepare() {
    }

    /**
     * Method that bake the pizza.
     */
    public void bake() {
    }

    /**
     * Method that cut the pizza.
     */
    public void cut() {
    }

    /**
     * Method that box the pizza.
     */
    public void box() {
    }

    /**
     * Getter of cost.
     *
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /** Customized toString method. **/
    @Override
    public String toString() {
        return "Pizza " + type + " cost:" + cost;
    }

    /**
     * Getter of ingredients.
     *
     * @return ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Adder of ingredient.
     *
     * @param ingredient this a single ingredient.
     */
    public void addIngredients(final Ingredient ingredient) {
        this.ingredients.add(ingredient);
        this.cost += ingredient.getCost();
    }

    /**
     * Remover of ingredients.
     *
     * @param ingredient this is single ingredient.
     */
    public void removeIngredients(final Ingredient ingredient) {
        this.ingredients.remove(ingredient);
        this.cost = this.cost - ingredient.getCost();
    }
}
