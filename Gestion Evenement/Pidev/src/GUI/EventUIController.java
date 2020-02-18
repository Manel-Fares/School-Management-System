/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import pidev.entities.Club;
import pidev.service.ClubService;
import pidev.service.DemandeEvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EventUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private JFXTextField domaine;

    private JFXTextField nom_club;

    private JFXTextField idResponsable;

    ClubService cs = new ClubService();
    @FXML
    private AnchorPane page_creer_club;
    @FXML
    private Pane bck;
    @FXML
    private Pane sidebar;
    String rolle;
    @FXML
    private Label consulter_demande_club;
    @FXML
    private Label demande_evenement_club;
    private Label club_affichage;
    private Label demandeEvenementaAfichage;
    private Label evenement_affichage;
    @FXML
    private ImageView affichage;
    @FXML
    private ImageView affichage2;
    @FXML
    private ImageView demande;
    @FXML
    private Pane sidebarClub;

    @FXML
    private Pane area;
    @FXML
    private Pane barre;
    DemandeEvenementService devs = new DemandeEvenementService();
    @FXML
    private ImageView notif_admin;
    @FXML
    private Label nbr_notif_admin;
    @FXML
    private Label desc_notif;
    @FXML
    private Pane notification_area;
    @FXML
    private ImageView affichage1;
    @FXML
    private ImageView demande1;
    @FXML
    private ImageView affichage11;
    @FXML
    private JFXButton evenement_organiser;
    @FXML
    private JFXButton btn_eveneemnt;
    @FXML
    private JFXButton btn_consulter_club;
    @FXML
    private JFXButton btn_demande_evenemnt;
    @FXML
    private JFXButton clubEvenement;
    @FXML
    private ImageView stat;

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getRolle() {
        return rolle;
    }
DemandeEvenementService dvs = new DemandeEvenementService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        notif_admin.setVisible(false);
        nbr_notif_admin.setVisible(false);
        stat.setVisible(false);
        notification_area.setVisible(false);
        clubEvenement.setVisible(false);
        affichage.setVisible(false);
        btn_consulter_club.setVisible(false);
        sidebarClub.setVisible(false);
        evenement_organiser.setVisible(false);
        demande_evenement_club.setVisible(false);
        consulter_demande_club.setVisible(false);
        affichage2.setVisible(false);
        btn_demande_evenemnt.setVisible(false);
        btn_eveneemnt.setVisible(false);
        demande.setVisible(false);

        
    }

    void affichage() {
        Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("DemandeEvenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ajouter_club(MouseEvent event) {
        int id = Integer.parseInt(idResponsable.getText());
        Club t = new Club(id, nom_club.getText(), domaine.getText());
        try {
            cs.ajouter(t);
        } catch (SQLException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void afficher_club(MouseEvent event) {
        Parent fxml;
        try {
            System.out.println(getRolle());

            fxml = FXMLLoader.load(getClass().getResource("DemandeEvenement.fxml"));

            area.getChildren().removeAll();
            area.getChildren().setAll(fxml);

            System.out.println(getRolle());
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void demandeEvenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Afficher_Club.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Evenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("afficher_Demande_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void affiche_demabde_evenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("consulter_demande_evenemet.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            sidebarClub.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ajouterEvenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Affciher_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cllub(MouseEvent event) {
        System.out.println(getRolle());
        if (getRolle().equals("root")) {

            notif_admin.setVisible(true);

            nbr_notif_admin.setVisible(true);
            affichage.setVisible(true);
            stat.setVisible(true);
            affichage2.setVisible(true);
            demande.setVisible(true);
            btn_consulter_club.setVisible(true);
            btn_demande_evenemnt.setVisible(true);
            btn_eveneemnt.setVisible(true);
            sidebar.setVisible(true);
            clubEvenement.setVisible(true);
            nbr_notif_admin.setText("" + devs.nombre_demande());
        } else {

            sidebarClub.setVisible(true);
            evenement_organiser.setVisible(true);
            demande_evenement_club.setVisible(true);
            consulter_demande_club.setVisible(true);
        }
    }

    @FXML
    private void evenement(MouseEvent event) {
        System.out.println(getRolle());
        if (getRolle().equals("root")) {
            stat.setVisible(true);
            notif_admin.setVisible(true);

            affichage.setVisible(true);
            nbr_notif_admin.setVisible(true);
            affichage2.setVisible(true);
            demande.setVisible(true);
            btn_consulter_club.setVisible(true);
            btn_demande_evenemnt.setVisible(true);
            btn_eveneemnt.setVisible(true);
            sidebar.setVisible(true);
            nbr_notif_admin.setVisible(true);
            clubEvenement.setVisible(true);
            nbr_notif_admin.setText("" + devs.nombre_demande());
        } else {

            sidebarClub.setVisible(true);
            evenement_organiser.setVisible(true);
            demande_evenement_club.setVisible(true);
            consulter_demande_club.setVisible(true);

        }

    }

    @FXML
    private void evenement_organiser(ActionEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Affichage_evenement_etudiant.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            sidebarClub.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficher_notif(MouseEvent event) {
        int i;
        notification_area.setVisible(true);
        // for(i=0;i<devs.notifiction().size();i++){
        desc_notif.setText(devs.notifiction().toString());
        //}
        /* for(i=0;i<devs.notifiction().size();i++)
              System.out.println(devs.notifiction().get(i));
        {    desc_notif.setText(devs.notifiction().get(i));
        }*/

    }

    @FXML
    private void notification_demande_affichage(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("afficher_Demande_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            notification_area.setVisible(false);

        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void femer_area_notification(MouseEvent event) {
        notification_area.setVisible(false);

    }

    @FXML
    private void Demande_organisation_event_club(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("DemandeEvenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            sidebarClub.setVisible(true);

            notification_area.setVisible(false);

        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affcihe_stat_clubEvenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("ClubPlusActif.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            notification_area.setVisible(false);

        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficher_donne_Club(MouseEvent event) {
         Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Afficher_donneClub.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            notification_area.setVisible(false);

        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


/*  void affichage() {
        Parent fxml;
        Parent fxml1;

        try {        

            // if(getRolle().equals("club")){
            fxml = FXMLLoader.load(getClass().getResource("DemandeEvenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            /*  fxml1 = FXMLLoader.load(getClass().getResource("sidebar.fxml"));
            sidebar.getChildren().removeAll();
            sidebar.getChildren().setAll(fxml1);
              }*/
 /* } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ajouter_club(MouseEvent event) {
        int id = Integer.parseInt(idResponsable.getText());
        Club t = new Club(id, nom_club.getText(), domaine.getText());
        try {
            cs.ajouter(t);
        } catch (SQLException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML

    void afficher_club(MouseEvent event) {
        Parent fxml;
        try {System.out.println(getRolle());

            fxml = FXMLLoader.load(getClass().getResource("DemandeEvenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
            System.out.println(getRolle());
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void demandeEvenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Afficher_Club.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void Evenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("afficher_Demande_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void affiche_demabde_evenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("afficher_Demande_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ajouterEvenement(MouseEvent event) {
        Parent fxml;
        try {
            fxml = FXMLLoader.load(getClass().getResource("Affciher_Evenement.fxml"));
            bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EventUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 */
