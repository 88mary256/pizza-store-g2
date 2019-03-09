package pizzeria.data;

/**
 * Enumerator for ingredients.
 *
 * @author David Mamamani
 *
 */
public enum IngredientType {
    /** List of ingredients. */
    TOMATOES, MOZZARELLA_CHEESE, GREEN_PEPPER, RED_PEPPER, OLIVES, BASIL,
    /** List of ingredients. */
    GROUND, MUSHRROOMS, ARTICHOKES, EGG_PLANT, ONION, PARMESAN_CHEESE, CALM,
    /** List of ingredients. */
    PEPPERONI;

    /**
     * Get enum type from name.
     *
     * @param typeName name
     * @return IngredientType
     */
    public static IngredientType get(final String typeName) {
        for (final IngredientType ingredientType : IngredientType.values()) {
            if (ingredientType.name().equalsIgnoreCase(typeName.trim())) {
                return ingredientType;
            }
        }
        return null;
    }
}
