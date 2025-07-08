package fawrytask;

import java.time.LocalDate;

public class PerishableProduct extends Product implements Shippable {
    private LocalDate expiryDate;
    private double weight;

    public PerishableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public boolean is_expired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
