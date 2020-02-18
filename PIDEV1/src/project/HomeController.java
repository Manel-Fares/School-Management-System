/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import project.entities.User;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class HomeController implements Initializable {

    @FXML
    private Button etudiant;
    @FXML
    private Button enseignant;
    @FXML
    private Button personnel;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EspaceEtudiant(ActionEvent event) {
          try {
           
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ListEtudiant.fxml"));
              Parent root = loader.load();
                ListEtudiantController apc = loader.getController();
                
                etudiant.getScene().setRoot(root);
            
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
    }

    @FXML
    private void EspaceEnseignant(ActionEvent event) {
    }

    @FXML
    private void EspacePersonnel(ActionEvent event) {
    }
    
}
