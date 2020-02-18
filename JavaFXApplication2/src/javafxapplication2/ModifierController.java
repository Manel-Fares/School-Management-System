/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import entity.Class;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import entity.Class;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import service.ClassService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField ModNameClass;
    @FXML
    private TextField SnModClass;
    @FXML
    private Button BtnModClass;
    @FXML
    private ComboBox<String> ModNivClass;
    @FXML
    private ComboBox<String> SpecNivClass;
    @FXML
    private TextArea DescModClass;
    
    private Class data;
    @FXML
    private Button BtnDelClass;

    ModifierController(Class data) {
        this.data=data;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        ModNameClass.setText(data.getName());
        SnModClass.setText(String.valueOf(data.getNbr_Etudiant()));
         ObservableList<String> optionsNiv = 
    FXCollections.observableArrayList("1","2","3","4","5");
        ObservableList<String> optionsSpec = 
    FXCollections.observableArrayList("A","B","TWIN","DS","BI","GL","INFOB");
        ModNivClass.getItems().clear();
        SpecNivClass.getItems().clear();
        ModNivClass.setItems(optionsNiv);
        SpecNivClass.setItems(optionsSpec);
        DescModClass.setText(data.getDescription());
        UpdateClassAction();
        DeleteClassAction();
        
        
    }    

    
    public void UpdateClassAction() {
       BtnModClass.setOnAction(new EventHandler() {
           @Override
           public void handle(Event event) {
               String niv=ModNivClass.getValue()+SpecNivClass.getValue();
               Class u =new Class(data.getId(),ModNameClass.getText(),niv,Integer.parseInt(SnModClass.getText()),DescModClass.getText());;
        ClassService us =new ClassService();
        us.UpdateClass(u);
               System.out.println("updated");
           }
       });
    }
    
     public void DeleteClassAction() {
       BtnDelClass.setOnAction(new EventHandler() {
           @Override
           public void handle(Event event) {
               ClassService us =new ClassService();
        System.out.println(data.getId());
        us.DeleteClass(data.getId());
        System.out.println("Deleted");
           }
       });
    }

   
    
}
