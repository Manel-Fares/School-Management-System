/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entity.CalendarAnnuel;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import javafxapplication2.CalendarEventController;
import service.CalendarAnnuelService;

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
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton cancelButton;
    CalendarEventController mainController;
    String getDay,GetMonth,GetYear;
    boolean back=false;

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
/*                            FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("CalendarEvent.fxml"));
               CalendarEventController eventController = loader.getController();
               eventController.setMainController(this);
               String k=String.valueOf(this.date.getValue());
               eventController.getVBox().setStyle("-fx-background-color:rgba(255,0,0,0.7);");
               Label b = new Label(subject.getText());
               Label bb = new Label(termSelect.getValue());
               Label bbb = new Label(k);
               eventController.getVBox().getChildren().add(b); 
               eventController.getVBox().getChildren().add(bb); 
               eventController.getVBox().getChildren().add(bbb); 
               System.out.println("here222");
            */    
        
    }

    @FXML
    private void cancel(MouseEvent event) {
         Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
    
}
