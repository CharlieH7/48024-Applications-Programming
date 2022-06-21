package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;
import model.TMS;


public class FacultyController extends Controller<Faculty> {
   
    @FXML 
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TableView<Student> studentsTv;
    @FXML
    private Button delete;
    @FXML
    private Button select;
    @FXML
    private Button slip;
    
    private String getName() {
        return name.getText();
    }
    
    private String getEmail() {
        return email.getText();
    }

    private Student getSelectedStudent() {
        return studentsTv.getSelectionModel().getSelectedItem();
    }
    
    public final Faculty getFaculty() {
        return model;
    }
    
    @FXML
    private void initialize() {
       name.textProperty().addListener(Event -> getFaculty().filterList(getName(), "0"));
       email.textProperty().addListener(Event -> getFaculty().filterList("0", getEmail()));
       studentsTv.getSelectionModel().selectedItemProperty().addListener((observable, oldSubject, newSubject) -> delete.setDisable(newSubject == null));
       studentsTv.getSelectionModel().selectedItemProperty().addListener((observable, oldSubject, newSubject) -> select.setDisable(newSubject == null));
       studentsTv.getSelectionModel().selectedItemProperty().addListener((observable, oldSubject, newSubject) -> slip.setDisable(newSubject == null));
    }
    
    @FXML
    private void handleAdd(ActionEvent event) throws Exception{
        Student student = new Student("", "", "", "", "", "", 0, 0.0, "Code");
        Stage addStage = new Stage();
        addStage.getIcons().add(new Image("/view/edit.png"));
        model.addStudent(student);
        ViewLoader.showStage(student, "/view/student.fxml", "Adding New Student", addStage);
    }
    
    @FXML
    private void handleDelete() {
        model.removeStudent(studentsTv.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void handleSelect(ActionEvent event) throws Exception{
        Stage selectStage = new Stage();
        selectStage.getIcons().add(new Image("/view/edit.png")); 
        ViewLoader.showStage(getSelectedStudent(), "/view/student.fxml", "Accessing File: " + getSelectedStudent().getName(), selectStage);
    }
    
    @FXML
    private void handleSlip(ActionEvent event) throws Exception{
        Image icon = new Image(getClass().getResourceAsStream("/view/edit.png"));
        Stage slipStage = new Stage();
        slipStage.getIcons().add(icon); 
        ViewLoader.showStage(getSelectedStudent(), "/view/slip.fxml", getSelectedStudent().getName() + " SLIP Report", slipStage);
    }

    @FXML
    private void handleReport(ActionEvent event) throws Exception{
        Stage reportStage = new Stage();
        reportStage.getIcons().add(new Image("/view/uts.jpeg")); 
        ViewLoader.showStage(new TMS(model), "/view/tms.fxml", "TMS Report", reportStage);
    }
    
    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
    }
}
