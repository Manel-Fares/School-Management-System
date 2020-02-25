/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import service.ClassService;
import service.EmploisService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class ModifierEController implements Initializable {

   
    @FXML
    private JFXTimePicker Heure;
    @FXML
    private JFXButton Source;
    @FXML
    private JFXButton Delete;
    @FXML
    private JFXButton Update;

    
    @FXML
    private JFXDatePicker DateE;
    String Path,listview;
    AfficherEController aff;
    @FXML
    private Label label;
    /**
     * Initializes the controller class.
     */
    
       

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        label.setVisible(false);
        UploadFile();
        UpdateClassAction();
        DeleteClassAction();
    }  
    
     public void UpdateClassAction() {
       Update.setOnAction(new EventHandler() {
           @Override
           public void handle(Event event) {             
               Emplois u =new Emplois(Integer.valueOf(label.getText()),Date.valueOf(DateE.getValue()),Time.valueOf(Heure.getValue()),listview);
        EmploisService us =new EmploisService();
      //  String PathTo= "C:\\Users\\Pytrooooo\\Documents\\NetBeansProjects\\JavaFXApplication2\\src\\PDFimport\\"; 
               //Paths.get("").toAbsolutePath().toString();
                try {
        String PathTo= "C:\\Users\\Pytrooooo\\Documents\\NetBeansProjects\\JavaFXApplication2\\src\\PDFimport\\"+listview; 
        //Paths.get("").toAbsolutePath().toString();
        File org=new File(Path);
        File news=new File(PathTo);
        Files.copy(org.toPath(), news.toPath(), StandardCopyOption.REPLACE_EXISTING);
               } catch (IOException ex) {
                   Logger.getLogger(ModifierEController.class.getName()).log(Level.SEVERE, null, ex);
               }
                us.UpdateEmplois(u);
               System.out.println("updated");
           }
       });
    }
    
     public void DeleteClassAction() {
       Delete.setOnAction(new EventHandler() {
           @Override
           public void handle(Event event) {
               EmploisService us =new EmploisService();
        System.out.println(Integer.valueOf(label.getText()));
        us.DeleteEmplois(Integer.valueOf(label.getText()));
        System.out.println("Deleted");
           }
       });
    }

   
     
    private void UploadFile() {
        Source.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                           FileChooser fc = new FileChooser();
    fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files","*.txt"),
            new FileChooser.ExtensionFilter("PDF Files","*.PDF"),
            new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
            new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
            new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
            new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
            new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html"),
            new FileChooser.ExtensionFilter("Ennour File (*.Ennour)", "*.Ennour")
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
        });

    }

    void setMainController(AfficherEController aThis) {
        aff=aThis;
    }

    void setData(String label,LocalDate aa,LocalTime bb,String pathh) {
        this.label.setText(label);
        this.DateE.setValue(aa);
        this.Heure.setValue(bb);
        this.Source.setText(pathh);
        this.listview=pathh;
        
    }

    
}
