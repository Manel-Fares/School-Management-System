/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import weboss.Entities.CalendarAnnuel;
import weboss.Service.CalendarAnnuelService;


/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class UpdateDeleteCalendarController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private HBox header;
    @FXML
    private Label topLabel;
    @FXML
    private JFXButton Cancel;
    @FXML
    private JFXTextField subject;
    @FXML
    private JFXComboBox<String> termSelect;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXButton UpdateButton;
    @FXML
    private JFXButton DeleteButton;
    @FXML
    private Label label;
    CalendarEventController cal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        label.setVisible(false);
                        ObservableList<String> optionsSpec = 
    FXCollections.observableArrayList("Holdiays","Exams","DS","Results","PI");
                termSelect.setItems(optionsSpec);
    }    

    @FXML
    private void CancelAction(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }



    @FXML
    private void UpdateAction(ActionEvent event) throws IOException {
        CalendarAnnuelService cas= new CalendarAnnuelService();
        CalendarAnnuel ca= new CalendarAnnuel(Integer.valueOf(label.getText()), subject.getText(), termSelect.getValue(), Date.valueOf(date.getValue()));
        cas.UpdateCalendar(ca);
        /*FXMLLoader loaders = new FXMLLoader();
        loaders.setLocation(getClass().getResource("CalendarEvent.fxml"));
        CalendarEventController eventController = loaders.getController();
        eventController.loadCalendarLabels();*/
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }



    @FXML
    private void DeleteAction(ActionEvent event) {
        CalendarAnnuelService cas= new CalendarAnnuelService();
        cas.DeleteCalendar(Integer.valueOf(label.getText()));
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    void setMainController(CalendarEventController aThis) {
        cal=aThis;
    }

    void setData(String id, String subject, String term,LocalDate date_ow) {
        this.label.setText(id);
        this.subject.setText(subject);
        this.termSelect.setValue(term);
        this.date.setValue(date_ow);
    }

    @FXML
    private void exit(MouseEvent event) {
    }

    @FXML
    private void save(MouseEvent event) {
    }

    @FXML
    private void cancel(MouseEvent event) {
    }


    
}
