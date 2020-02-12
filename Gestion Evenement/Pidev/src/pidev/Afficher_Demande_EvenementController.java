/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import java.net.URL;
import java.sql.SQLException;
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
import pidev.entities.DemandeEvenement;
import pidev.service.DemandeEvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */

    
public class Afficher_Demande_EvenementController implements Initializable {

    /**
     * Initializes the controller class.
     */@FXML
    private TableView<DemandeEvenement> tab_demande_evenemnt;

    @FXML
    private TableColumn<DemandeEvenement, Integer> id_evenement;

    @FXML
    private TableColumn<DemandeEvenement, Integer> id_club;

    @FXML
    private TableColumn<DemandeEvenement, String> date_debut;

    @FXML
    private TableColumn<DemandeEvenement, String> date_fin;

    @FXML
    private TableColumn<DemandeEvenement, String> description;

    @FXML
    private TableColumn<DemandeEvenement, String> etat;
     @FXML
    private final ObservableList<DemandeEvenement> listDemandeEvenement = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         // TODO
        DemandeEvenementService cs = new DemandeEvenementService();
        try {
            listDemandeEvenement.addAll(cs.affciher());
        } catch (SQLException ex) {
            Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        id_evenement.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Integer>("idDemandeEvenement"));
        id_club.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Integer>("idclub"));
        date_debut.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("datedebut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("datefin"));
        description.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("description"));
        etat.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("etat"));
        tab_demande_evenemnt.setItems(listDemandeEvenement);

    }    
    
}
