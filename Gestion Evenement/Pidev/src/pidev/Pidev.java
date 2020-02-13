/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pidev.entities.Club;
import pidev.entities.DemandeEvenement;
import pidev.entities.Evenement;
import pidev.service.ClubService;
import pidev.service.DemandeEvenementService;
import pidev.service.EvenementService;

/**
 *
 * @author asus
 */
public class Pidev extends Application {

    @Override
    public void start(Stage primaryStage) {
        String dd = "2013-02-24";
        String df = "2021-02-24";
        ClubService cs = new ClubService();
        Club c = new Club(11, 222, "eezzze", "aa");
        Evenement ev = new Evenement(dd, df, 10214);
        EvenementService evs = new EvenementService();
        DemandeEvenement db = new DemandeEvenement(1112, "club club clubb event", dd, df);
        DemandeEvenementService dvs = new DemandeEvenementService();

        try {
            //cs.ajouter(c);
            //cs.modifier(c, 72);
            //cs.supprimer(6);
            //System.out.println(cs.affciher());
            System.out.println("***************");
           // dvs.modifier(db, 8);
            //dvs.supprimer(10);
            System.out.println("***************");
            evs.modifier(ev,11);
            /* try {
            System.out.println(cs.affciher());
            } catch (SQLException ex) {
            Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML1.fxml"));
            Scene scene = new Scene(root, 1000, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
        }

        //primaryStage.setTitle("Hello World!");
        /*  try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Pidev.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
