/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import entity.Emplois;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import service.ClassService;
import service.EmploisService;

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
        String PathTo= "C:\\Users\\Pytrooooo\\Documents\\NetBeansProjects\\JavaFXApplication2\\src\\PDFimport\\"+listview; 
        //Paths.get("").toAbsolutePath().toString();
        File org=new File(Path);
        File news=new File(PathTo);
        Files.copy(org.toPath(), news.toPath(), StandardCopyOption.REPLACE_EXISTING);
        us.AddEmplois(u);
        System.out.println("Done");
    }  


  

    @FXML
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
    
    
