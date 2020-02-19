/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import static com.itextpdf.text.pdf.BidiOrder.PDF;
import static com.itextpdf.text.pdf.PdfName.PDF;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.mail.MessagingException;
import static javax.print.DocFlavor.BYTE_ARRAY.PDF;
import static javax.print.DocFlavor.INPUT_STREAM.PDF;
import static javax.print.DocFlavor.URL.PDF;
import project.entities.*;

import project.service.EnseignantService;
import project.service.EtudiantService;
import project.service.ParentService;
import project.service.ReclamationService;
import project.service.UserService;

/**
 * FXML Controller class
 *
 * @author Neifos
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
    private RadioButton F;
    @FXML
    private ComboBox<String> domain;
    ObservableList<String> sp = FXCollections.observableArrayList("Info","Math");
    @FXML
    private TextField cin;
    @FXML
    private TableView<Enseignant> table;
    public ObservableList<Enseignant> list = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Enseignant, Integer> cinTab;
    @FXML
    private TableColumn<Enseignant, String> nomTab;
    @FXML
    private TableColumn<Enseignant, String> prenomTab;
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
    private Button print;
    @FXML
    private TextField search;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
                EnseignantService ser = new EnseignantService();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
            
            System.out.println("tab error");
         
        }
        System.out.println(list);
          
            
            cinTab.setCellValueFactory(new PropertyValueFactory<Enseignant, Integer>("cinUser"));
            nomTab.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("nomUser"));
              prenomTab.setCellValueFactory(new PropertyValueFactory<Enseignant, String>("prenomUser"));
          
            table.setItems(list);
            domain.setItems(sp);
            statut.setItems(stat);
            search();
            
            getEtudiant();
    }  
        // TODO

    @FXML
    private void add(ActionEvent event) {
        
        String sexe = null,s;
       
          DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d =new Date(System.currentTimeMillis());
      
     
     
        EnseignantService ser = new EnseignantService();
      
        if(Gender.getSelectedToggle().equals(H))
            sexe="Homme";
        else if(Gender.getSelectedToggle().equals(F))
            sexe="femme";
            Enseignant ens = new Enseignant("",parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),parseInt(numT.getText()),d, sexe, cin.getText(),"Enseignant", statut.getValue(),Double.valueOf(salaire.getText()),d, domain.getValue());
      
       try {
            UserService.sendMail(email.getText(),"Congrats ","Your Password :"+cin.getText());
        } catch (MessagingException ex) {
            Logger.getLogger(EspaceEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        try {
            ser.ajouter(ens);
              loadData();
            clearData();
      
            table.refresh();
            
        } catch (SQLException ex) {
            System.out.println("add error");
        }
       
    }

    @FXML
    private void delete(ActionEvent event) {
        EnseignantService ser = new EnseignantService();
        Enseignant e = table.getSelectionModel().getSelectedItem();
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
          EnseignantService ser = new EnseignantService();
         Enseignant e = table.getSelectionModel().getSelectedItem();
         e.setNomUser(nom.getText());
         e.setPrenomUser(prenom.getText());
        try {
            ser.update(e,e.getIdUser());
            loadData();
            clearData();
        } catch (Exception ex) {
            System.out.println("update error ");
        }
          
        
    }
    
    public void getEtudiant() {
        table.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Enseignant e = table.getSelectionModel().getSelectedItem();
                nom.clear();
                prenom.setText(e.getNomUser());
                nom.setText(e.getNomUser());
              cin.setText(String.valueOf(e.getCinUser()));
                numT.setText(String.valueOf(e.getNumTelUser()));
                adresse.setText(e.getAdresseUser());
                dateN.setValue(e.getDateNaissanceUser().toLocalDate());
             
               
            }
        });
        
    }

    @FXML
    private void print(ActionEvent event) throws FileNotFoundException, DocumentException {
        Document doc = new Document();

        
        PdfWriter.getInstance(doc,new FileOutputStream("doc.pdf"));
        doc.open();
        doc.add(new Paragraph("bnj"));
        doc.close();
        
        
    }
      public void loadData(){
         EnseignantService ser = new EnseignantService();
        list.clear();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems(list);
        
    }
    public void clearData(){
        nom.clear();
        prenom.clear();
        email.clear();
        adresse.clear();
        numT.clear();
        //domain.setSelectionModel();
        cin.clear();
        
    }

    @FXML
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
    }
       
 public void search(){
          EnseignantService ser = new EnseignantService();
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
   
    
}
