/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EspaceEnseignantController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    @FXML
    private RadioButton H;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton F;
    @FXML
    private DatePicker dateN;
    @FXML
    private ComboBox<?> domain;
    @FXML
    private TextField cin;
    @FXML
    private TextField salaire;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> cinTab;
    @FXML
    private TableColumn<?, ?> nomTab;
    @FXML
    private TableColumn<?, ?> prenomTab;
    @FXML
    private TextField numT;
    @FXML
    private ComboBox<?> statut;
    @FXML
    private Button print;
    @FXML
    private TextField search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }

    @FXML
    private void print(ActionEvent event) {
    }
    
}
