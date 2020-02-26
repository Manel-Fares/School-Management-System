/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import weboss.Entities.Class;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import weboss.Service.ClassService;


/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<Class> TableViewClass;
    @FXML
    private TableColumn<Class,String> IdClassCol;
    @FXML
    private TableColumn<Class,String> NameClassCol;
    @FXML
    private TableColumn<Class,String> NiveauClassCol;
    @FXML
    private TableColumn<Class,String> NbrEtudiantClassCol;
    @FXML
    private TableColumn<Class,String> DescriptionClassCol;
    @FXML
    private AnchorPane AnchorPaneUpdate;
    @FXML
    private Button Reload;
    @FXML
    private TextField Recherche;
    ClassService us =new ClassService();
    @FXML
    private JFXButton Add;
    int nbr=0;
    @FXML
    private Pane affecter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClassService us =new ClassService();
        IdClassCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameClassCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NiveauClassCol.setCellValueFactory(new PropertyValueFactory<>("Niveau"));
        NbrEtudiantClassCol.setCellValueFactory(new PropertyValueFactory<>("Nbr_Etudiant"));
        DescriptionClassCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        
        TableViewClass.setItems(us.GetClass()); 
       // TableViewClass.onMouseClickedProperty()
       
      // OnUpdateClickAction();
       Recherche();   
       Run();
        Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/GetAllEtudiant.fxml"));
            affecter.getChildren().removeAll();
            affecter.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }    

    private void Run() {
        TableViewClass.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Class c=TableViewClass.getSelectionModel().getSelectedItem();
                if(nbr==2)
                    UpdateDeleteClass(c);
                else if(nbr>=2)
                    nbr=0;
                nbr++;              
            }
        });
        
    }

    @FXML
    private void ReloadAction(ActionEvent event) {
        ClassService us =new ClassService();       
        TableViewClass.setItems(us.GetClass()); 
        TableViewClass.refresh();
      
    }

 
     private void Recherche() {        
         Recherche.textProperty().addListener((observable, oldValue, newValue) -> {           
        TableViewClass.setItems(us.SearchClass(newValue)); 
        TableViewClass.refresh();
            
});
    }
     

    @FXML
    private void AddAction(ActionEvent event) {
        addClass();
        
    }
    
    
         private void addClass() {
            try {
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/GUIInterface/Ajouter.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
         
         
    private void UpdateDeleteClass(Class c) {
            try {
               FXMLLoader loaderr = new FXMLLoader();
               loaderr.setLocation(getClass().getResource("/GUIInterface/Modifier.fxml"));
               AnchorPane rootLayout = (AnchorPane) loaderr.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               ModifierController eventController = loaderr.getController();
               eventController.setMainController(this);
               eventController.setData(String.valueOf(c.getId()),c.getName(),c.getNiveau(),c.getSpec(),String.valueOf(c.getNbr_Etudiant()),c.getDescription()); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
      
  
      
     
 
    
}
