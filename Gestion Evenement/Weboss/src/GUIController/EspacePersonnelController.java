/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.mail.MessagingException;
import weboss.Entities.*;
import weboss.Service.PersonnelService;
import weboss.Service.UserService;


/**
 * FXML Controller class
 *
 * @author Neifos
 */
public class EspacePersonnelController implements Initializable {

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
    private ComboBox<String> domain;
    ObservableList<String> sp = FXCollections.observableArrayList("Service Finance","Service Scolarite");
    @FXML
    private TextField cin;
    @FXML
    private TableView<Personnel> table;
    public ObservableList<Personnel> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Personnel, Integer> cinTab;
    @FXML
    private TableColumn<Personnel, String> nomTab;
    @FXML
    private TableColumn<Personnel, String> prenomTab;
    @FXML
    private TextField numT;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private DatePicker dateN;
    @FXML
    private TextField salaire;
    @FXML
    private ComboBox<String> statut;
    ObservableList<String> stat = FXCollections.observableArrayList("Conge","En cours");
    @FXML
    private TextField search;
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
                PersonnelService ser = new PersonnelService();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
            
            System.out.println("tab error");
         
        }
        System.out.println(list);
          
            
            cinTab.setCellValueFactory(new PropertyValueFactory<Personnel, Integer>("cinUser"));
            nomTab.setCellValueFactory(new PropertyValueFactory<Personnel, String>("nomUser"));
              prenomTab.setCellValueFactory(new PropertyValueFactory<Personnel, String>("prenomUser"));
          
            table.setItems(list);
            statut.setItems(stat);
            domain.setItems(sp);
            search();
            getPersonnel();
    }  
        // TODO

    @FXML
    private void add(ActionEvent event) {
        
        String sexe = null,s;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d =new Date(System.currentTimeMillis());
       
     
        PersonnelService ser = new PersonnelService();
      
        if(Gender.getSelectedToggle().equals(H))
            sexe="Homme";
        else if(Gender.getSelectedToggle().equals(F))
            sexe="femme";
            Personnel pr = new Personnel("",parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),parseInt(numT.getText()),d, sexe, cin.getText(),"Enseignant", statut.getValue(),d,Double.valueOf(salaire.getText()), domain.getValue());
      
       try {
            UserService.sendMail(email.getText(),"Congrats ","Your Password :"+cin.getText());
        } catch (MessagingException ex) {
            Logger.getLogger(EspaceEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ser.ajouter(pr);
            loadData();
                clearData();
            
            
        } catch (SQLException ex) {
            System.out.println("add error");
        }
       
    }

    @FXML
    private void delete(ActionEvent event) {
        PersonnelService ser = new PersonnelService();
        Personnel e = table.getSelectionModel().getSelectedItem();
        try {
            ser.delete(e);
            loadData();
                clearData();
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
          PersonnelService ser = new PersonnelService();
         Personnel e = table.getSelectionModel().getSelectedItem();
         e.setNomUser(nom.getText());
         e.setPrenomUser(prenom.getText());
          // Etudiant etd = new Etudiant("",parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),1,d,sexe,cin.getText(),"Etudiant", "",d, domain.getValue(),null);
        try {
            ser.update(e,e.getIdUser());
            loadData();
                clearData();
        } catch (Exception ex) {
            System.out.println("update error ");
        }
          
        
    }
    
    public void getPersonnel() {
        table.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Personnel e = table.getSelectionModel().getSelectedItem();
              
                prenom.setText(e.getNomUser());
                nom.setText(e.getNomUser());
              cin.setText(String.valueOf(e.getCinUser()));
                numT.setText(String.valueOf(e.getNumTelUser()));
                adresse.setText(e.getAdresseUser());
                dateN.setValue(e.getDateNaissanceUser().toLocalDate());
                email.setText(e.getEmailUser());
                salaire.setText(String.valueOf(e.getSalairePr()));
                statut.setValue(e.getStatutPr());
             
               
            }
        });
        
    }
     public void loadData(){
         PersonnelService ser = new PersonnelService();
        list.clear();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
ex.getMessage();        }
        table.setItems(list);
        
    }
    public void clearData(){
        
        nom.clear();
        prenom.clear();
        numT.clear();
        cin.clear();
        dateN.setValue(null);
        adresse.clear();
        domain.setValue("Domain");
        statut.setValue("Status");
        salaire.clear();
        
    }

    /*@FXML
    private void back(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Home.fxml"));
              javafx.scene.Parent root;
        try {
            root = loader.load();
            HomeController apc = loader.getController();
                
                nom.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(EspacePersonnelController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }*/
     public void search(){
          PersonnelService ser = new PersonnelService();
          //listsearch.clear();
        search.textProperty().addListener(( observable,  oldValue,  newValue) -> {
              try {
                         
                  //listsearch.addAll(ser.search(newValue));
                  table.setItems(ser.search(newValue));
                  table.refresh();
                
              } catch (SQLException ex) {
                  Logger.getLogger(EspaceEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
              }
          });
        
        
    }

    @FXML
    private void print(ActionEvent event) throws FileNotFoundException, DocumentException {
              Document doc = new Document();
FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF files (.pdf)", ".pdf"),
                new FileChooser.ExtensionFilter("HTML files (.html)", ".html")
        );
        File saveFile = fileChooser.showSaveDialog(table.getScene().getWindow());

      //  file.save(saveFile.getAbsolutePath());
        
        PdfWriter.getInstance(doc,new FileOutputStream(saveFile.getAbsolutePath()));
        doc.open();
        System.out.println(doc.getHtmlStyleClass());
        doc.add(new Paragraph("Nom Enseignant :"+nom.getText()));
        doc.add(new Paragraph("Prénom Enseignant  :"+prenom.getText()));
        doc.add(new Paragraph("Email Enseignant  :"+email.getText()));
        doc.add(new Paragraph("Adresse Enseignant  :"+adresse.getText()));
        
        
        doc.close();
        
    }
       

   
    
}
