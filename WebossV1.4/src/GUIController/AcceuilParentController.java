/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AcceuilParentController implements Initializable {

    @FXML
    private AnchorPane bckacceuiletudiant;
    @FXML
    private Pane bck1;
    @FXML
    private Pagination pagination;
    @FXML
    private Pane bck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    void affichage(String x)  {
        Parent fxml;
      
       

        try {
            fxml = FXMLLoader.load(getClass().getResource(x));
             bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {
            Logger.getLogger(AcceuilEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }

        @FXML
    private void logout(MouseEvent event) {
         Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/Login.fxml"));
            bckacceuiletudiant.getChildren().removeAll();
            bckacceuiletudiant.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }


  @FXML
    private void AbsenceAction(ActionEvent event) {
        affichage("/GUIInterface/AbsenceEtudiant.fxml");
    }

    @FXML
    private void Credits(ActionEvent event) {
                affichage("/GUIInterface/InterfaceParentCredit.fxml");

    }

    @FXML
    private void Notes(ActionEvent event) {
                affichage("/GUIInterface/interfaceParentNote.fxml");

    }

    @FXML
    private void AnnualResults(ActionEvent event) {
                affichage("/GUIInterface/interfaceParentResultat.fxml");

    }

    
}
