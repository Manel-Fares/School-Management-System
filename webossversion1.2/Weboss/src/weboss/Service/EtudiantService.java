/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import Iservice.IService1;
import java.security.Key;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import weboss.BD.Database;
import weboss.Entities.Etudiant;
import weboss.Entities.Parent;

/**
 *
 * @author Neifos
 */
public class EtudiantService implements IService1<Etudiant> {

    private Connection con;
    private Statement ste;

    public EtudiantService() {
        con = Database.getInstance().getConnexion();

    }

    @Override
    public void ajouter(Etudiant e) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement pre = con.prepareStatement("INSERT INTO `users` (`idUser`, `cinUser`,`nomUser`,`prenomUser`,`dateNaissanceUser`,`sexeUser`,`emailUser`,`adresseUser`,`numTelUser`,`roleUser`,`motDePasseUser`,`classeEtd`,`inscriptionEtd`,`specialiteEtd`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        pre.setString(1, null);
        pre.setInt(2, e.getCinUser());
        pre.setString(3, e.getNomUser());
        pre.setString(4, e.getPrenomUser());
        pre.setDate(5, e.getDateNaissanceUser());
        pre.setString(6, e.getSexeUser());
        pre.setString(7, e.getEmailUser());
        pre.setString(8, e.getAdresseUser());
        pre.setInt(9, e.getNumTelUser());
        pre.setString(10, "Etudiant");
        pre.setString(11, e.getMotDePasseUser());
        pre.setString(12, e.getClasseEtd());
        pre.setDate(13, e.getInscriptionEtd());
        pre.setString(14, e.getSpecialiteEtd());

        pre.executeUpdate();
    }
  public void ajouter(Etudiant e,String id) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement pre = con.prepareStatement("INSERT INTO `users` (`idUser`, `cinUser`,`nomUser`,`prenomUser`,`dateNaissanceUser`,`sexeUser`,`emailUser`,`adresseUser`,`numTelUser`,`roleUser`,`motDePasseUser`,`classeEtd`,`inscriptionEtd`,`specialiteEtd`,`idParent`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        pre.setString(1, null);
        pre.setInt(2, e.getCinUser());
        pre.setString(3, e.getNomUser());
        pre.setString(4, e.getPrenomUser());
        pre.setString(5, dateFormat.format(e.getDateNaissanceUser()));
        pre.setString(6, e.getSexeUser());
        pre.setString(7, e.getEmailUser());
        pre.setString(8, e.getAdresseUser());
        pre.setInt(9, e.getNumTelUser());
        pre.setString(10, "Etudiant");
        pre.setString(11, e.getMotDePasseUser());
        pre.setString(12, e.getClasseEtd());
        pre.setString(13, dateFormat.format(e.getInscriptionEtd()));
        pre.setString(14, e.getSpecialiteEtd());
        pre.setString(15, id);

        pre.executeUpdate();
    }
    @Override
    public boolean delete(Etudiant t) throws SQLException {

        PreparedStatement pre = con.prepareStatement("delete from users where idUser=" + t.getIdUser());
        if (pre.executeUpdate() == 1) {
            return true;
        }

        return false;

    }
    @Override
   public boolean update(Etudiant t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update users set nomUser='" + t.getNomUser() + "',prenomUser='" + t.getPrenomUser() + "',emailUser='" + t.getEmailUser() + "',adresseUser='" + t.getAdresseUser() + "',numTelUser='" + t.getNumTelUser() + "',motDePasseUser='" + t.getMotDePasseUser() + "' where idUser=" +t.getIdUser());
        if (pre.executeUpdate() == 1) {
            return true;
        }

        return false;

    }
    public boolean update(Etudiant t,String id) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update users set nomUser='" + t.getNomUser() + "',prenomUser='" + t.getPrenomUser() + "',emailUser='" + t.getEmailUser() + "',adresseUser='" + t.getAdresseUser() + "',numTelUser='" + t.getNumTelUser() + "',motDePasseUser='" + t.getMotDePasseUser() + "' where idUser=" +id);
        if (pre.executeUpdate() == 1) {
            return true;
        }

