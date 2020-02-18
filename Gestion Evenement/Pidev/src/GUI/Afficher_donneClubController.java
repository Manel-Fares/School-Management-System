/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import pidev.entities.Club;
import pidev.service.ClubService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Afficher_donneClubController implements Initializable {

    @FXML
    private Label idClub;
    @FXML
    private Label IdResponsable;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField domaine;

    /**
     * Initializes the controller class.
     */
    ClubService cs=new ClubService();
    int idd=1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           try {
            Club c=cs.RecupererClb(idd);
            idClub.setText(""+c.getIdClub());
            IdResponsable.setText(""+c.getIdResponsable());
            nom.setText(c.getNomClub());
            domaine.setText(c.getDomaine());
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_donneClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void modifier(MouseEvent event) {
        Club c=new Club(nom.getText(), domaine.getText());
        try {
            cs.modifier(c, Integer.parseInt(idClub.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_donneClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
    
}
