package pizzeria.data;

/**
 * Lasagna product.
 *
 * @author Marines Lopez Soliz
 */
public class Lasagna extends Product {
    /** Cost of a lasania. **/
    public static final double LASAGNA_COST = 35;

    /** Default Constructor. **/
    public Lasagna() {
        this.productType = ProductType.LASAGNA;
        this.cost = LASAGNA_COST;
    }

    /** Customized toString method. **/
    @Override
    public String toString() {
        return "Lasania[cost=" + cost + "]";
    }
}
