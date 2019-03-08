package pizzeria.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pizzeria.business.Company;
import pizzeria.business.PizzaStore;
import pizzeria.data.Ingredient;
import pizzeria.data.IngredientType;
import pizzeria.data.PizzaTypes;

/**
 * Utility to create company from xml file.
 *
 * @author Marines Lopez Soliz
 *
 */
public class XmlParser {

    /**
     * Create company from xml file.
     * 
     * @param fileName string
     * @return company
     */
    public static Company getCompany(final String fileName) {
        final Company company = new Company();
        DocumentBuilder builder;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            final Document document = builder.parse(new File(fileName));
            final NodeList nodeList = document.getDocumentElement()
                    .getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                // store
                final Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    final Element elem = (Element) node;
                    final String storeName = node.getAttributes()
                            .getNamedItem("name").getNodeValue();

                    final Map<IngredientType, Ingredient> ingredientsPerStore = new HashMap<IngredientType, Ingredient>();
                    final NodeList ingredientList = elem
                            .getElementsByTagName("ingredients").item(0)
                            .getChildNodes();
                    for (int j = 0; j < ingredientList.getLength(); j++) {
                        final Node nodeIngredient = ingredientList.item(j);
                        final IngredientType type = getIngredientType(
                                nodeIngredient);
                        final double cost = Double
                                .parseDouble(node.getAttributes()
                                        .getNamedItem("name").getNodeValue());
                        final String unity = node.getAttributes()
                                .getNamedItem("unity").getNodeValue();
                        addIngredient(ingredientsPerStore, type, cost, unity);
                    }

                    final Map<PizzaTypes, Collection<IngredientType>> pizzaIngredientTypes = new HashMap<PizzaTypes, Collection<IngredientType>>();
                    final NodeList menu = elem.getElementsByTagName("menu")
                            .item(0).getChildNodes();
                    for (int j = 0; j < menu.getLength(); j++) {
                        final Collection<IngredientType> ingredientTypes = new ArrayList<IngredientType>();
                        final Node nodePizza = menu.item(j);
                        final PizzaTypes pizzaType = getPizzaType(nodePizza);
                        final String ingredientNames = node.getAttributes()
                                .getNamedItem("ingredients").getNodeValue();
                        for (final String iname : ingredientNames.split(",")) {
                            ingredientTypes.add(IngredientType.get(iname));
                        }
                        pizzaIngredientTypes.put(pizzaType, ingredientTypes);
                    }
                    final PizzaStore store = new PizzaStore(storeName,
                            ingredientsPerStore, pizzaIngredientTypes);
                    company.addStore(store);
                }
            }
        } catch (final ParserConfigurationException | SAXException
                | IOException e) {
            e.printStackTrace();
        }
        return company;
    }

    /**
     * Get ingredient type from xml node.
     *
     * @param node xml node
     * @return IngredientType
     */
    private static IngredientType getIngredientType(final Node node) {
        final String stringType = node.getAttributes().getNamedItem("type")
                .getNodeValue();
        return IngredientType.get(stringType);
    }

    /**
     * Get pizza type from xml node.
     *
     * @param node xml node
     * @return PizzaTypes
     */
    private static PizzaTypes getPizzaType(final Node node) {
        final String stringType = node.getAttributes().getNamedItem("type")
                .getNodeValue();
        return PizzaTypes.get(stringType);
    }

    /**
     * Utility to add ingredients in an ingredientsPerStore collection.
     *
     * @param ingredientsPerStore collection of ingredients per store.
     * @param type                ingredient type.
     * @param cost                cost per ingredient.
     * @param quantity            quantity of the ingredient.
     */
    private static void addIngredient(
            final Map<IngredientType, Ingredient> ingredientsPerStore,
            final IngredientType type, final double cost,
            final String quantity) {
        ingredientsPerStore.put(type, new Ingredient(type, cost, quantity));
    }
}
