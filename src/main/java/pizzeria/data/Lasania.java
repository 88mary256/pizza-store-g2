package pizzeria.data;

/**
 *
 * @author Marines Lopez Soliz
 *
 */
public class Lasania extends Product {
    /** Cost of a lasania. **/
    public static final double LASANIA_COST = 35;

    /** Default Constructor. **/
    public Lasania() {
        this.productType = ProductType.LASANIA;
        this.cost = LASANIA_COST;
    }
}
