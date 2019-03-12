/**
 * Info about this package doing something for package-info.java file.
 */
package pizzeria.business;

import java.util.ArrayList;
import java.util.List;

import pizzeria.data.Product;

/**
 * Contains the total cost of an order and the products for it.
 *
 * @author Marines Lopez Soliz
 */
public class Billing {

    /** Total cost of the billing. **/
    private double totalCost = 0;

    /** Pizzas list of the billing. **/
    private List<Product> products = new ArrayList<Product>();

    /**
     * Parameterized constructor.
     *
     * @param newTotalCost double
     * @param newProducts  List<Product>
     */
    public Billing(final double newTotalCost, final List<Product> newProducts) {
        this.totalCost = newTotalCost;
        this.products = newProducts;
    }

    /**
     * Getter of total cost.
     *
     * @return totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Getter of products.
     *
     * @return products
     */
    public List<Product> getProducts() {
        return products;
    }
}