        return false;

    }

    @Override
    public List<Etudiant> readAll() throws SQLException {
        System.out.println("ccggggggg");
        List<Etudiant> arr = new ArrayList<>();
        ste = con.createStatement();
        
       ResultSet rs = ste.executeQuery("select us.*,u.* from users us join users u on u.cinUser=us.idParent");        
      
       // ResultSet rs = ste.executeQuery("select * from users where roleUser='Etudiant'");
        while (rs.next()) {
          //  System.out.println(rs.getString("idUser"));
            String idUser = rs.getString("us.idUser");
           int cinUser = rs.getInt("us.cinUser");
            String nomUser = rs.getString("us.nomUser");
            String prenomUser = rs.getString("us.prenomUser");
            Date dateNaissanceUser = rs.getDate("us.dateNaissanceUser");
           String sexeUser = rs.getString("us.sexeUser");
            String emailUser = rs.getString("us.emailUser");
            String adresseUser = rs.getString("us.adresseUser");
           int numTelUser = rs.getInt("us.numTelUser");
            String motDePasseUser = rs.getString("us.motDePasseUser");
            String roleUser = rs.getString("us.roleUser");
            
            String classeEtd = rs.getString("us.classeEtd");
            Date inscriptionEtd = rs.getDate("us.inscriptionEtd");
            String specialiteEtd = rs.getString("us.specialiteEtd");
            String idParent = rs.getString("us.idParent");
           
            String idUserP = rs.getString("u.idUser");
           int cinUserP = rs.getInt("u.cinUser");
            String nomUserP = rs.getString("u.nomUser");
            String prenomUserP = rs.getString("u.prenomUser");
            Date dateNaissanceUserP = rs.getDate("u.dateNaissanceUser");
           String sexeUserP = rs.getString("u.sexeUser");
            String emailUserP = rs.getString("u.emailUser");
            String adresseUserP = rs.getString("u.adresseUser");
           int numTelUserP = rs.getInt("u.numTelUser");
            String motDePasseUserP = rs.getString("u.motDePasseUser");
            String roleUserP = rs.getString("u.roleUser");
        
    
        
   
            
         
             // motDePasseUser= decrypt(motDePasseUser, "45");
            Parent p = new Parent(idUserP, cinUserP, nomUserP, prenomUserP, emailUserP, adresseUserP, numTelUserP, dateNaissanceUserP, sexeUserP, motDePasseUserP, roleUserP);
            
           // System.out.println(p);
            Etudiant u = new Etudiant(idUser, cinUser,nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser, classeEtd, inscriptionEtd,specialiteEtd,p);
                       
                         
            arr.add(u);
        }
        return arr;
    }

        public ObservableList<Etudiant> search(String nom) throws SQLException {
        System.out.println("ccggggggg");
        ObservableList<Etudiant> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        
       ResultSet rs = ste.executeQuery("select us.*,u.* from users us join users u on u.cinUser=us.idParent where us.nomUser like '%"+nom+"%'");        
      
   
        while (rs.next()) {
         
            String idUser = rs.getString("us.idUser");
           int cinUser = rs.getInt("us.cinUser");
            String nomUser = rs.getString("us.nomUser");
            String prenomUser = rs.getString("us.prenomUser");
            Date dateNaissanceUser = rs.getDate("us.dateNaissanceUser");
           String sexeUser = rs.getString("us.sexeUser");
            String emailUser = rs.getString("us.emailUser");
            String adresseUser = rs.getString("us.adresseUser");
           int numTelUser = rs.getInt("us.numTelUser");
            String motDePasseUser = rs.getString("us.motDePasseUser");
            String roleUser = rs.getString("us.roleUser");
            
            String classeEtd = rs.getString("us.classeEtd");
            Date inscriptionEtd = rs.getDate("us.inscriptionEtd");
            String specialiteEtd = rs.getString("us.specialiteEtd");
            String idParent = rs.getString("us.idParent");
           
            String idUserP = rs.getString("u.idUser");
           int cinUserP = rs.getInt("u.cinUser");
            String nomUserP = rs.getString("u.nomUser");
            String prenomUserP = rs.getString("u.prenomUser");
            Date dateNaissanceUserP = rs.getDate("u.dateNaissanceUser");
           String sexeUserP = rs.getString("u.sexeUser");
            String emailUserP = rs.getString("u.emailUser");
            String adresseUserP = rs.getString("u.adresseUser");
           int numTelUserP = rs.getInt("u.numTelUser");
            String motDePasseUserP = rs.getString("u.motDePasseUser");
            String roleUserP = rs.getString("u.roleUser");
        
    
        
   
            
         
             // motDePasseUser= decrypt(motDePasseUser, "45");
            Parent p = new Parent(idUserP, cinUserP, nomUserP, prenomUserP, emailUserP, adresseUserP, numTelUserP, dateNaissanceUserP, sexeUserP, motDePasseUserP, roleUserP);
            
           // System.out.println(p);
            Etudiant u = new Etudiant(idUser, cinUser,nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser, classeEtd, inscriptionEtd,specialiteEtd,p);
                       
                         
            arr.add(u);
        }
        return arr;
    }

    public String encrypt(String password, String key) {
        try {
            Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, clef);
            return new String(cipher.doFinal(password.getBytes()));
        } catch (Exception e) {
            return null;
        }
    }

    public String decrypt(String password, String key) {
        try {
            Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, clef);
            return new String(cipher.doFinal(password.getBytes()));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

   

}
