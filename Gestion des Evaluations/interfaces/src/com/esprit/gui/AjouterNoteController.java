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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class AjouterNoteController implements Initializable {

    @FXML
    private DatePicker dateNote;
    @FXML
    private TextField idMatiere;
    @FXML
    private TextField idEtudiant;
    @FXML
    private Slider noteCC;
    @FXML
    private Slider noteDS;
    @FXML
    private Slider noteExam;
    @FXML
    private Button ajouterNote;
    @FXML
    private Label cc;
    @FXML
    private Label ds;
    @FXML
    private Label exam;
    @FXML
    private TextField idEnseignant;
    @FXML
    private Button retourner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        noteCC.setMax(20);
        noteDS.setMax(20);
        noteExam.setMax(20);
        noteCC.setValue(0);
        noteCC.setMin(0);
        noteDS.setMin(0);
        noteDS.setValue(0);
        noteExam.setMin(0);
        noteExam.setValue(0);
        noteCC.setBlockIncrement(0.25);
        noteDS.setBlockIncrement(0.25);
        noteExam.setBlockIncrement(0.25);
        cc.setText(Double.toString(noteCC.getValue()));
        ds.setText(Double.toString(noteDS.getValue()));
        exam.setText(Double.toString(noteExam.getValue()));
        noteCC.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                cc.setText(Double.toString(noteCC.getValue()));
            }
        });

        noteDS.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ds.setText(Double.toString(noteDS.getValue()));
            }
        });

        noteExam.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                exam.setText(Double.toString(noteExam.getValue()));
            }
        });

    }

    @FXML
    private void ajouterNoteAction(ActionEvent event) throws SQLException {

        Note n = new Note(Integer.parseInt(idEtudiant.getText()), Integer.parseInt(idMatiere.getText()),
                Date.valueOf(dateNote.getValue()),
                noteCC.getValue(), noteDS.getValue(), noteExam.getValue(),Integer.parseInt(idEnseignant.getText()));

        ServiceNote ser = new ServiceNote();
        ser.ajouter(n);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ajouter Note");
                alert.setHeaderText("Votre Note est Enregistrée :) ");
                alert.setContentText("veuillez fermer cette fenetre ");
                alert.showAndWait();

    }

    @FXML
    private void retourAction(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
            final Stage stage = (Stage) node.getScene().getWindow();
            final Parent afficherNotes = FXMLLoader.load(getClass().getResource("interfaceEnseignantNote.fxml"));
            final Scene noteScene = new Scene(afficherNotes);

            stage.setScene(noteScene);
    }

}
