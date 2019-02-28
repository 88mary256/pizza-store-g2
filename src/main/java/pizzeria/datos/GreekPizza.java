package main.java.pizzeria.datos;

/**
 * Concrete Greek Pizza.
 *
 * @author David Mamani
 */
public class GreekPizza extends Pizza {

    private static final double GREEK_COST = 84.99;

    /**
     * Default constructor.
     */
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
