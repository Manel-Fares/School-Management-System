/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import project.entities.Enseignant;
import project.service.EnseignantService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class FormulaireController implements Initializable {
    @FXML
    private Button ajouter;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField email;

    @FXML
    private TextField cin;

    @FXML
    private TextField adresse;

    @FXML
    private TextField numTel;
        @FXML
    private RadioButton homme;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton femme;

    @FXML
    private ComboBox<String> domain;
    ObservableList<String> list = FXCollections.observableArrayList("Info","Math");

    
    
    @FXML
    public void AjouterEnseignant(){
        String sexe = null,s;
       
        Date d = new Date(12,12,2012);
     
        EnseignantService ser = new EnseignantService();
        if(Gender.getSelectedToggle().equals(homme))
            sexe="Homme";
        else if(Gender.getSelectedToggle().equals(femme))
            sexe="femme";
            
        
        Enseignant ens = new Enseignant("",parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),parseInt(numTel.getText()),d, sexe, "", "En Travaill", 100.2,d, domain.getValue());
        
        try {
            ser.ajouter(ens);
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @FXML
   /* public String Domain(ActionEvent event) {
        
        return domain.getValue();

    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        domain.setItems(list);
        
        // TODO
    }    


    
}