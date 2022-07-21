public class Store {
    public CashRegister cashRegister;
    private Product product;

    public Store() {
        cashRegister = new CashRegister();
        product = new Product("Sticky tape", 200, 2.99);
        product.addProductObserver(cashRegister);
    }
    public Product getProduct(){
        return this.product;
    }
    
    public CashRegister getCashRegister() {
        return this.cashRegister;
    }
}