package pizzeria.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pizzeria.data.IngredientType;
import pizzeria.data.Pizza;
import pizzeria.data.PizzaTypes;
import pizzeria.data.ProductType;
import pizzeria.util.XmlParser;

/**
 * Class to simulate a client that buy a pizza in the store.
 *
 * @author Marines Lopez Soliz
 */
public final class Cliente {

    /**
     * Default constructor.
     **/
    private Cliente() {
    }

    /**
     * Main method to execute our purchase.
     *
     * @param args arguments of console execution.
     */
    public static void main(final String[] args) {
        final Company company = XmlParser
                .getCompany("resources/loadStores.xml");
        final Store store = company.getStore(0);

        final Pizza p1 = store.orderPizza(PizzaTypes.GREEK_PIZZA);
        final Pizza p2 = store.orderPizza(PizzaTypes.CALM_PIZZA);
        final Pizza p3 = store.orderPizza(PizzaTypes.VEGGIE_PIZZA);
        System.out.println(p1 + "\n" + p2 + "\n " + p3);

        final List<OrderItem> order = new ArrayList<OrderItem>();
        order.add(new OrderPizzaItem(2, PizzaTypes.VEGGIE_PIZZA));
        order.add(new OrderPizzaItem(1, PizzaTypes.CHEESE_PIZZA));
        final Collection<IngredientType> customCheese = store
                .getDefaultIngredients(PizzaTypes.CHEESE_PIZZA);
        customCheese.add(IngredientType.TOMATOES);
        customCheese.remove(IngredientType.GREEN_PEPPER);
        order.add(new OrderPizzaItem(1, PizzaTypes.CHEESE_PIZZA,
                (List<IngredientType>) customCheese));
        order.add(new OrderPizzaItem(1, PizzaTypes.GREEK_PIZZA));
        final Collection<IngredientType> customGreek = store
                .getDefaultIngredients(PizzaTypes.CHEESE_PIZZA);
        customGreek.remove(IngredientType.ARTICHOKES);
        order.add(new OrderPizzaItem(1, PizzaTypes.GREEK_PIZZA,
                (List<IngredientType>) customGreek));
        order.add(new OrderItem(2, ProductType.LASANIA));

        final Billing billing = store.orderProducts(order);
        System.out.println(billing.getTotalCost());
        System.out.println(billing.getItems());
    }
}
