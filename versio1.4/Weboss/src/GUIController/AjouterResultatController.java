/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import weboss.Entities.Resultat;
import weboss.Service.ServiceNote;
import weboss.Service.ServiceResultat;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class AjouterResultatController implements Initializable {

    @FXML
    private TextField cin;
    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutAction(ActionEvent event) throws SQLException {
        ServiceResultat serR = new ServiceResultat();
        ServiceNote serN = new ServiceNote();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d =new Date(System.currentTimeMillis());
        int idEtudiant= serN.getIdEtudiant(cin.getText());
        System.out.println(idEtudiant);
        float resAnnuelle = serR.calculResultatParEtudiant(idEtudiant);
 
        Resultat r = new Resultat(idEtudiant, d, resAnnuelle);
        r.getEtudiant().setIdUser(String.valueOf(idEtudiant));
        
        serR.ajouterResultat(r);
    }

    @FXML
    private void supprimerAction(ActionEvent event) throws SQLException {
                ServiceResultat serR = new ServiceResultat();
                ServiceNote serN = new ServiceNote();
                int idEtudiant= serN.getIdEtudiant(cin.getText());
                serR.delete(idEtudiant);
                
        
        
    }

    @FXML
    private void modifierAction(ActionEvent event) {
    }
    
}
