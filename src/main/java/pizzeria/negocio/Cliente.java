package main.java.pizzeria.negocio;

import java.util.ArrayList;
import java.util.List;

import main.java.pizzeria.datos.PizzaTypes;

/**
 * Class to simulate a client that buy a pizza in the store.
 *
 * @author Marines Lopez Soliz
 */
public class Cliente {

    /**
     * Main method to execute our purchase.
     *
     * @param args arguments of console execution.
     */
    public static void main(final String[] args) {
        final PizzaStore store = new PizzaStore();

        store.orderPizza(PizzaTypes.GREEK_PIZZA);
        store.orderPizza(PizzaTypes.CALM_PIZZA);
        store.orderPizza(PizzaTypes.VEGGIE_PIZZA);

        final List<OrderItem> order = new ArrayList<OrderItem>();
        order.add(new OrderItem(2, PizzaTypes.VEGGIE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.CHEESE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.GREEK_PIZZA));

        final Billing billing = store.orderPizza(order);
        System.out.println(billing.getTotalCost());
        System.out.println(billing.getPizzas());
    }

}
