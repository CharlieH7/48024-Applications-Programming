import java.text.*;

/*
 * Each product has a name, stock and price.
 *
 * You can sell and restock a product.
 */
public class Product {
    // insert 3 fields here
    private String name;
    private int stock;
    private double price;
    private double cash;

    // insert 1 constructor here
    public Product() {
        name = "Sticky tape";
        stock = 200;
        price = 2.99;
    }
    /**
     * This pseudo-procedure sells "n" amount of stock.
     * The stock should decrease by "n".
     *
     * This method also returns the money earned from the sale.
     *
     * This is a rare occasion where a procedure returns something.
     */
    public double sell(double n) {
        // insert your code here to update the stock
        stock -= n;
        cash = 2.99 * n;
        return cash; // a dummy return value - which you will change
    }

    /**
     * Add "n" amount to this product's stock.
     */
    public void restock(double n) {
        stock += n;
    }

    // return true if stock is less than the amount entered by user
    public boolean has(double n) {
       return stock < n;
    }

    /**
     * Return a string in the form:
     *
     * [stock] [name] at $[price]
     *
     * e.g. "200 Sticky tape at $2.99"
     *
     * DO NOT hard code the data in this string
     * or you will be penalised for a spoof.
     */
    @Override
    public String toString() {
        return stock + " Sticky tape at $" + price;
    }
}
