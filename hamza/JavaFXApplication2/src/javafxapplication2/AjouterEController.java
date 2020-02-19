/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

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
    private JFXButton GetEmplois;
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
    private void AddEmploisAction(ActionEvent event) {
         
        Emplois u =new Emplois(Date.valueOf(DateEmplois.getValue()),Time.valueOf(HeureEmplois.getValue()),listview);
        EmploisService us =new EmploisService();
        File file =new File(Path);
        File copyfile = new File("C:\\Users\\Pytrooooo\\Documents\\NetBeansProjects\\JavaFXApplication2\\src\\PDFimport\\"+listview);
        BufferedReader reader;
        PrintWriter writer;
        String line; 
        try{
            if(copyfile.createNewFile() || !copyfile.createNewFile()) {
                reader= new BufferedReader(new FileReader(file));
                writer = new PrintWriter(new FileWriter(copyfile));
                while((line=reader.readLine())!=null){
                    writer.println(line);
                }
                reader.close();
                writer.close();
            }
        }catch(IOException e) {
            System.out.println("error");
        }
        us.AddEmplois(u);
        System.out.println("Done");
    }  


  

    @FXML
    private void UploadFile(ActionEvent event) {
        
    FileChooser fc = new FileChooser();
    fc.getExtensionFilters().addAll(
            new ExtensionFilter("PDF Files","*.PDF"),
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
   
    

    @FXML
    private void GetEmploisAction(ActionEvent event) throws IOException  {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("AfficherE.fxml"));
        PaneAdd.getChildren().setAll(pane);
    }
    
}
    
    
