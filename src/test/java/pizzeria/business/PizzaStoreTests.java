/**
 * Info about this package doing something for package-info.java file.
 */
package pizzeria.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pizzeria.data.CalmPizza;
import pizzeria.data.CheesePizza;
import pizzeria.data.GreekPizza;
import pizzeria.data.PepperoniPizza;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;
import pizzeria.data.VeggiePizza;

/**
 * Test suit to verify that pizza store create all types of pizzas.
 *
 * @author Marines Lopez Soliz
 *
 */
public class PizzaStoreTests {

    /** store. **/
    private final PizzaStore store = new PizzaStore();

    /**
     * TC to verify greek pizza creation.
     */
    @Test
    public void pizzaStoreCreateGreekPizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.GREEK_PIZZA);
        assertTrue(pizza instanceof GreekPizza);
    }

    /**
     * TC to verify calm pizza creation.
     */
    @Test
    public void pizzaStoreCalmPizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.CALM_PIZZA);
        assertTrue(pizza instanceof CalmPizza);
    }

    /**
     * TC to verify cheese pizza creation.
     */
    @Test
    public void pizzaStoreCreateCheesePizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.CHEESE_PIZZA);
        assertTrue(pizza instanceof CheesePizza);
    }

    /**
     * TC to verify pepperoni pizza creation.
     */
    @Test
    public void pizzaStoreCreatePepperoniPizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.PEPPERONI_PIZZA);
        assertTrue(pizza instanceof PepperoniPizza);
    }

    /**
     * TC to verify veggie pizza creation.
     */
    @Test
    public void pizzaStoreCreateVeggiePizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.VEGGIE_PIZZA);
        assertTrue(pizza instanceof VeggiePizza);
    }

    /**
     * TC to verify that is possible order multiple pizza and get the total cost
     * and pizza list.
     */
    @Test
    public void pizzaStoreOrderGroupOfPizzasBilling() {
        final List<OrderItem> order = new ArrayList<OrderItem>();
        order.add(new OrderItem(2, PizzaTypes.VEGGIE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.CHEESE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.GREEK_PIZZA));
        final int amountOfPizzas = 4;
        final int sizeOfPrice = 6;

        final Billing billing = store.orderPizza(order);
        assertEquals(String.valueOf(billing.getTotalCost()).substring(0,
                sizeOfPrice), "306.96");
        assertEquals(billing.getPizzas().size(), amountOfPizzas);
    }

    /**
     * TC to verify that is possible order multiple pizzas and get the correct
     * Pizza.
     */
    @Test
    public void pizzaStoreOrderGroupOfPizzasGetCorrectPizzaTypes() {
        final List<OrderItem> order = new ArrayList<OrderItem>();
        order.add(new OrderItem(2, PizzaTypes.VEGGIE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.CHEESE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.GREEK_PIZZA));

        final Billing billing = store.orderPizza(order);
        assertTrue(billing.getPizzas().get(0) instanceof VeggiePizza);
        assertTrue(billing.getPizzas().get(1) instanceof VeggiePizza);
        assertTrue(billing.getPizzas().get(2) instanceof CheesePizza);
        assertTrue(billing.getPizzas()
                .get(billing.getPizzas().size() - 1) instanceof GreekPizza);
    }

}
