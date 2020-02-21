/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import pidev.service.DemandeEvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class sondageController implements Initializable {

  
    @FXML
    private JFXTextArea desc;
    @FXML
    private JFXTextField Titre;
    @FXML
    private JFXTextField id_club;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     

    }

  

    @FXML
    private void ajouter(MouseEvent event) {
        
    }

}
