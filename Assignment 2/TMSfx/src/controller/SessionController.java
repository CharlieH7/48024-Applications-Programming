package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Session;


public class SessionController extends Controller<Session> {
    
    public final Session getSession() {
        return model;
    }
    
    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        Stage loginStage = new Stage();
        loginStage.getIcons().add(new Image("/view/book.png")); 
        ViewLoader.showStage(getSession(), "/view/login.fxml", "Sign in", loginStage);
    }
    
    @FXML
    private void handleExit(ActionEvent event) {
        stage.close();
    }
}
