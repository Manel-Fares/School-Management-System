/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import project.entities.Enseignant;
import project.entities.Etudiant;
import project.entities.User;
import project.service.EnseignantService;
import project.service.EtudiantService;
import project.service.ParentService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class AjouterEtudiantController implements Initializable {

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
    private ComboBox<String> domain;
            ObservableList<String> list = FXCollections.observableArrayList("Info","Math");


    @FXML
    private RadioButton homme;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton femme;

    @FXML
    private Button Ajouter;

    @FXML
    private TextField nomResponsable;

    @FXML
    private DatePicker date;

   @FXML
    void AjouterEtudiant(ActionEvent event) {
   String sexe = null,s;
       
        Date d = new Date(12,12,2012);
     
        EtudiantService ser = new EtudiantService();
        ParentService ser1 = new ParentService();
        if(Gender.getSelectedToggle().equals(homme))
            sexe="Homme";
        else if(Gender.getSelectedToggle().equals(femme))
            sexe="femme";
            
        
        Etudiant etd = new Etudiant("",parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),1,d,sexe,cin.getText(), "",d, domain.getValue());
        System.out.println(etd);
        User parent = new User("",parseInt(cin.getText())+1, nomResponsable.getText(), "", "", adresse.getText(),parseInt(numTel.getText()),d,"",cin.getText());
        System.out.println(parent);
        try {
            ser.ajouter(etd);
            ser1.ajouter(parent);
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        domain.setItems(list);
        // TODO
    }    
    
}
