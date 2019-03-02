package main.java.pizzeria.datos;

/**
 * Concrete Pepperoni Pizza.
 *
 * @author David Mamani
 */
public class PepperoniPizza extends Pizza {
/**
* Cost of PepperoniPizza.
*/
    private static final double PEPPERONI_COST = 89.99;

    /**
     * Default constructor.
     */
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
