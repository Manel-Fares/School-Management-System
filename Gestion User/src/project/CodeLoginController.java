/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.entities.User;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class CodeLoginController implements Initializable {

    @FXML
    private TextField code;
    @FXML
    private Button check;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    

    @FXML
    private void check(ActionEvent event) throws IOException {
        if(Integer.parseInt(code.getText())==User.code){
             Alert info = new Alert(Alert.AlertType.INFORMATION);
             info.setTitle("Check");
             info.setContentText("Done");
             info.show();
              FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("NewPassword.fxml"));
              Parent root = loader.load();
                NewPasswordController apc = loader.getController();
                
                code.getScene().setRoot(root);
            
        }
    }
    
}
