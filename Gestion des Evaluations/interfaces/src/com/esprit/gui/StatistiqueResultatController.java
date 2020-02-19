/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Service.ServiceResultat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

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
        
                ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                
                new PieChart.Data("1er année", 13),
                new PieChart.Data("2eme année", 25),
                new PieChart.Data("3eme année", 10),
                new PieChart.Data("4eme année", 22),
                new PieChart.Data("5eme année", 30));
      
        piechart.setData(pieChartData);
    }    
    
}
