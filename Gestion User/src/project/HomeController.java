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
    @FXML
    private Button logout;
    @FXML
    private Button reclamation;
    @FXML
    private Button charts;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EspaceEtudiant(ActionEvent event) {
          try {
           
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("EspaceEtudiant.fxml"));
              Parent root = loader.load();
                EspaceEtudiantController apc = loader.getController();
                
                etudiant.getScene().setRoot(root);
            
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
    }

    @FXML
    private void EspaceEnseignant(ActionEvent event) {
         try {
           
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("EspaceEnseignant.fxml"));
              Parent root = loader.load();
                EspaceEnseignantController apc = loader.getController();
                
                etudiant.getScene().setRoot(root);
            
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
    }

    @FXML
    private void EspacePersonnel(ActionEvent event) {
         try {
           
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("EspacePersonnel.fxml"));
              Parent root = loader.load();
                EspacePersonnelController apc = loader.getController();
                
                etudiant.getScene().setRoot(root);
            
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        User.user=null;
            try {
           
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Login.fxml"));
              Parent root = loader.load();
                LoginController apc = loader.getController();
                
                etudiant.getScene().setRoot(root);
            
            
        } catch (Exception ex) {
            System.out.println("logout error");
        }
    }

    @FXML
    private void reclamation(ActionEvent event) {
        try {
           
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("page1.fxml"));
              Parent root = loader.load();
                ViewReclamation apc = loader.getController();
                
                etudiant.getScene().setRoot(root);
            
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
    }

    @FXML
    private void charts(ActionEvent event) {
        try {
           
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ChartUser.fxml"));
              Parent root = loader.load();
                ChartUserController apc = loader.getController();
                
                etudiant.getScene().setRoot(root);
            
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
    }
    
}
