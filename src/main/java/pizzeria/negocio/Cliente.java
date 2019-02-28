package main.java.pizzeria.negocio;

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
    public static void main(String[] args) {
        final PizzaStore store = new PizzaStore();

        store.orderPizza(PizzaTypes.GREEK_PIZZA);
        store.orderPizza(PizzaTypes.CLAM_PIZZA);
        store.orderPizza(PizzaTypes.VEGGIE_PIZZA);

    }

}
