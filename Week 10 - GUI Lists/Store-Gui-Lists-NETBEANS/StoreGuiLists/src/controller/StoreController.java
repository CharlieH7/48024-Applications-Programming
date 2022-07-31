package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import au.edu.uts.ap.javafx.*;
import model.*;

public class StoreController extends Controller<Store> {
    
    @FXML private Text cashTxt;
    @FXML private ListView<Product> groupsLv;
    
    public final Store getStore() {
        return model;
    }
    
    @FXML 
    private void initialize() {
        cashTxt.textProperty().bind(getStore().getCashRegister().cashProperty().asString("$%.2f"));
    }
    
    private Product getSelectedProduct() {
        return groupsLv.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void handleView(ActionEvent event) throws Exception {
        ViewLoader.showStage(getSelectedProduct(), "/view/product.fxml", "Product", new Stage());
    }
}
