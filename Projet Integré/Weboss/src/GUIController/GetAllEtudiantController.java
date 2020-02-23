/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import weboss.Entities.User;
import weboss.Service.ClassService;


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
    @FXML
    private JFXRadioButton Proffesor;
    @FXML
    private JFXRadioButton Studient;
    @FXML
    private ToggleGroup GroupRole;
    @FXML
    private JFXButton Add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClassService cs=new ClassService();
        ColNom.setCellValueFactory(new PropertyValueFactory<>("nomUser"));
        if (GroupRole.getSelectedToggle().equals(Studient))
                ClassC.setItems(cs.GetNomClass());
        else if(GroupRole.getSelectedToggle().equals(Proffesor))
                ClassC.setItems(cs.GetEns());
        System.out.println("qsqsqsqsqsqsqs");
        init();
    }   
    
            public void init(){
        ClassC.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {  
                ClassService as=new ClassService();  
                System.out.println(as.GetEtudFromClass(ClassC.getValue()));
                if (GroupRole.getSelectedToggle().equals(Studient))
                     TableEtud.setItems(as.GetEtudFromClass(ClassC.getValue()));
                else if (GroupRole.getSelectedToggle().equals(Proffesor))
                     TableEtud.setItems(as.GetEnseiFromClass(ClassC.getValue()));
            }
        });
    }

    private void addToClass() {
            try {
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/GUIInterface/AffecterClass.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(GetAllEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    @FXML
    private void AddAction(ActionEvent event) {
        addToClass();
    }
    
}
