/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import weboss.Service.DemandeEvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AcceuilPersonelController implements Initializable {

    @FXML
    private AnchorPane background;
    @FXML
    private Pane bck;
    @FXML
    private Label nbr_notif_admin;
    @FXML
    private ImageView notif_icon;
    @FXML
    private Pane notification_area;
    @FXML
    private Label desc_notif;

    /**
     * Initializes the controller class.
     */
    DemandeEvenementService devs=new DemandeEvenementService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         nbr_notif_admin.setText("" + devs.nombre_demande());
         notification_area.setVisible(false);
        // TODO
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

    @FXML
    private void logout(MouseEvent event) {
         Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/Login.fxml"));
            background.getChildren().removeAll();
            background.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void afficherNotification(MouseEvent event) {
         notification_area.setVisible(true);
desc_notif.setText(devs.notifiction().toString());  
    }

    @FXML
    private void afficherClass(MouseEvent event) {
        affichage("/GUIInterface/Afficher.fxml");

    }

    @FXML
    private void afficherEmploie(MouseEvent event) {
        affichage("/GUIInterface/AfficherE.fxml");

    }

    @FXML
    private void afficherCalendar(MouseEvent event) {
        //affichage("/GUIInterface/CalendarEvent.fxml");

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUIInterface/CalendarEvent.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    @FXML
    private void afficherAffect(MouseEvent event) {
        affichage("/GUIInterface/GetAllEtudiant.fxml");

    }

    @FXML
    private void afficherAbsence(MouseEvent event) {
        affichage("/GUIInterface/AfficherAbsence.fxml");

    }

    @FXML
    private void afficherEvenement(MouseEvent event) {
        affichage("/GUIInterface/Affciher_Evenement.fxml");

    }

    @FXML
    private void afficherClub(MouseEvent event) {
        affichage("/GUIInterface/Afficher_Club.fxml");

    }

    @FXML
    private void afficherDemandeEvent(MouseEvent event) {
        affichage("/GUIInterface/afficher_Demande_Evenement.fxml");

    }

    @FXML
    private void fermerNotif(MouseEvent event) {
        notification_area.setVisible(false);
    }

}
