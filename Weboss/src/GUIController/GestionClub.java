/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import weboss.Entities.Club;
import weboss.Entities.User;
import weboss.Service.ClubService;
import weboss.Service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class GestionClub implements Initializable {

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
    private TableColumn<Club, User> id_responsable;
    @FXML
    private TableColumn<Club, String> domaine;

    private final ObservableList<Club> listClub = FXCollections.observableArrayList();

    @FXML
    private AnchorPane page2;
    @FXML
    private JFXTextField search;
    private JFXTextField select;
    @FXML
    private JFXButton supprimer;
    static int idd;
    static String nomm;
    ClubService cs = new ClubService();
    @FXML
    private JFXTextField ID_resp;
    @FXML
    private JFXTextField nom_clb;
    @FXML
    private JFXTextField doma;
    @FXML
    private JFXButton aj;
@FXML
    private TableView<Map.Entry<String, String>> tab;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> nomClb;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> nbr;

    
    EvenementService evs = new EvenementService();
//    ClubService cs = new ClubService();
    int i;
    private final ObservableList<Map.Entry<String, String>> listEvenement = FXCollections.observableArrayList();
    @FXML
    private Label pourcentage;
    @FXML
    private Label nbr_evenement_organiser;
    @FXML
    private Label nom_club1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            listClub.addAll(cs.affciher());
            //System.out.println(cs.recuperer_id_clubs());
        } catch (SQLException ex) {
            Logger.getLogger(GestionClub.class.getName()).log(Level.SEVERE, null, ex);
        }

        id_club.setCellValueFactory(new PropertyValueFactory<Club, Integer>("idClub"));
        nom_club.setCellValueFactory(new PropertyValueFactory<Club, String>("nomClub"));
        id_responsable.setCellValueFactory(new PropertyValueFactory<Club, User>("Responsable"));
        domaine.setCellValueFactory(new PropertyValueFactory<Club, String>("domaine"));
        tab_club.setItems(listClub);
            
        
        
        
        
        
        // TODO
        nomClb.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//this callback returns property for just one cell, you can't use a loop here
//for first column we use key
                return new SimpleStringProperty(p.getValue().getKey());
            }
        });
        nbr.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//for second column we use value
                return new SimpleStringProperty(p.getValue().getValue());
            }
        });
        try {
            for (i = 0; i < cs.recuperer_id_clubs().size(); i++) {
                int x = cs.recuperer_id_clubs().get(i);
                System.out.println(x);
                listEvenement.addAll(evs.nbrEvenementClub(x).entrySet());
                tab.setItems(listEvenement);
                tab.getColumns().setAll(nomClb, nbr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClubPlusActifController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void selection(MouseEvent event) {
        Club ev = tab_club.getSelectionModel().getSelectedItem();
     
        idd = ev.getIdClub();
        nomm=ev.getNomClub();
    }

    @FXML
    void supprimer_club(MouseEvent event) {
        final ObservableList<Club> listClub2 = FXCollections.observableArrayList();
        Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setHeaderText(null);
    alert.setContentText("Vous voulez supprimer club"+nomm+"?");

    ButtonType deleteGame = new ButtonType("Supprimer Club)");
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(deleteGame, buttonTypeCancel);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == deleteGame){
        try {
            cs.supprimer(idd);
            listClub2.addAll(cs.affciher());
            tab_club.setItems(listClub2);

        } catch (SQLException ex) {
            Logger.getLogger(GestionClub.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }

    @FXML
    private void cherche(KeyEvent event) {
        final ObservableList<Club> listClub2 = FXCollections.observableArrayList();

        search.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                System.out.println(newValue);
                listClub2.addAll(cs.recherche(newValue));
                tab_club.setItems(listClub2);
            } catch (SQLException ex) {
                Logger.getLogger(GestionClub.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void ajouter(MouseEvent event) throws SQLException {
                final ObservableList<Club> listClub2 = FXCollections.observableArrayList();

      // int  id_resp=Integer.parseInt(ID_resp.getText());
       String nom=nom_clb.getText();
       String domainee=doma.getText();
       User u =cs.recupererInfoResponsable(ID_resp.getText());
     //  User uu = new User(id_resp,u.getNomUser(),u.getPrenomUser()); 
        System.out.println(u);
       Club c=new Club(u, nom, domainee);
        try {
            cs.ajouter(c);
             listClub2.addAll(cs.affciher());
            tab_club.setItems(listClub2);
        } catch (SQLException ex) {
            Logger.getLogger(GestionClub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void select(MouseEvent event) throws SQLException {
        nom_club1.setText(tab.getSelectionModel().getSelectedItem().getKey());
        nbr_evenement_organiser.setText(tab.getSelectionModel().getSelectedItem().getValue());
        int x = Integer.parseInt(tab.getSelectionModel().getSelectedItem().getValue());
        int y = evs.nbr_evenementTotale();
        float pr = ((float) x / y) * 100;
        pourcentage.setText(""+pr+"%");
        
    }

}
