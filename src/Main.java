package fawrytask;

import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        Customer customer=new Customer("Sama",1000);

        Product tv=new ShippableProduct("TV", 300, 5, 10.0);
        Product cheese = new PerishableProduct("Cheese", 50, 10, LocalDate.of(2025, 7, 30), 200);

        Product card=new Product("ScratchCard", 30, 20);

        Cart cart = new Cart();
        cart.addProduct(tv,1);
        cart.addProduct(cheese,2);
        cart.addProduct(card,1);

        boolean success = Checkout.checkout(customer, cart);

        if(success){
            System.out.println("Payment completed successfully.");
        } 
        else{
            System.out.println("Payment failed.");
        }

        System.out.println("Remaining balance: "+customer.getBalance());
    }
}
