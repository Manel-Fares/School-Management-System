/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import org.controlsfx.control.Rating;
import weboss.Entities.Etudiant;
import weboss.Service.ClubService;
import weboss.Service.EtudiantService;
import weboss.Service.RatingService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ProdilUserController implements Initializable {

    @FXML
    private JFXButton btnChoisir;
    @FXML
    private Label lNP;
    @FXML
    private Label lAdresse;
    @FXML
    private Label lPoint;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField lAdresseTF;
    @FXML
    private ImageView image;
    @FXML
    private JFXTextField numtel;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField mdp;
    String imgurl, imgpath;

    EtudiantService ser = new EtudiantService();
    private Label star;

    ClubService cs = new ClubService();
    RatingService rs = new RatingService();
    @FXML
    private Label NomClub;
    @FXML
    private Rating rating;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setText(Etudiant.etd.getNomUser());
        prenom.setText(Etudiant.etd.getPrenomUser());
        lNP.setText(Etudiant.etd.getNomUser() + " " + Etudiant.etd.getPrenomUser());

        email.setText(Etudiant.etd.getEmailUser());
        lAdresse.setText(Etudiant.etd.getAdresseUser());
        mdp.setText(Etudiant.etd.getMotDePasseUser());
        if (Etudiant.etd.getClasseEtd() != null) {
            lPoint.setText(Etudiant.etd.getClasseEtd());
        } else {
            lPoint.setText(Etudiant.etd.getSpecialiteEtd());
        }

        String path = "C:\\Users\\Neifos\\Pictures\\Camera Roll\\Weboss\\src\\weboss\\Image\\" + Etudiant.etd.getPicUser();
        File file = new File(path);
        image.setImage(new Image(file.toURI().toString()));
        // TODO
        try {
            if (cs.recupererResponsablExist(Integer.parseInt(Etudiant.etd.getIdUser())) == 0) {
                 NomClub.setVisible(false);

               rating.setVisible(false);
            } else {
                rating.setRating(rs.recuperernbrRating(cs.recuperer_id_club(Integer.parseInt(Etudiant.etd.getIdUser())).getIdClub()));
                NomClub.setText("" + cs.recuperer_id_club(Integer.parseInt(Etudiant.etd.getIdUser())).getNomClub());
                System.out.println(cs.recuperer_id_club(Integer.parseInt(Etudiant.etd.getIdUser())).getIdClub());
                //System.out.println(cs.recuperer_id_club(Integer.parseInt(Etudiant.etd.getIdUser())).getNomClub());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdilUserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void uploadPhoto(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showSaveDialog(null);
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("IMAGE Files", "*.png"));
        if (selectedFile != null) {
            imgurl = selectedFile.getName();
            imgpath = selectedFile.getAbsolutePath();
            File file = new File(imgpath);
            image.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    private void save(ActionEvent event) {

        Etudiant.etd.setNomUser(nom.getText());
        Etudiant.etd.setPrenomUser(prenom.getText());
        Etudiant.etd.setEmailUser(email.getText());
        Etudiant.etd.setMotDePasseUser(mdp.getText());
        System.out.println(imgurl);
        Etudiant.etd.setPicUser(imgurl);
        Etudiant.etd.setAdresseUser(lAdresse.getText());
        imageadd();

        try {
            ser.update(Etudiant.etd);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void imageadd() {
        try {
            String path = "C:\\Users\\Neifos\\Pictures\\Camera Roll\\Weboss\\src\\weboss\\Image\\" + imgurl;
            File org = new File(imgpath);
            File org1 = new File(path);
            Files.copy(org.toPath(), org1.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(EspaceEnseignantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
