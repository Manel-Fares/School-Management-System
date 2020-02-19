/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.AbsenceService;
import service.ClassService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AffecterClassController implements Initializable {

    @FXML
    private TableView<User> tableUser;
    @FXML
    private TableColumn<User, String> NomCol;
    @FXML
    private JFXComboBox<String> SelectRole;
    @FXML
    private JFXComboBox<String> SelectClass;
    @FXML
    private Label RoleLabel;
    @FXML
    private JFXButton Add;
    @FXML
    private JFXButton Get;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
               ClassService cs=new ClassService();
              ObservableList<String> optionsRole = 
    FXCollections.observableArrayList("Etudiant","Enseignant");
       SelectClass.setItems(cs.GetNomClass());
       SelectRole.getItems().clear();
       SelectRole.setItems(optionsRole);
       init();
       getall();
        
    }  
    
             private void ShowInfo() {
       
            // Open add event view
            try {
               User u= tableUser.getSelectionModel().getSelectedItem();
               // Load root layout from fxml file.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("AbsenceShowUser.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage(StageStyle.UNDECORATED);
               stage.initModality(Modality.APPLICATION_MODAL); 
               AbsenceService as=new AbsenceService();
               int a=as.GetNbrAbsence(u.getId());
               // Pass main controller reference to view
               AbsenceShowUserController abController = loader.getController();
               abController.setSecondeController(this);
               abController.setData(u.getRole(),u.getNom(),u.getPrenom(),String.valueOf(a));
               // Show the scene containing the root layout.
               Scene scene = new Scene(rootLayout);
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(CalendarEventController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    
        public void getall(){
      
        tableUser.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println(  tableUser.getSelectionModel().getSelectedItem());
                ShowInfo();
            }
        });
    }
        public void init(){
        SelectRole.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                RoleLabel.setText(SelectRole.getValue());
                AbsenceService as=new AbsenceService();       
                tableUser.setItems(as.GetRole(SelectRole.getValue()));
            }
        });
    }

    @FXML
    private void AddAction(ActionEvent event) {
        User u= tableUser.getSelectionModel().getSelectedItem();
        ClassService cs=new ClassService();
        if(SelectRole.getValue().equals("Etudiant"))
        {
        cs.AffecteClass(u.getId(), SelectClass.getValue());
        }
        else if(SelectRole.getValue().equals("Enseignant"))
        {
        cs.AffecteEnseigantClass(u.getId(),SelectClass.getValue());
        }
       
    }

    @FXML
    private void GetAction(ActionEvent event) throws IOException {
         
         if(SelectRole.getValue().equals("Etudiant"))
        {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GetAllEtudiant.fxml"));
        rootPane.getChildren().setAll(pane);
        }
        else if(SelectRole.getValue().equals("Enseignant"))
        {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GetAllEnseigant.fxml"));
        rootPane.getChildren().setAll(pane);
        }
    }
    
}
