package test.java.pizzeria.negocio;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
class PizzaStoreTests {

    private final PizzaStore store = new PizzaStore();

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void pizzaStore_createGreekPizza_ok() {
        final Pizza pizza = store.orderPizza(PizzaTypes.GREEK_PIZZA);
        assertTrue(pizza instanceof GreekPizza);
    }

    @Test
    void pizzaStore_CalmPizza_ok() {
        final Pizza pizza = store.orderPizza(PizzaTypes.CALM_PIZZA);
        assertTrue(pizza instanceof CalmPizza);
    }

    @Test
    void pizzaStore_createCheesePizza_ok() {
        final Pizza pizza = store.orderPizza(PizzaTypes.CHEESE_PIZZA);
        assertTrue(pizza instanceof CheesePizza);
    }

    @Test
    void pizzaStore_createPepperoniPizza_ok() {
        final Pizza pizza = store.orderPizza(PizzaTypes.PEPPERONI_PIZZA);
        assertTrue(pizza instanceof PepperoniPizza);
    }

    @Test
    void pizzaStore_createVeggiePizza_ok() {
        final Pizza pizza = store.orderPizza(PizzaTypes.VEGGIE_PIZZA);
        assertTrue(pizza instanceof VeggiePizza);
    }

    @Test
    void pizzaStore_orderGroupOfPizzas_billing() {
        final List<OrderItem> order = new ArrayList<OrderItem>();
        order.add(new OrderItem(2, PizzaTypes.VEGGIE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.CHEESE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.GREEK_PIZZA));

        final Billing billing = store.orderPizza(order);
        assertEquals(billing.getTotalCost(), 332.46);
        assertEquals(billing.getPizzas().size(), 4);
    }

    @Test
    void pizzaStore_orderGroupOfPizzas_getCorrectPizzaTypes() {
        final List<OrderItem> order = new ArrayList<OrderItem>();
        order.add(new OrderItem(2, PizzaTypes.VEGGIE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.CHEESE_PIZZA));
        order.add(new OrderItem(1, PizzaTypes.GREEK_PIZZA));

        final Billing billing = store.orderPizza(order);
        assertTrue(billing.getPizzas().get(0) instanceof VeggiePizza);
        assertTrue(billing.getPizzas().get(1) instanceof VeggiePizza);
        assertTrue(billing.getPizzas().get(2) instanceof CheesePizza);
        assertTrue(billing.getPizzas().get(3) instanceof GreekPizza);
    }

}
