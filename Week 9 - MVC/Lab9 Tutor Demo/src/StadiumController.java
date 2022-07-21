import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StadiumController {
    
    private final Stadium stadium = new Stadium();
    
    public final Stadium getStadium() {
        return stadium;
    }
    
    @FXML
    private TextField sellTf;
    
    private void setAmount(int amount) {
        sellTf.setText("" + amount);
    }
    
    private int getAmount() {
        return Integer.parseInt(sellTf.getText());
    }
    
    public void handleSell(ActionEvent e) {
        int amount = getAmount();
        stadium.getGroup().sell(amount);
        setAmount(0);
        
    }
}
