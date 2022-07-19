
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class IncDec extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    private Label valueLbl;
    private TextField valueTf;
    private Button decBtn;
    private Button incBtn;
    private Button clear;
    
    @Override
    public void start(Stage stage) {
        // create the leaf nodes
        valueLbl = new Label("Value");
        valueTf = new TextField("0");
        decBtn = new Button("-1");
        incBtn = new Button("+1");
        clear = new Button("C");
        // create the branch nodes
        HBox hbox = new HBox(10, valueLbl, valueTf, decBtn, incBtn, clear);
        // set the event handlers
        decBtn.setOnAction(new DecBtnHandler());
        incBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setValue((getValue() + 1));
            }
        });
        clear.setOnAction(event -> setValue(0));
//        incBtn.setOnAction(event -> setValue(getValue() + 1));
        // set set the scene and stage
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.show();
        
    }
    
    private int getValue() {
        return Integer.parseInt(valueTf.getText());
    }
    
    private void setValue(int newValue) {
        valueTf.setText("" + newValue);
    }
    
    private class DecBtnHandler implements EventHandler<ActionEvent> {
         @Override
        public void handle(ActionEvent event) {
            // get the value
            int value = getValue();
            // take 1 off
            value--;
            // set the new value
            setValue(value);
        }
    }
        
}
