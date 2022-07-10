import java.util.*;

public class Store {

    // declaring a cashRegister object and declaring + Initialising a Product LinkedList
    private CashRegister cashInCashRegister;
    private LinkedList<Product> products = new LinkedList<Product>();
    String words = "";
    LinkedList<Product> matches1 = new LinkedList<Product>();
    LinkedList<Product> matches2 = new LinkedList<Product>();

    public static void main(String[] args) {
        Store store = new Store();
        store.use();
    }

    public Store() {
        // Insert 6 lines of code to initialise the fields.
        products.add(new Product("Whiteboard Marker", 85, 1.5));
        products.add(new Product("Whiteboard Eraser", 45, 5.00));
        products.add(new Product("Black Pen", 100, 1.5));
        products.add(new Product("Red Pen", 100, 1.5));
        products.add(new Product("Blue Pen", 100, 1.5));
        cashInCashRegister = new CashRegister();
    }

    private Product product (String name) {
        for (Product product: products) {
            if (product.hasName(name)) {
                return product;
            }
        }
        return null;
    }

    private char readOptions() {
        System.out.print("Choice (s/r/v/c/p/x): ");
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
                case 'p':
                    pruneProducts();
                    break;
                default:
                    help();
            }
        }
        System.out.println("Done");
    }

    private String readName() {
        System.out.print("Name: ");
        return In.nextLine();
    }

    private int readNumber() {
        System.out.print("Number: ");
        return In.nextInt();
    }

    private String capitalise(String name) {
        name = name.toLowerCase();
        words = "";
        for (String word: name.split(" ")) {
            words += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
        }
        words = words.trim();
        return words;
    }

    private LinkedList<Product> containPen(LinkedList<Product> products) {
        
        for (Product product : products) {
            if (product.getName().contains("Pen")) {
                matches1.add(product);
            }    
        }   
        return matches1;
    }

    private void viewMatches1() {
        System.out.println("Multiple products match:");
        containPen(products).clear();
        for (Product product: containPen(products)) {
            System.out.println(product);
        }
    }

    private LinkedList<Product> containWhiteb(LinkedList<Product> products) {
        
        for (Product product : products) {
            if (product.getName().contains("Whiteb")) {
                matches2.add(product);
            }    
        }   
        return matches2;
    }

    private void viewMatches2() {
        System.out.println("Multiple products match:");
        for (Product product: containWhiteb(products)) {
            System.out.println(product);
        }
    }

private void sell() {
        String p = readName();
        words = capitalise(p);
        Product product = product(words);
        
       if (product != null) {
            System.out.println("Selling " + words);
            double amount = readNumber();
            if (product.has(amount)) {
                System.out.println("Not enough stock");
            }
            else {
                double money = product.sell(amount);
                cashInCashRegister.updateCash(money);
            }
        }
        else if (words.equals("Pen")) {
            viewMatches1();
        }
        else if (words.equals("Whiteb")) {
            viewMatches2();
        }
        else {
            System.out.println("No such product");
        }
    }

    private void restock() {
        String s = readName();
        words = capitalise(s);
        Product product = product(words);
        if (product != null) {
            System.out.println("Restocking " + words);
            product.restock(readNumber());
        }
        else if (words.equals("Pen")) {
            containPen(products).clear();
            containPen(products);
            for(int i = 0; i < matches1.size(); i++) {
                System.out.println("Restocking " + matches1.get(i).getName());
                matches1.get(i).restock(readNumber());
            }
        }
        else if (words.equals("Whiteboard")) {
            containWhiteb(products);
            for(int i = 0; i < matches2.size(); i++) {
                System.out.println("Restocking " + matches2.get(i).getName());
                matches2.get(i).restock(readNumber());
            }
        }
        else {
            System.out.println("Adding new product");
            int number = readNumber();
            double price = readPrice();
            products.add(new Product(words, number, price));
        }

    }

    private void viewStock() {
        for (Product product: products) {
            System.out.println(product);
        }
    }

    private void viewCash() {
        System.out.println(cashInCashRegister);
    }

    private void pruneProducts() {
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product pd = it.next();
            if(pd.getStock() == 0) {
                it.remove();
            }
        }
    }

    private double readPrice() {
        System.out.print("Price: $");
        return In.nextDouble();
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("p = prune products");
        System.out.println("x = exit");
    }
}
