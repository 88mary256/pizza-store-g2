package main.java.pizzeria.datos;

/**
 * Concrete Pepperoni Pizza.
 *
 * @author David Mamamani
 */
public class PepperoniPizza extends Pizza {

    private final static double PEPPERONI_COST = 89.99;

    public PepperoniPizza() {
        super(PizzaTypes.PEPPERONI_PIZZA, PEPPERONI_COST);
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
