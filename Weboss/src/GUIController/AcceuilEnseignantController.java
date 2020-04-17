/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AcceuilEnseignantController implements Initializable {

    @FXML
    private AnchorPane background;
    @FXML
    private Pane bck;
    @FXML
    private Pane menu;

    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menu.setVisible(false);
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
    @FXML
    private void logout(MouseEvent event) {
  Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/Login.fxml"));
            background.getChildren().removeAll();
            background.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void AfficherGestionNotes(MouseEvent event) {
        affichage("/GUIInterface/GestionNoteEnseignant.fxml");
    }

    @FXML
    private void chapitresManagement(MouseEvent event) {
    }

    @FXML
    private void QuizManagement(MouseEvent event) {
    }

   

    @FXML
    private void afficher(MouseEvent event) {
    }
    @FXML
    private void afficherBarreMenu(MouseEvent event) {
        menu.setVisible(true);
    }

    @FXML
    private void BarreMenu(MouseEvent event) {
                menu.setVisible(false);

    }
    
    
}
