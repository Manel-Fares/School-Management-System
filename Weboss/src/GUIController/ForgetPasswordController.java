/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.layout.AnchorPane;
import weboss.Entities.User;
import weboss.Service.UserService;


/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ForgetPasswordController implements Initializable {

    @FXML
    private AnchorPane bck;
    @FXML
    private JFXTextField email;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        email.isDisabled();
        // TODO
    }    

    @FXML
    private void forget(ActionEvent event) {
        try {
            Parent fxml;
            UserService ser = new UserService();
            User.code=ser.getcode();
            System.out.println(User.user);
            if (ser.VerificationEmail(email.getText())){
                
                
                try {
                    System.out.println(ser.getUser(email.getText()));
                    User.user=ser.getUser(email.getText());
                    
                } catch (SQLException ex) {
                    System.out.println("error user");
                }
                
                try {
                    
                    ser.sendMail(email.getText(),"Password",String.valueOf(User.code));
                    
                    
                    fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/CodeLogin.fxml"));
                    bck.getChildren().removeAll();
                    bck.getChildren().setAll(fxml);
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }else{
                Alert info = new Alert(Alert.AlertType.ERROR);
                info.setTitle("Email");
                info.setContentText("Email n'existe pas");
                info.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
}
