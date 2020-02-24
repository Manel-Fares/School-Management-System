/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import service.AbsenceService;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class StatController implements Initializable {

    @FXML
    private BarChart<?, ?> chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        AbsenceService as = new AbsenceService();
        XYChart.Series set1 = new XYChart.Series<>();
        for(int i=0 ; i< as.StatNbrAbsence().size();i++){
        set1.getData().add(new XYChart.Data<>(as.StatNomAbsence().get(i),as.StatNbrAbsence().get(i)));
        }
        chart.getData().addAll(set1);
    }    
    
    
    
}
