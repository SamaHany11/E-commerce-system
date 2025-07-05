package fawrytask;

import java.util.*;

public class Cart{
    private Map<Product,Integer>items;

    public Cart(){
        items=new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        items.put(product, items.getOrDefault(product,0)+quantity);
    }

    public Map<Product,Integer>getItems(){
        return items;
    }

    public double getTotal(){
        double total=0.0;
        for (Map.Entry<Product,Integer>entry:items.entrySet()){
            Product product=entry.getKey();
            int quantity=entry.getValue();
            total+=product.getPrice()*quantity;
        }
        return total;
    }
}

