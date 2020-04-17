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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import weboss.Entities.Club;
import weboss.Entities.Evenement;
import weboss.Entities.Personnel;
import weboss.Entities.User;
import weboss.Service.EvenementService;
import weboss.Service.ValidationChamps;

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
    @FXML
    private ImageView valid_path;
    @FXML
    private ImageView invalid_path;
    @FXML
    private ImageView valid_f;
    @FXML
    private ImageView invalid_f;
    @FXML
    private Label error_cin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(MouseEvent event) {
          boolean islistViewEmpty = ValidationChamps.isTextFieldNotEmpty(listView, valid_path, invalid_path);

         boolean isdateEmpty = ValidationChamps.isdATE(dd, df, valid_f,invalid_f);
        

     if (!isdateEmpty) {
              
                error_cin.setText("Error Date");
            }

        if (!islistViewEmpty) {
            error_cin.setText("pic");
        }

       
   
        if (islistViewEmpty && isdateEmpty  ) {
            error_cin.setText(null);
        }
        final ObservableList<Evenement> listEvenement2 = FXCollections.observableArrayList();
      //  User u = Personnel.pr;
        Club c = new Club(1);
        Evenement ev = new Evenement(dd.getValue().toString(), df.getValue().toString(), c, listView.getText());
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
