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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import weboss.Entities.Enseignant;
import weboss.Entities.Etudiant;
import weboss.Entities.Personnel;
import weboss.Entities.User;
import weboss.Entities.UserParent;

import weboss.Service.UserService;
import weboss.Weboss;

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
    @FXML
    private Pane captcha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         if (!Weboss.isSplashLoaded) {
            loadSplashScreen();
             
        // TODO
        
      
    }
       
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

        
        UserService ser = new UserService();
  
    
        try {
            
            User u=ser.login(email.getText(), mdp.getText());
            System.out.println(Enseignant.ensg);
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
            } else if(u instanceof Enseignant){
                System.out.println("ens");
                  FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("/GUIInterface/AcceuilEnseignant.fxml"));
                Parent root = loader.load();
                AcceuilEnseignantController apc = loader.getController();
                
                email.getScene().setRoot(root);
                System.out.println("p22");
                        
                
            } else if(u instanceof Enseignant){
                System.out.println("ens");
                  FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("/GUIInterface/AcceuilEnseignant.fxml"));
                Parent root = loader.load();
                AcceuilEnseignantController apc = loader.getController();
                
                email.getScene().setRoot(root);
                System.out.println("p22");
                        
                
            }
            else if(u instanceof User){
                System.out.println("hiii");
                  FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("/GUIInterface/Acceuil.fxml"));
                Parent root = loader.load();
                AcceuilController apc = loader.getController();
                
                email.getScene().setRoot(root);
                System.out.println("p22");
                        
                
            }
            
          
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     private void loadSplashScreen() {
        try {
            Weboss.isSplashLoaded = true;

            StackPane pane = FXMLLoader.load(getClass().getResource(("/GUIInterface/splash.fxml")));
          
           // root.setBackground(Background.EMPTY);
            bck.getChildren().setAll(pane);


            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                                  
                try {
                    Stage stageq = (Stage) bck.getScene().getWindow();
                    stageq.close();                    
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/GUIInterface/Login.fxml"));
                    AnchorPane rootLayout = (AnchorPane) loader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    Scene scene = new Scene(rootLayout);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }                
            });

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
