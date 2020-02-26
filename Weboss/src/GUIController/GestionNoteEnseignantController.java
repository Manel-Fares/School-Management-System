/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import weboss.Entities.Enseignant;
import weboss.Entities.Note;
import weboss.Entities.User;
import weboss.Service.ServiceNote;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class GestionNoteEnseignantController implements Initializable {

    @FXML
    private Pane pane;
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
    private JFXButton valider;
    @FXML
    private TableView<Note> tableViewNotes;
    @FXML
    private TableColumn<Note, String> info;
    @FXML
    private TableColumn<Note, String> noteCC;
    @FXML
    private TableColumn<Note, String> noteDS;
    @FXML
    private TableColumn<Note, String> noteExam;
    @FXML
    private TableColumn<Note, String> moyenne;
    @FXML
    private JFXComboBox<String> subjects;
    @FXML
    private JFXComboBox<String> classes;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
    private TableView<User> etudiants;
    @FXML
    private JFXButton add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        info.setCellValueFactory(new PropertyValueFactory<>("info"));
        noteCC.setCellValueFactory(new PropertyValueFactory<>("noteCC"));
        noteDS.setCellValueFactory(new PropertyValueFactory<>("noteDS"));
        noteExam.setCellValueFactory(new PropertyValueFactory<>("noteExam"));
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        pane.setVisible(false);
        ServiceNote ser = new ServiceNote();
          ObservableList<String> classesList = ser.GetClassesEnseignant(Enseignant.ensg.getIdUser());
       // ObservableList<String> classesList = ser.GetClassesEnseignant("19");
        System.out.println(classesList);
        classes.setItems(classesList);
        initList();

    }

    @FXML
    private void validerAction(ActionEvent event) {

        valider.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                Note note = (Note) tableViewNotes.getSelectionModel().getSelectedItem();
                note.setNoteCC(noteCC1.getValue());
                note.setNoteDS(noteDS1.getValue());
                note.setNoteExam(noteExam1.getValue());

                ServiceNote ser = new ServiceNote();
                note.setMoyenne(ser.formuleNote(note));
                System.out.println(note.getMoyenne());
                try {
                    ser.update(note);
                    pane.setVisible(false);

                } catch (SQLException ex) {
                }
                reload();
            }
        });

    }

    @FXML
    private void modifierAction(ActionEvent event) {

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
    private void supprimerAction(ActionEvent event) {

        int selectedIndex = tableViewNotes.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            Note n = (Note) tableViewNotes.getSelectionModel().getSelectedItem();
//            System.out.println("ID : " + n.getEtudiant().getId());

            ServiceNote sn = new ServiceNote();
            try {
                sn.delete(n);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Supprimer Note");
                alert.setHeaderText("Une Note a été supprimer :) ");
                alert.setContentText("veuillez fermer cette fenetre ");
                alert.showAndWait();
            } catch (SQLException ex) {
            }
            reload();

        }

    }

    public void initList() {
        classes.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                ServiceNote ser = new ServiceNote();
                ObservableList<String> subjectList = ser.GetNomMatiere(Enseignant.ensg.getIdUser(), classes.getValue());
                subjects.setItems(subjectList);
                afficher();
            }
        });

    }

    public void afficher() {
        subjects.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                ServiceNote ser = new ServiceNote();
                String nomClasse = classes.getValue();
                int idMat = ser.GetIdMatiere(subjects.getValue(), nomClasse);
                tableViewNotes.setItems(ser.getNotesEnseignant1(nomClasse, idMat, Integer.parseInt(Enseignant.ensg.getIdUser())));

            }
        });

    }

    public void reload() {
        ServiceNote ser = new ServiceNote();
        String nomClasse = classes.getValue();
        int idMat = ser.GetIdMatiere(subjects.getValue(), nomClasse);
        tableViewNotes.setItems(ser.getNotesEnseignant1(nomClasse, idMat, Integer.parseInt(Enseignant.ensg.getIdUser())));
        tableViewNotes.refresh();

    }

    @FXML
    private void addAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GUIInterface/AddNote.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
