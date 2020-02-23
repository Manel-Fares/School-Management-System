/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Service.ServiceNote;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class CreditEtudiantController implements Initializable {

    @FXML
    private TableColumn<Note, String> noteCC;
    @FXML
    private TableColumn<Note, String> noteDS;
    @FXML
    private TableColumn<Note, String> noteExam;
    @FXML
    private TableView<Note> tableViewNotes;
    @FXML
    private TableColumn<Note, String> moyenne;
    @FXML
    private TextField idEtudiant;
    @FXML
    private TableColumn<Note, String> infoMatiere;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        noteCC.setCellValueFactory(new PropertyValueFactory<>("noteCC"));
        noteDS.setCellValueFactory(new PropertyValueFactory<>("noteDS"));
        noteExam.setCellValueFactory(new PropertyValueFactory<>("noteExam"));
        infoMatiere.setCellValueFactory(new PropertyValueFactory<>("info"));
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));

  
           afficher();

    }

    private void afficher() {

        idEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
            ServiceNote sn = new ServiceNote();
            tableViewNotes.setItems(sn.listeEtudiantCredit(newValue));

        });
    }

}
