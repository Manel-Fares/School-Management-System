/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import weboss.Weboss;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class MainController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          if (!Weboss.isSplashLoaded) {
            loadSplashScreen();
        }
    }    
       private void loadSplashScreen() {
        try {
            Weboss.isSplashLoaded = true;

            StackPane pane = FXMLLoader.load(getClass().getResource(("/GUIInterface/splash.fxml")));
          
           // root.setBackground(Background.EMPTY);
            root.getChildren().setAll(pane);


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
                    Stage stageq = (Stage) root.getScene().getWindow();
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
