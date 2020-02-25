/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import weboss.Entities.DemandeEvenement;
import weboss.Entities.Etudiant;
import weboss.Entities.User;
import weboss.Service.ClubService;
import weboss.Service.DemandeEvenementService;

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
    private JFXTextField budget;
    @FXML
    private JFXButton b;
    @FXML
    private JFXButton select_img;
    @FXML
    private JFXTextField listView;
//int identifiant=FXML1Controller.getIdentifiant();
ClubService c=new ClubService();

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
    
       // System.out.println("" + Etudiant.etd.getIdUser());
        int id=c.recuperer_id_club(Integer.parseInt( Etudiant.etd.getIdUser()));
        String dd = date_debut.getValue().toString();
        String df = date_fin.getValue().toString();
        String descc= desc.getText();
        float b=Float.parseFloat(budget.getText());
        String img=listView.getText();
        ev = new DemandeEvenement(id, descc, dd, df, img, b, img);
        des.ajouter(ev);
        

    }

    @FXML
    private void selectioe_image(ActionEvent event) {
        FileChooser fc=new FileChooser();
        File selectedFile= fc.showSaveDialog(null);
        fc.getExtensionFilters().addAll(new ExtensionFilter ("PDF Files","*.pdf"));
        if(selectedFile !=null)
        {
            listView.setText(selectedFile.getAbsolutePath());
        }
        
    }

}
