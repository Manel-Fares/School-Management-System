/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import weboss.Entities.Enseignant;
import weboss.Entities.Note;
import weboss.Service.ServiceNote;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class AddNoteController implements Initializable {

    @FXML
    private DatePicker dateNote;
    private TextField idMatiere;
    private TextField idEtudiant;
    @FXML
    private Slider noteCC;
    @FXML
    private Slider noteDS;
    @FXML
    private Slider noteExam;
    @FXML
    private Label cc;
    @FXML
    private Label ds;
    @FXML
    private Label exam;

    @FXML
    private Button add;
    @FXML
    private JFXComboBox<String> subjects;
    @FXML
    private JFXComboBox<String> students;
    @FXML
    private JFXComboBox<String> classes;

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

        ServiceNote ser = new ServiceNote();
      //  ObservableList<String> classesList = ser.GetClassesEnseignant("19");
            ObservableList<String> classesList = ser.GetClassesEnseignant(Enseignant.ensg.getIdUser());
        classes.setItems(classesList);
        initList();

    }

    public void initList() {
        classes.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                ServiceNote ser = new ServiceNote();
                ObservableList<String> StudentList = ser.GetEtudFromClass(classes.getValue());
                students.setItems(StudentList);
               // ObservableList<String> subjectList = ser.GetNomMatiere("19", classes.getValue());
                  ObservableList<String> subjectList = ser.GetNomMatiere(Enseignant.ensg.getIdUser(), classes.getValue());
                subjects.setItems(subjectList);
            }
        });
    }

    @FXML
    private void addNoteAction(ActionEvent event) throws SQLException {
        ServiceNote ser = new ServiceNote();
        
        int idN = ser.getIdEtudiant(students.getValue());
        
        int idM = ser.GetIdMatiere(subjects.getValue(), classes.getValue());
        
        Note n = new Note(idN, idM,Date.valueOf(dateNote.getValue()),
                noteCC.getValue(), noteDS.getValue(), noteExam.getValue(), Integer.parseInt(Enseignant.ensg.getIdUser()));
      
        n.setMoyenne(ser.formuleNote(n));
        

        
            
    //Integer.parseInt(Enseignant.ensg.getIdUser());


        ser.ajouter(n);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajouter Note");
        alert.setHeaderText("Votre Note est Enregistrée :) ");
        alert.setContentText("veuillez fermer cette fenetre ");
        alert.showAndWait();

    }
}
