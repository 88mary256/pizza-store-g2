package pizzeria.data;

/**
 * This enum represents all types of products.
 *
 * @author Marines Lopez Soliz
 *
 */
public enum ProductType {
    /** Product types. **/
    PIZZA, LASANIA;

    /**
     * Get enum type from name.
     *
     * @param typeName name
     * @return ProductType
     */
    public static ProductType get(final String typeName) {
        for (final ProductType type : ProductType.values()) {
            if (type.name().equalsIgnoreCase(typeName.trim())) {
                return type;
            }
        }
        return null;
    }
}
