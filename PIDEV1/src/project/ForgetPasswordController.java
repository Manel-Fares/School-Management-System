/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.mail.MessagingException;
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
        // TODO
    }    

    @FXML
    private void forget(ActionEvent event) {
        try {
            ser.sendMail(email.getText());
        } catch (MessagingException ex) {
            Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
