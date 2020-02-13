/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import pidev.service.DemandeEvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Consulter_demande_evenemetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<DemandeEvenement> tab;

    @FXML
    private TableColumn<DemandeEvenement, Integer> id_club;

    @FXML
    private TableColumn<DemandeEvenement, Float> budget;

    @FXML
    private TableColumn<DemandeEvenement, String> desc;

    @FXML
    private TableColumn<DemandeEvenement, String> dd;

    @FXML
    private TableColumn<DemandeEvenement, String> df;

     private final ObservableList<DemandeEvenement> l = FXCollections.observableArrayList();
     DemandeEvenementService cs =new DemandeEvenementService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
            /*try {
                l.addAll(cs.afficherDemandeSpecifique(1));
            } catch (SQLException ex) {
                Logger.getLogger(Consulter_demande_evenemetController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
    }    
    
}
