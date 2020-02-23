/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import project.entities.Enseignant;
import project.entities.Etudiant;
import project.service.EnseignantService;
import project.service.UserService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class ChartUserController implements Initializable {

    @FXML
    private BarChart<?, ?> salary;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private PieChart User;
    public ObservableList<Enseignant> list = FXCollections.observableArrayList();
     public ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList();

                  EnseignantService ser = new EnseignantService();
                  UserService ser1 = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(ChartUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        XYChart.Series set1 = new XYChart.Series<>();
        for(int i=0 ; i< list.size();i++){
        set1.getData().add(new XYChart.Data<>(list.get(i).getNomUser(),list.get(i).getSalaireEnsg()));
        }
        salary.getData().addAll(set1);
        try {
            pieChart.add(new PieChart.Data("Enseignant",ser1.getNombreEnseignant()));
            pieChart.add(new PieChart.Data("Etudiant",ser1.getNombreEtudiant()));
            pieChart.add(new PieChart.Data("Staff Administarif",ser1.getNombrePersonnel()));
            pieChart.add(new PieChart.Data("Parent",ser1.getNombreParent()));
           User.setData(pieChart);
            User.setTitle("Number of Users");
            
            
            
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ChartUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void back(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Home.fxml"));
              javafx.scene.Parent root;
        try {
            root = loader.load();
            HomeController apc = loader.getController();
                
                x.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(EspacePersonnelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
