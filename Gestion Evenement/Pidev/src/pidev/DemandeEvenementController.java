/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import pidev.entities.DemandeEvenement;
import pidev.service.DemandeEvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class DemandeEvenementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    DemandeEvenementService des = new DemandeEvenementService();
    DemandeEvenement ev;
    @FXML
    private JFXDatePicker date_debut;

    @FXML
    private JFXDatePicker date_fin;
    @FXML
    private JFXTextArea desc;
    @FXML
    private JFXTextField id_club;
    //

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Date dd = new Date(1, 1, 1);
        Date df = new Date(1, 1, 1);

//ZoneId defaultZoneId = ZoneId.systemDefault();
        // TODO
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(dtf.format(date_debut.getValue()));
        //String d1 = dateFormat.format(date_debut.getValue());
        /*Date dd=new SimpleDateFormat("dd/MM/yyyy").parse(d1);
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String d2 = dateFormat1.format(this.date_fin.getValue());*/ //Date df=new SimpleDateFormat("dd/MM/yyyy").parse(d2);
    }

    @FXML
    void ajouter_demande(MouseEvent event) throws SQLException {
        int id = Integer.parseInt(id_club.getText());
        System.out.println("" + id);
        String dd = date_debut.getValue().toString();
        String df = date_fin.getValue().toString();
        System.out.println("" + desc.getText());

        ev = new DemandeEvenement(id, desc.getText(), dd, df);
        des.ajouter(ev);

    }

}
