/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage; 
import javafx.stage.Popup; 
//import net.demilich.metastone.gui.cards.CardTooltip;


/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AccueilController implements Initializable {

    @FXML
    private AnchorPane PaneAccueil;
    @FXML
    private Button Emplois;
    @FXML
    private Button Class;
    @FXML
    private Button Calendar;
    @FXML
    private Button AffEtud;
    @FXML
    private Button AffEns;
    @FXML
    private Button Absence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Stage stage = new Stage();

    }    

    @FXML
    private void EmploisAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("AjouterE.fxml"));
        PaneAccueil.getChildren().setAll(pane);
    }

    @FXML
    private void ClassAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
        PaneAccueil.getChildren().setAll(pane);
    }

    @FXML
    private void CalendarAction(ActionEvent event) throws IOException {
               AnchorPane pane= FXMLLoader.load(getClass().getResource("CalendarEvent.fxml"));
        PaneAccueil.getChildren().setAll(pane);
    }

    @FXML
    private void AffEtudAction(ActionEvent event) throws IOException {
               AnchorPane pane= FXMLLoader.load(getClass().getResource("AffecterClass.fxml"));
        PaneAccueil.getChildren().setAll(pane);
    }

    @FXML
    private void AffEnsAction(ActionEvent event) throws IOException {
               AnchorPane pane= FXMLLoader.load(getClass().getResource("AffecterClass.fxml"));
        PaneAccueil.getChildren().setAll(pane);
    }

    @FXML
    private void AbsenceAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Absence.fxml"));
        PaneAccueil.getChildren().setAll(pane);
    }
    
}
