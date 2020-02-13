/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pidev.*;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pidev.entities.Evenement;
import pidev.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Affciher_EvenementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField text;
    @FXML
    private TableView<Evenement> tab_evenement;
    @FXML
    private TableColumn<Evenement, Integer> id_evenement;
    @FXML
    private TableColumn<Evenement, Integer> id_club;

    @FXML
    private TableColumn<Evenement, String> date_debut;

    @FXML
    private TableColumn<Evenement, String> date_fin;

    private final ObservableList<Evenement> listEvenement = FXCollections.observableArrayList();
    @FXML
    private AnchorPane bck;
    @FXML
    private JFXTextField idclub;
    @FXML
    private JFXDatePicker dd;
    @FXML
    private JFXDatePicker df;
    EvenementService cs = new EvenementService();
public void affichee()
{
 try {
            listEvenement.addAll(cs.affciher());
        } catch (SQLException ex) {
            Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        id_evenement.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("idEvenement"));
        id_club.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("idClub"));
        date_debut.setCellValueFactory(new PropertyValueFactory<Evenement, String>("dateDebut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<Evenement, String>("dateFin"));
        tab_evenement.setItems(listEvenement);

}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       affichee();
    }
    int id;

    @FXML
    void Selectonne(MouseEvent event) {
        Evenement ev = tab_evenement.getSelectionModel().getSelectedItem();
        //int id = Integer.parseInt(text.getText());

        idclub.setText("" + ev.getIdClub());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(ev.getDateDebut());
        LocalDate localDate2 = LocalDate.parse(ev.getDateFin());
        dd.setValue(localDate);
        df.setValue(localDate2);
        //dd.setValue(ev.getDateDebut().to);

    }

    int valeurID() {
        Evenement ev = tab_evenement.getSelectionModel().getSelectedItem();

        return ev.getIdEvenement();
    }

    @FXML
    void supprimer(MouseEvent event) throws SQLException {

        cs.supprimer(valeurID());
        affichee();
    }

    @FXML
    void modifier(MouseEvent event) {

        Evenement ev = new Evenement(dd.getValue().toString(), df.getValue().toString(), Integer.parseInt(idclub.getText()));
        System.out.println(ev);
        
        try {
            cs.modifier(ev, valeurID());
                    System.out.println(ev);
                    System.out.println(valeurID());

        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

}
