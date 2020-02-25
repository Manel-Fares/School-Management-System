/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.layout.AnchorPane;
import weboss.Entities.User;


/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class CodeLoginController implements Initializable {

    @FXML
    private JFXTextField code;
    @FXML
    private Button check;
    @FXML
    private AnchorPane bck;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    

    @FXML
    private void check(ActionEvent event) throws IOException {
        Parent fxml;
        if(Integer.parseInt(code.getText())==User.code){
             Alert info = new Alert(Alert.AlertType.INFORMATION);
             info.setTitle("Check");
             info.setContentText("Done");
             info.show();
             
            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/CodeLogin.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            
        }
    }
    
}
