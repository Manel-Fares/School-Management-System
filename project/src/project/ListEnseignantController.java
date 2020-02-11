/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.entities.Enseignant;
import project.entities.Etudiant;
import project.entities.Reclamation;
import project.service.EnseignantService;
import project.service.EtudiantService;
import project.service.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ListEnseignantController implements Initializable {

    @FXML
    private TableView<Enseignant> table;

    @FXML
    private TableColumn<Enseignant, String> id;

    @FXML
    private TableColumn<Enseignant, Integer> cin;

    @FXML
    private TableColumn<Enseignant, String> nom;

    @FXML
    private TableColumn<Enseignant, String> prenom;

    @FXML
    private TableColumn<Enseignant, String> email;

    @FXML
    private TableColumn<Enseignant, String> adresse;

    @FXML
    private TableColumn<Enseignant, Integer> numtel;

    @FXML
    private TableColumn<Enseignant, Date> date;

    @FXML
    private TableColumn<Enseignant, String> sexe;

    @FXML
    private TableColumn<Enseignant, String> mdp;
     @FXML
    private TableColumn<Enseignant, Double> salaire;

    @FXML
    private TableColumn<Enseignant, Date> dateE;

    @FXML
    private TableColumn<Enseignant, String> domain;

    @FXML
    private TableColumn<Enseignant, String> statut;

   

    @FXML
    public ObservableList<Enseignant> list = FXCollections.observableArrayList();
    
    @FXML
    public void afficher(){
       
   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              EnseignantService ser = new EnseignantService();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
         
        }
        System.out.println(list);
          
            id.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("idUser"));
            cin.setCellValueFactory(new PropertyValueFactory<Enseignant, Integer>("cinUser"));
            nom.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("nomUser"));
              prenom.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("prenomUser"));
            date.setCellValueFactory(new PropertyValueFactory<Enseignant, Date>("dateNaissanceUser"));
            dateE.setCellValueFactory(new PropertyValueFactory<Enseignant, Date>("dateEmbaucheEnsg"));
            statut.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("statutEnsg"));
            mdp.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("motDePasseUser"));
            numtel.setCellValueFactory(new PropertyValueFactory<Enseignant, Integer>("numTelUser"));
            sexe.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("sexeUser"));
            salaire.setCellValueFactory(new PropertyValueFactory<Enseignant, Double>("salaireEnsg"));
          
            
            adresse.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("adresseUser"));
            email.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("emailUser"));
           
            domain.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("domaineEnsg"));
            table.setItems(list);
    }    
    
}
