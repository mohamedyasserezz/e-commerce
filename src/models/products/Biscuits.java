package models.products;

import java.time.LocalDate;
import contract.Expirable;
import contract.Shippable;
import models.Product;

// Biscuits are expirable and shippable products
public class Biscuits extends Product implements Expirable, Shippable {
    private static final String PRODUCT_NAME = "Biscuits";
    private double weight; // grams
    private LocalDate expiryDate;

    public Biscuits(double price, int quantity, double weight, LocalDate expiryDate) {
        super(PRODUCT_NAME, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }
} 