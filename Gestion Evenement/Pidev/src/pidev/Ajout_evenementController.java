/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import pidev.entities.Evenement;
import pidev.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Ajout_evenementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField id_club;

    @FXML
    private JFXDatePicker dd;

    @FXML
    private JFXDatePicker df;

    @FXML
    private JFXButton ajout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void ajouter_evenement(MouseEvent event) throws SQLException {
                EvenementService evs = new EvenementService();

        int id = Integer.parseInt(id_club.getText());
        String dateudebut = dd.getValue().toString();
        String datefin = df.getValue().toString();
        Evenement ev=new Evenement(dateudebut, datefin, id);
        evs.ajouter(ev);

    }
    

}
