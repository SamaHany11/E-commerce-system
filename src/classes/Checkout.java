package fawrytask;

import java.util.*;

public class Checkout {

    public static boolean checkout(Customer customer, Cart cart) {
        if (cart.getItems().isEmpty()) {
            System.out.println("Cart is empty.");
            return false;
        }

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (!product.isquantity_available(quantity)) {
                System.out.println("Not enough quantity for: " + product.getName());
                return false;
            }

            if (product instanceof PerishableProduct) {
                PerishableProduct perishable = (PerishableProduct) product;
                if (perishable.is_expired()) {
                    System.out.println("Product expired: " + product.getName());
                    return false;
                }
            }
        }

        double subtotal = cart.getTotal();
        double totalWeight = 0.0;
        boolean hasShippable = false;

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                totalWeight += shippable.getWeight() * quantity;
                hasShippable = true;
            }
        }

        double totalWeightInKg = totalWeight / 1000;
        double shippingCost = totalWeightInKg * 50;
        double totalAmount = subtotal + shippingCost;

        if (!customer.canAfford(totalAmount)) {
            System.out.println("Customer can't afford the total amount.");
            return false;
        }

        customer.pay(totalAmount);

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.decrease_quantity(quantity);
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double lineTotal = product.getPrice() * quantity;
            System.out.printf("%dx %-15s %.0f%n", quantity, product.getName(), lineTotal);
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        if (hasShippable) {
            System.out.printf("Shipping         %.0f%n", shippingCost);
        }
        System.out.printf("Amount           %.0f%n", totalAmount);

        if (hasShippable) {
            System.out.println("** Shipment notice **");
            for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                if (product instanceof Shippable) {
                    Shippable shippable = (Shippable) product;
                    double weight = shippable.getWeight() * quantity;
                    System.out.printf("%dx %-15s %.0fg%n", quantity, shippable.getName(), weight);
                }
            }
            System.out.printf("Total package weight %.1fkg%n", totalWeightInKg);
        }

        return true;
    }
}
