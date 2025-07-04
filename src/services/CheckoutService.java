package services;

import models.*;
import models.products.*;
import contract.Expirable;
import contract.Shippable;
import java.util.*;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        double orderSubtotal = 0;

        double totalShippingFee = 0;

        List<Shippable> shippableItems = new ArrayList<>();

        for (Map.Entry<Product, Integer> cartEntry : cart.getItems().entrySet()) {

            Product product = cartEntry.getKey();

            int productQuantity = cartEntry.getValue();

            if (productQuantity > product.getQuantity()) {
                System.out.printf("there is no enough stock for %s\n", product.getName());
                return;
            }

            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                System.out.printf("Product %s is expired\n", product.getName());
                return;
            }

            orderSubtotal += product.getPrice() * productQuantity;

            if (product instanceof Shippable) {

                for (int i = 0; i < productQuantity; i++) {
                    shippableItems.add((Shippable) product);
                }

                double shippingFeePerItem = 15.0;

                totalShippingFee += shippingFeePerItem * productQuantity;
            }
        }

        double totalAmount = orderSubtotal + totalShippingFee;

        if (customer.getBalance() < totalAmount) {
            System.out.println("Error: Insufficient balance");
            return;
        }

        ShippingService.ship(shippableItems);

        System.out.println("** Checkout receipt **");

        for (Map.Entry<Product, Integer> cartEntry : cart.getItems().entrySet()) {
            Product product = cartEntry.getKey();
            int productQuantity = cartEntry.getValue();

            System.out.printf("%dx %s\t%.0f\n", productQuantity, product.getName(),
                    product.getPrice() * productQuantity);
        }

        System.out.println("------------------------");
        System.out.printf("Subtotal\t%.0f\n", orderSubtotal);

        if (totalShippingFee > 0) {
            System.out.printf("Shipping\t%.0f\n", totalShippingFee);
        }

        System.out.printf("Amount\t%.0f\n", totalAmount);

        customer.deductBalance(totalAmount);

        for (Map.Entry<Product, Integer> cartEntry : cart.getItems().entrySet()) {
            Product product = cartEntry.getKey();
            int productQuantity = cartEntry.getValue();
            product.reduceQuantity(productQuantity);
        }
    }
}