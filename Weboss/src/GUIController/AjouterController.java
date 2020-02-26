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
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import weboss.Service.ClassService;
import weboss.Entities.Class;



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
    

       public void afficherAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        //alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public boolean testSaisie() {
        
       // System.out.println("compare="+dateDebut.getValue().compareTo(dateFin.getValue()));

        if (NameClass.getText().trim().isEmpty() || NbrEtudClass.getText().trim().isEmpty()
                || DescriptionClass.getText().trim().isEmpty()
                //|| adresse.getText().trim().isEmpty()
                || NiveauClass.getValue() == null
                || SpecClass.getValue() == null
                //|| imageFileLabel.getText().trim().isEmpty()
                ) {
            afficherAlert("Tous les champs doivent être remplis");
            return false;
        }
        String r=NameClass.getText().substring(0,1);
        String r2=NameClass.getText().substring(0,2);
        if(!r.equals(NiveauClass.getValue())&& !r2.equals(SpecClass.getValue()))
                {
            afficherAlert("verifier niveau et specalite champ");
            return false;  
                }

        try {
            Double num = Double.parseDouble(NbrEtudClass.getText());
        } catch (NumberFormatException e) {
            afficherAlert("Champs Nombre invalide");
            return false;
        }
        return true;
    }
    public boolean _1erelettre()
    {
        String r=NameClass.getText().substring(0,1);
         Pattern err = Pattern.compile("^[1-5]");
         if (!err.matcher(r).matches()) {
            afficherAlert("premier lettre doit commencer 1-5");
            return false;
        }      
        return true;
    }
    
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
        ClassService us =new ClassService();
        System.out.println(us.ValidatorNomClass(NameClass.getText()));
        if (testSaisie()){
            if(_1erelettre())
            {
        if(!us.ValidatorNomClass(NameClass.getText()))
        {
        String niv=NiveauClass.getValue()+SpecClass.getValue();
        Class u =new Class(NameClass.getText(),NiveauClass.getValue(),SpecClass.getValue(),Integer.parseInt(NbrEtudClass.getText()),DescriptionClass.getText());
        
        us.AddClass(u);
        System.out.println("Done");
        Stage stage = (Stage) AddClassAnchorPane.getScene().getWindow();
        stage.close();
        }
        else
        afficherAlert("Name already exist");
        }
        }
    }
    



   
    
}
