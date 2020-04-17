/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.nio.file.Paths;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import weboss.Entities.Emplois;
import weboss.Service.EmploisService;


/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AjouterEController implements Initializable {

    @FXML
    private JFXDatePicker DateEmplois;
    @FXML
    private JFXTimePicker HeureEmplois;
    @FXML
    private JFXButton SourceEmplois;
    @FXML
    private JFXButton AddEmplois;
    @FXML
    private AnchorPane PaneAdd;
    
    private String  listview,Path;
    @FXML
    private Label error_cin;

    
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
               // NameClass.getText().trim().isEmpty() || NbrEtudClass.getText().trim().isEmpty()
               // || DescriptionClass.getText().trim().isEmpty()
                //|| adresse.getText().trim().isEmpty()
               /* ||*/ DateEmplois.getValue() == null
                || HeureEmplois.getValue() == null
                || listview.equals("")
                || Path.equals("")
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
        }
        if (dateDebut.getValue().compareTo(dateFin.getValue()) == 0) {
            if (heureDebut.getValue().compareTo(heureFin.getValue()) > 0) {
                afficherAlert("Heure fin doit être supérieur à l'heure de début");
                return false;
            }
        }*/
      /*  try {
            Double num = Double.parseDouble(NbrEtudClass.getText());
        } catch (NumberFormatException e) {
            afficherAlert("Champs Nombre invalide");
            return false;
        }*/
        return true;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    

    @FXML
    private void AddEmploisAction(ActionEvent event) throws IOException {
         
        if( testSaisie())
        {
       Emplois u =new Emplois(Date.valueOf(DateEmplois.getValue()),Time.valueOf(HeureEmplois.getValue()),listview);
        EmploisService us =new EmploisService();
        String PathTo= "C:\\Users\\Pytrooooo\\Documents\\NetBeansProjects\\JavaFXApplication2\\src\\PDFimport\\"+listview; 
        //Paths.get("").toAbsolutePath().toString();
        File org=new File(Path);
        File news=new File(PathTo);
        Files.copy(org.toPath(), news.toPath(), StandardCopyOption.REPLACE_EXISTING);
        us.AddEmplois(u);
        System.out.println("Done");
    }  }


  

    private void UploadFile(ActionEvent event) {
        
      FileChooser fc = new FileChooser();
    fc.getExtensionFilters().addAll(
            new ExtensionFilter("PDF Files","*.PDF"),
            new ExtensionFilter("TXT Files","*.txt"),
            new ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
            new ExtensionFilter("XLS files (*.xls)", "*.xls"),
            new ExtensionFilter("ODS files (*.ods)", "*.ods"),
            new ExtensionFilter("CSV files (*.csv)", "*.csv"),
            new ExtensionFilter("HTML files (*.html)", "*.html"),
            new ExtensionFilter("Ennour File (*.Ennour)", "*.Ennour")
    );
    File selectedFiles = fc.showOpenDialog(null);
    if (selectedFiles !=null){
        
        listview=selectedFiles.getName();
        Path=selectedFiles.getAbsolutePath();
            System.out.println(listview);
            
        }else{
        System.out.println("file is not valid");
    }
}

    
}
    
    
