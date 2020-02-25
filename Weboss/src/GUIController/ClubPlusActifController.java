/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import weboss.Service.ClubService;
import weboss.Service.EvenementService;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class ClubPlusActifController implements Initializable {
    
    @FXML
    private TableView<Map.Entry<String, String>> tab;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> nomClb;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> nbr;

    /**
     * Initializes the controller class.
     */
    EvenementService evs = new EvenementService();
    ClubService cs = new ClubService();
    int i;
    private final ObservableList<Map.Entry<String, String>> listEvenement = FXCollections.observableArrayList();
    @FXML
    private Label nom_club;
    private Label nbr_evenement;
    @FXML
    private Label pourcentage;
    @FXML
    private Label nbr_evenement_organiser;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    
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
ex.getMessage();

    }
        
        
        
        
        
        
        // TODO
        nomClb.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//this callback returns property for just one cell, you can't use a loop here
//for first column we use key
                return new SimpleStringProperty(p.getValue().getKey());
            }
        });
        nbr.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//for second column we use value
                return new SimpleStringProperty(p.getValue().getValue());
            }
        });
        try {
            for (i = 0; i < cs.recuperer_id_clubs().size(); i++) {
                int x = cs.recuperer_id_clubs().get(i);
                System.out.println(x);
                listEvenement.addAll(evs.nbrEvenementClub(x).entrySet());
                tab.setItems(listEvenement);
                tab.getColumns().setAll(nomClb, nbr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClubPlusActifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void select(MouseEvent event) throws SQLException {
        
        nom_club.setText(tab.getSelectionModel().getSelectedItem().getKey());
        nbr_evenement_organiser.setText(tab.getSelectionModel().getSelectedItem().getValue());
        int x = Integer.parseInt(tab.getSelectionModel().getSelectedItem().getValue());
        int y = evs.nbr_evenementTotale();
        float pr = ((float) x / y) * 100;
        pourcentage.setText(""+pr+"%");
        
    }
    
}
