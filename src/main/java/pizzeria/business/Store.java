package pizzeria.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import pizzeria.data.Ingredient;
import pizzeria.data.IngredientType;
import pizzeria.data.Lasania;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;
import pizzeria.data.Product;
import pizzeria.data.ProductType;

/**
 * Class to represent a store of pizzas or pizzeria.
 *
 * @author Marines Lopez Soliz
 */
public class Store {

    /** Store name. **/
    private final String name;

    /** Factory of pizzas. **/
    private final PizzaFactory factory;

    /**
     * Parameterized constructor.
     *
     * @param newName        name
     * @param newIngredients store ingredient collection.
     * @param newMenuDetail  ingredient types of a pizza type per store.
     */
    public Store(final String newName,
            final Map<IngredientType, Ingredient> newIngredients,
            final Map<PizzaTypes, Collection<IngredientType>> newMenuDetail) {
        this.name = newName;
        this.factory = new PizzaFactory(newIngredients, newMenuDetail);
    }

    /**
     * Create a pizza with the pizzaType.
     *
     * @param type PizzaType
     * @return Pizza
     */
    public Pizza orderPizza(final PizzaTypes type) {
        return factory.createPizza(type);
    }

    /**
     * Create a billing from an order.
     *
     * @param order List<OrderItems>
     * @return billing
     */
    public Billing orderProducts(final List<OrderItem> order) {
        double totalCost = 0;
        final List<Product> products = new ArrayList<Product>();
        for (final OrderItem orderItem : order) {
            if (orderItem.getProductType() == ProductType.PIZZA) {
                final OrderPizzaItem orderPizzaItem = (OrderPizzaItem) orderItem;
                final Pizza pizza = factory.createPizza(
                        orderPizzaItem.getPizzaType(),
                        orderPizzaItem.getAdditionalIngredients(),
                        orderPizzaItem.getRemovedIngredients());
                addProducts(orderItem.getQuantity(), pizza, products);
                totalCost += orderItem.getQuantity() * pizza.getCost();

            } else if (orderItem.getProductType() == ProductType.LASANIA) {
                addProducts(orderItem.getQuantity(), orderLasania(), products);
                totalCost += orderItem.getQuantity() * Lasania.LASANIA_COST;
            }
        }
        return new Billing(totalCost, products);
    }

    /**
     * Add amount of products to the list.
     *
     * @param quantity quantity to add.
     * @param product  product to add.
     * @param products list of products.
     */
    private void addProducts(final int quantity, final Product product,
            final List<Product> products) {
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
    }

    /**
     * Create a product Lasania
     *
     * @return Lasania
     */
    public Lasania orderLasania() {
        return new Lasania();
    }

    /**
     * Getter of store name.
     *
     * @return name
     **/
    public String getName() {
        return this.name;
    }

    /**
     * Custom toString.
     * 
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }
}
