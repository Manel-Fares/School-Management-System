/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Service.ServiceNote;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class ModifierNoteController implements Initializable {

    @FXML
    private DatePicker dateNote;
    @FXML
    private TextField idMatiere;
    @FXML
    private TextField idEtudiant;
    @FXML
    private Button modifierNote;
    @FXML
    private Label cc;
    @FXML
    private Label ds;
    @FXML
    private Label exam;
    @FXML
    private Slider noteCC;
    @FXML
    private Slider noteDS;
    @FXML
    private Slider noteExam;

    private Note note;
    @FXML
    private TextField idEnseignant;

    public ModifierNoteController(Note note) {
        this.note = note;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idEtudiant.setText(Integer.toString(note.getIdEtudiant()));
        idMatiere.setText(Integer.toString(note.getIdMatiere()));
        idEnseignant.setText(Integer.toString(note.getIdEnseignant()));
        noteDS.setValue(note.getNoteDS());
        noteCC.setValue(note.getNoteCC());
        noteExam.setValue(note.getNoteExam());
        dateNote.setValue(note.getDateNote().toLocalDate());
        cc.setText(Double.toString(noteCC.getValue()));
        ds.setText(Double.toString(noteDS.getValue()));
        exam.setText(Double.toString(noteExam.getValue()));

        modifierNoteAction();
        //DeleteClassAction();
    }

    @FXML
    private void modifierNoteAction() {
        modifierNote.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Note n = new Note(Integer.parseInt(idEtudiant.getText()), Integer.parseInt(idMatiere.getText()),
                        Date.valueOf(dateNote.getValue()), noteCC.getValue(), noteDS.getValue(), noteExam.getValue(),
                        Integer.parseInt(idEnseignant.getText()));
                
                ServiceNote ser = new ServiceNote();
                try {
                    ser.update(n);
                } catch (SQLException ex) {
                }
            }
        });

    }

}
