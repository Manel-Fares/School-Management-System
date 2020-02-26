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
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import weboss.Entities.Enseignant;
import weboss.Entities.Matiere;
import weboss.Service.EnseignantService;
import weboss.Service.ServiceMatier;

/**
 * FXML Controller class
 *
 * @author bouch
 */
public class AfficherMatierController implements Initializable {

    @FXML
    private TableView<Matiere> tab;
    @FXML
    private ComboBox<String> res;
    ServiceMatier sm= new ServiceMatier();
    EnseignantService sp = new EnseignantService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       TableColumn<Matiere,String> q=new TableColumn<Matiere,String>("Subject name");
       q.setCellValueFactory(new PropertyValueFactory<>("nom"));
       TableColumn<Matiere,String> qui=new TableColumn<Matiere,String>("Head of Subject");
       qui.setCellValueFactory(new Callback<CellDataFeatures<Matiere,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<Matiere, String> param) {
                    if (param.getValue().getResponsable()!=null)
                    return new SimpleStringProperty(param.getValue().getResponsable().getNomUser()+" "+param.getValue().getResponsable().getPrenomUser());
                    else 
                        return new SimpleObjectProperty();
                }
            });
       ObservableList<Matiere> data = FXCollections.observableArrayList();

        try {
            List<Matiere> lq = sm.readAll();
            for (int i = 0; i < lq.size(); i++) {
                data.add(lq.get(i));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
       tab.getColumns().addAll(q,qui);
       tab.setItems(data);
       try {
            List<String> st2 = new ArrayList<>();
            List<Enseignant> st = sp.readAll();
            for (int i = 0; i < st.size(); i++) {
                st2.add(st.get(i).getPrenomUser()+""+st.get(i).getNomUser());
            }
            res.getItems().addAll(st2);
        } catch (SQLException ex) {
ex.getMessage();        }

       
    }    

    @FXML
    private void supp(ActionEvent event) {
    int selectedIndex = tab.getSelectionModel().getSelectedIndex();
        ObservableList<Matiere> data2 = FXCollections.observableArrayList();
        if (selectedIndex >= 0) {

            Matiere n = (Matiere) tab.getSelectionModel().getSelectedItem();

            try {
                sm.delete(n);
                List<Matiere> lm = sm.readAll();
                for (int i = 0; i < lm.size(); i++) {
                    data2.add(lm.get(i));
                }
                tab.setItems(data2);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {
         Matiere q = tab.getSelectionModel().getSelectedItem();
         List<Enseignant> st = sp.readAll();
         int i=res.getSelectionModel().getSelectedIndex();
         String  id = st.get(i).getIdUser();
         q.setResponsable((Enseignant) sp.findById(id));
        try {
            sm.update(q);
            loadData();
        } catch (Exception ex) {
            System.out.println("update error ");
        }
    }

    @FXML
    private void ret(ActionEvent event) {
    }

    private void loadData() {
    ObservableList<Matiere> data = FXCollections.observableArrayList();
        data.clear();
        try {
            List<Matiere> lq = sm.readAll();
            for (int i = 0; i < lq.size(); i++) {
                data.add(lq.get(i));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       tab.setItems(data);
    }
    

}
