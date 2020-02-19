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
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
import project.entities.User;
import project.service.UserService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ForgetPasswordController implements Initializable {

    @FXML
    private TextField email;

    UserService ser = new UserService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        email.isDisabled();
        // TODO
    }    

    @FXML
    private void forget(ActionEvent event) throws IOException {
        UserService ser = new UserService();
        User.code=ser.getcode();
         System.out.println(User.user);
        try {
            System.out.println(ser.getUser(email.getText()));
            User.user=ser.getUser(email.getText());
        } catch (SQLException ex) {
            System.out.println("error user");
        }
       
        try {
          
            ser.sendMail(email.getText(),"Password",String.valueOf(User.code));
            
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("CodeLogin.fxml"));
              Parent root = loader.load();
                CodeLoginController apc = loader.getController();
                
                email.getScene().setRoot(root);
        } catch (MessagingException ex) {
            Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    
}
