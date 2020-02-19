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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class InterfaceEnseignantNoteController implements Initializable {

    @FXML
    private TableView<Note> tableViewNotes;
    @FXML
    private TableColumn<Note, String> idEtudiant;
    @FXML
    private TableColumn<Note, String> idMatiere;
    @FXML
    private TableColumn<Note, String> noteCC;
    @FXML
    private TableColumn<Note, String> noteDS;
    @FXML
    private TableColumn<Note, String> noteExam;
    @FXML
    private TableColumn<Note, String> moyenne;
    @FXML
    private TextField rechercher;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button actualiser;
    @FXML
    private TextField idEnseignant;
    @FXML
    private Button ajouter;
    @FXML
    private Button calculMoyenne;
    @FXML
    private Label cc;
    @FXML
    private Label ds;
    @FXML
    private Label exam;
    @FXML
    private Slider noteCC1;
    @FXML
    private Slider noteDS1;
    @FXML
    private Slider noteExam1;
    @FXML
    private Pane pane;
    @FXML
    private Button valider;

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
        pane.setVisible(false);
        ServiceNote sn = new ServiceNote();
        tableViewNotes.setItems(sn.getNotes());
        //  modifierAction();

        rechercher();
        //  supprimerButtonAction();

        // TODO
    }

    @FXML
    private void supprimerButtonAction(ActionEvent event) {
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

        int selectedIndex = tableViewNotes.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Note note = (Note) tableViewNotes.getSelectionModel().getSelectedItem();
            noteDS1.setValue(note.getNoteDS());
            noteCC1.setValue(note.getNoteCC());
            noteExam1.setValue(note.getNoteExam());
            cc.setText(Double.toString(noteCC1.getValue()));
            ds.setText(Double.toString(noteDS1.getValue()));
            exam.setText(Double.toString(noteExam1.getValue()));
            pane.setVisible(true);
            noteCC1.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    cc.setText(Double.toString(noteCC1.getValue()));
                }
            });

            noteDS1.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    ds.setText(Double.toString(noteDS1.getValue()));
                }
            });

            noteExam1.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    exam.setText(Double.toString(noteExam1.getValue()));
                }
            });

        }
    }

    @FXML
    private void actualiserAction(ActionEvent event) {
        ServiceNote sn = new ServiceNote();
        tableViewNotes.setItems(sn.getNotes());
        tableViewNotes.refresh();
    }

    @FXML
    private void calculerMoyenneAction(ActionEvent event) {

        int selectedIndex = tableViewNotes.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            Note n = (Note) tableViewNotes.getSelectionModel().getSelectedItem();
            //  n.setIdEnseignant(Integer.parseInt(idEnseignant.getText()));

            ServiceNote sp = new ServiceNote();
            try {
                sp.calculMoyenneNote(n);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Moyenne Matiere");
                alert.setHeaderText("Une moyenne a été calculer :) ");
                alert.setContentText("veuillez fermer cette fenetre ");
                alert.showAndWait();
            } catch (SQLException ex) {
            }
        }

    }

    private void rechercher() {

        rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            ServiceNote sn = new ServiceNote();
            tableViewNotes.setItems(sn.listeNoteEtudiant(newValue));

        });
    }

    @FXML
    private void validerModificationAction(ActionEvent event) {
        valider.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Note note = (Note) tableViewNotes.getSelectionModel().getSelectedItem();
                Note n = new Note(note.getIdEtudiant(), note.getIdMatiere(), note.getDateNote(),
                        noteCC1.getValue(), noteDS1.getValue(), noteExam1.getValue());
                       // Integer.parseInt(idEnseignant.getText()));

                ServiceNote ser = new ServiceNote();
                try {
                    ser.update(n);
                    pane.setVisible(false);
                } catch (SQLException ex) {
                }
            }
        });
        
    }

}
