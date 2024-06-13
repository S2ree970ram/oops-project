import java.util.ArrayList;
import java.util.List;

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
