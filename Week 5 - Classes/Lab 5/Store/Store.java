/**
 * The store has and sells one product: Sticky tape.
 *
 * You can sell and restock a product, view stock and view cash.
 */
public class Store {

    // insert main method here
    public static void main(String[] args) {
        new Store().use();  
    }

    // insert 2 fields here
    private Product product;
    private CashRegister cashInCashRegister;


    // insert 1 constructor here
    public Store() {
        product = new Product();
        cashInCashRegister = new CashRegister();
    }

    private char readOptions() {
        System.out.print("Choice (s/r/v/c/x): ");
        return In.nextChar();
    }

    public void use() {
        char options;
        while ((options = readOptions()) != 'x') {
            switch (options) {
                case 's':
                    sell();
                    break;
                case 'r':
                    restock();
                    break;
                case 'v':
                    viewStock();
                    break;
                case 'c':
                    viewCash();
                    break;
                default:
                    help();
            }
        }
        System.out.println("Done");
    }

    private double readNumber() {
        System.out.print("Number: ");
        return In.nextDouble();    
    }

    private void sell() {
        double amount = readNumber();
        if (product.has(amount)) {
            System.out.println("Not enough stock");
        }
        else {
            product.sell(amount);
            cashInCashRegister.updateCash(amount);
        }
    }
    
    private void restock() {
        product.restock(readNumber());
    }

    private void viewStock() {
        System.out.println(product);
    }

    private void viewCash() {
        System.out.println(cashInCashRegister);
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("x = exit");
    }
}
