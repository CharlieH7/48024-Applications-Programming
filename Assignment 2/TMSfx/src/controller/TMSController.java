package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import model.TMS;
import model.Report;

public class TMSController extends Controller<TMS>{
    
    public final DecimalFormat decimalplace2 = new DecimalFormat("#.00");
    @FXML 
    private TableView<Report> tmsTv;
    @FXML 
    private Text totalTuition;
    @FXML 
    private Text totalNetFee;
    @FXML 
    private Text totalBas;
    @FXML 
    private Text totalScholarship;
    @FXML 
    private Text totalDeduction;
    
    
    @FXML 
    private void initialize() {
        tmsTv.setItems(model.reports());
        totalTuition.setText("$" + decimalplace2.format(model.getTotalTuitionFee()));;
        totalNetFee.setText("$" + decimalplace2.format(model.getTotalNetFee()));
        totalBas.setText("$" + decimalplace2.format(model.getBas()));
        totalScholarship.setText("$" + decimalplace2.format(model.getTotalScholarship()));
        totalDeduction.setText("$" + decimalplace2.format(model.getTotalDeduction()));
    }
    
    @FXML 
    private void handleClose(ActionEvent event) throws Exception {
        stage.close();
    }
}