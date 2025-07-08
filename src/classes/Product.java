package fawrytask;


public class Product{
protected String  name;
protected  double price;
protected int quantity;
Product(String  name ,double price,int quantity){
	this.name=name;
	this.price=price;
	this.quantity=quantity;
}
public String getName(){
	return name;
}
public double getPrice(){
	return price;
}
int getquantity() {
    return quantity;
}

public boolean isquantity_available(int requested_quantity){
	 return requested_quantity<=quantity;
}
public void decrease_quantity(int amount){
	quantity-=amount;
}
}
