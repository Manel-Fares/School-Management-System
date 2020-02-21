/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Question;
import Service.ServiceQuestion;
import Service.ServiceTag;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;

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
    
    @FXML
    private Button btnReturn;
    @FXML
    private AnchorPane rootPan;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //txtQTitle.setText(String.valueOf(Question.q));
        ServiceTag tq= new ServiceTag();
        try {
            combotag.setItems(tq.readNom());
        } catch (SQLException ex) {
            Logger.getLogger(AddQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        passage();
        
        
 
        
    }    
    
    
    @FXML
    public void GUIAddQ() {
        try {
            
            String txtBody = txtQBody.getText();
            String txtTitle = txtQTitle.getText();
            String txtTagName = combotag.getValue();
            ServiceQuestion serQ = new ServiceQuestion();
            //Question q = new Question(8, txtBody, 4, 2, 1);
            Question q2 = new Question(txtBody, 1, 1, 1, txtTitle, txtTagName);
            //serQ.ajouter(q2);
            serQ.ajouter2(q2);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void passage(){
    btnReturn.setOnAction(new EventHandler() {
        @Override
        public void handle(Event event) {
            try {
                AnchorPane pane =FXMLLoader.load(getClass().getResource("listQuestion.fxml"));
                rootPan.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(ListQuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    }
    

    
}
