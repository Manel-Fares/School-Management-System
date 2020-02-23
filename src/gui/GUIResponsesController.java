/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entite.Reponse;
import Entite.Question;
import Service.ServiceReponse;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author bensl
 */
public class GUIResponsesController implements Initializable {

    @FXML
    private Button btnRadd;
    @FXML
    private Button btnRreturn;
    @FXML
    private AnchorPane rootPan;
    @FXML
    private TextArea txtAreaR;
    @FXML
    private VBox vboxR;
    @FXML
    private Pagination pagR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //String qIndex = String.valueOf(Question.q);
        int qIndex = Question.q;
        
        
        //System.out.println("");
        
        
        ServiceReponse serR = new ServiceReponse();
        
        try {
            pagR.setPageCount(serR.findResponseByQuestion(qIndex).size());
        } catch (SQLException ex) {
            Logger.getLogger(GUIResponsesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //pagR.setPageFactory(n -> new TextArea());
        
//        pagR.setPageFactory((pageIndex) -> {
//            
//            TextArea txtA = new TextArea();
//            try {
//                for (int i = 0; i < serR.findResponseByQuestion(qIndex).size(); i++) {
//                //    txtA = new TextArea();
//                    txtAreaR.setText(serR.findResponseByQuestion(i).toString());
//                    System.out.println(serR.findResponseByQuestion(i).toString());
//                    txtA=txtAreaR;
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(GUIResponsesController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            return new VBox(txtA);
////        });
      /*  List<String> content = new ArrayList<>();
        try {
            content= serR.findResponseByQuestion(qIndex);
            System.out.println(content);
            pagR.setPageFactory(n -> {
                return newcontent.get(0);
            });
        } catch (SQLException ex) {
            Logger.getLogger(GUIResponsesController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       ServiceReponse dev = new ServiceReponse();
        ArrayList<String> images = new ArrayList<>();
        try {
            System.out.println("image path:" + dev.findResponseByQuestion(Question.q));

            //images.addAll(dev.recpererImage());
            //System.out.println(images);
            for (int i = 0; i < dev.findResponseByQuestion(Question.q).size(); i++) {
                
               // final String imageURI = new File(dev.recpererImage().get(i)).toURI().toString();
              //  System.out.println(imageURI);
                images.add(dev.findResponseByQuestion(Question.q).get(i).toString());
                // images.add(imageURI);
            }
            /*images.add("/GUI/1.jpg");
            images.add("/GUI/1.jpg");*/
        } catch (SQLException ex) {
            Logger.getLogger(GUIResponsesController.class.getName()).log(Level.SEVERE, null, ex);
        }

        pagR.setPageCount(images.size());
        pagR.setPageFactory(n -> new Label(images.get(n)));

        //pagR.setPageFactory(n -> new TextArea(content.get(n)));
        //System.out.println(content);
        
        passageReturn();
    }    

    @FXML
    private void GUIAddR(ActionEvent event) throws SQLException {
        int qIndex = Question.q;
        String txtBody = txtAreaR.getText();
        ServiceReponse serR = new ServiceReponse();
        Reponse r1 = new Reponse(txtBody, 0, qIndex);
        serR.ajouter2(r1);
    }
    
    public void passageReturn(){
    btnRreturn.setOnAction(new EventHandler() {
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
    
    int qIndex = Question.q;
    ServiceReponse serR = new ServiceReponse();
    public int sizeR() throws SQLException {
            return serR.findResponseByQuestion(qIndex).size();
    }
}
