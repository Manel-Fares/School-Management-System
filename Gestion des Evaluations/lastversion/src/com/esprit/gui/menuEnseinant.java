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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class menuEnseinant implements Initializable {

    @FXML
    private Button notes;
    @FXML
    private Button credit;
    @FXML
    private Button resultat;
    @FXML
    private Pane change;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void notesAction(ActionEvent event) {
        
        
    Parent interfaceEtudiantNote;
        try {
            interfaceEtudiantNote = FXMLLoader.load(getClass().getResource("GestionNoteEnseignant.fxml"));
            change.getChildren().removeAll();
            change.getChildren().setAll(interfaceEtudiantNote);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void creditAction(ActionEvent event) {
        Parent interfaceEtudiantCreditt;
                try {
            interfaceEtudiantCreditt = FXMLLoader.load(getClass().getResource("AjouterNote.fxml"));
            change.getChildren().removeAll();
            change.getChildren().setAll(interfaceEtudiantCreditt);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @FXML
    private void resultatAction(ActionEvent event) {
        Parent interfaceEtudiantResultat;
                try {
            interfaceEtudiantResultat = FXMLLoader.load(getClass().getResource("interfaceEtudiantResultat.fxml"));
            change.getChildren().removeAll();
            change.getChildren().setAll(interfaceEtudiantResultat);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
