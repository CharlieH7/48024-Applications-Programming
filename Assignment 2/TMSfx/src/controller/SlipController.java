package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Student;



public class SlipController extends Controller<Student> {
    
    @FXML
    private Text credits;
    @FXML
    private Text payPerCredits;
    @FXML
    private Text totalFee;
    @FXML
    private Text scholarship;
    @FXML
    private Text netFee;
    @FXML
    private Text deduction;
    
    @FXML
    public void initialize() {
        setCredits();
        setpayPerCredits();
        setTotalFee();
        setScholarship();
        setNetFee();
        setDeduction();
    }
    
    private String getCredits() {
        return Integer.toString(model.getCredits());
    }
    
    private void setCredits() {
        credits.setText(getCredits() + " credits");
    }
    
    private String getpayPerCredits() {
        return Double.toString(model.getPayPerCredit());
    }
    
    private void setpayPerCredits() {
        payPerCredits.setText("$" + getpayPerCredits() + "0");
    }
    
    private String getTotalFee() {
        return Double.toString(model.getTotalFee());
    }
    
    private void setTotalFee() {
        totalFee.setText("$" + getTotalFee() + "0");
    }
    
    private String getScholarship() {
        return Double.toString(model.getScholarship());
    }
    
    private void setScholarship() {
        scholarship.setText("$" + getScholarship() + "0");
    }
    
    private String getNetFee() {
        return Double.toString(model.getNetFee());
    }
    
    private void setNetFee() {
        netFee.setText("$" + getNetFee() + "0");
    }
    
    private String getDeduction() {
        return Double.toString(model.getDeduction());
    }
    
    private void setDeduction() {
        deduction.setText("$" + getDeduction() + "0");
    }  

    @FXML
    public void handleClose(ActionEvent event) {
        stage.close();
    }
}
