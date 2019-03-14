package pizzeria.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Define common variables and methods for different Pizza products.
 *
 * @author David Mamani
 *
 */

public class Pizza extends Product {
    /**
     * Cost of base customPizza.
     */
    public static final double CUSTOM_COST = 44.99;

    /** Type of the pizza. **/
    private final PizzaTypes type;

    /** Ingredients of a pizza. **/
    private final List<Ingredient> ingredients = new ArrayList<Ingredient>();

    /** Default Constructor. **/
    private Pizza() {
        this.productType = ProductType.PIZZA;
        this.type = PizzaTypes.CUSTOM_PIZZA;
        this.cost = CUSTOM_COST;
    }

    /**
     * Parameterized constructor.
     *
     * @param newType This is the type.
     */
    public Pizza(final PizzaTypes newType) {
        this.productType = ProductType.PIZZA;
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

    /** Customized toString method. **/
    @Override
    public String toString() {
        return "Pizza[type=" + type + ", cost=" + cost + ", ingredients= "
                + ingredients + "]";
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

    public PizzaTypes getPizzaType() {
        return type;
    }
}
