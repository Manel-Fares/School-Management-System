/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import weboss.Entities.Absence;
import weboss.Entities.Matiere;
import weboss.Entities.*;
import weboss.Service.AbsenceService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AbsenceEtudiantController implements Initializable {

    @FXML
    private TableView<Absence> TableMatiere;
    @FXML
    private TableColumn<Absence, Matiere> MatiereCol;
    @FXML
    private TableColumn<Absence, String> DateCol;
    @FXML
    private TableColumn<Absence, String> TimeDebCol;
    @FXML
    private TableColumn<Absence, String> TimeFinCol;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        MatiereCol.setCellValueFactory(new PropertyValueFactory<>("matiere"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TimeDebCol.setCellValueFactory(new PropertyValueFactory<>("timeDeb"));
        TimeFinCol.setCellValueFactory(new PropertyValueFactory<>("timeFin"));
        AbsenceService as=new AbsenceService();
        label.setText("Total Number : "+as.GetOnlineNbrAbsence(Etudiant.etd.getIdUser()));
        TableMatiere.setItems(as.OnlineAbsence(Etudiant.etd.getIdUser())); 
    }    
    
}
