/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import entity.Emplois;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.ClassService;
import service.EmploisService;

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
        OnUpdateClickAction();
        Recherche();
    }    

    @FXML
    private void ReloadAction(ActionEvent event) {
        EmploisService us =new EmploisService();
        TableViewEmplois.setItems(us.GetEmplois()); 
        TableViewEmplois.refresh();
    }
    
     private void OnUpdateClickAction()  {
       TableViewEmplois.setOnMouseClicked(new EventHandler() {
           @Override
           public void handle(Event event) {
              try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("ModifierE.fxml"));
              // Class dataList =  TableViewClass.getSelectionModel().getSelectedItem();
            // Create the new controller and pass the currently selected data item to it
                  ModifierEController controller = new ModifierEController(TableViewEmplois.getSelectionModel().getSelectedItem());
                  
            // Set the controller to the loader
            loader.setController(controller);
            

            Stage editorStage = new Stage();
            editorStage.setTitle("Edit Item");

            // Centers the editor window over the current window
            editorStage.initOwner(TableViewEmplois.getScene().getWindow());

            // Ensures the new window needs to be closed before the current window can be used again
            editorStage.initModality(Modality.APPLICATION_MODAL);

            editorStage.setScene(new Scene(loader.load()));
            editorStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
     
}
