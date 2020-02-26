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
import com.jfoenix.controls.JFXTextField;
import com.teknikindustries.bulksms.SMS;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.mail.MessagingException;
import weboss.Entities.*;
import weboss.Service.EtudiantService;
import weboss.Service.UserParentService;

import weboss.Service.UserService;
import weboss.Service.ValidationChamps;

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
    ObservableList<String> sp = FXCollections.observableArrayList("Info", "Math");
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
    public ObservableList<Etudiant> listsearch = FXCollections.observableArrayList();
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
    @FXML
    private Button print;
    @FXML
    private TextField search;
    @FXML
    private Label error_cin;
    private Label error_nom;
    private Label error_prenom;
    private Label error_email;
    private Label error_adress;
    private Label error_phone;
    private Label error_nomR;
    private Label error_phoneR;
    private Label error_adR;
    private Label error_cinR;
    @FXML
    private JFXTextField img;
    @FXML
    private ImageView image;
    String imgurl, imgpath;
    @FXML
    private ImageView valid;
    @FXML
    private ImageView invalid;
    @FXML
    private ImageView invalid_nom;
    @FXML
    private ImageView valid_nom;
    @FXML
    private ImageView valid_prenom;
    @FXML
    private ImageView valid_nomR;
    @FXML
    private ImageView valid_telR;
    @FXML
    private ImageView valid_adresseR;
    @FXML
    private ImageView valid_cinR;
    @FXML
    private ImageView valid_email;
    @FXML
    private ImageView valid_tel;
    @FXML
    private ImageView valid_domain;
    @FXML
    private ImageView invalid_nomR;
    @FXML
    private ImageView invalid_telR;
    @FXML
    private ImageView invalid_adresseR;
    @FXML
    private ImageView invalid_cinR;
    @FXML
    private ImageView invalid_prenom;
    @FXML
    private ImageView invalid_email;
    @FXML
    private ImageView invalid_tel;
    @FXML
    private ImageView invalid_domain;
    @FXML
    private ImageView invalid_date;
    @FXML
    private ImageView valid_date;
    @FXML
    private ImageView invalid_adress;
    @FXML
    private ImageView valid_adress;

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
        search();
        table.refresh();
    }
    // TODO

    @FXML
    private void add(ActionEvent event) {
        boolean isCinEmpty = ValidationChamps.isNumber(cin, valid, invalid);
        boolean isNomEmpty = ValidationChamps.isTextFieldNotEmpty(nom, valid_nom, invalid_nom);
        boolean isPrenomEmpty = ValidationChamps.isTextFieldNotEmpty(prenom, valid_prenom, invalid_prenom);
        boolean isEmailEmpty = ValidationChamps.isEmail(email, valid_email, invalid_email);
        boolean isAdresseEmpty = ValidationChamps.isTextFieldNotEmpty(adresse, valid_adress, invalid_adress);
        boolean isTelEmpty = ValidationChamps.isNumber(numT, valid_tel, invalid_tel);
        boolean isNomREmpty = ValidationChamps.isTextFieldNotEmpty(nomR, valid_nomR, invalid_nomR);
        boolean isadressREmpty = ValidationChamps.isTextFieldNotEmpty(adresseR, valid_adresseR, invalid_adresseR);
        boolean isPhoneREmpty = ValidationChamps.isNumber(numTR, valid_telR, invalid_telR);
        boolean isCinREmpty = ValidationChamps.isNumber(idParent, valid_cinR, invalid_cinR);
        if (!isCinREmpty) {
            error_cin.setText("CinR Non Videe");
        }

        if (!isadressREmpty) {
            error_cin.setText("AdresseR Non Videe");
        }

        if (!isPhoneREmpty) {
            error_cin.setText("TelR No Empty");
        }

        if (!isadressREmpty) {
            error_cin.setText("AdresseR Non Videe");
        }
        if (!isPhoneREmpty) {
            error_cin.setText("TelR No Empty");
        }
        if (!isNomREmpty) {
            error_cin.setText("NomR No Empty");
        }
        if (!isTelEmpty) {
            error_cin.setText("Tel No Empty");
        }
        if (!isAdresseEmpty) {
            error_cin.setText("Adresse No Empty");
        }
        if (!isEmailEmpty) {
            error_cin.setText("Email No Empty");
        }
        if (!isPrenomEmpty) {
            error_cin.setText("Prenom No Empty");
        }
        if (!isNomEmpty) {
            error_cin.setText("Nom No Empty");
        }
        if (!isCinEmpty) {
            error_cin.setText("cin No Empty");
        }
        if (isAdresseEmpty && isCinEmpty && isCinREmpty && isEmailEmpty && isNomEmpty && isNomREmpty && isPhoneREmpty && isPrenomEmpty && isTelEmpty && isadressREmpty) {
            error_cin.setText(null);
        }

        String sexe = null, s;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d = new Date(System.currentTimeMillis());
        //Date d = new Date(12,12,2012);

        EtudiantService ser = new EtudiantService();
        UserParentService ser1 = new UserParentService();
        if (Gender.getSelectedToggle().equals(H)) {
            sexe = "Homme";
        } else if (Gender.getSelectedToggle().equals(F)) {
            sexe = "Femme";
        }

        UserParent parent = new UserParent("", parseInt(idParent.getText()), nomR.getText(), "", "", adresse.getText(), parseInt(numTR.getText()), d, "", cin.getText(), "Parent", "");
        System.out.println(parent);
        Etudiant etd = new Etudiant("", parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(), parseInt(numT.getText()), Date.valueOf(dateN.getValue()), sexe, cin.getText(), "Etudiant", imgurl, null, d, domain.getValue(), parent);
        System.out.println(etd);
        SMS smsTn = new SMS();

        //smsTn.SendSMS("argoubisofien", "Neifos13235258", "Your Account :"+cin.getText()+"Password"+cin.getText(), "+216"+numTR.getText(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
        //System.out.println(parent);
        try {
            // if(!isAdresseEmpty && !isCinEmpty && !isCinREmpty && !isEmailEmpty && !isNomREmpty && !isPhoneREmpty && !isPrenomEmpty && !isTelEmpty && !isadressREmpty){
            if (isAdresseEmpty && isCinEmpty && isCinREmpty && isEmailEmpty && isNomEmpty && isNomREmpty && isPhoneREmpty && isPrenomEmpty && isTelEmpty && isadressREmpty) {
                ser1.ajouter(parent);

                //ser.ajouter(etd);
                ser.ajouter(etd, idParent.getText());
                loadData();
                clearData();
            }
        } catch (Exception ex) {
            System.out.println("error add");
        }
        try {
            UserService.sendMail(email.getText(), "Congrats ", "Your Password :" + cin.getText());
        } catch (MessagingException ex) {
            Logger.getLogger(EspaceEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void delete(ActionEvent event) {
        EtudiantService ser = new EtudiantService();
        Etudiant e = table.getSelectionModel().getSelectedItem();

        try {
            if (ser.delete(e)) {
                Alert info = new Alert(Alert.AlertType.INFORMATION);
                info.setTitle("Delete");
                info.setContentText("Delete Done");
                info.show();
                loadData();
                clearData();
            }

        } catch (SQLException ex) {
            System.out.println("delete error");

        }
        table.setItems(list);
        table.refresh();

    }

    @FXML
    private void update(ActionEvent event) {
        boolean isCinEmpty = ValidationChamps.isNumber(cin, valid, invalid);
        boolean isNomEmpty = ValidationChamps.isTextFieldNotEmpty(nom, valid_nom, invalid_nom);
        boolean isPrenomEmpty = ValidationChamps.isTextFieldNotEmpty(prenom, valid_prenom, invalid_prenom);
        boolean isEmailEmpty = ValidationChamps.isEmail(email, valid_email, invalid_email);
        boolean isAdresseEmpty = ValidationChamps.isTextFieldNotEmpty(adresse, valid_adress, invalid_adress);
        boolean isTelEmpty = ValidationChamps.isNumber(numT, valid_tel, invalid_tel);
        boolean isNomREmpty = ValidationChamps.isTextFieldNotEmpty(nomR, valid_nomR, invalid_nomR);
        boolean isadressREmpty = ValidationChamps.isTextFieldNotEmpty(adresseR, valid_adresseR, invalid_adresseR);
        boolean isPhoneREmpty = ValidationChamps.isNumber(numTR, valid_telR, invalid_telR);
        boolean isCinREmpty = ValidationChamps.isNumber(idParent, valid_cinR, invalid_cinR);
        if (!isCinREmpty) {
            error_cin.setText("CinR Non Videe");
        }

        if (!isadressREmpty) {
            error_cin.setText("AdresseR Non Videe");
        }

        if (!isPhoneREmpty) {
            error_cin.setText("TelR No Empty");
        }

        if (!isadressREmpty) {
            error_cin.setText("AdresseR Non Videe");
        }
        if (!isPhoneREmpty) {
            error_cin.setText("TelR No Empty");
        }
        if (!isNomREmpty) {
            error_cin.setText("NomR No Empty");
        }
        if (!isTelEmpty) {
            error_cin.setText("Tel No Empty");
        }
        if (!isAdresseEmpty) {
            error_cin.setText("Adresse No Empty");
        }
        if (!isEmailEmpty) {
            error_cin.setText("Email No Empty");
        }
        if (!isPrenomEmpty) {
            error_cin.setText("Prenom No Empty");
        }
        if (!isNomEmpty) {
            error_cin.setText("Nom No Empty");
        }
        if (!isCinEmpty) {
            error_cin.setText("cin No Empty");
        }
        if (isAdresseEmpty && isCinEmpty && isCinREmpty && isEmailEmpty && isNomEmpty && isNomREmpty && isPhoneREmpty && isPrenomEmpty && isTelEmpty && isadressREmpty) {
            error_cin.setText(null);
        }

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d = new Date(System.currentTimeMillis());
        //Date d = new Date(12,12,2012);
        String sexe = null, s;
        if (Gender.getSelectedToggle().equals(H)) {
            sexe = "Homme";
        } else if (Gender.getSelectedToggle().equals(F)) {
            sexe = "femme";
        }
        EtudiantService ser = new EtudiantService();
        Etudiant e = table.getSelectionModel().getSelectedItem();
        e.setNomUser(nom.getText());
        e.setPrenomUser(prenom.getText());
        e.setAdresseUser(adresse.getText());
        e.setPicUser(imgurl);
        e.setNumTelUser(parseInt(numT.getText()));
        // Etudiant etd = new Etudiant("",parseInt(cin.getText()), nom.getText(), prenom.getText(), email.getText(), adresse.getText(),1,d,sexe,cin.getText(),"Etudiant", "",d, domain.getValue(),null);
        try {
            if (isAdresseEmpty && isCinEmpty && isCinREmpty && isEmailEmpty && isNomEmpty && isNomREmpty && isPhoneREmpty && isPrenomEmpty && isTelEmpty && isadressREmpty) {
                ser.update(e, e.getIdUser());
                loadData();
                clearData();
            }
        } catch (Exception ex) {
            System.out.println("update error ");
        }

    }

    public void getEtudiant() {
        table.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Etudiant e = table.getSelectionModel().getSelectedItem();
                clearData();
                prenom.setText(e.getPrenomUser());
                nom.setText(e.getNomUser());
                cin.setText(String.valueOf(e.getCinUser()));
                numT.setText(String.valueOf(e.getNumTelUser()));
                adresse.setText(e.getAdresseUser());
                domain.setValue(e.getSpecialiteEtd());
                domain.getSelectionModel().selectFirst();
                nomR.setText(e.getParent().getNomUser());
                numTR.setText(String.valueOf(e.getParent().getNumTelUser()));
                idParent.setText(String.valueOf(e.getParent().getCinUser()));
                email.setText(e.getEmailUser());
                adresseR.setText(e.getParent().getAdresseUser());
                dateN.setValue(e.getDateNaissanceUser().toLocalDate());
                String path = "C:\\Users\\Neifos\\Pictures\\Camera Roll\\Weboss\\src\\weboss\\Image\\" + e.getPicUser();
                File file = new File(path);
                image.setImage(new Image(file.toURI().toString()));

            }
        });

    }

    public void loadData() {
        EtudiantService ser = new EtudiantService();
        list.clear();
        try {
            list.addAll(ser.readAll());
        } catch (SQLException ex) {
            ex.getMessage();
        }
        table.setItems(list);

    }

    public void clearData() {
        nom.clear();
        prenom.clear();
        numT.clear();
        idParent.clear();
        adresse.clear();
        numTR.clear();
        cin.clear();
        adresseR.clear();
        email.clear();
        nomR.clear();
        dateN.setValue(null);

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
        PdfWriter.getInstance(doc, new FileOutputStream(saveFile.getAbsolutePath()));
        doc.open();
        System.out.println(doc.getHtmlStyleClass());
        doc.add(new Paragraph("Nom Enseignant :" + nom.getText()));
        doc.add(new Paragraph("Prénom Enseignant  :" + prenom.getText()));
        doc.add(new Paragraph("Email Enseignant  :" + email.getText()));
        doc.add(new Paragraph("Adresse Enseignant  :" + adresse.getText()));

        doc.close();

    }

    /*  @FXML
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
    public void search() {
        EtudiantService ser = new EtudiantService();
        //listsearch.clear();
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            try {

                //listsearch.addAll(ser.search(newValue));
                table.setItems(ser.search(newValue));
                table.refresh();

            } catch (SQLException ex) {
                ex.getMessage();
            }
        });

    }

    @FXML
    private void image(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showSaveDialog(null);
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("IMAGE Files", "*.png"));
        if (selectedFile != null) {
            imgurl = selectedFile.getName();
            imgpath = selectedFile.getAbsolutePath();
            File file = new File(imgpath);
            image.setImage(new Image(file.toURI().toString()));
        }
    }

    public void imageadd() {
        try {
            String path = "C:\\Users\\Neifos\\Pictures\\Camera Roll\\Weboss\\src\\weboss\\Image\\" + imgurl;
            File org = new File(imgpath);
            File org1 = new File(path);
            Files.copy(org.toPath(), org1.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(EspaceEnseignantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
