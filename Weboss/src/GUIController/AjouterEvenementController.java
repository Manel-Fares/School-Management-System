/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import weboss.Entities.Evenement;
import weboss.Service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouterEvenementController implements Initializable {

    @FXML
    private JFXDatePicker dd;
    @FXML
    private JFXDatePicker df;
    @FXML
    private JFXTextField listView;
    EvenementService cs = new EvenementService();
    @FXML
    private AnchorPane rootPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(MouseEvent event) {
        final ObservableList<Evenement> listEvenement2 = FXCollections.observableArrayList();

        Evenement ev = new Evenement(dd.getValue().toString(), df.getValue().toString(), 0000, listView.getText());
        try {
            cs.ajouter(ev);
            listEvenement2.addAll(cs.affciher());

            //tab_evenement.setItems(listEvenement2);
        } catch (SQLException ex) {
            Logger.getLogger(Affciher_EvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void selectImage(MouseEvent event) {
           FileChooser fc = new FileChooser();
        File selectedFile = fc.showSaveDialog(null);
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        if (selectedFile != null) {
            listView.setText(selectedFile.getAbsolutePath());
        }
    }
    
}
