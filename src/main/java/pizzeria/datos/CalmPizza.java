package main.java.pizzeria.datos;

/**
 * Concrete Calm Pizza.
 *
 * @author David Mamamani
 */
public class CalmPizza extends Pizza {

    private static final double CALM_COST = 94.99;

    /**
     * Default constructor.
     */
    public CalmPizza() {
        super(PizzaTypes.CALM_PIZZA, CALM_COST);
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
