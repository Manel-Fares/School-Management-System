/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.service;

import java.security.Key;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import project.Utils.DataBase;
import project.IService.IService;
import project.entities.Etudiant;
import project.entities.User;

/**
 *
 * @author Neifos
 */
public class EtudiantService implements IService<Etudiant> {

    private Connection con;
    private Statement ste;

    public EtudiantService() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Etudiant e) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement pre = con.prepareStatement("INSERT INTO `users` (`idUser`, `cinUser`,`nomUser`,`prenomUser`,`dateNaissanceUser`,`sexeUser`,`emailUser`,`adresseUser`,`numTelUser`,`roleUser`,`motDePasseUser`,`classeEtd`,`inscriptionEtd`,`specialiteEtd`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
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
        PreparedStatement pre = con.prepareStatement("update users set nomUser='" + t.getNomUser() + "',prenomUser='" + t.getPrenomUser() + "',emailUser='" + t.getEmailUser() + "',adresseUser='" + t.getAdresseUser() + "',numTelUser='" + t.getNumTelUser() + "',motDePasseUser='" + t.getMotDePasseUser() + "',classeEtd='" + t.getClasseEtd() + "' where idUser=" + t.getIdUser());
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
        ResultSet rs = ste.executeQuery("select * from users where roleUser='Etudiant'");
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
            String classeEtd = rs.getString("classeEtd");
            Date inscriptionEtd = rs.getDate("inscriptionEtd");
            String specialiteEtd = rs.getString("specialiteEtd");
           motDePasseUser= decrypt(motDePasseUser, "45");
            Etudiant u = new Etudiant(idUser, cinUser,nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, classeEtd, inscriptionEtd,specialiteEtd);

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
