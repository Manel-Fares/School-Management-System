/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import weboss.Entities.Etudiant;
import weboss.Entities.Note;
import weboss.Service.ServiceNote;
import weboss.Service.ServiceResultat;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class InterfaceParentResultatController implements Initializable {

    @FXML
    private TableView<Note> tanleViewMoyenne;
    @FXML
    private TableColumn<Note, String> nomMatiere;
    @FXML
    private TableColumn<Note, String> moyenne;
    @FXML
    private Button resultat;
    @FXML
    private TextField idEtudiant;
    @FXML
    private TextField res;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nomMatiere.setCellValueFactory(new PropertyValueFactory<>("info"));
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));

         ServiceNote sn = new ServiceNote();
        tanleViewMoyenne.setItems(sn.listeNoteEtudiantinterface(Etudiant.etd.getIdUser()));
        //afficher();

    }

   /* private void afficher() {

        idEtudiant.textProperty().addListener((observable, oldValue, newValue) -> {
            ServiceNote sn = new ServiceNote();
            tanleViewMoyenne.setItems(sn.listeMoyenneNoteEtudiant(newValue));

        });
    }*/

    @FXML
    private void afficherResultat(ActionEvent event) throws SQLException {

        
            ServiceResultat sr = new ServiceResultat();

            float r = sr.getResultat(idEtudiant.getText());
            System.out.println(r);
            res.setText(Float.toString(r));
            System.out.println("    resultat afficher");
     

    }

}
