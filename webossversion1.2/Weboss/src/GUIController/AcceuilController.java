/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import weboss.Service.DemandeEvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AcceuilController implements Initializable {

    @FXML
    private Pane bck;
   
    @FXML
    private AnchorPane background;
    @FXML
    private Pane user_charts;
    @FXML
    private Pane chartClub;
    @FXML
    private Label nbr_notif_admin;
    @FXML
    private ImageView notif_icon;

    DemandeEvenementService devs = new DemandeEvenementService();
    @FXML
    private Pane notification_area;
    @FXML
    private Label desc_notif;
    @FXML
    private Pane nbrEtudiantClass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Parent fxml,fxml1;
         nbr_notif_admin.setText("" + devs.nombre_demande());
         notification_area.setVisible(false);
        try {

            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/ChartUser.fxml"));
            user_charts.getChildren().removeAll();
            user_charts.getChildren().setAll(fxml);
            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/ChartsClub.fxml"));
            chartClub.getChildren().removeAll();
            chartClub.getChildren().setAll(fxml);
            fxml1 = FXMLLoader.load(getClass().getResource("/GUIInterface/Stat.fxml"));
            nbrEtudiantClass.getChildren().removeAll();
            nbrEtudiantClass.getChildren().setAll(fxml1);
            

        } catch (IOException ex) {
            ex.getMessage();
        }
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
    private void p1(MouseEvent event) {
        affichage("/GUIInterface/p1.fxml");
        
    }

    private void p2(MouseEvent event) {
                affichage("/GUIInterface/p1.fxml");

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

    private void EspaceEtudiant(ActionEvent event) {
        affichage("/GUIInterface/EspaceEtudiant.fxml");
    }

    private void EspaceEnseignant(ActionEvent event) {
                affichage("/GUIInterface/EspaceEnseignant.fxml");

    }

    private void EspacePersonnel(ActionEvent event) {
                affichage("/GUIInterface/EspacePersonnel.fxml");

    }

    @FXML
    private void afficherNotification(MouseEvent event) {
         notification_area.setVisible(true);
desc_notif.setText(devs.notifiction().toString());      
    }

    private void demandeEvenement(MouseEvent event) {
         affichage("/GUIInterface/DemandeEvenement.fxml");
    }

    private void GestionClub(MouseEvent event) {
                 affichage("/GUIInterface/Afficher_Club.fxml");

    }

    @FXML
    private void afficherClass(MouseEvent event) {
    }
    
}
