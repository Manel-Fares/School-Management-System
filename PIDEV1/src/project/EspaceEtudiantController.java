/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import project.entities.Etudiant;
import project.entities.Parent;
import project.entities.User;
import project.service.EtudiantService;
import project.service.ParentService;

/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class EspaceEtudiantController implements Initializable {

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
    private RadioButton F;
    @FXML
    private DatePicker dateN;
    @FXML
    private ComboBox<String> domain;
    ObservableList<String> sp = FXCollections.observableArrayList("Info","Math");
    @FXML
    private TextField cin;
    @FXML
    private TextField nomR;
    @FXML
    private TextField numTR;
    @FXML
    private TextField adresseR;
    @FXML
    private TableView<Etudiant> table;
    public ObservableList<Etudiant> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Etudiant, Integer> cinTab;
    @FXML
    private TableColumn<Etudiant, String> nomTab;
    @FXML
    private TableColumn<Etudiant, String> prenomTab;
    @FXML
    private TextField numT;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private TextField idParent;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
                EtudiantService ser = new EtudiantService();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
            
            System.out.println("tab error");
         
        }
        System.out.println(list);
          
            
            cinTab.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("cinUser"));
            nomTab.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nomUser"));
              prenomTab.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenomUser"));
          
            table.setItems(list);
            domain.setItems(sp);
            getEtudiant();
    }  
        // TODO

    @FXML
    private void add(ActionEvent event) {
        
        String sexe = null,s;
       
        Date d = new Date(12,12,2012);
     
        EtudiantService ser = new EtudiantService();
        ParentService ser1 = new ParentService();
        if(Gender.getSelectedToggle().equals(H))
            sexe="Homme";
        else if(Gender.getSelectedToggle().equals(F))
            sexe="femme";
            
         Parent parent = new Parent(""+1,1, nomR.getText(), "", "", adresse.getText(),parseInt(numTR.getText()),d,"",cin.getText(),"Parent",idParent.getText());
         System.out.println(parent);
        Etudiant etd = new Etudiant(idParent.getText(),parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),parseInt(numT.getText()),d,sexe,cin.getText(),"Etudiant", "",d, domain.getValue(),parent);
        System.out.println(etd);
      
        //System.out.println(parent);
        try {
            ser.ajouter(etd,idParent.getText());
            ser1.ajouter(parent);
            table.refresh();
            
        } catch (SQLException ex) {
            System.out.println("add error");
        }
       
    }

    @FXML
    private void delete(ActionEvent event) {
        EtudiantService ser = new EtudiantService();
        Etudiant e = table.getSelectionModel().getSelectedItem();
       
        try {
           if( ser.delete(e)){
             Alert info = new Alert(Alert.AlertType.INFORMATION);
             info.setTitle("Delete");
             info.setContentText("Delete Done");
             info.show();
            
           }
               
        } catch (SQLException ex) {
            System.out.println("delete error");

            }
         table.setItems(list);
            table.refresh();
        
    }

    @FXML
    private void update(ActionEvent event) {
         Date d = new Date(12,12,2012);
        String sexe = null,s;
         if(Gender.getSelectedToggle().equals(H))
            sexe="Homme";
        else if(Gender.getSelectedToggle().equals(F))
            sexe="femme";
          EtudiantService ser = new EtudiantService();
         Etudiant e = table.getSelectionModel().getSelectedItem();
         e.setNomUser(nom.getText());
         e.setPrenomUser(prenom.getText());
          // Etudiant etd = new Etudiant("",parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),1,d,sexe,cin.getText(),"Etudiant", "",d, domain.getValue(),null);
        try {
            ser.update(e,e.getIdUser());
            
        } catch (Exception ex) {
            System.out.println("update error ");
        }
          
        
    }
    
    public void getEtudiant() {
        table.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Etudiant e = table.getSelectionModel().getSelectedItem();
                nom.clear();
                prenom.setText(e.getNomUser());
                nom.setText(e.getNomUser());
              cin.setText(String.valueOf(e.getCinUser()));
                numT.setText(String.valueOf(e.getNumTelUser()));
                adresse.setText(e.getAdresseUser());
                domain.setValue(e.getSpecialiteEtd());
                domain.getSelectionModel().selectFirst();
                nomR.setText(e.getParent().getNomUser());
               
            }
        });
        
    }
       

   
    
}
