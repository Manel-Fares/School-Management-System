/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import pidev.entities.Club;
import pidev.service.ClubService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EventUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField domaine;

    @FXML
    private JFXTextField nom_club;

    @FXML
    private JFXTextField idResponsable;

    ClubService cs = new ClubService();
    @FXML
    private AnchorPane page_creer_club;
    @FXML
    private Pane bck;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void ajouter_club(MouseEvent event) {
        int id = Integer.parseInt(idResponsable.getText());
        Club t = new Club(id, nom_club.getText(), domaine.getText());
        try {
            cs.ajouter(t);
        } catch (SQLException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML

    void afficher_club(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("page2.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void demandeEvenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("DemandeEvenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Evenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Affciher_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @FXML
    void affiche_demabde_evenement(MouseEvent event) {
 Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("afficher_Demande_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void ajouterEvenement(MouseEvent event) {
Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Ajout_evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
