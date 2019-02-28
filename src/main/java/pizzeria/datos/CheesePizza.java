package main.java.pizzeria.datos;

/**
 * Concrete Cheese Pizza
 *
 * @author David Mamamani
 */
public class CheesePizza extends Pizza {

    private final static double CHEESE_COST = 98.49;

    public CheesePizza() {
        super(PizzaTypes.CHEESE_PIZZA, CHEESE_COST);
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }

    @Override
    public void box() {

    }
}
