/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import weboss.Service.ClassService;
import weboss.Entities.Class;


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
   


    
        public void afficherAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public boolean testSaisie() {
        
       // System.out.println("compare="+dateDebut.getValue().compareTo(dateFin.getValue()));

        if (ModNameClass.getText().trim().isEmpty() || SnModClass.getText().trim().isEmpty()
                || DescModClass.getText().trim().isEmpty()
                //|| adresse.getText().trim().isEmpty()
                || ModNivClass.getValue() == null
                || SpecNivClass.getValue() == null
                //|| imageFileLabel.getText().trim().isEmpty()
                ) {
            afficherAlert("Tous les champs doivent être remplis");
            return false;
        }
       /* Instant instant = Instant.from(dateDebut.getValue().atStartOfDay(ZoneId.systemDefault()));
        Date dateD = Date.from(instant);
        Date cuurentDate = new Date();
        if (dateD.compareTo(cuurentDate) < 0) {

            afficherAlert("Date debut doit être supérieur à la date d'aujoud'hui");
            return false;
        }
        if (dateDebut.getValue().compareTo(dateFin.getValue()) > 0) {
            afficherAlert("Date fin doit être supérieur ou égal à la date de debut");
            return false;
        }
        if (dateDebut.getValue().compareTo(dateFin.getValue()) == 0) {
            if (heureDebut.getValue().compareTo(heureFin.getValue()) > 0) {
                afficherAlert("Heure fin doit être supérieur à l'heure de début");
                return false;
            }
        }*/
        try {
            Double num = Double.parseDouble(SnModClass.getText());
        } catch (NumberFormatException e) {
            afficherAlert("Champs Nombre invalide");
            return false;
        }
        return true;
    }
    
    

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
        ClassService us =new ClassService();
        if (testSaisie()){
        if(us.ValidatorNomClass(ModNameClass.getText()))
        {
        String niv=ModNivClass.getValue()+SpecNivClass.getValue();
        Class u =new Class(Data.getId(),ModNameClass.getText(),ModNivClass.getValue(),SpecNivClass.getValue(),Integer.parseInt(SnModClass.getText()),DescModClass.getText());;        
        us.UpdateClass(u);
        System.out.println("updated");
        }}
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
