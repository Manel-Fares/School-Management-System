/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import  entity.Class;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
import service.ClassService;
public class AjouterController implements Initializable {

    @FXML
    private AnchorPane AddClassAnchorPane;
    @FXML
    private JFXButton AddClass;
    @FXML
    private Label label;
    @FXML
    private JFXTextField NameClass;
    @FXML
    private JFXTextField NbrEtudClass;
    @FXML
    private JFXComboBox<String> NiveauClass;
    @FXML
    private JFXComboBox<String> SpecClass;
    @FXML
    private JFXTextArea DescriptionClass;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> optionsNiv = 
    FXCollections.observableArrayList("1","2","3","4","5");
        ObservableList<String> optionsSpec = 
    FXCollections.observableArrayList("A","B","TWIN","DS","BI","GL","INFOB");
        NiveauClass.getItems().clear();
        SpecClass.getItems().clear();
        NiveauClass.setItems(optionsNiv);
        SpecClass.setItems(optionsSpec);
        
    
    }    

    @FXML
    private void AddClassAction(ActionEvent event) throws IOException {
        String niv=NiveauClass.getValue()+SpecClass.getValue();
        Class u =new Class(NameClass.getText(),NiveauClass.getValue(),SpecClass.getValue(),Integer.parseInt(NbrEtudClass.getText()),DescriptionClass.getText());
        ClassService us =new ClassService();
        us.AddClass(u);
        System.out.println("Done");
        Stage stage = (Stage) AddClassAnchorPane.getScene().getWindow();
        stage.close();
        
    }



   
    
}
