/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import org.controlsfx.control.Rating;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import weboss.Entities.Club;
import weboss.Entities.Etudiant;
//import weboss.Entities.Rating;
import weboss.Service.*;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class RatingController implements Initializable {

    @FXML
    private GridPane grid;
    double p = 0;
    @FXML
    private AnchorPane root;
    /**
     * Initializes the controller class.
     */
    ClubService cs = new ClubService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        RatingService rs = new RatingService();

        List<Club> lst = new ArrayList<Club>();
        ClubService cb = new ClubService();
        try {
            lst = cb.affciher();
        } catch (SQLException ex) {
            Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
        int j = 0;
        for (Club c : lst) {
            final Rating rating = new Rating();
            try {
                
                    rating.setRating(rs.recuperernbrRating(c.getIdClub()));
                
                // System.out.println("club1 "+rs.recuperernbrRating(cs.recupererListeIDCLub().get(i)));
            } catch (SQLException ex) {
                Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
            }

            rating.setUpdateOnHover(false);
            rating.setPartialRating(false);
            rating.setMax(5);

            rating.setOnMouseClicked(new EventHandler() {
                @Override
                public void handle(Event event) {

                    System.out.println(rating.getRating());
                    p = rating.getRating();

                }
            });
            System.out.println(p);
            VBox vbox = new VBox();
            System.out.println(c.getIdClub());
            Label name = new Label(c.getNomClub());
            Label dmn = new Label(c.getDomaine());
            Button btn = new Button("voter");
            btn.setOnAction((event) -> {
               

                weboss.Entities.Rating rate = new weboss.Entities.Rating();
                rate.setC(c);
                rate.setRating(p);
                rate.setEt(Etudiant.etd);
                RatingService rtd = new RatingService();
                try {
                    if (rs.recupererRateEtudiant(rate.getC().getIdClub(), Integer.parseInt(rate.getEt().getIdUser())) == 0) {
                        rtd.ajouter(rate);
                    } else {
                        rs.modifier(rate, p);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(RatingController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });
            vbox.getChildren().addAll(name, dmn, rating, btn);
            grid.add(vbox, i, j);
            i++;
            if (i == 3) {
                i = 0;
                j++;

            }

        }

    }

}
