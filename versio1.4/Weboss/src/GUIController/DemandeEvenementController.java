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
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import weboss.Entities.DemandeEvenement;
import weboss.Entities.Etudiant;
import weboss.Entities.User;
import weboss.Service.ClubService;
import weboss.Service.DemandeEvenementService;
import weboss.Service.ValidationChamps;

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
    @FXML
    private Label labelDF;
    @FXML
    private Label labelIMG;
    @FXML
    private Label labelDD;
    @FXML
    private Label labelB;
    @FXML
    private Label labelDesc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Date dd = new Date(1, 1, 1);
        Date df = new Date(1, 1, 1);
        date_debut.setValue(dd.toLocalDate());
        date_fin.setValue(dd.toLocalDate());

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
    void ajouter_demande(MouseEvent event)  {
    try { 
        ///////////////////////////////////////////////////////////////////////////////////////////////
        boolean isBudEmpty = ValidationChamps.isTextFieldNotEmpty(budget, labelB,"Empty!");
        boolean isImgEmpty = ValidationChamps.isTextFieldNotEmpty(listView, labelIMG,"Empty!");
        boolean isDescEmpty = ValidationChamps.isTextAreaNotEmpty(desc, labelDesc,"Empty!");
       // boolean isDateDEmpty = ValidationChamps.isDateEqToDate(date_fin,date_debut, labelB,"Is not equals to the other!");
        boolean isDateDDEmpty = ValidationChamps.isDatePickerNotEmpty(date_debut, labelDD,"Empty!");
        boolean isDateDFEmpty = ValidationChamps.isDatePickerNotEmpty(date_fin, labelDF,"Empty!");
        ///////////////////////////////////////////////////////////////////////////////////////////////
        
       // System.out.println("" + Etudiant.etd.getIdUser());
        int id=c.recuperer_id_club(Integer.parseInt( Etudiant.etd.getIdUser()));
        if(!isBudEmpty && !isImgEmpty && !isDescEmpty && !isDateDDEmpty && !isDateDFEmpty)
              {
        String dd = date_debut.getValue().toString();
        String df = date_fin.getValue().toString();
        String descc= desc.getText();
        float b=Float.parseFloat(budget.getText());
        String img=listView.getText();
        Date dd_controle = Date.valueOf(date_debut.getValue());
        Date df_controle = Date.valueOf(date_fin.getValue());

        ev = new DemandeEvenement(id, descc, dd, df, img, b, img);
              
                  System.out.println("aa");
              // des.ajouter(ev);   
              
              }    
            
        }
catch (SQLException ex) {
            System.out.println("exepction");
            }

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
