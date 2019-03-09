/**
 * Info about this package doing something for package-info.java file.
 */
package pizzeria.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pizzeria.data.CalmPizza;
import pizzeria.data.CheesePizza;
import pizzeria.data.GreekPizza;
import pizzeria.data.Ingredient;
import pizzeria.data.PepperoniPizza;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;
import pizzeria.data.VeggiePizza;
import pizzeria.util.XmlParser;

/**
 * Test suit to verify that pizza store create all types of pizzas.
 *
 * @author Marines Lopez Soliz
 *
 */
public class PizzaStoreTests {

    /** store. **/
    private PizzaStore store;

    /** Method to initialice test suit data. **/
    @Before
    public void before() {
        final Company company = XmlParser
                .getCompany("resources/loadStores.xml");
        store = company.getStore(0);
    }

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
        final int sizeOfPrice = 8;

        final Billing billing = store.orderPizza(order);
        assertEquals(
                String.valueOf(billing.getTotalCost()).substring(0,
                        sizeOfPrice),
                String.valueOf(getBillingCost(billing)).substring(0,
                        sizeOfPrice));
        assertEquals(billing.getPizzas().size(), amountOfPizzas);
    }

    /**
     * Get cost of a billing.
     *
     * @param bill billing
     * @return cost of the billing
     */
    private double getBillingCost(final Billing bill) {
        double cost = 0;
        for (final Pizza pizza : bill.getPizzas()) {
            cost += getCost(pizza);
        }
        return cost;
    }

    /**
     * Get cost of a pizza.
     *
     * @param pizza pizza
     * @return cost of a pizza
     */
    private double getCost(final Pizza pizza) {
        double cost = Pizza.CUSTOM_COST;
        for (final Ingredient ingredient : pizza.getIngredients()) {
            cost += ingredient.getCost();
        }
        return cost;
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
