/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utils.DataBase;
import Entite.Question;
import Service.ServiceQuestion;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TableColumn<Question, Integer> id = new TableColumn("id");
        TableColumn<Question, String> body = new TableColumn("body");
        //tableQ.getColumns().addAll(id, body);
        tableQ.getColumns().addAll(body);
        
        ServiceQuestion serQ = new ServiceQuestion();
        
        try {
            Connection con = DataBase.getInstance().getConnection();
            //ResultSet rs = con.createStatement().executeQuery("SELECT `id_question`, `body` FROM `question` ");
            ResultSet rs = con.createStatement().executeQuery("SELECT `body` FROM `question` ");
            while(rs.next()){
                observableQL.add(new Question(rs.getString("body")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        //colBody.setCellValueFactory(new PropertyValueFactory<>("body"));
        tableQ.setItems(observableQL);
        
    }
    
}
