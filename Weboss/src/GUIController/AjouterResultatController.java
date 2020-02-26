/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javax.mail.MessagingException;
import weboss.Entities.Note;
import weboss.Entities.Resultat;
import weboss.Service.ServiceNote;
import weboss.Service.ServiceResultat;
import weboss.Service.UserService;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class AjouterResultatController implements Initializable {

    @FXML
    private TextField cin;
    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton calculer;
    @FXML
    private ImageView imageResult;
    @FXML
    private Pane management;
    @FXML
    private JFXButton manage;
    @FXML
    private Pane transcript;
    @FXML
    private JFXButton calculer1;
    @FXML
    private JFXButton create;
    @FXML
    private Label message;
    @FXML
    private ImageView singleResultimage;
    @FXML
    private ImageView transcriptimage;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        management.setVisible(false);
        transcript.setVisible(true);
        create.setVisible(false);
    }

    @FXML
    private void ajoutAction(ActionEvent event) throws SQLException {

        ServiceResultat serR = new ServiceResultat();
        ServiceNote serN = new ServiceNote();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d = new Date(System.currentTimeMillis());
        int idEtudiant = serN.getIdEtudiant(cin.getText());
        System.out.println(idEtudiant);
        float resAnnuelle = serR.calculResultatParEtudiant(idEtudiant);

        Resultat r = new Resultat(idEtudiant, d, resAnnuelle);
        r.getEtudiant().setIdUser(String.valueOf(idEtudiant));
        serR.delete(idEtudiant);
        serR.ajouterResultat(r);
    }

    @FXML
    private void supprimerAction(ActionEvent event) throws SQLException {
        ServiceResultat serR = new ServiceResultat();
        ServiceNote serN = new ServiceNote();
        int idEtudiant = serN.getIdEtudiant(cin.getText());
        serR.delete(idEtudiant);
        management.setVisible(false);

    }

    @FXML
    private void calculerAction(ActionEvent event) throws SQLException {
       
        ServiceResultat serR = new ServiceResultat();
        ServiceNote serN = new ServiceNote();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        Date d = new Date(System.currentTimeMillis());
        List<Integer> l = serR.getListEtudiant();
        float resAnnuelle;
        for (Integer E : l) {
            resAnnuelle = serR.calculResultatParEtudiant(E);
            Resultat r = new Resultat(E, d, resAnnuelle);
            r.getEtudiant().setIdUser(Integer.toString(E));
            serR.delete(E);
            serR.ajouterResultat(r);

        }
        management.setVisible(false);

    }

    @FXML
    private void reCalculerAction(ActionEvent event) {
        management.setVisible(true);
                cin.clear();

    }

    @FXML
    private void transcriptAction(ActionEvent event) {
        management.setVisible(true);
        transcript.setVisible(false);
       create.setVisible(true);

    }

    @FXML
    private void createAction(ActionEvent event) throws SQLException, DocumentException, FileNotFoundException, MessagingException {
        
        ServiceNote sn = new ServiceNote();
        ServiceResultat sr = new ServiceResultat();
        int idE = sn.getIdEtudiant(cin.getText());
        float r = sr.getResultat(Integer.toString(idE));

        List<Note> listNote = sn.listeMoyenneNoteEtudiant(Integer.toString(idE));
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Neifos\\Desktop\\Weboss\\src\\PDF\\resultat.pdf"));
        doc.open();
        Font regular = new Font(Font.FontFamily.HELVETICA, 14);
        Font font = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        font.setColor(BaseColor.BLUE);
        Paragraph p = new Paragraph("Annual Result Information ", font);
        p.setAlignment(Element.ALIGN_CENTER);
        doc.add(p);
        doc.add(new Paragraph(" "));
        p = new Paragraph("Subject   |     Score   ", regular);
        p.setAlignment(Element.ALIGN_CENTER);
        doc.add(p);
        for (Note n : listNote) {
            p = new Paragraph(n.getInfo() + " : " + n.getMoyenne(), regular);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
        }
        p = new Paragraph("Result : " + r, regular);
        p.setAlignment(Element.ALIGN_CENTER);
        doc.add(p);
      //  UserService.sendMail("manelfares5@gmail.com","transcript","Transcript Reclamation treated ");
        doc.close();
        management.setVisible(false);
        transcript.setVisible(true);
        create.setVisible(false);
        cin.clear();
        

    }

    @FXML
    private void fullResultCalcul(MouseEvent event) {
    }

    @FXML
    private void calculatesingleResult(MouseEvent event) {
    }

    @FXML
    private void transcriptDownload(MouseEvent event) {
    }

}
