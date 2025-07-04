package models.products;

import models.Product;

// MobileScratchCard is a product that does not expire and is not shippable
public class MobileScratchCard extends Product {
    private static final String PRODUCT_NAME = "ScratchCard";
    public MobileScratchCard(double price, int quantity) {
        super(PRODUCT_NAME, price, quantity);
    }
} 