package pizzeria.business;

import java.util.ArrayList;
import java.util.List;

import pizzeria.data.Ingredient;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;

/**
 * Class to represent a store of pizzas or pizzeria.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaStore {

    /** Store name. **/
    private final String name;

    /** Factory of pizzas. **/
    private final PizzaFactory factory;

    public PizzaStore(final String newName,
            final List<Ingredient> newIngredients) {
        this.name = newName;
        this.factory = new PizzaFactory(newIngredients);
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
    public Billing orderPizza(final List<OrderItem> order) {
        double totalCost = 0;
        final List<Pizza> pizzas = new ArrayList<Pizza>();
        for (final OrderItem orderItem : order) {
            final Pizza pizza = factory.createPizza(orderItem.getType());
            System.out.println(pizza);
            for (int i = 0; i < orderItem.getQuantity(); i++) {
                pizzas.add(pizza);
            }
            totalCost += orderItem.getQuantity() * pizza.getCost();
        }
        return new Billing(totalCost, pizzas);
    }

    public String getName() {
        return this.name;
    }
}
