/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import weboss.Entities.Enseignant;
import weboss.Entities.Matiere;
import weboss.Entities.teaching;
import weboss.Service.EnseignantService;
import weboss.Service.ServiceMatier;
import weboss.Service.TeachingService;

/**
 * FXML Controller class
 *
 * @author bouch
 */
public class AffecterMatierEnseignantController1 implements Initializable {

    @FXML
    private JFXComboBox<String> sub;
    @FXML
    private JFXComboBox<String> tea;
    ServiceMatier sm=new ServiceMatier();
    EnseignantService sp=new EnseignantService();
    TeachingService ts=new TeachingService();
    @FXML
    private TableView<teaching> tab;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                TableColumn<teaching,String> t=new TableColumn<teaching,String>("Teacher");
       t.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<teaching,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<teaching, String> param) {
                    if (param.getValue().getM().getResponsable()!=null)
                    return new SimpleStringProperty(param.getValue().getM().getResponsable().getNomUser()+" "+param.getValue().getM().getResponsable().getPrenomUser());
                    else 
                        return new SimpleObjectProperty();
                }
            });
       
        TableColumn<teaching,String> s=new TableColumn<teaching,String>("Subject");
       s.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<teaching,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<teaching, String> param) {
                    if (param.getValue().getM().getNomMatiere()==null) 
                        return new SimpleObjectProperty();
                    else 
                        return new SimpleStringProperty(param.getValue().getM().getNomMatiere());
                }
            });
       tab.getColumns().addAll(t,s);
        // TODO
               try {
            List<String> st2 = new ArrayList<>();
            List<String> st = sm.getMat();
            for (int i = 0; i < st.size(); i++) {
                st2.add(st.get(i).substring(st.get(i).indexOf(" ") + 1));
            }
            sub.getItems().addAll(st2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            try {
            List<String> st2 = new ArrayList<>();
            List<Enseignant> st = sp.readAll();
            for (int i = 0; i < st.size(); i++) {
                st2.add(st.get(i).getNomUser()+" "+st.get(i).getPrenomUser());
            }
            tea.getItems().addAll(st2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    @FXML
    private void affecter(ActionEvent event) throws SQLException {
         //////////////////
         List<String> st = sm.getMat();
         int i=sub.getSelectionModel().getSelectedIndex();
         int id = Integer.parseInt(st.get(i).substring(0, st.get(i).indexOf(" ")));
         System.out.println(id);
         Matiere m=sm.findById(id);
         ///////////////////////////////
         List<Enseignant> st3 = sp.readAll();
         int i3=tea.getSelectionModel().getSelectedIndex();
         String id3 =st3.get(i).getIdUser();
         System.out.println(id);
         Enseignant e2=(Enseignant) sp.findById(id3);
         List<Enseignant> st2 = sp.readAll();
         ///////////
         int i2=tea.getSelectionModel().getSelectedIndex();
         String id2 = st2.get(i2).getIdUser();
         m.setResponsable((Enseignant) sp.findById(id2));
         TeachingService ts=new TeachingService();
         try {
             ts.ajouter(m,e2);
        } catch (Exception ex) {
            System.out.println("update error ");
        }
    }

    @FXML
    private void afficher(ActionEvent event) {
              ObservableList<teaching> data = FXCollections.observableArrayList();
             
        try {
            
            List<teaching> lq = ts.readAll();
            for (int i = 0; i < lq.size(); i++) {
                data.add(lq.get(i));
                System.out.println(lq.get(i));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
       tab.setItems(data);
       
        
    }
    
}
