package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.InputException;
import model.Student;

public class StudentController extends Controller<Student>{
    
    public Validator validator = new Validator();
    
    @FXML 
    private TextField name;
    @FXML
    private TextField email;
    @FXML 
    private TextField phone;
    @FXML 
    private TextField address;
    @FXML 
    private TextField studentID;
    @FXML 
    private TextField type;
    @FXML 
    private TextField credits;
    @FXML 
    private TextField scholarship;
    @FXML 
    private TextField deduction;
    @FXML 
    private Button update;
    @FXML
    private Button add;
    
    private Student getStudent() {
        return model;
    }
    
    private Faculty getFaculty() {
        return model.getFaculty();
    }
    
    private String getName() {
        return name.getText();
    }
    
    private String getEmail() {
        return email.getText();
    }
    
    private String getPhone() {
        return phone.getText();
    }
    
    private String getAddress() {
        return address.getText();
    }
    
    private String getStudentID() {
        return studentID.getText();
    }
    
    private String getType() {
        return type.getText();
    }
    
    private String getCredits() {
        return credits.getText();
    }
    
    private String getScholarship() {
        return scholarship.getText();
    }
    
    private String getDeductionCode() {
        return deduction.getText();
    }
    
    private String getDeductionRate() {
        if (model.getDeduction() > 1) {
            return "2022AUT";
        }
        else {
            return "";
        }
    }
    
    @FXML
    private void initialize() {
        if (getStudent().getName().equals("")) {
            name.setText(getStudent().getName());
            email.setText(getStudent().getEmail());
            phone.setText(getStudent().getPhone());
            address.setText(getStudent().getAddress());
            studentID.setText(getStudent().getID());
            type.setText(getStudent().getType());
            credits.setText("" + getStudent().getCredits());
            scholarship.setText("" + getStudent().getScholarship());
            deduction.setText("Code");
            update.setDisable(true);
        }
        else {
            name.setText(getStudent().getName());
            email.setText(getStudent().getEmail());
            phone.setText(getStudent().getPhone());
            address.setText(getStudent().getAddress());
            studentID.setText(getStudent().getID());
            type.setText(getStudent().getType());
            credits.setText("" + getStudent().getCredits());
            scholarship.setText("" + getStudent().getScholarship());
            deduction.setText("" + getStudent().getDeduction());
            add.setDisable(true);
        }
    }
    
    
    private String setErrorMessage() {
        validator.clear();
        ArrayList<String> errorsList;
        errorsList = new ArrayList<>();
        validator.generateErrors(getName(), getEmail(), getPhone(),getAddress(), getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
        for (String s: validator.errors()) {
            errorsList.add(s);
        }
        String result = errorsList.toString();
        result =  result.substring(1, result.length()-1);
        result = result.replaceAll(",","");
        result = result.replaceAll("\\s+", " ");
        result = result.replaceAll("!", "!\n");
        return result;
    }
   
    
    @FXML 
    private void handleAdd() throws Exception {
        boolean valid = validator.isValid(getName(), getEmail(), getPhone(),getAddress(),getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
            if (valid) {
                //getFaculty().addStudent(getStudent());
                getStudent().updateDetails(getName(), getEmail(), getPhone(), getAddress(), getStudentID(), getType(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()), getDeductionCode());
                stage.close();  
            }
            else {
                Stage errorStage = new Stage();
                errorStage.getIcons().add(new Image("/view/error.png")); 
                ViewLoader.showStage(new InputException(setErrorMessage()), "/view/error.fxml", "Input Exceptions", errorStage);
            }
}
    
    @FXML 
    private void handleUpdate() throws Exception{
        boolean valid = validator.isValid(getName(), getEmail(), getPhone(),getAddress(),getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
            if (valid) {
                getStudent().updateDetails(getName(), getEmail(), getPhone(), getAddress(), getStudentID(), getType(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()), getDeductionCode());
                stage.close();  
            }
            else {
                validator.generateErrors(getName(), getEmail(), getPhone(),getAddress(), getType(), getStudentID(), Integer.parseInt(getCredits()), Double.parseDouble(getScholarship()));
                Stage errorStage = new Stage();
                errorStage.getIcons().add(new Image("/view/error.png")); 
                ViewLoader.showStage(new InputException(setErrorMessage()), "/view/error.fxml", "Input Exceptions", errorStage);
            }
    }
    
    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
    }
}
