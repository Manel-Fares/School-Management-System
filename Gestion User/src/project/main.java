 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.teknikindustries.bulksms.SMS;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.MessagingException;
import project.service.EtudiantService;
import project.service.EnseignantService;
import project.service.ReclamationService;
import project.entities.User;
import project.entities.Etudiant;
import project.entities.Enseignant;
import project.entities.Personnel;
import project.entities.Reclamation;
import project.service.PersonnelService;
import project.service.UserService;

/**
 *
 * @author Neifos
 */
public class main {
    
    public static void main(String[] args)  {
        EtudiantService ser = new EtudiantService();
        EnseignantService ser1 = new EnseignantService();
        ReclamationService ser2 = new ReclamationService();
        PersonnelService ser3 = new PersonnelService();
        UserService ser4 = new UserService();
        
         Date d = new Date(2020,12,12);
        // Reclamation r = new Reclamation("","note", "qsfqdfqf", d);
         //  User ensg = new Personnel("", 55555, "ala","kaka","qsfdq@qsfdqd","7ay sdqf",2014587,d,"h","sdfsdf544","Entravail",d,144.0,"fina");
           //  User etd = new Etudiant("", 8888444,"sof","arg","gfs@ggm","hahahad",4550,d,"hhhH", ser.encrypt("soofff", "45"),"3A1",d,"info");
     /*   try {
            System.out.println(ser4.getNombreEnseignant());
        } catch (SQLException ex) {
            System.out.println("errrrrrrrrrrrror");
        }*/
        
   
    }
  
      
  
    
}
