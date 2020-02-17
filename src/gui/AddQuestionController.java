/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Question;
import Service.ServiceQuestion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author bensl
 */
public class AddQuestionController implements Initializable {

    
    @FXML
    public TextArea txtQBody;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
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
