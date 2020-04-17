/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIController;


import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.mail.MessagingException;
import weboss.Entities.Club;
import weboss.Entities.DemandeEvenement;
import weboss.Service.ClubService;
import weboss.Service.DemandeEvenementService;
import weboss.Service.EvenementService;
import weboss.Service.UserService;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class Afficher_Demande_EvenementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<DemandeEvenement> tab_demande_evenemnt;

    @FXML
    private TableColumn<DemandeEvenement, Integer> id_evenement;

    @FXML
    private TableColumn<DemandeEvenement, Club> id_club;

    @FXML
    private TableColumn<DemandeEvenement, String> date_debut;

    @FXML
    private TableColumn<DemandeEvenement, String> date_fin;

    @FXML
    private TableColumn<DemandeEvenement, String> description;

    @FXML
    private TableColumn<DemandeEvenement, String> etat;
    @FXML
    private JFXTextField id_evenment_selectionne;

    private final ObservableList<DemandeEvenement> listDemandeEvenement = FXCollections.observableArrayList();
    DemandeEvenementService cs = new DemandeEvenementService();
    EvenementService evs = new EvenementService();
    UserService u=new UserService();
    ClubService clubs=new ClubService();
    @FXML
    private TableColumn<DemandeEvenement, Float> Budget;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        try {
            listDemandeEvenement.addAll(cs.affciher());
        } catch (SQLException ex) {
ex.getMessage();        }

        id_evenement.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Integer>("idDemandeEvenement"));
        id_club.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Club>("idClub"));
        date_debut.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("datedebut"));
        date_fin.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("datefin"));
        description.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("description"));
        etat.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, String>("etat"));
        Budget.setCellValueFactory(new PropertyValueFactory<DemandeEvenement, Float>("budget"));
        tab_demande_evenemnt.setItems(listDemandeEvenement);

    }

    @FXML
    void select(MouseEvent event) {
        DemandeEvenement dev = tab_demande_evenemnt.getSelectionModel().getSelectedItem();

        System.out.println("hhhh");
        System.out.println(dev.getIdDemandeEvenement());

        id_evenment_selectionne.setText("" + dev.getIdDemandeEvenement());
    }

    @FXML
    void validation(MouseEvent event) {
        final ObservableList<DemandeEvenement> refresh = FXCollections.observableArrayList();

        try {
            DemandeEvenement dev = tab_demande_evenemnt.getSelectionModel().getSelectedItem();
            cs.valider(Integer.parseInt(id_evenment_selectionne.getText()));
            evs.ajouter_demande_valider();
           //cs.supprimer(dev.getIdDemandeEvenement());
           String mail="omar.jmai@esprit.tn";
            String html = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
"<head>\n" +
"<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
"<meta content=\"width=device-width\" name=\"viewport\"/>\n" +
"<!--[if !mso]><!-->\n" +
"<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n" +
"<!--<![endif]-->\n" +
"<title></title>\n" +
"<!--[if !mso]><!-->\n" +
"<link href=\"https://fonts.googleapis.com/css?family=Droid+Serif\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"<!--<![endif]-->\n" +
"<style type=\"text/css\">\n" +
"		body {\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"		}\n" +
"\n" +
"		table,\n" +
"		td,\n" +
"		tr {\n" +
"			vertical-align: top;\n" +
"			border-collapse: collapse;\n" +
"		}\n" +
"\n" +
"		* {\n" +
"			line-height: inherit;\n" +
"		}\n" +
"\n" +
"		a[x-apple-data-detectors=true] {\n" +
"			color: inherit !important;\n" +
"			text-decoration: none !important;\n" +
"		}\n" +
"	</style>\n" +
"<style id=\"media-query\" type=\"text/css\">\n" +
"		@media (max-width: 520px) {\n" +
"\n" +
"			.block-grid,\n" +
"			.col {\n" +
"				min-width: 320px !important;\n" +
"				max-width: 100% !important;\n" +
"				display: block !important;\n" +
"			}\n" +
"\n" +
"			.block-grid {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.col {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.col>div {\n" +
"				margin: 0 auto;\n" +
"			}\n" +
"\n" +
"			img.fullwidth,\n" +
"			img.fullwidthOnMobile {\n" +
"				max-width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col {\n" +
"				min-width: 0 !important;\n" +
"				display: table-cell !important;\n" +
"			}\n" +
"\n" +
"			.no-stack.two-up .col {\n" +
"				width: 50% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num4 {\n" +
"				width: 33% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num8 {\n" +
"				width: 66% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num4 {\n" +
"				width: 33% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num3 {\n" +
"				width: 25% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num6 {\n" +
"				width: 50% !important;\n" +
"			}\n" +
"\n" +
"			.no-stack .col.num9 {\n" +
"				width: 75% !important;\n" +
"			}\n" +
"\n" +
"			.video-block {\n" +
"				max-width: none !important;\n" +
"			}\n" +
"\n" +
"			.mobile_hide {\n" +
"				min-height: 0px;\n" +
"				max-height: 0px;\n" +
"				max-width: 0px;\n" +
"				display: none;\n" +
"				overflow: hidden;\n" +
"				font-size: 0px;\n" +
"			}\n" +
"\n" +
"			.desktop_hide {\n" +
"				display: block !important;\n" +
"				max-height: none !important;\n" +
"			}\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;\">\n" +
"<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
"<table bgcolor=\"#FFFFFF\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
"<div style=\"background-color:#7b95ff;\">\n" +
"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 500px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#7b95ff;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:500px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"500\" style=\"background-color:transparent;width:500px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
"<div class=\"col num12\" style=\"min-width: 320px; max-width: 500px; display: table-cell; vertical-align: top; width: 500px;\">\n" +
"<div style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<div align=\"center\" class=\"img-container center autowidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" alt=\"Image\" border=\"0\" class=\"center autowidth\" src=\"API/logo.pngs\" style=\"text-decoration: none; -ms-interpolation-mode: bicubic; border: 0; height: auto; width: 100%; max-width: 500px; display: block;\" title=\"Image\" width=\"500\"/>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"</div>\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"<div style=\"background-color:transparent;\">\n" +
"<div class=\"block-grid\" style=\"Margin: 0 auto; min-width: 320px; max-width: 500px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
"<div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
"<!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:500px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"500\" style=\"background-color:transparent;width:500px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
"<div class=\"col num12\" style=\"min-width: 320px; max-width: 500px; display: table-cell; vertical-align: top; width: 500px;\">\n" +
"<div style=\"width:100% !important;\">\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"<div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
"<!--<![endif]-->\n" +
"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td class=\"divider_inner\" style=\"word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 25px; padding-right: 25px; padding-bottom: 25px; padding-left: 25px;\" valign=\"top\">\n" +
"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_content\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 7px solid #000000; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
"<tbody>\n" +
"<tr style=\"vertical-align: top;\" valign=\"top\">\n" +
"<td style=\"word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\" valign=\"top\"><span></span></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 35px; padding-left: 35px; padding-top: 35px; padding-bottom: 35px; font-family: Georgia, 'Times New Roman', serif\"><![endif]-->\n" +
"<div style=\"color:#555555;font-family:'Droid Serif', Georgia, Times, 'Times New Roman', serif;line-height:2;padding-top:35px;padding-right:35px;padding-bottom:35px;padding-left:35px;\">\n" +
"<div style=\"line-height: 2; font-size: 12px; color: #555555; font-family: 'Droid Serif', Georgia, Times, 'Times New Roman', serif; mso-line-height-alt: 24px;\">\n" +
"<p style=\"text-align: center; line-height: 2; word-break: break-word; font-size: 30px; mso-line-height-alt: 60px; margin: 0;\"><span style=\"font-size: 30px;\">Bonjour M/Mm,</span><br/><span style=\"font-size: 30px;\">Votre Demande De Création d'un Evenement est valider :)</span><br/><span style=\"font-size: 30px;\">Cordialement.</span></p>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if mso]></td></tr></table><![endif]-->\n" +
"<!--[if (!mso)&(!IE)]><!-->\n" +
"</div>\n" +
"<!--<![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<!--[if (IE)]></div><![endif]-->\n" +
"</body>\n" +
"</html>";
                        
                        

             String maill=u.getMail(clubs.recupererResponsable(dev.getIdclub().getIdClub()));
             System.out.println(maill);
             System.out.println("id"+clubs.recupererResponsable(dev.getIdclub().getIdClub()));
            try {
                UserService.sendMail(mail, "Confirmation", "aaaa");
            } catch (MessagingException ex) {
                Logger.getLogger(Afficher_Demande_EvenementController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
           
          
            refresh.addAll(cs.affciher());
            tab_demande_evenemnt.setItems(refresh);

        } catch (SQLException ex) {
            ex.getMessage();
        }

    }
    

}
