/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import weboss.Service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AcceuilEtudiantController implements Initializable {

    @FXML
    private Pagination pagination;
    @FXML
    private Pane sousMenuEvenemet;
    @FXML
    private JFXButton reclamation;

    @FXML
    private Pane bck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherAfficheEvenement();
        sousMenuEvenemet.setVisible(false);
    }

    void affichage(String x) {
        Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource(x));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void afficherAfficheEvenement() {
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
            ex.getMessage();
        }

        pagination.setPageCount(images.size());
        pagination.setPageFactory(n -> new ImageView(images.get(n)));
    }

    //////////
    @FXML
    void ConsulterDemande(MouseEvent event) {
        affichage("/GUIInterface/consulter_demande_evenemet.fxml");

    }

    @FXML
    void afficer_sous_menu_event(MouseEvent event) {
        sousMenuEvenemet.setVisible(true);

    }

    @FXML
    void demandeEvenement(MouseEvent event) {
        affichage("/GUIInterface/DemandeEvenement.fxml");
        sousMenuEvenemet.setVisible(false);

    }

    @FXML
    void fermerSosMenuEvent(MouseEvent event) {
        sousMenuEvenemet.setVisible(false);

    }

    @FXML
    private void logout(MouseEvent event) {
        affichage("/GUIInterface/Login.fxml");
    }

}
