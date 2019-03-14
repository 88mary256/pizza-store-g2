package pizzeria.business;

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
        final Billing billing = new Billing();
        for (final OrderItem item : order) {
            billing.addProduct(createBillingItem(item));
        }
        return billing;
    }

    /**
     * Create a billingItem from an order.
     *
     * @param item Order item
     * @return billing item
     */
    public BillingItem createBillingItem(final OrderItem item) {
        Product product = new Product();
        if (item.getProductType() == ProductType.PIZZA) {
            final OrderPizzaItem orderPizzaItem = (OrderPizzaItem) item;
            final Pizza pizza = factory.createPizza(
                    orderPizzaItem.getPizzaType(),
                    orderPizzaItem.getIngredients());
            product = pizza;
        } else if (item.getProductType() == ProductType.LASANIA) {
            product = orderLasania();
        }
        return new BillingItem(item.getQuantity(), product);
    }

    /**
     * Create a product Lasania.
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

    /**
     * Getter of default ingredients for a pizza type.
     *
     * @param type pizza type.
     * @return list of ingredients type.
     */
    public Collection<IngredientType> getDefaultIngredients(
            final PizzaTypes type) {
        return factory.getDefaultIngredients(type);
    }
}
