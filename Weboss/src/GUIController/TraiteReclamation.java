/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import weboss.Entities.Reclamation;
import weboss.Service.ReclamationService;


/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class TraiteReclamation implements Initializable {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Date d = new Date(2020,12,12);
   @FXML private  TableView<Reclamation> table;
   @FXML private  TableColumn<Reclamation,String> id;
    @FXML private  TableColumn<Reclamation,String> nom;
    @FXML private  TableColumn<Reclamation,String> desc;
    @FXML private  TableColumn<Reclamation,String> etat;
    @FXML private  TableColumn<Reclamation,Date> date;

    public ObservableList<Reclamation> list = FXCollections.observableArrayList();
    @FXML
    private JFXTextField search;
    
    @FXML
    public void afficher(){
       
   
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ReclamationService ser = new ReclamationService();
        try {
            list.addAll(ser.readAll());
            System.out.println(list);
        } catch (SQLException ex) {
            Logger.getLogger(TraiteReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            id.setCellValueFactory(new PropertyValueFactory<Reclamation , String>("nomUser"));
            nom.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("sujetReclamation"));
            desc.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("descriptionReclamation"));
            etat.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("statutReclamation"));
            date.setCellValueFactory(new PropertyValueFactory<Reclamation, Date>("dateCreation"));
            table.setItems(list);
        // TODO
    }    


    @FXML
    private void valid(MouseEvent event) {
        try {
            ReclamationService ser = new ReclamationService();
            Reclamation rec = table.getSelectionModel().getSelectedItem();
            
            ser.updateEtat(rec,"traite");
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(TraiteReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
         

         
    }
      public void loadData(){
         ReclamationService ser = new ReclamationService();
        list.clear();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
            ex.getMessage();
        }
        table.setItems(list);
        
    }
    
    
}
