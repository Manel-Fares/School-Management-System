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
                try {
                    popup(c);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
    }
    
    private void OnUpdateClickAction()  {
     /*  TableViewClass.setOnMouseClicked(new EventHandler() {
           @Override
           public void handle(Event event) {
              try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("Modifier.fxml"));
              Class dataList = TableViewClass.getSelectionModel().getSelectedItem();
           
            Parent root =loader.load(); 
                  ModifierController controller = loader.getController();
                   System.out.println(dataList);
                   System.out.println("ssss"+controller.getData());
                 controller.setData(dataList);
                  TableViewClass.getScene().setRoot(root);
                  
   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       });*/
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
     
     
     private void popup(Class data) throws IOException {                     
         Stage stage = (Stage) AnchorPaneUpdate.getScene().getWindow();         
         final Popup popup = new Popup();
        Button leave = new Button("X"); 
        Button update = new Button("Update"); 
        Button delete = new Button("Delete"); 
         Label label = new Label(); 
        TextField tf1 =new TextField();
        TextField tf2 =new TextField();
        TextArea DescModClass= new TextArea();
       popup.centerOnScreen();
        tf1.setText(data.getName());
        tf2.setText(String.valueOf(data.getNbr_Etudiant()));
         ObservableList<String> optionsNiv = 
    FXCollections.observableArrayList("1","2","3","4","5");
        ObservableList<String> optionsSpec = 
    FXCollections.observableArrayList("A","B","TWIN","DS","BI","GL","INFOB");
        ComboBox<String> ModNivClass =new ComboBox<>();
        ComboBox<String> SpecNivClass=new ComboBox<>();
         ModNivClass.getItems().clear();
        SpecNivClass.getItems().clear();
        ModNivClass.setItems(optionsNiv);
        SpecNivClass.setItems(optionsSpec);
        DescModClass.setText(data.getDescription());
   // popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
       label.setStyle(" -fx-background-color: rgba(53,157,243,0.5);-fx-pref-height:350px;-fx-pref-width:300px;");
       leave.setLayoutX(270);
       leave.setLayoutY(10);
       update.setLayoutX(90);
       update.setLayoutY(270);
       delete.setLayoutX(170);
       delete.setLayoutY(270);
       tf1.setLayoutX(70);
       tf1.setLayoutY(50);
       tf2.setLayoutX(70);
       tf2.setLayoutY(150);
        ModNivClass.setLayoutX(70);
       ModNivClass.setLayoutY(100);
       SpecNivClass.setLayoutX(170);
       SpecNivClass.setLayoutY(100);
       DescModClass.setLayoutX(70);
       DescModClass.setLayoutY(200);
       DescModClass.setStyle("-fx-pref-height:50px;-fx-pref-width:150px;");
       leave.setOnAction((ActionEvent event) -> {
           popup.hide();
        });
       update.setOnAction((ActionEvent event) -> {
           popup.hide();
           String niv=ModNivClass.getValue()+SpecNivClass.getValue();
               Class u =new Class(data.getId(),tf1.getText(),ModNivClass.getValue(),SpecNivClass.getValue(),Integer.parseInt(tf2.getText()),DescModClass.getText());;
        ClassService us =new ClassService();
        us.UpdateClass(u);
           TableViewClass.setItems(us.GetClass()); 
           TableViewClass.refresh();
        });
       delete.setOnAction((ActionEvent event) -> {
           popup.hide();
           us.DeleteClass(data.getId());
        System.out.println("Deleted");
           TableViewClass.setItems(us.GetClass()); 
           TableViewClass.refresh();
        });
       
       popup.getContent().addAll(label,leave,tf1,tf2,update,delete,ModNivClass,SpecNivClass,DescModClass);
   
    TableViewClass.setOnMouseClicked(new EventHandler() {
             @Override
             public void handle(Event event) {
                 popup.show(stage);
             }               
         });
   
  
   
     }
    
}
