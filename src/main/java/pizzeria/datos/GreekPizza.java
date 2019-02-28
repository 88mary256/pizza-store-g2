package main.java.pizzeria.datos;

/**
 * Concrete Greek Pizza.
 *
 * @author David Mamamani
 */
public class GreekPizza extends Pizza {

    private final static double GREEK_COST = 84.99;

    public GreekPizza() {
        super(PizzaTypes.GREEK_PIZZA, GREEK_COST);
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
