/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import weboss.Entities.User;
import weboss.Service.UserService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane bck;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private void Login(ActionEvent event) {
        UserService ser = new UserService();
                    System.out.println(User.user);

        try {
            User.user=ser.login(email.getText(), mdp.getText());
             System.out.println(User.user);
            if(User.user.getRoleUser().equals("Etudiant")){
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Etudiant.fxml"));
              Parent root = loader.load();
               // EtudiantController apc = loader.getController();
                
                email.getScene().setRoot(root);
            System.out.println(User.user);
            }/*else if(User.user.getRoleUser().equals("Enseignant")){}
            else if(User.user.getRoleUser().equals("Personnel")){}*/
            else{
                FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Acceuil.fxml"));
              Parent root = loader.load();
               // HomeController apc = loader.getController();
               
                
                email.getScene().setRoot(root);
                
            }
                
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
        
        
        
    }

    private void forgetpassword(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("ForgetPassword.fxml"));
              Parent root = loader.load();
                //ForgetPasswordController apc = loader.getController();
                
               // /forget.getScene().setRoot(root);
        
    }
    
    
    public void input_login() {
        mdp.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                        UserService ser = new UserService();
                    System.out.println(User.user);

        try {
            User.user=ser.login(email.getText(), mdp.getText());
             System.out.println(User.user);
            if(User.user.getRoleUser().equals("Etudiant")){
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Etudiant.fxml"));
              Parent root = loader.load();
              //  EtudiantController apc = loader.getController();
                
                email.getScene().setRoot(root);
            System.out.println(User.user);
            }/*else if(User.user.getRoleUser().equals("Enseignant")){}
            else if(User.user.getRoleUser().equals("Personnel")){}*/
            else{
                FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Home.fxml"));
              Parent root = loader.load();
               // HomeController apc = loader.getController();
               
                
                email.getScene().setRoot(root);
                
            }
                
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
        
            }
        });
    }
    
    void affichage(String x) {
        Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource(x));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }


    private void login(MouseEvent event) {
        affichage("/GUIInterface/Acceuil.fxml");

    }

    @FXML
    private void forget(MouseEvent event) {
    }

    @FXML
    private void Login(MouseEvent event) {
    }

}
    