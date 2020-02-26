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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import weboss.Entities.Enseignant;
import weboss.Entities.Matiere;
import weboss.Service.EnseignantService;
import weboss.Service.ServiceMatier;

/**
 * FXML Controller class
 *
 * @author bouch
 */
public class AffecterMatierEnseignantController implements Initializable {

    @FXML
    private JFXComboBox<String> sub;
    @FXML
    private JFXComboBox<String> tea;
    ServiceMatier sm=new ServiceMatier();
    EnseignantService sp=new EnseignantService();
    @FXML
    private TableView<?> tab;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
         List<String> st = sm.getMat();
         int i=sub.getSelectionModel().getSelectedIndex();
         int id = Integer.parseInt(st.get(i).substring(0, st.get(i).indexOf(" ")));
         System.out.println(id);
         Matiere m=sm.findById(id);
         System.out.println(m.getIdMatiere());
       List<Enseignant> st2 = sp.readAll();
         int i2=tea.getSelectionModel().getSelectedIndex();
         String id2 =  st2.get(i2).getIdUser();
         m.setResponsable((Enseignant) sp.findById(id2));
        try {
            sm.update(m);
        } catch (Exception ex) {
            System.out.println("update error ");
        }
    }

    @FXML
    private void afficher(ActionEvent event) {
    }
    
}
