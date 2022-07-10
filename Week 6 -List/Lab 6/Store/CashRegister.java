import java.text.*;

public class CashRegister {
    public double cash;

    public CashRegister() {
        cash = 0.0;
    }

    public void updateCash(double amount) {
        cash += amount;
    }

    @Override
    public String toString() {
        return "Cash: $" + formatted(cash);
    }

    private String formatted(double amount) {
        return new DecimalFormat("###,##0.00").format(amount);
    }
}
