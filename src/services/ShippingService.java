package services;

import contract.Shippable;
import java.util.List;

public class ShippingService {

    public static void ship(List<Shippable> shippableItems) {

        if (shippableItems.isEmpty())
            return;

        System.out.println("** Shipment notice **");

        double totalPackageWeight = 0;

        for (Shippable shippableItem : shippableItems) {
            System.out.printf("%s %s\n", shippableItem.getName(), formatWeight(shippableItem.getWeight()));
            totalPackageWeight += shippableItem.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalPackageWeight / 1000.0);
        System.out.println();
    }

    private static String formatWeight(double weightInGrams) {
        return String.format("%.0fg", weightInGrams);
    }
}