package models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartItems = new LinkedHashMap<>();

    public void add(Product product, int quantityToAdd) {
        if (quantityToAdd <= 0) throw new IllegalArgumentException("Quantity must be positive");
        int currentQuantity = cartItems.getOrDefault(product, 0);
        cartItems.put(product, currentQuantity + quantityToAdd);
    }

    public Map<Product, Integer> getItems() {
        return cartItems;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
} 