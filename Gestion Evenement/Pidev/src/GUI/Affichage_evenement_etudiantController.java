/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import pidev.service.DemandeEvenementService;
import pidev.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Affichage_evenement_etudiantController implements Initializable {

    @FXML
    private Pagination pagination;
    @FXML
    private Pane bck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementService dev = new EvenementService();
        ArrayList<String> images = new ArrayList<>();
        try {
            System.out.println("image path:" + dev.recpererImage());

            //images.addAll(dev.recpererImage());
            //System.out.println(images);
            for (int i = 0; i < dev.recpererImage().size(); i++) {
                
                final String imageURI = new File(dev.recpererImage().get(i)).toURI().toString();
                System.out.println(imageURI);
                images.add(imageURI);
                // images.add(imageURI);
            }
            /*images.add("/GUI/1.jpg");
            images.add("/GUI/1.jpg");*/
        } catch (SQLException ex) {
            Logger.getLogger(Affichage_evenement_etudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }

        pagination.setPageCount(images.size());
        pagination.setPageFactory(n -> new ImageView(images.get(n)));
    }

    @FXML
    private void DemadeEvenement(ActionEvent event) {
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
    private void Consulter_Demande(ActionEvent event) {
          Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("consulter_demande_evenemet.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void evenement(ActionEvent event) {
         Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Affichage_evenement_etudiant.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
