/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import weboss.Entities.Enseignant;
import weboss.Entities.Etudiant;
import weboss.Entities.Personnel;
import weboss.Entities.User;
import weboss.Entities.UserParent;

import weboss.Service.UserService;

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
    private AnchorPane bck;
    @FXML
    private Label f;
    @FXML
    private Pane bckLogin;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private Label welcome;
    @FXML
    private Label LetfText;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //   input_login();
    }

    /*
    private void Login(ActionEvent event) {
        UserService ser = new UserService();
                   // System.out.println(User.user);

                   
        try {
           
            System.out.println(ser.login(email.getText(), mdp.getText()));
             System.out.println(Enseignant.ensg);
            if(ser.login(email.getText(), mdp.getText()) instanceof Etudiant){
                   FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("/GUIInterface/AcceuilEtudiant.fxml"));
              Parent root = loader.load();
                AcceuilEtudiantController apc = loader.getController();
                
                email.getScene().setRoot(root);
                
            }
            
            else if(ser.login(email.getText(), mdp.getText()) instanceof Enseignant){
                 FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("/GUIInterface/Acceuil.fxml"));
              Parent root = loader.load();
                AcceuilController apc = loader.getController();
                
                email.getScene().setRoot(root);
            }
           Etudiant.etd=(Etudiant) ser.login(email.getText(), mdp.getText());
            
            if(Etudiant.etd.getRoleUser().equals("Etudiant")){
             FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Etudiant.fxml"));
              Parent root = loader.load();
                EtudiantController apc = loader.getController();
                
                email.getScene().setRoot(root);
           // System.out.println(User.user);
            }else if(Enseignant.ensg.getRoleUser().equals("Enseignant")){
                  FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("EspaceEnseignant.fxml"));
              Parent root = loader.load();
                EspaceEnseignantController apc = loader.getController();
                
                email.getScene().setRoot(root);
            }/*
            else if(User.user.getRoleUser().equals("Personnel")){}*/
 /*  else{
                FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Home.fxml"));
              Parent root = loader.load();
                HomeController apc = loader.getController();
               
                
                email.getScene().setRoot(root);
                
            }
                
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
        
        
        
    }

    
    
    public void input_login() {
        mdp.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                        UserService ser = new UserService();
                   // System.out.println(User.user);
try{
  
                
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
        
            }
        });
    }
     */
    @FXML
    private void forget(MouseEvent event) {
        
        Parent fxml;
        
        try {
            
            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/ForgetPassword.fxml"));
            bckLogin.getChildren().removeAll();
            bckLogin.getChildren().setAll(fxml);
            mdp.setVisible(false);
            email.setVisible(false);
            loginBtn.setVisible(false);
            f.setVisible(false);
            welcome.setVisible(false);
            LetfText.setText("Forget Password");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    
    @FXML
    private void Login(MouseEvent event) {

        // System.out.println(User.user);
        UserService ser = new UserService();
        
        try {
            
            User u=ser.login(email.getText(), mdp.getText());
            System.out.println(Personnel.pr);
            if (u instanceof Etudiant) {
                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("/GUIInterface/AcceuilEtudiant.fxml"));
                Parent root = loader.load();
                AcceuilEtudiantController apc = loader.getController();
                
                email.getScene().setRoot(root);
                
            } else if (u instanceof Personnel) {            
                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("/GUIInterface/AcceuilPersonel.fxml"));
                Parent root = loader.load();
                AcceuilPersonelController apc = loader.getController();
                
                email.getScene().setRoot(root);
            }else if(u instanceof UserParent) {
                System.out.println("salutttttttttt");
                FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("/GUIInterface/AcceuilParent.fxml"));
                Parent root = loader.load();
                AcceuilPersonelController apc = loader.getController();
                
                email.getScene().setRoot(root);
            } else if(u instanceof User){
                System.out.println("hiii");
                  FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("/GUIInterface/Acceuil.fxml"));
                Parent root = loader.load();
                AcceuilController apc = loader.getController();
                
                email.getScene().setRoot(root);
                System.out.println("p22");
                        
                
            }
          
            
        } catch (Exception ex) {
            System.out.println("login error");
        }
    }
    
}
