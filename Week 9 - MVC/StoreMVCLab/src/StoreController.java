
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class StoreController {
    private final Store store = new Store();
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;

    public final Store getStore() { 
        return store; 
    }
    
    private final void setAmount(int amount) { 
        amountTf.setText(""+amount); 
    }
    
    private final int getAmount() { 
        return Integer.parseInt(amountTf.getText()); 
    }
    
    @FXML 
    private void initialize() {
        amountTf.setText("0");
        cashTxt.textProperty().bind(store.getCashRegister().cashProperty().asString("$%.2f"));
    }
   
    @FXML 
    private void handlesell(ActionEvent event) {
        Product product = getStore().getProduct();
        int amount = getAmount();
        if (product.has(amount))
            product.sell(amount);
        setAmount(0);
    }
   
}