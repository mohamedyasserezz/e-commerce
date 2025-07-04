package models.products;

import contract.Shippable;
import models.Product;

// TV is a shippable product, but does not expire
public class TV extends Product implements Shippable {
    private static final String PRODUCT_NAME = "TV";
    private double weight; // grams

    public TV(double price, int quantity, double weight) {
        super(PRODUCT_NAME, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
} 