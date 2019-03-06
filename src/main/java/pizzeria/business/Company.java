package pizzeria.business;

import static pizzeria.data.IngredientType.ARTICHOKES;
import static pizzeria.data.IngredientType.BASIL;
import static pizzeria.data.IngredientType.CALM;
import static pizzeria.data.IngredientType.EGG_PLANT;
import static pizzeria.data.IngredientType.GREEN_PEPPER;
import static pizzeria.data.IngredientType.GROUND;
import static pizzeria.data.IngredientType.MOZZARELLA_CHEESE;
import static pizzeria.data.IngredientType.MUSHRROOMS;
import static pizzeria.data.IngredientType.OLIVES;
import static pizzeria.data.IngredientType.ONION;
import static pizzeria.data.IngredientType.PARMESAN_CHEESE;
import static pizzeria.data.IngredientType.RED_PEPPER;
import static pizzeria.data.IngredientType.TOMATOES;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pizzeria.data.Ingredient;

/** Class to represent the company, that contains multiple sucursales. **/
public class Company {

    private final List<PizzaStore> sucursales = new ArrayList<PizzaStore>();

    /** Default constructor. **/
    public Company() {
        final List<Ingredient> ingredientsSuc1 = new ArrayList<Ingredient>();
        ingredientsSuc1.add(new Ingredient(TOMATOES, 2, "250gr"));
        ingredientsSuc1.add(new Ingredient(GREEN_PEPPER, 3, "100gr"));
        ingredientsSuc1.add(new Ingredient(RED_PEPPER, 3, "100gr"));
        ingredientsSuc1.add(new Ingredient(ONION, 3, "500gr "));
        ingredientsSuc1.add(new Ingredient(OLIVES, 6, "6"));
        ingredientsSuc1.add(new Ingredient(BASIL, 6, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(GROUND, 6, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(MOZZARELLA_CHEESE, 8, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(PARMESAN_CHEESE, 8, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(ARTICHOKES, 8, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(EGG_PLANT, 8, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(MUSHRROOMS, 10, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(CALM, 15, "0.5kg"));
        final PizzaStore sucursal1 = new PizzaStore("sucursal 1",
                ingredientsSuc1);

        final List<Ingredient> ingredientsSuc2 = new ArrayList<Ingredient>();
        ingredientsSuc1.add(new Ingredient(TOMATOES, 3, "250gr"));
        ingredientsSuc1.add(new Ingredient(GREEN_PEPPER, 4, "100gr"));
        ingredientsSuc1.add(new Ingredient(RED_PEPPER, 4, "100gr"));
        ingredientsSuc1.add(new Ingredient(ONION, 4, "500gr "));
        ingredientsSuc1.add(new Ingredient(OLIVES, 7, "6"));
        ingredientsSuc1.add(new Ingredient(BASIL, 7, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(GROUND, 6, "300gr"));
        ingredientsSuc1.add(new Ingredient(MOZZARELLA_CHEESE, 9, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(PARMESAN_CHEESE, 9, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(ARTICHOKES, 9, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(EGG_PLANT, 9, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(MUSHRROOMS, 11, "0.5kg"));
        ingredientsSuc1.add(new Ingredient(CALM, 16, "0.5kg"));
        final PizzaStore sucursal2 = new PizzaStore("sucursal 2",
                ingredientsSuc2);

        sucursales.add(sucursal1);
        sucursales.add(sucursal2);
    }

    /**
     * Method that get a sucursal.
     *
     * @param i position in the sucursal list
     * @return pizza store
     */
    public PizzaStore getStore(final int i) {
        return this.getStore(i);
    }

    /**
     * Method that get a sucursal.
     *
     * @param name store name
     * @return pizza store
     */
    public PizzaStore getStore(final String name) {
        return this.sucursales.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList()).get(0);
    }
}
