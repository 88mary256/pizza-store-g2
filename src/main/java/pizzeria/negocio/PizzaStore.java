package pizzeria.negocio;

import java.util.ArrayList;
import java.util.List;

import pizzeria.datos.Pizza;
import pizzeria.datos.PizzaTypes;

/**
 * Class to represent a store of pizzas or pizzeria.
 *
 * @author Marines Lopez Soliz
 */
public class PizzaStore {

    private final SimplePizzaFactory factory = new SimplePizzaFactory();

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
            for (int i = 0; i < orderItem.getQuantity(); i++) {
                pizzas.add(pizza);
            }
            totalCost += orderItem.getQuantity() * pizza.getCost();
        }
        return new Billing(totalCost, pizzas);
    }
}
