/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IdClassCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameClassCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NiveauClassCol.setCellValueFactory(new PropertyValueFactory<>("Niveau"));
        NbrEtudiantClassCol.setCellValueFactory(new PropertyValueFactory<>("Nbr_Etudiant"));
        DescriptionClassCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ClassService us =new ClassService();
        TableViewClass.setItems(us.GetClass()); 
       // TableViewClass.onMouseClickedProperty()
       
       OnUpdateClickAction();
       Recherche();
               
        
    }    


    
    private void OnUpdateClickAction()  {
       TableViewClass.setOnMouseClicked(new EventHandler() {
           @Override
           public void handle(Event event) {
              try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("Modifier.fxml"));
              // Class dataList =  TableViewClass.getSelectionModel().getSelectedItem();
            // Create the new controller and pass the currently selected data item to it
                  ModifierController controller = new ModifierController(TableViewClass.getSelectionModel().getSelectedItem());
                  
            // Set the controller to the loader
            loader.setController(controller);
            

            Stage editorStage = new Stage();
            editorStage.setTitle("Edit Item");

            // Centers the editor window over the current window
            editorStage.initOwner(TableViewClass.getScene().getWindow());

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

    @FXML
    private void ReloadAction(ActionEvent event) {
        ClassService us =new ClassService();
        TableViewClass.setItems(us.GetClass()); 
        TableViewClass.refresh();
        
    }

 
     private void Recherche() {
         
         Recherche.textProperty().addListener((observable, oldValue, newValue) -> {
            ClassService us =new ClassService();
        TableViewClass.setItems(us.SearchClass(newValue)); 
        TableViewClass.refresh();
    
});
    }
    
}
