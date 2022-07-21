import java.text.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

public class Group {
    private String name;
    private int capacity;
    private double price;
    private IntegerProperty sold = new SimpleIntegerProperty();
    private DoubleProperty income = new SimpleDoubleProperty();
    private IntegerProperty left = new SimpleIntegerProperty();
    
    public Group(String name, int capacity, double price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        
        income.bind(sold.multiply(price));
        left.bind(Bindings.subtract(capacity, sold));
        sold.set(0);
    }
    
    public final String getName() {
        return name;
    }
    
    public final int getCapacity() {
        return capacity;
    }
    
    public final double getPrice() {
        return price;
    }
    
    public final ReadOnlyIntegerProperty soldProperty() {
        return sold;
    }
    
    public final int getSold() {
        return sold.get();
    }
    
    public final ReadOnlyDoubleProperty incomeProperty() {
        return income;
    }
    
    public final double getIncome() {
        return income.get();
    }
    
    public final ReadOnlyIntegerProperty leftProperty() {
        return left;
    }
    
    public final double getLeft() {
        return left.get();
    }
    
    public void sell(int number) {
        sold.set(sold.get() + number);
    }
    
    @Override 
    public String toString() {
        return getLeft() + " " + name + " seats @ $" + formatted(price);
    }
    
    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}
