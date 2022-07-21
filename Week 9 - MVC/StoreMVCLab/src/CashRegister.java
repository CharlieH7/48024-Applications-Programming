import java.text.DecimalFormat;
import javafx.beans.property.*;


public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();
    
    public CashRegister() {
        cash.set(0.0); 
    }

    public void add(double money) {
        this.cash.set(money + cash.get());
    }

    public final double getCash(){
        return this.cash.get();
    }
    
    public ReadOnlyDoubleProperty cashProperty(){
        return this.cash;
    }
    
    @Override
    public void handleSale(double amount) {
        add(amount);
    }

}
