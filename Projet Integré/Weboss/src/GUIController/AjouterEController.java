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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    

    @FXML
    private void AddEmploisAction(ActionEvent event) throws IOException {
         
        Emplois u =new Emplois(Date.valueOf(DateEmplois.getValue()),Time.valueOf(HeureEmplois.getValue()),listview);
        EmploisService us =new EmploisService();
        String PathTo= "C:\\wamp64\\www\\PDFimport\\"; 
        //Paths.get("").toAbsolutePath().toString();
        Files.copy(Paths.get(Path), Paths.get(PathTo), StandardCopyOption.REPLACE_EXISTING);
        us.AddEmplois(u);
        System.out.println("Done");
    }  


  

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
    
    
