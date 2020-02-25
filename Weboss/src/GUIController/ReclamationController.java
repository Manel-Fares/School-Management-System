/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;


import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import weboss.Entities.Etudiant;
import weboss.Entities.Reclamation;
import weboss.Entities.User;
import weboss.Service.ReclamationService;


/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField subj;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private TextArea desc;
    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, String> description;
    @FXML
    private TableColumn<Reclamation, Date> date;
    @FXML
    private TableColumn<Reclamation, String> etat;
    public ObservableList<Reclamation> list = FXCollections.observableArrayList();

                  ReclamationService ser = new ReclamationService();
               
               Reclamation r = new Reclamation();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

             
        try {
            list.addAll(ser.readAllParEtudiant(Etudiant.etd));
        } catch (SQLException ex) {
            System.out.println("error tab reclamation");
        }
        
            
            sujet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("sujetReclamation"));
            description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("descriptionReclamation"));
            etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("statutReclamation"));
            date.setCellValueFactory(new PropertyValueFactory<Reclamation, Date>("dateCreation"));
            table.setItems(list);
       
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d =new Date(System.currentTimeMillis());
        
       
         
    
         Reclamation rec = new Reclamation(subj.getText(),desc.getText(), "Non Traité", d, Etudiant.etd);
        try {
            ser.ajouter(rec);
                Alert info = new Alert(Alert.AlertType.INFORMATION);
             info.setTitle("Add");
             info.setContentText(" Done");
             info.show();
               loadData();
                clearData();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void delete(ActionEvent event) {
      
        Reclamation r =table.getSelectionModel().getSelectedItem();
        try {
            if(ser.delete(r)){
                 Alert info = new Alert(Alert.AlertType.INFORMATION);
             info.setTitle("Delete");
             info.setContentText("Delete Done");
             info.show();
            loadData();
            clearData();
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadData(){
        
        list.clear();
        try {
            list.addAll(ser.readAllParEtudiant(Etudiant.etd));
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems(list);
        
    }
    public void clearData(){
        subj.clear();
        desc.clear();
    }

    
}
