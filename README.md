   E-Commerce Checkout System With Java

Overview
This Java-based project simulates a simple e-commerce checkout system with the following features:
•	Product Types:
o	Regular products
o	Perishable products (with expiry dates)
o	Shippable products (with weight for shipping calculation)
•	Shopping Cart:
o	Holds products with specified quantities
•	Customer:
o	Has a balance used to pay for orders
•	Checkout Process:
o	Validates product availability and expiry dates
o	Calculates subtotal and shipping costs
o	Deducts the total amount from the customer’s balance
o	Updates product quantities in stock
o	Prints a formatted checkout receipt and shipping notice
Edge Cases Handled
•	Empty shopping cart
•	Expired perishable products
•	Insufficient stock for requested quantities
•	Insufficient customer balance to complete purchase
How It Works
1.	Add products (regular, perishable, or shippable) to the shopping cart with desired quantities.
2.	Checkout:
o	System checks for any expired or out-of-stock items.
o	Calculates total cost including shipping fees for shippable products.
o	Checks if the customer has enough balance.
3.	If all validations pass:
o	Customer balance is reduced by the total amount.
o	Product stock is updated.
o	A detailed receipt and shipping notice are printed.
4.	If any issue occurs (empty cart, expired product, insufficient stock or balance), the checkout process will notify the user accordingly.
Project Structure (Example)
•	Product (base class)
•	PerishableProduct (extends Product, adds expiry date)
•	ShippableProduct (extends Product, adds weight)
•	Cart (holds products and quantities)
•	Customer (tracks user balance)
•	CheckoutService (handles validation, calculation, and printing)
How to Run
•	Compile all .java files
•	Run the main class that initializes sample products, customer, cart, and calls the checkout method
•	Follow console output for checkout process and receipts
Requirements
•	Java SE Development Kit (JDK) 8 or higher

