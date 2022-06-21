package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.InputException;

public class ErrorController extends Controller<InputException>{
   
    public final InputException getException() {
        return model;
    }
    
    @FXML 
    private void handleOkay(ActionEvent event) {
        stage.close();
    }
}
