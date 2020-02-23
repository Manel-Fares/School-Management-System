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
public class MenuController implements Initializable {

    @FXML
    private Button credit;
    @FXML
    private Pane change;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    





    @FXML
    private void creditAction(ActionEvent event) {
         Parent ajoutNote;
        try {
            ajoutNote = FXMLLoader.load(getClass().getResource("creditEtudiant.fxml"));
            change.getChildren().removeAll();
            change.getChildren().setAll(ajoutNote);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void notesAction(ActionEvent event) {
             Parent ajoutNote;
        try {
            ajoutNote = FXMLLoader.load(getClass().getResource("InterfaceEtudiantNote.fxml"));
            change.getChildren().removeAll();
            change.getChildren().setAll(ajoutNote);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void resultatAction(ActionEvent event) {
         Parent ajoutNote;
        try {
            ajoutNote = FXMLLoader.load(getClass().getResource("interfaceEtudiantResultat.fxml"));
            change.getChildren().removeAll();
            change.getChildren().setAll(ajoutNote);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ajouterAction(ActionEvent event) {
    }

    @FXML
    private void modifierAction(ActionEvent event) {
    }

    
    
}
