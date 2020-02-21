/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Page2Controller.nomm;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pidev.service.DemandeEvenementService;
import pidev.entities.DemandeEvenement;
import pidev.service.ClubService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Consulter_demande_evenemetController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<DemandeEvenement> tab;

    @FXML
    private TableColumn<DemandeEvenement, Integer> id_club;

    @FXML
    private TableColumn<DemandeEvenement, Float> budget;

    @FXML
    private TableColumn<DemandeEvenement, String> desc;

    @FXML
    private TableColumn<DemandeEvenement, String> dd;

    @FXML
    private TableColumn<DemandeEvenement, String> df;
    @FXML
    private TableColumn<DemandeEvenement, Integer> id_demande;

    private final ObservableList<DemandeEvenement> l = FXCollections.observableArrayList();
    @FXML
    private TableColumn<DemandeEvenement, String> etat;
    @FXML
    private JFXTextField b;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXDatePicker date_deb;
    @FXML
    private JFXDatePicker date_f;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton modifier;
    DemandeEvenementService cs = new DemandeEvenementService();
ClubService c=new ClubService();
int identifiant=FXML1Controller.getIdentifiant();
    @FXML
    private TableColumn<DemandeEvenement, String> image;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            System.out.println(identifiant);
            int x=c.recuperer_id_club(identifiant);
            System.out.println(x);
            List<DemandeEvenement> oo = cs.afficherDemandeSpecifique(x);
            l.addAll(oo);
            for (DemandeEvenement d : oo) {
                System.out.println(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Consulter_demande_evenemetController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // l.addAll((DemandeEvenement)cs.afficherDemandeSpecifique(11));
        id_club.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Integer>("idclub"));
        dd.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("datedebut"));
        df.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("datefin"));
        desc.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("description"));
        budget.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Float>("budget"));
        etat.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("etat"));
        id_demande.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Integer>("idDemandeEvenement"));
        image.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("image"));
        tab.setItems(l);

    }

    @FXML
    private void select(MouseEvent event) {
        DemandeEvenement dev = tab.getSelectionModel().getSelectedItem();
        b.setText("" + dev.getBudget());
        LocalDate localDate = LocalDate.parse(dev.getDatedebut());
        LocalDate localDate2 = LocalDate.parse(dev.getDatefin());
        date_deb.setValue(localDate);
        date_f.setValue(localDate2);
        description.setText(dev.getDescription());
    }

    @FXML
    private void supprimer_demande(MouseEvent event) throws SQLException {
             final ObservableList<DemandeEvenement> l2 = FXCollections.observableArrayList();
  
        DemandeEvenement dev = tab.getSelectionModel().getSelectedItem();
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText(null);
    alert.setContentText("Vous voulez supprimer club"+nomm+"?");

    ButtonType deleteGame = new ButtonType("Supprimer Club)");
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(deleteGame, buttonTypeCancel);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == deleteGame){
        cs.supprimer(dev.getIdDemandeEvenement());
        int x=c.recuperer_id_club(identifiant);
           
            List<DemandeEvenement> o = cs.afficherDemandeSpecifique(x);
            l2.addAll(o);
        tab.setItems(l2);

    }}

    @FXML
    private void modifier_demande(MouseEvent event) {
                     final ObservableList<DemandeEvenement> l2 = FXCollections.observableArrayList();

        float budget = Float.parseFloat(b.getText());
        String dd = date_deb.getValue().toString();
        String df = date_f.getValue().toString();
        String desc = description.getText();
        DemandeEvenement dev = tab.getSelectionModel().getSelectedItem();
        DemandeEvenement t = new DemandeEvenement(desc, dd, df, budget);
        try {
            
            cs.modifier(t, dev.getIdDemandeEvenement());
            int x=c.recuperer_id_club(identifiant);
           
            List<DemandeEvenement> oo = cs.afficherDemandeSpecifique(x);
                        l2.addAll(oo);

                    tab.setItems(l2);

        } catch (SQLException ex) {
            Logger.getLogger(Consulter_demande_evenemetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
