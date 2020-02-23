/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import weboss.Entities.Absence;
import weboss.Entities.Matiere;
import weboss.Entities.User;
import weboss.Service.AbsenceService;


/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AfficherAbsenceController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Absence> TableAbsence;
    @FXML
    private TableColumn<Absence, String> IdCol;
    @FXML
    private TableColumn<Absence, User> NomCol;
    @FXML
    private TableColumn<Absence, Matiere> MatiereCol;
    @FXML
    private TableColumn<Absence, String> DateCol;
    @FXML
    private TableColumn<Absence, String> TimeDebCol;
    @FXML
    private TableColumn<Absence, String> TimeFinCol;
    @FXML
    private JFXTextField SearchInput;
    @FXML
    private JFXButton Add;
    @FXML
    private JFXButton Reload;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        MatiereCol.setCellValueFactory(new PropertyValueFactory<>("matiere"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TimeDebCol.setCellValueFactory(new PropertyValueFactory<>("timeDeb"));
        TimeFinCol.setCellValueFactory(new PropertyValueFactory<>("timeFin"));
        AbsenceService as=new AbsenceService();
        TableAbsence.setItems(as.GetAbsence()); 
        Recherche();
    }   
    
     private void Recherche() {
         
     
        SearchInput.textProperty().addListener((observable, oldValue, newValue) -> {
            AbsenceService us =new AbsenceService();
        TableAbsence.setItems(us.SearchEmplois(newValue)); 
        TableAbsence.refresh();
    
});
    }
     
                  private void addAbsence() {
            try {
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/GUIInterface/Absence.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherAbsenceController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

    @FXML
    private void AddAction(ActionEvent event) {
        addAbsence();
    }

    @FXML
    private void ReloadAction(ActionEvent event) {
        AbsenceService as=new AbsenceService();
        TableAbsence.setItems(as.GetAbsence()); 
        TableAbsence.refresh();
    }
    
}
