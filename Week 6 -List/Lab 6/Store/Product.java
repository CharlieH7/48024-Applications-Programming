import java.text.*;

public class Product {
    private String name;
    private int stock;
    private double price;
    private double cash;

    public Product(String name, int stock, double price) {
        // insert 3 lines of code to initialise the fields.
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

    public boolean isEmpty() {
        return stock == 0;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    /**
     * Return true if this product has at least n stock
     */
    public boolean has(double n) {
       return stock < n;
    }

    /**
     * Sell n stock of this product (decrease stock by n)
     * and return the amount of money earned (price * n)
     */
    public double sell(double n) {
        // insert your code here to update the stock
        stock -= n;
        cash += this.price * n;
        return cash; // a dummy return value - which you will change
    }

    /**
     * Increase stock by n.
     */
    public void restock(double n) {
        stock += n;
    }

    @Override
    public String toString() {
        return name + " - " + stock + " at $" + formatted(price); 
    }

    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}
