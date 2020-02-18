/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import project.entities.User;
import project.service.ParentService;


/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ListParentController implements Initializable {

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, String> id;

    @FXML
    private TableColumn<User, Integer> cin;

    @FXML
    private TableColumn<User, String> nom;

    @FXML
    private TableColumn<User, String> prenom;

    @FXML
    private TableColumn<User, String> email;

    @FXML
    private TableColumn<User, String> adresse;

    @FXML
    private TableColumn<User, Integer> numtel;

    @FXML
    private TableColumn<User, Date> date;

    @FXML
    private TableColumn<User, String> sexe;

    @FXML
    private TableColumn<User, String> mdp;

  

    @FXML
    public ObservableList<User> list = FXCollections.observableArrayList();
    
    @FXML
    public void afficher(){
       
   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                ParentService ser = new ParentService();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
         
        }
        System.out.println(list);
          
            id.setCellValueFactory(new PropertyValueFactory<User, String>("idUser"));
            cin.setCellValueFactory(new PropertyValueFactory<User, Integer>("cinUser"));
            nom.setCellValueFactory(new PropertyValueFactory<User, String>("nomUser"));
              prenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenomUser"));
            date.setCellValueFactory(new PropertyValueFactory<User, Date>("dateNaissanceUser"));
            mdp.setCellValueFactory(new PropertyValueFactory<User, String>("motDePasseUser"));
            numtel.setCellValueFactory(new PropertyValueFactory<User, Integer>("numTelUser"));
            sexe.setCellValueFactory(new PropertyValueFactory<User, String>("sexeUser"));
          
            
            adresse.setCellValueFactory(new PropertyValueFactory<User, String>("adresseUser"));
            email.setCellValueFactory(new PropertyValueFactory<User, String>("emailUser"));
           
        
            table.setItems(list);
            table.setEditable(true);
            nom.setCellFactory(TextFieldTableCell.forTableColumn());
    }  
       @FXML
    void update(TableColumn.CellEditEvent<User,Integer> UserStringCellEditEvent) {
    User u = table.getSelectionModel().getSelectedItem();
    u.setCinUser(UserStringCellEditEvent.getNewValue());
    
        

    }
    
}
