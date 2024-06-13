Online Shopping System

Description
Develop an online shopping system with classes like Product, Customer, and ShoppingCart. This project demonstrates inheritance, composition, and encapsulation. Users can browse products, add items to their cart, and proceed to checkout.
 
These projects provide hands-on experience in implementing OOP concepts in Java and are suitable for beginners to gain a solid understanding of OOP principles and their application in real-world scenarios.

Sure! Let's break down the code in detail to explain each part and how it fits into the overall design of the online shopping system.

	Product Class

java
class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Description: " + description;
    }
}


Fields: The `Product` class has three private fields: `name`, `price`, and `description`. These represent the name, price, and description of the product, respectively.
Constructor: The constructor initializes these fields when a new `Product` object is created.
Getters: The `getName`, `getPrice`, and `getDescription` methods provide access to the private fields, following the principle of encapsulation.
toString Method: This method overrides the default `toString` method to provide a meaningful string representation of a `Product` object, which is useful for printing product details.

	Customer Class

java
class Customer {
    private String name;
    private ShoppingCart cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new ShoppingCart(this);
    }

    public String getName() {
        return name;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}

Fields: The `Customer` class has two private fields: `name` (the customer's name) and `cart` (the customer's shopping cart).
Constructor: The constructor initializes the `name` field and creates a new `ShoppingCart` object for the customer.
Getters: The `getName` and `getCart` methods provide access to the private fields.

ShoppingCart Class
java
import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private Customer customer;
    private List<Product> products;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " has been added to the cart.");
    }

    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println(product.getName() + " has been removed from the cart.");
    }

    public void checkout() {
        double total = 0;
        System.out.println("Checking out the following items:");
        for (Product product : products) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println("Total Amount: $" + total);
    }
}


Fields: The `ShoppingCart` class has two private fields: `customer` (the owner of the cart) and `products` (a list of products in the cart).
Constructor: The constructor initializes the `customer` field and creates an empty `products` list.
Methods:
  `addProduct(Product product)`: Adds a product to the cart and prints a message.
 `removeProduct(Product product)`: Removes a product from the cart and prints a message.
  `checkout()`: Prints the details of all products in the cart and calculates the total price.

	OnlineShoppingSystem Class (Main Class)

java
public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99, "A high-performance laptop.");
        Product product2 = new Product("Smartphone", 599.99, "A latest model smartphone.");
        Product product3 = new Product("Headphones", 199.99, "Noise-cancelling headphones.");

        
        Customer customer = new Customer("John Doe");
        customer.getCart().addProduct(product1);
        customer.getCart().addProduct(product2);
        customer.getCart().addProduct(product3);
        customer.getCart().checkout();
    }
}

Main Method: The entry point of the program. This method demonstrates the interaction between the `Product`, `Customer`, and `ShoppingCart` classes.
  Creating Products: Three `Product` objects are created with specific details.
  Creating a Customer: A `Customer` object is created with a name.
  Adding Products to Cart: The `addProduct` method is called on the customer's cart to add the created products.
  Checkout: The `checkout` method is called to display the products in the cart and calculate the total price.

o	Summary

	Encapsulation: Every class offers public methods to interact with its data while encapsulating it. 
	
Composition: To illustrate a "has-a" relationship, the `ShoppingCart` class consists of a list of `Product` objects and a reference to a `Customer` object.
	
Interaction: The `ShoppingCart` class oversees a group of `Product` objects, and the `Customer` class communicates with it. This illustrates how various items may cooperate to create a whole system. 


A simple online shopping system may be developed using this programme by adding features like product categories, payment processing, and user identification. 
Out put:
 
![Screenshot 2024-06-13 080709](https://github.com/S2ree970ram/oops-project/assets/157942734/81be7954-9efc-4fdf-9df7-2c19c777a813)

