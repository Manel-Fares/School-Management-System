/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import entity.Emplois;
import java.net.URL;
import java.sql.*;
//import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import service.ClassService;
import service.EmploisService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class ModifierEController implements Initializable {

   
    @FXML
    private TextField Heure;
    @FXML
    private TextField Source;
    @FXML
    private Button Delete;
    @FXML
    private Button Update;

    private Emplois emplois;
    @FXML
    private DatePicker DateE;
    /**
     * Initializes the controller class.
     */
    
    
    public ModifierEController(Emplois emplois) {
    this.emplois=emplois;    
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DateE.setValue(emplois.getDate().toLocalDate());
        Heure.setText(emplois.getHeure());
        Source.setText(emplois.getSource());
        UpdateClassAction();
        DeleteClassAction();
    }  
    
     public void UpdateClassAction() {
       Update.setOnAction(new EventHandler() {
           @Override
           public void handle(Event event) {             
               Emplois u =new Emplois(emplois.getIdEmplois(),Date.valueOf(DateE.getValue()),Heure.getText(),Source.getText());
        EmploisService us =new EmploisService();
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
        System.out.println(emplois.getIdEmplois());
        us.DeleteClass(emplois.getIdEmplois());
        System.out.println("Deleted");
           }
       });
    }

    
}
