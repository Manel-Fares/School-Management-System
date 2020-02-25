/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import weboss.Entities.Enseignant;

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
    private ImageView imgProfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            String path = "C:\\Users\\Neifos\\Documents\\GitHub\\School-Management-System\\Weboss\\src\\weboss\\Image\\"+Enseignant.ensg.getPicUser();
            File imgurll= new File(path);
            Image img=new Image(imgurll.toURI().toString());
            imgProfil.setImage(img);
        // TODO
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
    }

    @FXML
    private void AfficherGestionNotes(MouseEvent event) {
        affichage("/GUIInterface/GestionNoteEnseignant.fxml");
    }
    
}
