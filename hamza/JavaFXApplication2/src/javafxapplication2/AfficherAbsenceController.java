/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXTextField;
import entity.Absence;
import entity.Matiere;
import entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.AbsenceService;
import service.EmploisService;

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
    
}
