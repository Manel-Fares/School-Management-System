/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class Demande_clubController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Label nbr_notif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pane.setVisible(false);
        DemandeEvenementService dvs = new DemandeEvenementService();

    }

    @FXML
    private void afficher_notification(MouseEvent event) {
        pane.setVisible(true);

    }

}
