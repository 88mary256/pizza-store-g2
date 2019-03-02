package pizzeria.data;

/**
 * Enumerator for ingredients.
 *
 * @author David Mamamani
 *
 */
public enum Ingredient {
    /** List of ingredients. */
    TOMATOES(2), MOZZARELLA_CHEESE(8), GREEN_PEPPER(3), RED_PEPPER(3),
    /** List of ingredients. */
    OLIVES(6), BASIL(6), GROUND(6), MUSHRROOMS(10), ARTICHOKES(8), EGG_PLANT(8),
    /** List of ingredients. */
    ONION(3), PARMESAN_CHEESE(8), CALM(15);

    /** cost for additional ingredient. **/
    private double cost;

    /**
     * Default Constructor.
     *
     * @param newCost double.
     **/
    Ingredient(final double newCost) {
        this.cost = newCost;
    }

    /**
     * Getter of the cost.
     *
     * @return cost double.
     **/
    public double getCost() {
        return cost;
    }
}
