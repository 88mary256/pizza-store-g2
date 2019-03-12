package pizzeria.business;

import pizzeria.gui.Frame;

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
        /*
         * final Company company = XmlParser
         * .getCompany("resources/loadStores.xml"); final Store store =
         * company.getStore(0);
         * 
         * final Pizza p1 = store.orderPizza(PizzaTypes.GREEK_PIZZA); final
         * Pizza p2 = store.orderPizza(PizzaTypes.CALM_PIZZA); final Pizza p3 =
         * store.orderPizza(PizzaTypes.VEGGIE_PIZZA); System.out.println(p1 +
         * "\n" + p2 + "\n " + p3);
         * 
         * final List<OrderItem> order = new ArrayList<OrderItem>();
         * order.add(new OrderPizzaItem(2, PizzaTypes.VEGGIE_PIZZA));
         * order.add(new OrderPizzaItem(1, PizzaTypes.CHEESE_PIZZA));
         * order.add(new OrderPizzaItem(1, PizzaTypes.CHEESE_PIZZA,
         * Arrays.asList(IngredientType.TOMATOES),
         * Arrays.asList(IngredientType.GREEN_PEPPER))); order.add(new
         * OrderPizzaItem(1, PizzaTypes.GREEK_PIZZA)); order.add(new
         * OrderPizzaItem(1, PizzaTypes.GREEK_PIZZA, Collections.EMPTY_LIST,
         * Arrays.asList(IngredientType.ARTICHOKES))); order.add(new
         * OrderItem(2, ProductType.LASANIA));
         * 
         * final Billing billing = store.orderProducts(order);
         * System.out.println(billing.getTotalCost());
         * System.out.println(billing.getPizzas());
         * System.out.println(billing.getProducts());
         */
        final Frame interfaz = new Frame();
    }
}
