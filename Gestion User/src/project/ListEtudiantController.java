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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.entities.Etudiant;
import project.service.EtudiantService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ListEtudiantController implements Initializable {

    @FXML
    private TableView<Etudiant> table;

    @FXML
    private TableColumn<Etudiant, String> id;

    @FXML
    private TableColumn<Etudiant, Integer> cin;

    @FXML
    private TableColumn<Etudiant, String> nom;

    @FXML
    private TableColumn<Etudiant, String> prenom;

    @FXML
    private TableColumn<Etudiant, String> email;

    @FXML
    private TableColumn<Etudiant, String> adresse;

    @FXML
    private TableColumn<Etudiant, Integer> numtel;

    @FXML
    private TableColumn<Etudiant, Date> date;

    @FXML
    private TableColumn<Etudiant, String> sexe;

    @FXML
    private TableColumn<Etudiant, String> mdp;

    @FXML
    private TableColumn<Etudiant, String> classe;

    @FXML
    private TableColumn<Etudiant, Date> dateI;

    @FXML
    private TableColumn<Etudiant, String> sp;

    @FXML
    public ObservableList<Etudiant> list = FXCollections.observableArrayList();
    
    @FXML
    public void afficher(){
       
   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              EtudiantService ser = new EtudiantService();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
         
        }
        System.out.println(list);
          
            id.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("idUser"));
            cin.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("cinUser"));
            nom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nomUser"));
              prenom.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenomUser"));
            date.setCellValueFactory(new PropertyValueFactory<Etudiant, Date>("dateNaissanceUser"));
            dateI.setCellValueFactory(new PropertyValueFactory<Etudiant, Date>("inscriptionEtd"));
            classe.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("classeEtd"));
            mdp.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("motDePasseUser"));
            numtel.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("numTelUser"));
            sexe.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("sexeUser"));                 
            adresse.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("adresseUser"));
            email.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("emailUser"));          
            sp.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("specialiteEtd"));
            table.setItems(list);
    }    
    
}
