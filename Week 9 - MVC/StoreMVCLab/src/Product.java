
import java.text.DecimalFormat;
import java.util.LinkedList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Product {
    private final LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();
    
    private IntegerProperty stock = new SimpleIntegerProperty();
    private double price;
    private String name;


    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock.set(stock);
        this.price = price;
    }

    public void sell(int n) {
        stock.set(stock.get()- n);
        double money = n * price;
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        stock.set(stock.get() + n);
    }

    public boolean has(int n) {
        return stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }
    
    public final String getName() {
        return name;
    }
    
    public final String getPrice() { 
        return formatted(price); 
    }
    
    private String formatted(double money){
        return new DecimalFormat("###,##0.00").format(money);
    }
    
    public final int getStock(){
        return stock.get();
    }
    
    public ReadOnlyIntegerProperty stockProperty(){
        return stock;
    } 

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}