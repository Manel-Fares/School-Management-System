/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import javafx.stage.Stage;
import weboss.Service.ClassService;
import weboss.Entities.Class;
import weboss.Service.ValidationChamps;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */

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
    @FXML
    private Label labelName;
    @FXML
    private Label labelNbr;
    @FXML
    private Label labelDesc;
    @FXML
    private Label labelNiv;
    @FXML
    private Label labelSpec;
    

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
        SpecClass.getSelectionModel().selectFirst();
        NiveauClass.getSelectionModel().selectFirst();
        
    
    }    

    @FXML
    private void AddClassAction(ActionEvent event) throws IOException {
        boolean isNameEmpty = ValidationChamps.isTextFieldNotEmpty(NameClass, labelName,"Empty!");
        boolean isNBREmpty = ValidationChamps.isTextFieldNotEmpty(NbrEtudClass, labelNbr,"Empty!");
       // boolean isNivEmpty = ValidationChamps.isComboBoxNotEmpty(NiveauClass, labelNiv,"Empty!");
       // boolean isSpecEmpty = ValidationChamps.isComboBoxNotEmpty(SpecClass, labelSpec,"Empty!");
        boolean isDescEmpty = ValidationChamps.isTextAreaNotEmpty(DescriptionClass, labelDesc,"Empty!");
      //  String niv=NiveauClass.getValue()+SpecClass.getValue();
      if(!isNameEmpty && !isNBREmpty  && !isDescEmpty)
      {
        Class u =new Class(NameClass.getText(),NiveauClass.getValue(),SpecClass.getValue(),Integer.parseInt(NbrEtudClass.getText()),DescriptionClass.getText());
        ClassService us =new ClassService();
        
        us.AddClass(u);
      }
        System.out.println("Done");
        Stage stage = (Stage) AddClassAnchorPane.getScene().getWindow();
        stage.close();
        
    }



   
    
}
