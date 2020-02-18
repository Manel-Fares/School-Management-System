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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import project.entities.User;
import project.service.UserService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private TextField mdp;
    @FXML
    private Label forget;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
        UserService ser = new UserService();
                    System.out.println(User.user);

        try {
            User.user=ser.login(email.getText(), mdp.getText());
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Home.fxml"));
              Parent root = loader.load();
                HomeController apc = loader.getController();
                
                email.getScene().setRoot(root);
            System.out.println(User.user);
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
        
        
        
    }

    @FXML
    private void forgetpassword(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ForgetPassword.fxml"));
              Parent root = loader.load();
                ForgetPasswordController apc = loader.getController();
                
                forget.getScene().setRoot(root);
        
    }
    
}
