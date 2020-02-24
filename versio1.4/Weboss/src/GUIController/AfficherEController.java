/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import weboss.Entities.Emplois;
import weboss.Service.EmploisService;


/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AfficherEController implements Initializable {

    @FXML
    private TableView<Emplois> TableViewEmplois;
    @FXML
    private TableColumn<Emplois, String> IdEmploisCol;
    @FXML
    private TableColumn<Emplois, String> DateEmploisCol;
    @FXML
    private TableColumn<Emplois, String> HeureEmploisCol;
    @FXML
    private TableColumn<Emplois, String> SourceEmploisCol;
    @FXML
    private Button Reload;
    @FXML
    private AnchorPane PaneGet;
    @FXML
    private TextField Recherche;
    @FXML
    private JFXButton Add;
    int nbr=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IdEmploisCol.setCellValueFactory(new PropertyValueFactory<>("IdEmplois"));
        DateEmploisCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
        HeureEmploisCol.setCellValueFactory(new PropertyValueFactory<>("Heure"));
        SourceEmploisCol.setCellValueFactory(new PropertyValueFactory<>("Source"));
        EmploisService us =new EmploisService();
        TableViewEmplois.setItems(us.GetEmplois()); 
        Recherche();
        Run();
    }    
    @FXML
    private void ReloadAction(ActionEvent event) {
        EmploisService us =new EmploisService();
        TableViewEmplois.setItems(us.GetEmplois()); 
        TableViewEmplois.refresh();
    }
    
    private void Run() {
        TableViewEmplois.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Emplois c=TableViewEmplois.getSelectionModel().getSelectedItem();
                if(nbr==2)
                    UpdateDeleteClass(c);
                else if(nbr>=2)
                    nbr=0;
                nbr++;              
            }
        });
        
    }
 private void Recherche() {
        Recherche.textProperty().addListener((observable, oldValue, newValue) -> {
        EmploisService us =new EmploisService();
        TableViewEmplois.setItems(us.SearchEmplois(newValue)); 
        TableViewEmplois.refresh();    
});
    }

    @FXML
    private void SendAction(ActionEvent event) throws IOException {
             try {
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/GUIInterface/SendEmplois.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherEController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }


    @FXML
    private void AddAction(ActionEvent event) {
            addEmplois();
    }
    
    private void addEmplois() {
        try {
             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("/GUIInterface/AjouterE.fxml"));
             AnchorPane rootLayout = (AnchorPane) loader.load();
             Stage stageqq = new Stage();
             stageqq.initModality(Modality.APPLICATION_MODAL); 
             Scene scene = new Scene(rootLayout);               
             stageqq.setScene(scene);
             stageqq.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherEController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
                 
            private void UpdateDeleteClass(Emplois c) {
            try {
               FXMLLoader loaderrrr = new FXMLLoader();
               loaderrrr.setLocation(getClass().getResource("/GUIInterface/ModifierE.fxml"));
               AnchorPane rootLayout = (AnchorPane) loaderrrr.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               ModifierEController eventController = loaderrrr.getController();
               eventController.setMainController(this);
               eventController.setData(String.valueOf(c.getIdEmplois()),c.getDate().toLocalDate(),c.getHeure().toLocalTime(),c.getSource()); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherEController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
     
}
