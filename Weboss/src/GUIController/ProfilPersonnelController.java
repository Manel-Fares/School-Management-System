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

import weboss.Entities.Personnel;

import weboss.Service.PersonnelService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ProfilPersonnelController implements Initializable {

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

    
          PersonnelService ser = new PersonnelService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setText(Personnel.pr.getNomUser());
        prenom.setText(Personnel.pr.getPrenomUser());
        cin.setText(String.valueOf(Personnel.pr.getCinUser()));
        email.setText(Personnel.pr.getEmailUser());
        adresse.setText(Personnel.pr.getAdresseUser());
        mdp.setText(Personnel.pr.getMotDePasseUser());
         dateN.setValue(Personnel.pr.getDateNaissanceUser().toLocalDate());
                 String path = "C:\\Users\\Neifos\\Pictures\\Camera Roll\\Weboss\\src\\weboss\\Image\\"+Personnel.pr.getPicUser();
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
        System.out.println("ccddd");
            System.out.println(imgurl);
         Personnel.pr.setNomUser(nom.getText());
         Personnel.pr.setPrenomUser(prenom.getText());
         Personnel.pr.setCinUser(parseInt(cin.getText()));
         Personnel.pr.setEmailUser(email.getText());
         Personnel.pr.setMotDePasseUser(mdp.getText());
         Personnel.pr.setPicUser(imgurl);
         Personnel.pr.setAdresseUser(adresse.getText());
         Personnel.pr.setDateNaissanceUser(Date.valueOf(dateN.getValue()));
         
         
        try {
            ser.update(Personnel.pr,Personnel.pr.getIdUser());
         
            
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
