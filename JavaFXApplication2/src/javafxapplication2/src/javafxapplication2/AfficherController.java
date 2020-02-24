/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.sun.javaws.Main;
import javafx.scene.chart.PieChart.Data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entity.Class;
import java.io.IOException;
import static java.lang.Math.E;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import service.ClassService;
import javafxapplication2.ModifierController;

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
               loader.setLocation(getClass().getResource("Ajouter.fxml"));
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
               loaderr.setLocation(getClass().getResource("Modifier.fxml"));
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
