package main.java.pizzeria.datos;

/**
 * Concrete Veggie Pizza
 *
 * @author David Mamamani
 */
public class VeggiePizza extends Pizza {

    private String type;
    private final static double VEGGI_COST = 74.49;

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
