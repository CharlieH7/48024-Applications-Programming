
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {
    
    Stage window;
    
    public static void main (String[] args) {
        launch(args);
    }
    
    private Label userNameLabel; 
    private Label passwordLabel;
    private TextField userNameTf;
    private PasswordField passwordTf;
    private Button login;
    private Text loginSuccessfulLb;
    String userName = "sam";
    String password = "mypassword";
    
    @Override 
    public void start(Stage stage) throws Exception{
        window = stage;
        window.setTitle("Login");
        // 1. create the leaf nodes
        userNameLabel = new Label("Username:");
        passwordLabel = new Label("Password:");
        userNameTf = new TextField("");
        passwordTf = new PasswordField();
        login = new Button("Login");
        loginSuccessfulLb = new Text("");

        // 2. create the branch node
        GridPane gridPane = new GridPane();
        GridPane.setConstraints(userNameLabel, 0, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(userNameTf, 1, 0);
        GridPane.setConstraints(passwordTf, 1, 1);
        GridPane.setConstraints(login, 1, 2);
        GridPane.setConstraints(loginSuccessfulLb, 1, 3);
        
        gridPane.getChildren().addAll(userNameLabel, passwordLabel, userNameTf, passwordTf, login, loginSuccessfulLb);
        // 3. set the event handlers
        login.setOnAction(new LoginEvent());
        // 4. set the scene, show the stage
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    
        
    private class LoginEvent implements EventHandler<ActionEvent> {
         @Override
        public void handle(ActionEvent event) {
            if (getUsername().equals(userName) && getPassword().equals(password)) {
                loginSuccessfulLb.setText("Password correct!");
            } else {
                loginSuccessfulLb.setText("Password incorrect!");
            }
        }
    }
    private String getUsername() {
        return userNameTf.getText();
    }
    
    private String getPassword() {
        return passwordTf.getText();
    }
}
