/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import weboss.Service.ServiceResultat;


/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class StatistiqueResultatController implements Initializable {

    @FXML
    private PieChart piechart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceResultat sr= new ServiceResultat();
            
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            
                            new PieChart.Data("Success Rate", sr.PourcentageReussiteEcole()),
                            new PieChart.Data("Failure Rate",sr.PourcentageEcheanceEcole()));
            
            piechart.setData(pieChartData);
        } catch (SQLException ex) {
            
        }
    }    
    
}
