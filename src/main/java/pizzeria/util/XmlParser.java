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
public final class XmlParser {

    /** Default constructor. **/
    private XmlParser() {
    }

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
                    final String storeName = getValue(node, "name");
                    final Map<IngredientType, Ingredient> ingredientsPerStore
                            = loadIngredients(node, elem);
                    final Map<PizzaTypes, Collection<IngredientType>>
                            pizzaIngredientTypes = loadMenu(node, elem);
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
     * Load menu from Element.
     *
     * @param node xml node
     * @param elem xml Element
     * @return map with ingredient types per pizza type
     */
    private static Map<PizzaTypes, Collection<IngredientType>> loadMenu(
            final Node node, final Element elem) {
        final Map<PizzaTypes, Collection<IngredientType>> pizzaIngredientTypes
                = new HashMap<PizzaTypes, Collection<IngredientType>>();
        final NodeList menu = getChilds(elem, "menu");
        for (int j = 0; j < menu.getLength(); j++) {
            final Collection<IngredientType> ingredientTypes
                    = new ArrayList<IngredientType>();
            final Node nodePizza = menu.item(j);
            if (nodePizza.getNodeType() == Node.ELEMENT_NODE) {
                final PizzaTypes pizzaType = getPizzaType(nodePizza);
                final String ingredientNames = getValue(nodePizza,
                        "ingredients");
                for (final String iname : ingredientNames.split(",")) {
                    ingredientTypes.add(IngredientType.get(iname));
                }
                pizzaIngredientTypes.put(pizzaType, ingredientTypes);
            }
        }
        return pizzaIngredientTypes;
    }

    /**
     * Load ingredients from Element.
     *
     * @param node xml node
     * @param elem xml element
     * @return map with Ingredient per ingredient type
     */
    private static Map<IngredientType, Ingredient> loadIngredients(
            final Node node, final Element elem) {

        final Map<IngredientType, Ingredient> ingredientsPerStore
                = new HashMap<IngredientType, Ingredient>();
        final NodeList ingredientList = getChilds(elem, "ingredients");
        for (int j = 0; j < ingredientList.getLength(); j++) {
            final Node nodeIngredient = ingredientList.item(j);
            if (nodeIngredient.getNodeType() == Node.ELEMENT_NODE) {
                final IngredientType type = getIngredientType(nodeIngredient);
                final double cost = Double
                        .parseDouble(getValue(nodeIngredient, "cost"));
                final String unity = getValue(nodeIngredient, "unity");
                addIngredient(ingredientsPerStore, type, cost, unity);
            }
        }
        return ingredientsPerStore;
    }

    /**
     * Get child nodes of a node with tagName.
     *
     * @param elem    xml element
     * @param tagName string
     * @return NodeList
     */
    private static NodeList getChilds(final Element elem,
            final String tagName) {
        return elem.getElementsByTagName(tagName).item(0).getChildNodes();
    }

    /**
     * Get string value of a node with name id "name".
     *
     * @param node xml node
     * @param name string node name
     * @return String value
     */
    private static String getValue(final Node node, final String name) {
        return node.getAttributes().getNamedItem(name).getNodeValue();
    }

    /**
     * Get ingredient type from xml node.
     *
     * @param node xml node
     * @return IngredientType
     */
    private static IngredientType getIngredientType(final Node node) {
        final String stringType = getValue(node, "type");
        return IngredientType.get(stringType);
    }

    /**
     * Get pizza type from xml node.
     *
     * @param node xml node
     * @return PizzaTypes
     */
    private static PizzaTypes getPizzaType(final Node node) {
        final String stringType = getValue(node, "type");
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
