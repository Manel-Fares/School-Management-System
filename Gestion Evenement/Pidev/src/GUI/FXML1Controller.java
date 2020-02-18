/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import pidev.BD.*;
import pidev.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXML1Controller implements Initializable {

    @FXML
    private Pane sidebar;

    @FXML
    private Pane loginarea;
      /*  @FXML
    private ImageView left_img;*/
     @FXML
    private AnchorPane login_page;
    @FXML
    private ImageView left_img;
    @FXML
    private JFXTextField user_name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
      @FXML
    void affiche_tab(MouseEvent event) throws IOException {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("eventUI.fxml"));
            Parent root = loader.load();
            EventUIController ev=loader.getController();
            ev.setRolle(user_name.getText());
        login_page.getChildren().removeAll();        
        login_page.getChildren().setAll(root);
         
    }
 
}
