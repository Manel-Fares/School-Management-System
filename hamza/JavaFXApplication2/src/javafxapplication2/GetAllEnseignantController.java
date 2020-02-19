/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.AbsenceService;
import service.ClassService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class GetAllEnseignantController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<User> TableEtud;
    @FXML
    private TableColumn<User, String> ColNom;
    @FXML
    private JFXListView<User> ClassC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ColNom.setCellValueFactory(new PropertyValueFactory<>("class"));
        AbsenceService cs=new AbsenceService();  
       ClassC.setItems(cs.GetRole("Enseignant"));
        
        
        init();
    }  
    
                public void init(){
        ClassC.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {             
                ClassService as=new ClassService();  
                AbsenceService cs=new AbsenceService(); 
                User u= ClassC.getSelectionModel().getSelectedItem();
                System.out.println("qsqsqs");
                System.out.println(as.GetEnseiFromClass(u.getId()));
               ObservableList<User> l = FXCollections.observableArrayList();
               l.addAll(as.GetEnseiFromClass(u.getId()));
                TableEtud.setItems(l);

                //TableEtud.setItems(as.GetEnseiFromClass(u.getId()));
            }
        });
    }
    
}
