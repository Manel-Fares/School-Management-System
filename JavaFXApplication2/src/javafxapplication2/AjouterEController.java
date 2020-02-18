/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import entity.Emplois;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import service.ClassService;
import service.EmploisService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AjouterEController implements Initializable {

    @FXML
    private DatePicker DateEmplois;
    @FXML
    private TextField HeureEmplois;
    @FXML
    private TextField SourceEmplois;
    @FXML
    private Button AddEmplois;
    @FXML
    private Button GetEmplois;
    @FXML
    private AnchorPane PaneAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddEmploisAction(ActionEvent event) {
         
        Emplois u =new Emplois(Date.valueOf(DateEmplois.getValue()),HeureEmplois.getText(),SourceEmplois.getText());
        EmploisService us =new EmploisService();
       us.AddEmplois(u);
        System.out.println("Done");
    }

    @FXML
    private void GetEmploisAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("AfficherE.fxml"));
        PaneAdd.getChildren().setAll(pane);
    }
    
    
    
}
