/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import weboss.Entities.User;
import weboss.Service.UserService;


/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class NewPasswordController implements Initializable {

    @FXML
    private Button reset;
    @FXML
    private TextField mdp;
    @FXML
    private TextField mdpC;
    @FXML
    private AnchorPane bck;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reset(ActionEvent event) {
        Parent fxml;
        UserService ser = new UserService();
        if(mdp.getText().equals(mdpC.getText()) && mdp.getLength()>=8){
            try {
                System.out.println(User.user);
               
                try {
                    ser.updatePassword(mdp.getText(),Integer.parseInt(User.user.getIdUser()));
                } catch (SQLException ex) {
                    System.out.println("error update mdp");
                }
                
            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/L.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            } catch (IOException ex) {
                System.out.println("error login");
            }
        }
        else{
             Alert info = new Alert(Alert.AlertType.WARNING);
             info.setTitle("Password Error");
             info.setContentText("Check your Password");
             info.show();
        }
    }
    
}
