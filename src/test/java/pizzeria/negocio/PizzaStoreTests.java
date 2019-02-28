package test.java.pizzeria.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.pizzeria.datos.CalmPizza;
import main.java.pizzeria.datos.CheesePizza;
import main.java.pizzeria.datos.GreekPizza;
import main.java.pizzeria.datos.PepperoniPizza;
import main.java.pizzeria.datos.Pizza;
import main.java.pizzeria.datos.PizzaTypes;
import main.java.pizzeria.datos.VeggiePizza;
import main.java.pizzeria.negocio.Billing;
import main.java.pizzeria.negocio.OrderItem;
import main.java.pizzeria.negocio.PizzaStore;

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
     * Test case to verify greek pizza creation.
     */
    @Test
    public void pizzaStoreCreateGreekPizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.GREEK_PIZZA);
        assertTrue(pizza instanceof GreekPizza);
    }

    /**
     * Test case to verify calm pizza creation.
     */
    @Test
    public void pizzaStoreCalmPizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.CALM_PIZZA);
        assertTrue(pizza instanceof CalmPizza);
    }

    /**
     * Test case to verify cheese pizza creation.
     */
    @Test
    public void pizzaStoreCreateCheesePizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.CHEESE_PIZZA);
        assertTrue(pizza instanceof CheesePizza);
    }

    /**
     * Test case to verify pepperoni pizza creation.
     */
    @Test
    public void pizzaStoreCreatePepperoniPizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.PEPPERONI_PIZZA);
        assertTrue(pizza instanceof PepperoniPizza);
    }

    /**
     * Test case to verify veggie pizza creation.
     */
    @Test
    public void pizzaStoreCreateVeggiePizzaOk() {
        final Pizza pizza = store.orderPizza(PizzaTypes.VEGGIE_PIZZA);
        assertTrue(pizza instanceof VeggiePizza);
    }

    /**
     * Test case to verify that is possible order multiple pizzas and get the total
     * cost and pizzas list.
     */
    @Test
    public void pizzaStoreOrderGroupOfPizzasBilling() {
        final List<OrderItem> order = new ArrayList<OrderItem>();
        order.add(new OrderItem(2, PizzaTypes.VEGGIE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.CHEESE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.GREEK_PIZZA));
        final int amountOfPizzas = 4;

        final Billing billing = store.orderPizza(order);
        assertEquals(String.valueOf(billing.getTotalCost()), "332.46");
        assertEquals(billing.getPizzas().size(), amountOfPizzas);
    }

    /**
     * Test case to verify that is possible order multiple pizzas and get the
     * correct pizzas.
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
        assertTrue(billing.getPizzas().get(billing.getPizzas().size() - 1) instanceof GreekPizza);
    }

}
