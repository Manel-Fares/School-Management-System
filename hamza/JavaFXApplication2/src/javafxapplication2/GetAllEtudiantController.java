/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXComboBox;
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
public class GetAllEtudiantController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<User> TableEtud;
    @FXML
    private TableColumn<User, String> ColNom;
    
    @FXML
    private JFXComboBox<String> ClassC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ColNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        ClassService cs=new ClassService();   
        ClassC.setItems(cs.GetNomClass());
        System.out.println("qsqsqsqsqsqsqs");
        init();
    }   
    
            public void init(){
        ClassC.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {             
                ClassService as=new ClassService();     
                System.out.println(as.GetEtudFromClass(ClassC.getValue()));
                System.out.println("qsqsqs");
                TableEtud.setItems(as.GetEtudFromClass(ClassC.getValue()));
            }
        });
    }
    
}
