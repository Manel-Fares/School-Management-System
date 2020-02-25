/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import weboss.Entities.Etudiant;
import weboss.Service.ClubService;
import weboss.Service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AcceuilEtudiantController implements Initializable {

    @FXML
    private Pagination pagination;
    private Pane sousMenuEvenemet;
    @FXML
    private JFXButton reclamation;

    @FXML
    private Pane bck;
    @FXML
    private AnchorPane bckacceuiletudiant;
    @FXML
    private Pane bck1;

    /**
     * Initializes the controller class.
     */
    ClubService cs=new ClubService();
    @FXML
    private MenuButton evenmentMenu;
    @FXML
    private Pane bck_Rating;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          try {
            System.out.println("aaa "+cs.recupererResponsablExist(Integer.parseInt( Etudiant.etd.getIdUser())));
            if(cs.recupererResponsablExist(Integer.parseInt( Etudiant.etd.getIdUser()))==0)
            {
                evenmentMenu.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcceuilEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }

        afficherAfficheEvenement();
        affichageRating();
 
    }
//omar.jmai@esprit.tn
    void affichage(String x)  {
        Parent fxml;
      
       

        try {
            fxml = FXMLLoader.load(getClass().getResource(x));
             bck.getChildren().removeAll();
            bck.getChildren().setAll(fxml);

        } catch (IOException ex) {
            Logger.getLogger(AcceuilEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
 void affichageRating()  {
        Parent fxml;
      
       

        try {
            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/rating.fxml"));
             bck_Rating.getChildren().removeAll();
            bck_Rating.getChildren().setAll(fxml);

        } catch (IOException ex) {
            Logger.getLogger(AcceuilEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    public void afficherAfficheEvenement() {
       EvenementService dev = new EvenementService();
        ArrayList<String> images = new ArrayList<>();
        try {
            System.out.println("image path:" + dev.recpererImage());

            //images.addAll(dev.recpererImage());
            //System.out.println(images);
            for (int i = 0; i < dev.recpererImage().size(); i++) {

                final String imageURI = new File(dev.recpererImage().get(i)).toURI().toString();
                System.out.println(imageURI);
                images.add(imageURI);
                // images.add(imageURI);
            }
            /*images.add("/GUI/1.jpg");
            images.add("/GUI/1.jpg");*/
        } catch (SQLException ex) {
            ex.getMessage();
        }

        pagination.setPageCount(images.size());
        pagination.setPageFactory(n -> new ImageView(images.get(n)));
    }

    //////////
   

   

    @FXML
    private void logout(MouseEvent event) {
         Parent fxml;

        try {

            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/Login.fxml"));
            bckacceuiletudiant.getChildren().removeAll();
            bckacceuiletudiant.getChildren().setAll(fxml);

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

  


 

    @FXML
    private void AbsenceAction(ActionEvent event) {
        affichage("/GUIInterface/AbsenceEtudiant.fxml");
    }

    @FXML
    private void Credits(ActionEvent event) {
                affichage("/GUIInterface/creditEtudiant.fxml");

    }

    @FXML
    private void Notes(ActionEvent event) {
                affichage("/GUIInterface/interfaceEtudiantNote.fxml");

    }

    @FXML
    private void AnnualResults(ActionEvent event) {
                affichage("/GUIInterface/interfaceEtudiantResultat.fxml");

    }

    @FXML
    private void QA(MouseEvent event) {
                        affichage("/GUIInterface/listQuestion.fxml");

    }

    @FXML
    private void reclamation(ActionEvent event) {
        affichage("/GUIInterface/Reclamation.fxml");
    }

    @FXML
    private void profil(ActionEvent event) {
         affichage("/GUIInterface/ProfilEtudiant.fxml");
    }

    @FXML
    private void demandeevenement(ActionEvent event) {
                 affichage("/GUIInterface/DemandeEvenement.fxml");

    }

    @FXML
    private void consulterDemande(ActionEvent event) {
                 affichage("/GUIInterface/consulter_demande_evenemet.fxml");

    }

    @FXML
    private void home(MouseEvent event) {
  Parent fxml;
      
       

        try {
            fxml = FXMLLoader.load(getClass().getResource("/GUIInterface/AcceuilEtudiant.fxml"));
             bckacceuiletudiant.getChildren().removeAll();
            bckacceuiletudiant.getChildren().setAll(fxml);

        } catch (IOException ex) {
            Logger.getLogger(AcceuilEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


   

}
