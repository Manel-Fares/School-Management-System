/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;


import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import weboss.Entities.Chapitre;
import weboss.Service.ServiceChapitre;
import weboss.Service.ServiceMatier;

/**
 * FXML Controller class
 *
 * @author bouch
 */
public class AfficherChapitreController implements Initializable {

    private TableView<Chapitre> tab;
    @FXML
    private ComboBox<String> m;
    ServiceChapitre sc=new ServiceChapitre();
    ServiceMatier sm = new ServiceMatier();
    @FXML
    private ScrollPane scp;
    /**
     * Initializes the controller class.
     */    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       try {
            List<String> st2 = new ArrayList<>();
            List<String> st = sm.getMat();
            for (int i = 0; i < st.size(); i++) {
                st2.add(st.get(i).substring(st.get(i).indexOf(" ") + 1));
            }
            m.getItems().addAll(st2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        

       
    }    

    @FXML
    private void supp(ActionEvent event) {
    int selectedIndex = tab.getSelectionModel().getSelectedIndex();
        ObservableList<Chapitre> data2 = FXCollections.observableArrayList();
        if (selectedIndex >= 0) {

            Chapitre n = (Chapitre) tab.getSelectionModel().getSelectedItem();

            try {
                sc.delete(n);
                List<Chapitre> lm = sc.readAll();
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
         Chapitre q = tab.getSelectionModel().getSelectedItem();
         List<String> st = sm.getMat();
         int i=m.getSelectionModel().getSelectedIndex();
         int id = Integer.parseInt(st.get(i).substring(0, st.get(i).indexOf(" ")));
         q.setMatier(sm.findById(id));
        try {
            sc.update(q);
            loadData();
        } catch (SQLException ex) {
            System.out.println("update error ");
        }
    }

    @FXML
    private void ret(ActionEvent event) {
    }

    private void loadData() {
    ObservableList<Chapitre> data = FXCollections.observableArrayList();
        data.clear();
        try {
            List<Chapitre> lq = sc.readAll();
            for (int i = 0; i < lq.size(); i++) {
                data.add(lq.get(i));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       tab.setItems(data);
    }

    @FXML
    private void findchapbysub(ActionEvent event) throws SQLException {
         List<String> st = sm.getMat();
         int i=m.getSelectionModel().getSelectedIndex();
         int id = Integer.parseInt(st.get(i).substring(0, st.get(i).indexOf(" ")));
         
        
        GridPane grid=new GridPane();
        ScrollBar sb = new ScrollBar();
        sb.setOrientation(Orientation.VERTICAL);
        grid.setVgap(10);
        grid.setHgap(10);
        try {
            List<String> ls = sc.getchapsofsubj(sm.findById(id).getIdMatiere());
            int y=0;
            for(int j=0; j<ls.size();j++){
                if (y==3){
                    y=0;
                }
                Pane p= new Pane();
                Label l = new Label(ls.get(j));
                Button b=new Button();
                String s=ls.get(j);
                EventHandler<ActionEvent> event2 =new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            File f=new File(s);
                            Desktop.getDesktop().open(f);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }; 
                b.setOnAction(event2);
                p.getChildren().addAll(l,b);
                grid.add(p, y,j/3);
                y++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
       
 
        // Set content for ScrollPane
        scp.setContent(grid);
 
        // Always show vertical scroll bar
        scp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
    
}



