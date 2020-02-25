/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;


import static GUIController.GestionClub.nomm;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import weboss.Entities.Evenement;
import weboss.Service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Affciher_EvenementController implements Initializable {

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
    //private final ObservableList<Evenement> listEvenement2 = FXCollections.observableArrayList();

    @FXML
    private AnchorPane bck;
    @FXML
    private JFXTextField idclub;
    @FXML
    private JFXDatePicker dd;
    @FXML
    private JFXDatePicker df;
    EvenementService cs = new EvenementService();
    @FXML
    private JFXTextField listView;
    @FXML
    private TableColumn<Evenement, String> image;
    @FXML
    private JFXTextField search;

    public void affichee() {
        try {
            listEvenement.addAll(cs.affciher());
        } catch (SQLException ex) {
ex.getMessage();        }

        id_evenement.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("idEvenement"));
        id_club.setCellValueFactory(new PropertyValueFactory<Evenement, Integer>("idClub"));
        date_debut.setCellValueFactory(new PropertyValueFactory<Evenement, String>("dateDebut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<Evenement, String>("dateFin"));
        image.setCellValueFactory(new PropertyValueFactory<Evenement, String>("image"));
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
      /*  Evenement ev = tab_evenement.getSelectionModel().getSelectedItem();
        //int id = Integer.parseInt(text.getText());

        idclub.setText("" + ev.getIdClub());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate = LocalDate.parse(ev.getDateDebut());
        LocalDate localDate2 = LocalDate.parse(ev.getDateFin());
        dd.setValue(localDate);
        df.setValue(localDate2);
        //dd.setValue(ev.getDateDebut().to);*/

    }

    int valeurID() {
        Evenement ev = tab_evenement.getSelectionModel().getSelectedItem();

        return ev.getIdEvenement();
    }

    @FXML
    void supprimer(MouseEvent event) throws SQLException {
     final ObservableList<Evenement> listEvenement2 = FXCollections.observableArrayList();
  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText(null);
    alert.setContentText("Vous voulez supprimer club"+nomm+"?");

    ButtonType deleteGame = new ButtonType("Supprimer Club)");
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(deleteGame, buttonTypeCancel);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == deleteGame){
        cs.supprimer(valeurID());
        listEvenement2.addAll(cs.affciher());

        tab_evenement.setItems(listEvenement2);
    }}

    @FXML
    void modifier(MouseEvent event) {
        Evenement ev = tab_evenement.getSelectionModel().getSelectedItem();
    /* final ObservableList<Evenement> listEvenement2 = FXCollections.observableArrayList();

        Evenement ev = new Evenement(dd.getValue().toString(), df.getValue().toString(), Integer.parseInt(idclub.getText()));
        System.out.println(ev);

        try {
            cs.modifier(ev, valeurID());
            listEvenement2.addAll(cs.affciher());

            tab_evenement.setItems(listEvenement2);
          

        } catch (SQLException ex) {
            ex.getMessage();
        }*/try{
                   FXMLLoader loaderr = new FXMLLoader();
               loaderr.setLocation(getClass().getResource("/GUIInterface/ModifierEvenement.fxml"));
               AnchorPane rootLayout = (AnchorPane) loaderr.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               ModifierEvenementController eventController = loaderr.getController();
               eventController.setMainController(this);
               eventController.setData(String.valueOf(ev.getIdEvenement()),ev.getDateDebut(),ev.getDateFin(),ev.getImage()); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
           }

    }

    @FXML
    private void selectioe_image(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showSaveDialog(null);
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        if (selectedFile != null) {
            listView.setText(selectedFile.getAbsolutePath());
        }

    }

    @FXML
    private void ajouter_evenement(ActionEvent event) {
       /*      final ObservableList<Evenement> listEvenement2 = FXCollections.observableArrayList();

        Evenement ev = new Evenement(dd.getValue().toString(), df.getValue().toString(), 0000, listView.getText());
        try {
            cs.ajouter(ev);
            listEvenement2.addAll(cs.affciher());

            tab_evenement.setItems(listEvenement2);
        } catch (SQLException ex) {
            Logger.getLogger(Affciher_EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }*/try {
                      FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("/GUIInterface/AjouterEvenement.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL); 
               Scene scene = new Scene(rootLayout);               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    @FXML
    private void chercher(KeyEvent event) {
         final ObservableList<Evenement> listEvenement2 = FXCollections.observableArrayList();

        search.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                System.out.println(newValue);
                listEvenement2.addAll(cs.recherche(newValue));
                tab_evenement.setItems(listEvenement2);
            } catch (SQLException ex) {
ex.getMessage();            }

        });
    }
}
