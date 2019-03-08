package pizzeria.data;

/**
 * Enumerator for types of pizzas.
 *
 * @author Marines Lopez Soliz
 *
 */
public enum PizzaTypes {
    /** List of Pizza Types. */
    CHEESE_PIZZA, GREEK_PIZZA, PEPPERONI_PIZZA, CALM_PIZZA, VEGGIE_PIZZA,
    /** List of Pizza Types. */
    CUSTOM_PIZZA;

    /**
     * Get enum type from name.
     *
     * @param typeName name
     * @return PizzaTypes
     */
    public static PizzaTypes get(final String typeName) {
        for (final PizzaTypes ingredientType : PizzaTypes.values()) {
            if (ingredientType.name().equalsIgnoreCase(typeName.trim()))
                return ingredientType;
        }
        return null;
    }
}
