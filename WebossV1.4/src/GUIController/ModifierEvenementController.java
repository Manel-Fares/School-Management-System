/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import weboss.Entities.Evenement;
import weboss.Service.EvenementService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierEvenementController implements Initializable {

    @FXML
    private JFXDatePicker dd;
    @FXML
    private JFXDatePicker df;
    @FXML
    private JFXTextField listView;
    Affciher_EvenementController aff;
    EvenementService cs= new EvenementService();
    @FXML
    private Label label;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        label.setVisible(false);
    }    

    @FXML
    private void modifier(MouseEvent event) throws SQLException {
        Evenement ev = new Evenement(dd.getValue().toString(), df.getValue().toString(),listView.getText());
        System.out.println(ev);

        cs.modifier(ev, Integer.valueOf(label.getText()));
        // listEvenement2.addAll(cs.affciher());
        
        //  tab_evenement.setItems(listEvenement2);
    }

    @FXML
    private void selectioe_image(ActionEvent event) {
    }

    @FXML
    private void ModifierAction(ActionEvent event) {
    }

    void setMainController(Affciher_EvenementController aThis) {
            aff=aThis;
    }

    void setData(String id,String dd,String df,String img) {
        this.label.setText(id);
        this.dd.setValue(LocalDate.parse(dd));
        this.df.setValue(LocalDate.parse(df));
        this.listView.setText(img);
    }
    
}
