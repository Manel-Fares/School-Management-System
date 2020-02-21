/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.jws.soap.SOAPBinding;
import project.entities.User;
import project.service.UserService;

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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reset(ActionEvent event) {
        UserService ser = new UserService();
        if(mdp.getText().equals(mdpC.getText())){
            try {
                System.out.println(User.user);
               
                try {
                    ser.updatePassword(mdp.getText(),Integer.parseInt(User.user.getIdUser()));
                } catch (SQLException ex) {
                    System.out.println("error update mdp");
                }
                FXMLLoader loader = new FXMLLoader
                                (getClass()
                                        .getResource("Login.fxml"));
                Parent root = loader.load();
                LoginController apc = loader.getController();
                
                mdp.getScene().setRoot(root);
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
