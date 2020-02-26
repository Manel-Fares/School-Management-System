/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
public class AddEventController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private HBox header;
    @FXML
    private Label topLabel;
    @FXML
    private JFXTextField subject;
    @FXML
    private JFXComboBox<String> termSelect;
    @FXML
    private JFXDatePicker date;
    CalendarEventController mainController;
    String getDay,GetMonth,GetYear;
    boolean back=false;

 public void afficherAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public boolean testSaisie() {
        
       // System.out.println("compare="+dateDebut.getValue().compareTo(dateFin.getValue()));

        if (
                //NameClass.getText().trim().isEmpty() || NbrEtudClass.getText().trim().isEmpty()
               // || DescriptionClass.getText().trim().isEmpty()
                /*||*/ subject.getText().trim().isEmpty()
                || termSelect.getValue() == null
                || date.getValue() == null
              //  || TimeDebut.getValue() == null
               // || TimeFin.getValue() == null
                
                //|| imageFileLabel.getText().trim().isEmpty()
                ) {
            afficherAlert("Tous les champs doivent être remplis");
            return false;
        }
       /* Instant instant = Instant.from(dateDebut.getValue().atStartOfDay(ZoneId.systemDefault()));
        Date dateD = Date.from(instant);
        Date cuurentDate = new Date();
        if (dateD.compareTo(cuurentDate) < 0) {

            afficherAlert("Date debut doit être supérieur à la date d'aujoud'hui");
            return false;
        }
        
        if (dateDebut.getValue().compareTo(dateFin.getValue()) > 0) {
            afficherAlert("Date fin doit être supérieur ou égal à la date de debut");
            return false;
        }*/
        //if (dateDebut.getValue().compareTo(dateFin.getValue()) == 0) {
            
        /*    if (TimeDebut.getValue().compareTo(TimeFin.getValue()) > 0) {
                afficherAlert("Heure fin doit être supérieur à l'heure de début");
                return false;
            }
            if (ListEtuEns.getSelectionModel().getSelectedItem()==null) {
                afficherAlert("vous devez selectionner user");
                return false;
            }*/
       /* }*/
      /*  try {
            Double num = Double.parseDouble(NbrEtudClass.getText());
        } catch (NumberFormatException e) {
            afficherAlert("Champs Nombre invalide");
            return false;
        }*/
        return true;
    }
    
    public void setData(String day,String month,String year) {
        date.setValue(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
    }
        public String GetDate() { 
         return String.valueOf(this.date.getValue());
    }
        public String GetSubject() { 
         return this.subject.getText();
    }
        public String GetTerm() { 
         return this.termSelect.getValue();
    }
        public boolean GetBack() { 
         return this.back;
    }

    public void setGetDay(String getDay) {
        this.getDay = getDay;
    }
    

    
     public void setMainController(CalendarEventController mainController) {
        this.mainController = mainController ;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        back=false;
                ObservableList<String> optionsSpec = 
    FXCollections.observableArrayList("Holdiays","Exams","DS","Results","PI");
                termSelect.setItems(optionsSpec);
        
    }    

    @FXML
    private void exit(MouseEvent event) {
    }

    @FXML
    private void save(MouseEvent event)  {
        if(testSaisie()){
         DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
         String calendarDate = date.getValue().format(myFormat);
         CalendarAnnuel ca=new CalendarAnnuel(subject.getText(), termSelect.getValue(), Date.valueOf(calendarDate));
         CalendarAnnuelService cas=new CalendarAnnuelService();
         cas.AddCalendar(ca);
         mainController.repaintView(); 
         this.back=true;
        // Close the window
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
        }
        
    }

    @FXML
    private void cancel(MouseEvent event) {
         Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }


    
}
