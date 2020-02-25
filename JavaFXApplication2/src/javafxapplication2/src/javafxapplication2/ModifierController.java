/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.*;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ClassService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class ModifierController implements Initializable {

    @FXML
    private JFXTextField ModNameClass;
    @FXML
    private JFXTextField SnModClass;
    @FXML
    private JFXButton BtnModClass;
    @FXML
    private JFXComboBox<String> ModNivClass;
    @FXML
    private JFXComboBox<String> SpecNivClass;
    @FXML
    private JFXTextArea DescModClass;
    
    
    @FXML
    private JFXButton BtnDelClass;
    
    private Class Data;
    @FXML
    private Label label;
    AfficherController aff;
    @FXML
    private AnchorPane rootPane;
   


    
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       label.setVisible(false);
        //ModNameClass.setText(Data.getName());
        //SnModClass.setText(String.valueOf(Data.getNbr_Etudiant()));
         ObservableList<String> optionsNiv = 
    FXCollections.observableArrayList("1","2","3","4","5");
        ObservableList<String> optionsSpec = 
    FXCollections.observableArrayList("A","B","TWIN","DS","BI","GL","INFOB");

        ModNivClass.setItems(optionsNiv);
        SpecNivClass.setItems(optionsSpec);

       
    }    

    
    public void UpdateClassAction() {
        String niv=ModNivClass.getValue()+SpecNivClass.getValue();
        Class u =new Class(Data.getId(),ModNameClass.getText(),ModNivClass.getValue(),SpecNivClass.getValue(),Integer.parseInt(SnModClass.getText()),DescModClass.getText());;
        ClassService us =new ClassService();
        us.UpdateClass(u);
        System.out.println("updated");
    }
    
     public void DeleteClassAction() {
        ClassService us =new ClassService();
        System.out.println(Data.getId());
        us.DeleteClass(Data.getId());
        System.out.println("Deleted");

    }

    @FXML
    private void BtnDelClassAction(ActionEvent event) {
        DeleteClassAction();
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void BtnModClassAction(ActionEvent event) {
        UpdateClassAction();
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    void setMainController(AfficherController aThis) {
        aff=aThis;
    }

    void setData(String id,String name,String niv,String spec,String nbr,String desc) {
        this.label.setText(id);
        this.ModNameClass.setText(name);       
        this.ModNivClass.setValue(niv);
       //this.ModNivClass.getSelectionModel().selectFirst();
        this.SpecNivClass.setValue(spec);
       // this.SpecNivClass.getSelectionModel().selectFirst();
        this.SnModClass.setText(nbr);
        this.DescModClass.setText(desc);
    }

   
    
}
