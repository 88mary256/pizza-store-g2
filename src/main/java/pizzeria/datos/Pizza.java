package main.java.pizzeria.datos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Define common activities for different Pizza products.
 *
 * @author David Mamani
 *
 */

public abstract class Pizza {

    private final PizzaTypes type;
    private final double cost;
    private final List<Ingredient> ingredients = new ArrayList<Ingredient>();

    /**
     * Parameterized constructor.
     *
     * @param cost This is the cost.
     * @param type This is the type.
     */
    public Pizza(final PizzaTypes type, final double cost) {
        this.type = type;
        this.cost = cost;
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
     * Adder of ingredients.
     *
     * @param ingredient
     */
    public void addIngredients(final Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    /**
     * Remover of ingredients.
     *
     * @param ingredient
     */
    public void removeIngredients(final Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
}