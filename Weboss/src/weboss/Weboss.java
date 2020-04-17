/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author asus
 */
public class Weboss extends Application {
    public static Boolean isSplashLoaded = false;
    
    @Override
    public void start(Stage primaryStage) {
       
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUIInterface/Login.fxml"));
           
        primaryStage= new Stage(StageStyle.UNDECORATED);
    //    primaryStage= new Stage(StageStyle.TRANSPARENT);
      // primaryStage.initModality(Modality.APPLICATION_MODAL); 
        primaryStage.initStyle(StageStyle.TRANSPARENT);   
         Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.setTitle("WeBoss");
           // primaryStage.fullScreenProperty()
            primaryStage.show();
        } catch (IOException ex) {
ex.getMessage();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
