/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class AccueilController implements Initializable {

    @FXML
    private Button resultat;
    @FXML
    private Button note;
    @FXML
    private Button listeDesNotes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void resultatAction(ActionEvent event) {
    }

    @FXML
    private void noteAction(ActionEvent event) throws IOException {
            Node node = (Node) event.getSource();
            final Stage stage = (Stage) node.getScene().getWindow();
            final Parent ajoutNote = FXMLLoader.load(getClass().getResource("AjouterNote.fxml"));
            final Scene notScene = new Scene(ajoutNote);

            stage.setScene(notScene);
    }

    @FXML
    private void afficherNotesAction(ActionEvent event) throws IOException {
            Node node = (Node) event.getSource();
            final Stage stage = (Stage) node.getScene().getWindow();
            final Parent afficherNotes = FXMLLoader.load(getClass().getResource("afficherNotesWithFilter.fxml"));
            final Scene noteScene = new Scene(afficherNotes);

            stage.setScene(noteScene);
    }
    
}
