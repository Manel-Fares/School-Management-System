/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private Pane login_area;
     @FXML
    private VBox sidebar;

    @FXML
    private ImageView img1;

    
    @FXML
    private ImageView img2;

    @FXML
    private JFXTextField user_name;

    @FXML
    private JFXTextField password;

    @FXML
    private Label forget;

    @FXML
    private JFXButton login;
    @FXML
    private Label welcome;
    /*@FXML
    private void open_event(MouseEvent event) {
       try {
            Parent fxml=FXMLLoader.load(getClass().getResource("eventUI.fxml"));
           login_area.getChildren().removeAll();
           login_area.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
}
