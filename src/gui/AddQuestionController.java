/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Question;
import Service.ServiceQuestion;
import Service.ServiceTag;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bensl
 */
public class AddQuestionController implements Initializable {

    
    @FXML
    public TextArea txtQBody;
    @FXML
    private Button btnAddQ;
    @FXML
    private TextField txtQTitle;
    @FXML
    private ComboBox<String> combotag;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtQTitle.setText(String.valueOf(Question.q));
        ServiceTag tq= new ServiceTag();
        try {
            combotag.setItems(tq.readNom());
        } catch (SQLException ex) {
            Logger.getLogger(AddQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    
    @FXML
    public void GUIAddQ() {
        try {
            
            String txtBody = txtQBody.getText();
            ServiceQuestion serQ = new ServiceQuestion();
            //Question q = new Question(8, txtBody, 4, 2, 1);
            Question q2 = new Question(txtBody, 1, 1, 1);
            serQ.ajouter(q2);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
