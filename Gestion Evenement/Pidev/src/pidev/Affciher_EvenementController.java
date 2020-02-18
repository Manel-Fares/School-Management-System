/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
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

    @FXML
    private final ObservableList<Evenement> listEvenement = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementService cs = new EvenementService();
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
    int id;

    @FXML
    void delete(MouseEvent event) {
        Evenement ev = tab_evenement.getSelectionModel().getSelectedItem();
        id = ev.getIdEvenement();
        text.setText("" + id);

    }

    @FXML
    void supprimer(MouseEvent event) throws SQLException {
        EvenementService evs = new EvenementService();
        int id = Integer.parseInt(text.getText());

        evs.supprimer(id);
        

    }
}
