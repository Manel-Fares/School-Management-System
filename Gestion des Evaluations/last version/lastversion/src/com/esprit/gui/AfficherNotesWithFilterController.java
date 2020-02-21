/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Service.ServiceNote;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class AfficherNotesWithFilterController implements Initializable {

    @FXML
    private TableColumn<Note, String> idEtudiant;
    @FXML
    private TableColumn<Note, String> idMatiere;
    @FXML
    private TableColumn<Note, String> noteCC;
    @FXML
    private TableColumn<Note, String> moyenne;
    @FXML
    private TableColumn<Note, String> noteDS;
    @FXML
    private TableColumn<Note, String> noteExam;
    @FXML
    private TextField rechercher;
    @FXML
    private TableView<Note> tableViewNotes;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button actualiser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idEtudiant.setCellValueFactory(new PropertyValueFactory<>("idEtudiant"));
        idMatiere.setCellValueFactory(new PropertyValueFactory<>("idMatiere"));
        noteCC.setCellValueFactory(new PropertyValueFactory<>("noteCC"));
        noteDS.setCellValueFactory(new PropertyValueFactory<>("noteDS"));
        noteExam.setCellValueFactory(new PropertyValueFactory<>("noteExam"));
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        ServiceNote sn = new ServiceNote();
        tableViewNotes.setItems(sn.getNotes());
        //  modifierAction();

        rechercher();
        //  supprimerButtonAction();

    }

    /*  private void modifierAction() {
        tableViewNotes.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierNote.fxml"));
                    ModifierNoteController controller = new ModifierNoteController(tableViewNotes.getSelectionModel().getSelectedItem());
                    loader.setController(controller);

                    Stage editorStage = new Stage();
                    // editorStage.setTitle("Modifier note selectionner");

                    editorStage.initOwner(tableViewNotes.getScene().getWindow());

                    // assurer fermuture de nouvelle fenetre avant l'utilisation du fenetre courante 
              /*    editorStage.initModality(Modality.APPLICATION_MODAL);
                    System.out.println("1");
                    editorStage.setScene(new Scene(loader.load()));
                    System.out.println("2");
                    editorStage.showAndWait();
                    // Set the scene:
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root, 550, 558));
                    stage.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
    private void rechercher() {

        rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            ServiceNote sn = new ServiceNote();
            tableViewNotes.setItems(sn.listeNoteEtudiant(newValue));
       

        });
    }

    private void print() {

    }

    @FXML
    private void supprimerButtonAction(ActionEvent event) throws IOException {

        //   tableViewNotes.getItems().removeAll(tableViewNotes.getSelectionModel().getSelectedItem());
        int selectedIndex = tableViewNotes.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            Note n = (Note) tableViewNotes.getSelectionModel().getSelectedItem();

            ServiceNote sp = new ServiceNote();
            try {
                sp.delete(n);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Supprimer Note");
                alert.setHeaderText("Une Note a été supprimer :) ");
                alert.setContentText("veuillez fermer cette fenetre ");
                alert.showAndWait();
            } catch (SQLException ex) {
            }

        }
    }

    @FXML
    private void ajouterAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        final Stage stage = (Stage) node.getScene().getWindow();
        final Parent ajoutN = FXMLLoader.load(getClass().getResource("AjouterNote.fxml"));
        final Scene noteScene = new Scene(ajoutN);

        stage.setScene(noteScene);
    }

    @FXML
    private void modifierAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        ModifierNoteController controller = new ModifierNoteController(tableViewNotes.getSelectionModel().getSelectedItem());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierNote.fxml"));
        loader.setController(controller);
        final Stage stage = (Stage) node.getScene().getWindow();
        final Parent modifN = loader.load();
        final Scene modScene = new Scene(modifN);

        stage.setScene(modScene);
                       

        
    }

    @FXML
    private void actualiserAction(ActionEvent event) {
        ServiceNote sn = new ServiceNote();
        tableViewNotes.setItems(sn.getNotes());
        tableViewNotes.refresh();
    }

}
