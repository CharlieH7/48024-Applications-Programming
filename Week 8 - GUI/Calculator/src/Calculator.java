import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Calculator extends Application {
    public static void main(String[] args) { 
        launch(args); 
    }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;

    @Override
    public void start(Stage stage) throws Exception {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First number:");
        firstNumberTf = new TextField("3");
        secondNumberLbl = new Label("Second number:");
        secondNumberTf = new TextField("7");
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField("");
        
        // 2. create the branch node
        GridPane gridPane = new GridPane();
        GridPane.setConstraints(firstNumberLbl, 0, 0);
        GridPane.setConstraints(firstNumberTf, 1, 0);
        GridPane.setConstraints(secondNumberLbl, 0, 1);
        GridPane.setConstraints(secondNumberTf, 1, 1);
        GridPane.setConstraints(operationLbl, 0, 2);
        GridPane.setConstraints(resultLbl, 0, 3);
        HBox hBox = new HBox(10, addBtn, subBtn, mulBtn, divBtn);
        GridPane.setConstraints(hBox, 1, 2);
        GridPane.setConstraints(resultTf, 1, 3);
        gridPane.getChildren().addAll(firstNumberLbl, firstNumberTf, secondNumberLbl, secondNumberTf, operationLbl, resultLbl, hBox, resultTf);
        // 3. set the event handlers
        addBtn.setOnAction(new AddHandler());
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setResult((getFirstNumber() - getSecondNumber()));
            }
        });
        mulBtn.setOnAction(event -> setResult((getFirstNumber() * getSecondNumber())));
        divBtn.setOnAction(event -> setResult((getFirstNumber() / getSecondNumber())));
        // 4. set the scene, show the stage
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    
    private int getFirstNumber() {
        return Integer.parseInt(firstNumberTf.getText());
    }
    private int getSecondNumber() {
        return Integer.parseInt(secondNumberTf.getText());
    }
    
    private void setResult(int value) {
        resultTf.setText("" + value);
    }
    
    private class AddHandler implements EventHandler<ActionEvent> {
         @Override
        public void handle(ActionEvent event) {
            // get the value and add and set the result to: the first number + the second number.
            int value;
            value = getFirstNumber() + getSecondNumber();
            // set the new value
            setResult(value);
        }
    }
}