package pizzeria.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Class to represent the company, that contains multiple stores. **/
public class Company {

    /** Store list. **/
    private final List<Store> stores = new ArrayList<Store>();

    /** Default constructor. **/
    public Company() {
    }

    /**
     * Add store to company.
     *
     * @param store pizzaStore
     */
    public void addStore(final Store store) {
        stores.add(store);
    }

    /**
     * Method that get a store.
     *
     * @param i position in the store list
     * @return pizza store
     */
    public Store getStore(final int i) {
        return this.stores.get(i);
    }

    /**
     * Method that get a store.
     *
     * @param name store name
     * @return pizza store
     */
    public Store getStore(final String name) {
        return this.stores.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList()).get(0);
    }

    public List<Store> getStores() {
        return this.stores;
    }
}
