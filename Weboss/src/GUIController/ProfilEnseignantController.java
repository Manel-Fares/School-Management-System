/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import weboss.Entities.Enseignant;

import weboss.Entities.Personnel;
import weboss.Service.EnseignantService;

import weboss.Service.PersonnelService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ProfilEnseignantController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField cin;
    @FXML
    private JFXDatePicker dateN;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField mdp;
    @FXML
    private JFXTextField adresse;
    String imgurl,imgpath;

    
          EnseignantService ser = new EnseignantService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setText(Enseignant.ensg.getNomUser());
        prenom.setText(Enseignant.ensg.getPrenomUser());
        cin.setText(String.valueOf(Enseignant.ensg.getCinUser()));
        email.setText(Enseignant.ensg.getEmailUser());
        adresse.setText(Enseignant.ensg.getAdresseUser());
        mdp.setText(Enseignant.ensg.getMotDePasseUser());
         dateN.setValue(Enseignant.ensg.getDateNaissanceUser().toLocalDate());
                 String path = "C:\\Users\\Neifos\\Pictures\\Camera Roll\\Weboss\\src\\weboss\\Image\\"+Enseignant.ensg.getPicUser();
                 File file = new File(path);
                image.setImage(new Image(file.toURI().toString()));
        // TODO
    }    

    @FXML
    private void img(ActionEvent event) {
           FileChooser fc=new FileChooser();
        File selectedFile= fc.showSaveDialog(null);
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter ("IMAGE Files","*.png"));
        if(selectedFile !=null)
        {
            imgurl=selectedFile.getName();
             imgpath = selectedFile.getAbsolutePath();
            File file = new File(imgpath);
            image.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    private void save(ActionEvent event) {
            
         Enseignant.ensg.setNomUser(nom.getText());
         Enseignant.ensg.setPrenomUser(prenom.getText());
         Enseignant.ensg.setCinUser(parseInt(cin.getText()));
         Enseignant.ensg.setEmailUser(email.getText());
         Enseignant.ensg.setMotDePasseUser(mdp.getText());
         Enseignant.ensg.setPicUser(imgurl);
         Enseignant.ensg.setAdresseUser(imgurl);
         Enseignant.ensg.setDateNaissanceUser(Date.valueOf(dateN.getValue()));
         
         
        try {
            ser.update(Enseignant.ensg,Enseignant.ensg.getIdUser());
         
            
        } catch (Exception ex) {
            System.out.println("update error ");
        }
    }
       public void imageadd(){
        try {
            String path = "C:\\Users\\Neifos\\Pictures\\Camera Roll\\Weboss\\src\\weboss\\Image\\"+imgurl;
            File org = new File(imgpath);
            File org1 = new File(path);
            Files.copy(org.toPath(), org1.toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(EspaceEnseignantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
