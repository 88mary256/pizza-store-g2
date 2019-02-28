package main.java.pizzeria.datos;

/**
 * Concrete Veggie Pizza.
 *
 * @author David Mamani
 */
public class VeggiePizza extends Pizza {

    private String type;
    private static final double VEGGI_COST = 74.49;

    /**
     * Default constructor.
     */
    public VeggiePizza() {
        super(PizzaTypes.VEGGIE_PIZZA, VEGGI_COST);
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
