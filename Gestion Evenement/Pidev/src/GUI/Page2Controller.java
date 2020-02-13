/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import pidev.*;
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
import javafx.scene.layout.AnchorPane;
import pidev.entities.Club;
import pidev.service.ClubService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Page2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Club> tab_club;

    @FXML
    private TableColumn<Club, Integer> id_club;

    @FXML
    private TableColumn<Club, String> nom_club;

    @FXML
    private TableColumn<Club, Integer> id_responsable;
    @FXML
    private TableColumn<Club, String> domaine;

    private final ObservableList<Club> listClub = FXCollections.observableArrayList();

    @FXML
    private AnchorPane page2;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXTextField select;
    @FXML
    private JFXButton supprimer;

    ClubService cs = new ClubService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listClub.addAll(cs.affciher());
        } catch (SQLException ex) {
            Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        id_club.setCellValueFactory(new PropertyValueFactory<Club, Integer>("idClub"));
        nom_club.setCellValueFactory(new PropertyValueFactory<Club, String>("nomClub"));
        id_responsable.setCellValueFactory(new PropertyValueFactory<Club, Integer>("idResponsable"));
        domaine.setCellValueFactory(new PropertyValueFactory<Club, String>("domaine"));
        tab_club.setItems(listClub);

    }

    @FXML
    void selection(MouseEvent event) {
 Club ev = tab_club.getSelectionModel().getSelectedItem();
 select.setText(""+ev.getIdClub());
    }

    @FXML
    void supprimer_club(MouseEvent event) {
        try {
            cs.supprimer(Integer.parseInt(select.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
