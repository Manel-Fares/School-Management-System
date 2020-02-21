/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Service.ServiceResultat;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class StatistiqueResultatController implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private BarChart<String, String> chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            try {
                ServiceResultat sr= new ServiceResultat();
                
                ObservableList<PieChart.Data> pieChartData =
                        FXCollections.observableArrayList(
                                
                                new PieChart.Data("pourcentage de réussite", sr.PourcentageReussiteEcole()),
                                new PieChart.Data("Pourcentage d'écheance",sr.PourcentageEcheanceEcole()));
                
                
                
                
                
                piechart.setData(pieChartData);
            } catch (SQLException ex) {
                
            }
            ServiceResultat sr= new ServiceResultat();
            XYChart.Series set1 = new XYChart.Series<>();
            
            set1.getData().add(new XYChart.Data<>("1",Float.toString(sr.PourcentageReussiteparClasse("1"))));
            set1.getData().add(new XYChart.Data<>("2",Float.toString(sr.PourcentageReussiteparClasse("2"))));
            set1.getData().add(new XYChart.Data<>("3",Float.toString(sr.PourcentageReussiteparClasse("3"))));
            set1.getData().add(new XYChart.Data<>("4",Float.toString(sr.PourcentageReussiteparClasse("4"))));
            set1.getData().add(new XYChart.Data<>("5",Float.toString(sr.PourcentageReussiteparClasse("5"))));
            
            chart.getData().addAll(set1);
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueResultatController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }    
    
}
