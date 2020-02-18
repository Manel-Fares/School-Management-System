/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import pidev.service.ClubService;
import pidev.service.EvenementService;

/**
 *
 * @author asus
 */
public class SatatistiqueController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    EvenementService evs = new EvenementService();
    ClubService cs = new ClubService();
    int i;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
       
            try {
            // TODO
            
              for (i = 0; i < cs.recuperer_id_clubs().size(); i++) {
                   System.out.println(cs.recuperer_id_clubs().get(i));
            for (Map.Entry<String, String> entry : evs.nbrEvenementClub(cs.recuperer_id_clubs().get(i)).entrySet()) {
               System.out.println(entry.getKey());
                            

               System.out.println(entry.getValue());
                XYChart.Series set = new XYChart.Series<>();
                set.getData().add(new XYChart.Data<>(entry.getKey(),Integer.parseInt(entry.getValue())));
                
                
                barChart.getData().addAll(set);
            }}
            } catch (SQLException ex) {
            Logger.getLogger(SatatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        

    }

}}
