/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utils.DataBase;
import Entite.Question;
import Service.ServiceQuestion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author bensl
 */
public class ListQuestionController implements Initializable {
    
    @FXML
    private TableView<Question> tableQ;
    
    @FXML
    private Button btn2Q;
    
    
//    
//    @FXML
//    private TableColumn<Question, String> colBody;
    
    ObservableList<Question> observableQL = FXCollections.observableArrayList();
//    @FXML
//    private TableColumn<Question, String> col_id;
//    @FXML
//    private TableColumn<Question, String> col_body;
//    @FXML
//    private TableColumn<Question, String> col_vote;
//    @FXML
//    private TableColumn<Question, String> col_tag;
//    @FXML
//    private TableColumn<Question, String> col_per;
    @FXML
    private AnchorPane rootPan;
    @FXML
    private TableColumn<Question, String> col_title;
    @FXML
    private TableColumn<Question, String> col_tagname;
    @FXML
    private Button btnListR;
    @FXML
    private TextField txtSearch;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        //col_id.setCellValueFactory(new PropertyValueFactory<>("id_question"));
        //col_body.setCellValueFactory(new PropertyValueFactory<>("body"));
        //col_vote.setCellValueFactory(new PropertyValueFactory<>("vote"));
        //col_tag.setCellValueFactory(new PropertyValueFactory<>("id_tag"));
        //col_per.setCellValueFactory(new PropertyValueFactory<>("id_personne"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_tagname.setCellValueFactory(new PropertyValueFactory<>("tag_name"));
        ServiceQuestion a = new ServiceQuestion();
        try {
            observableQL.addAll(a.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(ListQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableQ.getItems().setAll(observableQL);
        Question q= tableQ.getSelectionModel().getSelectedItem();

        
        passage();
        passageToResponses();
        get();
        search();
        //getName();
        
        
    }
    
    
    
    public void get(){
       // int q;
    tableQ.setOnMouseClicked(new EventHandler() {
        
        @Override
        public void handle(Event event) {
                    //Question q= tableQ.getSelectionModel().getSelectedItem();
            Question.q=tableQ.getSelectionModel().getSelectedIndex()+1;
                   
        
        }
    });
    //System.out.println(q+1);
    
    }
    
    public void getName(){
       // int q;
        tableQ.setOnMouseClicked(new EventHandler() {
        
        @Override
        public void handle(Event event) {
                    //Question q= tableQ.getSelectionModel().getSelectedItem();
            Question.qName=tableQ.getSelectionModel().getSelectedItem().getTitle();
        }
        });
        System.out.println(Question.qName);
    
    }
    
    public void passage(){
    btn2Q.setOnAction(new EventHandler() {
        @Override
        public void handle(Event event) {
            try {
                AnchorPane pane =FXMLLoader.load(getClass().getResource("addQuestion.fxml"));
                rootPan.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(ListQuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    }
    
    public void passageToResponses(){
    btnListR.setOnAction(new EventHandler() {
        @Override
        public void handle(Event event) {
            try {
                AnchorPane pane =FXMLLoader.load(getClass().getResource("GUIResponses.fxml"));
                rootPan.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(ListQuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    }
    public void search(){
         ServiceQuestion a = new ServiceQuestion();
         txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
             try {
                 tableQ.setItems(a.readRecherche(newValue));
             } catch (SQLException ex) {
                 Logger.getLogger(ListQuestionController.class.getName()).log(Level.SEVERE, null, ex);
             }
            tableQ.refresh();
         });
        
        
    } 
}

