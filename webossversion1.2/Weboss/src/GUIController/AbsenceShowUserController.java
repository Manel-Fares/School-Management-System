/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.teknikindustries.bulksms.SMS;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import weboss.Entities.User;


/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class AbsenceShowUserController implements Initializable {

    @FXML
    private Label InfoRole;
    @FXML
    private Label LabelInfoNom;
    @FXML
    private Label LabelInfoPrenom;
    @FXML
    private Label LabelInfoNbr;
    @FXML
    private Label InfoNom;
    @FXML
    private Label InfoPrenom;
    @FXML
    private Label InfoNbr;
    @FXML
    private JFXButton InfoBtnExit;
    AbsenceController mainController;
    AffecterClassController acc;
    User Data;
    @FXML
    private AnchorPane rootPane;
    String IDData;
    @FXML
    private JFXTextField Numero;
    @FXML
    private JFXButton sms;
    
    public void setData(String role,String nom,String prenom,String IDData) {
        InfoRole.setText(role);
        InfoNom.setText(nom);
        InfoPrenom.setText(prenom);
        InfoNbr.setText(IDData);

    }
    
 public void setMainController(AbsenceController mainController) {
        this.mainController = mainController ;
    }
  public void setSecondeController(AffecterClassController mainController) {
        this.acc = mainController ;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    

    @FXML
    private void onExit(ActionEvent event) {
          Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void smsAction(ActionEvent event) {
        SMS sms = new SMS();
        sms.SendSMS("test_nom", "0123Azertyuiop", "son fils "+InfoNom.getText()+" a "+InfoNbr.getText()+" Nombre d'absence", Numero.getText(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
    }
    
}
