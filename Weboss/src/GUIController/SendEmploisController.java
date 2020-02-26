/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author Pytrooooo
 */
public class SendEmploisController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXButton Upload;
    @FXML
    private JFXButton Send;
    String listview,Path;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     public void afficherAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
      
    public boolean testSaisie() {
        
       // System.out.println("compare="+dateDebut.getValue().compareTo(dateFin.getValue()));

        if (
               // NameClass.getText().trim().isEmpty() || NbrEtudClass.getText().trim().isEmpty()
               // || DescriptionClass.getText().trim().isEmpty()
                mail.getText().trim().isEmpty()
               // DateEmplois.getValue() == null
               // || HeureEmplois.getValue() == null
                || listview.equals("")
                || Path.equals("")
                //|| imageFileLabel.getText().trim().isEmpty()
                ) {
            afficherAlert("Tous les champs doivent être remplis");
            return false;
        }
 Pattern err = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
 if (!err.matcher(mail.getText()).matches()) {
     afficherAlert("Email non valider");
            return false;
        }      
 /* Instant instant = Instant.from(dateDebut.getValue().atStartOfDay(ZoneId.systemDefault()));
        Date dateD = Date.from(instant);
        Date cuurentDate = new Date();
        if (dateD.compareTo(cuurentDate) < 0) {

            afficherAlert("Date debut doit être supérieur à la date d'aujoud'hui");
            return false;
        }
        if (dateDebut.getValue().compareTo(dateFin.getValue()) > 0) {
            afficherAlert("Date fin doit être supérieur ou égal à la date de debut");
            return false;
        }
        if (dateDebut.getValue().compareTo(dateFin.getValue()) == 0) {
            if (heureDebut.getValue().compareTo(heureFin.getValue()) > 0) {
                afficherAlert("Heure fin doit être supérieur à l'heure de début");
                return false;
            }
        }*/
      /*  try {
            Double num = Double.parseDouble(NbrEtudClass.getText());
        } catch (NumberFormatException e) {
            afficherAlert("Champs Nombre invalide");
            return false;
        }*/
        return true;
    }

    @FXML
    private void UploadAction(ActionEvent event) {
            FileChooser fc = new FileChooser();
    fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("PDF Files","*.PDF"),
            new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
            new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
            new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
            new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
            new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html"),
            new FileChooser.ExtensionFilter("Ennour File (*.Ennour)", "*.Ennour")
    );
    File selectedFiles = fc.showOpenDialog(null);
    if (selectedFiles !=null){
        
        listview=selectedFiles.getName();
        Path=selectedFiles.getAbsolutePath();
            System.out.println(listview);
            
            
        }else{
        System.out.println("file is not valid");
    }
    Upload.setText(listview);
    }

    @FXML
    private void SendAction(ActionEvent event) {
        if(testSaisie())
        {
        mailling();
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
        }
    }
    
    
    public void mailling() {
        //authentication info
		final String username = "test.nom2020@gmail.com";
		final String password = "0123azertyuiop";
		String fromEmail = "test.nom2020@gmail.com";
		String toEmail = mail.getText();
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
                
		Session session = Session.getInstance(properties,new Authenticator() {                   
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
                    
});
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Emplois");
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("My multipart text");
			
			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.attachFile(Path);
                        
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
