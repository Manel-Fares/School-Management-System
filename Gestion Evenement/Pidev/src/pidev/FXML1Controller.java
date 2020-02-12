/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

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

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<String> table;
    @FXML
    private Pane sidebar;

    @FXML
    private Pane loginarea;
      /*  @FXML
    private ImageView left_img;*/
     @FXML
    private AnchorPane login_page;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
      @FXML
    void affiche_tab(MouseEvent event) throws IOException {
            Parent fxml=FXMLLoader.load(getClass().getResource("eventUI.fxml"));
        login_page.getChildren().removeAll();        
        login_page.getChildren().setAll(fxml);
        
    }
    
}
