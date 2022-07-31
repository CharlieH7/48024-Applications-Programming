import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.fxml.*;
import au.edu.uts.ap.javafx.*;
import model.Stadium;

public class StadiumApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Stadium stadium = new Stadium();
        ViewLoader.showStage(stadium, "/view/Stadium.fxml", "Stadium", stage);
    }
}
