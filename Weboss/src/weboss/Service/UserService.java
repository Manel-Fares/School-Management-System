/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import weboss.BD.Database;
import weboss.Entities.Enseignant;
import weboss.Entities.Etudiant;
import weboss.Entities.UserParent;
import weboss.Entities.Personnel;
import weboss.Entities.User;


/**
 *
 * @author Neifos
 */
public class UserService {
      private Connection con;
    private Statement ste;

    public UserService() {
        con = Database.getInstance().getConnexion();

    }
    public User login(String email,String mdp) throws SQLException{
        User u=null;
        System.out.println("cc");
      
         ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users where  emailUser='"+email+"' and motDePasseUser='"+mdp+"'");
    
        while (rs.next()) {
           
            String idUser = rs.getString("idUser");
           int cinUser = rs.getInt("cinUser");
            String nomUser = rs.getString("nomUser");
            String prenomUser = rs.getString("prenomUser");
            Date dateNaissanceUser = rs.getDate("dateNaissanceUser");
           String sexeUser = rs.getString("sexeUser");
            String emailUser = rs.getString("emailUser");
            String adresseUser = rs.getString("adresseUser");
           int numTelUser = rs.getInt("numTelUser");
            String motDePasseUser = rs.getString("motDePasseUser");
            String roleUser = rs.getString("roleUser");
            String classeEtd = rs.getString("classeEtd");
            Date inscriptionEtd = rs.getDate("inscriptionEtd");
            Date dateEmbaucheUser = rs.getDate("dateEmbaucheUser");
            String specialiteEtd = rs.getString("specialiteEtd");
            String statutUser = rs.getString("statutUser");
            String domaineUser = rs.getString("domaineUser");
            String picUser = rs.getString("picUser");
            Double salaireUser = rs.getDouble("salaireUser");
            int idParent = rs.getInt("idParent");
            switch (roleUser) {
                case "Etudiant":
                   
                    u = new Etudiant(idUser, cinUser,nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser, classeEtd, inscriptionEtd,specialiteEtd,null);
                    Etudiant.etd=(Etudiant) u;
                    return Etudiant.etd;
                case "Enseignant":
                   
                    Enseignant  ens = new Enseignant(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser,picUser, statutUser,salaireUser,dateEmbaucheUser,domaineUser);
                    Enseignant.ensg=(Enseignant) ens;
                    return Enseignant.ensg;
                case "Personnel":
                    Personnel per = new Personnel(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser,motDePasseUser,roleUser,picUser,statutUser,dateEmbaucheUser,salaireUser,domaineUser);
                    Personnel.pr= per;
               
                    return Personnel.pr;
                case "Parent":
                    UserParent parent = new UserParent(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser,picUser);
                    UserParent.parent=parent;
                    return UserParent.parent;
                case "root":
                    User user = new User(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser,picUser);
                    User.user=user;
                    System.out.println(user);
                    return User.user;
                default:
                    break;
            }
                
                
                       
                        
           
        
    }
        
         //System.out.println(Etudiant.user);
        return u;
}
    public static void sendMail(String recepient,String subj,String desc) throws MessagingException{
        System.out.println("prep...");
        Properties prop = new Properties();
        
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");
        
        String from ="sofien.argoubi@esprit.tn";
        String mdp = "13235258";
        
        Session session = Session.getInstance(prop,new Authenticator() {
            @Override
            protected  PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from, mdp);
              }
            });
        Message  message = prepareMessage(session,from,recepient,subj,desc);
        Transport.send(message);
        System.out.println("send ok");
    }
    private static Message prepareMessage(Session session, String from,String recepient,String subj,String desc){
        try{
            Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject(subj);
            message.setText(desc);
            return message;
        }catch(Exception ex){
            System.out.println("error send");
        }
        return null;
    }
    
    public int getcode(){
        return (int) (Math.random() * ( 9999 - 1000 ));

    }
    public User getUser(String email) throws SQLException{
        
        
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users where emailUser='"+email+"'");
        System.out.println(rs);
        while (rs.next()) {
            System.out.println(rs.getString("idUser"));
            String idUser = rs.getString("idUser");
            int cinUser = rs.getInt("cinUser");
            String nomUser = rs.getString("nomUser");
            String prenomUser = rs.getString("prenomUser");
            Date dateNaissanceUser = rs.getDate("dateNaissanceUser");
            String sexeUser = rs.getString("sexeUser");
            String emailUser = rs.getString("emailUser");
            String adresseUser = rs.getString("adresseUser");
            int numTelUser = rs.getInt("numTelUser");           
            String motDePasseUser = rs.getString("motDePasseUser");
            String roleUser = rs.getString("roleUser");
            String picUser = rs.getString("picUser");
            
     User.user = new User(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser,picUser);
        }
        return User.user;
    }
      public boolean updatePassword(String mdp,int id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update users set motDePasseUser='" + mdp + "' where idUser='" +id+"'");
        if (pre.executeUpdate() == 1) {
            return true;
        }

        return false;

    }
      public int getNombreEnseignant() throws SQLException{
          int nbrT=0;
           ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select count(*) from users where roleUser='Enseignant'");
          rs.first();
        nbrT=rs.getInt(1);
        
          
       return nbrT;
        
      }
       public int getNombreEtudiant() throws SQLException{
          int nbrT=0;
           ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select count(*) from users where roleUser='Etudiant'");
          rs.first();
        nbrT=rs.getInt(1);
        
          
       return nbrT;
        
      }
        public int getNombrePersonnel() throws SQLException{
          int nbrT=0;
           ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select count(*) from users where roleUser='Personnel'");
          rs.first();
        nbrT=rs.getInt(1);
        
          
       return nbrT;
        
      }
         public int getNombreParent() throws SQLException{
          int nbrT=0;
           ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select count(*) from users where roleUser='Parent'");
          rs.first();
        nbrT=rs.getInt(1);
        
          
       return nbrT;
        
      }
          public String getMail(int id) throws SQLException
    {
        List<Integer> arr = new ArrayList<>();
        ste = con.createStatement();
         String c="";
        ResultSet rs = ste.executeQuery("SELECT emailUser FROM `users` WHERE idUser='"+id+"'");
        while (rs.next()) {
      c=rs.getString("emailUser");
            
        }
    return c;
    }
}
