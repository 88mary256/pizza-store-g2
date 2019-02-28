package test.java.pizzeria;

import static org.junit.Assert.assertTrue;

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
import main.java.pizzeria.negocio.PizzaStore;

/**
 * Test suit to verify that pizza store create all types of pizzas.
 *
 * @author Marines Lopez Soliz
 *
 */
class PizzaStoreTests {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void pizzaStore_createGreekPizza_ok() {
        final PizzaStore store = new PizzaStore();
        final Pizza pizza = store.orderPizza(PizzaTypes.GREEK_PIZZA);
        assertTrue(pizza instanceof GreekPizza);
    }

    @Test
    void pizzaStore_CalmPizza_ok() {
        final PizzaStore store = new PizzaStore();
        final Pizza pizza = store.orderPizza(PizzaTypes.CLAM_PIZZA);
        assertTrue(pizza instanceof CalmPizza);
    }

    @Test
    void pizzaStore_createCheesePizza_ok() {
        final PizzaStore store = new PizzaStore();
        final Pizza pizza = store.orderPizza(PizzaTypes.CHEESSE_PIZZA);
        assertTrue(pizza instanceof CheesePizza);
    }

    @Test
    void pizzaStore_createPepperoniPizza_ok() {
        final PizzaStore store = new PizzaStore();
        final Pizza pizza = store.orderPizza(PizzaTypes.PEPERONI_PIZZA);
        assertTrue(pizza instanceof PepperoniPizza);
    }

    @Test
    void pizzaStore_createVeggiePizza_ok() {
        final PizzaStore store = new PizzaStore();
        final Pizza pizza = store.orderPizza(PizzaTypes.VEGGIE_PIZZA);
        assertTrue(pizza instanceof VeggiePizza);
    }

}
