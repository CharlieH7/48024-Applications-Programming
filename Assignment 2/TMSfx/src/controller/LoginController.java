package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.Session;

public class LoginController extends Controller<Session> {
    
    @FXML 
    private TextField email;
    @FXML 
    private PasswordField password;
    @FXML 
    private Label errorMessage;
    
    private String getEmail() {
        return email.getText();
    }
    
    private String getPassword() {
        return password.getText();
    }
    
    private void setEmail() {
        email.setText("");
    }
    
    private void setPassword() {
        password.setText("");
    }
    
    @FXML
    private void handleOk(ActionEvent event) throws Exception {
        Faculty faculty = model.getFaculty(getEmail(), getPassword());
        if (faculty == null) {
            errorMessage.setText("Incorrect login details");
            setEmail();
            setPassword();
        }
        else if(faculty.login(getEmail(), getPassword())) {
            Stage adminStage = new Stage();
            adminStage.getIcons().add(new Image("/view/faculty.png")); 
            ViewLoader.showStage(faculty, "/view/faculty.fxml", "Session Admin: " + faculty.getName(), adminStage);
            stage.close();
        }
    }
    
    @FXML
    private void handleCancel(ActionEvent event) {
        stage.close();
    }
}
