package pizzeria.datos;

/**
 * Enumerator for ingredients.
 *
 * @author David Mamamani
 *
 */
public enum Ingredient {
    /**
     * List of ingredients.
     */
    TOMATOES(2), MOZZARELLA_CHEESE(8), GREEN_PEPPER(3), RED_PEPPER(3),
    OLIVES(6), BASIL(6), GROUND(6), MUSHRROOMS(10), ARTICHOKES(8), EGG_PLANT(8),
    ONION(3), PARMESAN_CHEESE(8), CALM(15);

    /** cost for additional ingredient. **/
    private double cost;

    /**
     * Default Constructor.
     *
     * @param cost double.
     **/
    private Ingredient(final double cost) {
        this.cost = cost;
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
