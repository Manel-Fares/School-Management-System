/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import Iservice.IService1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import weboss.BD.Database;
import weboss.Entities.Personnel;


/**
 *
 * @author Neifos
 */
public class PersonnelService implements IService1<Personnel> {

    private Connection con;
    private Statement ste;

    public PersonnelService() {
        con = Database.getInstance().getConnexion();

    }

    @Override
    public void ajouter(Personnel e) throws SQLException {
 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement pre = con.prepareStatement("INSERT INTO `users` (`idUser`, `cinUser`,`nomUser`,`prenomUser`,`dateNaissanceUser`,`sexeUser`,`emailUser`,`adresseUser`,`numTelUser`,`roleUser`,`dateEmbaucheUser`,`motDePasseUser`,`statutUser`,`salaireUser`,`domaineUser`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        pre.setString(1, null);
        pre.setInt(2, e.getCinUser());
        pre.setString(3, e.getNomUser());
        pre.setString(4, e.getPrenomUser());
        pre.setString(5, dateFormat.format(e.getDateNaissanceUser()));
        pre.setString(6, e.getSexeUser());
        pre.setString(7, e.getEmailUser());
        pre.setString(8, e.getAdresseUser());
        pre.setInt(9, e.getNumTelUser());
        pre.setString(10, "Personnel");
        pre.setString(11, dateFormat.format(e.getDateEmbauchePr()));
        pre.setString(12, e.getMotDePasseUser());
        pre.setString(13, e.getStatutPr());
        pre.setDouble(14, e.getSalairePr());
        pre.setString(15, e.getFonctionPr());

        pre.executeUpdate();    }

    @Override
    public boolean delete(Personnel t) throws SQLException {
 PreparedStatement pre=con.prepareStatement("delete from users where idUser="+t.getIdUser());
                if(pre.executeUpdate()==1)
                    return true;
                
                
                return false;    }

    @Override
    public boolean update(Personnel t) throws SQLException {
PreparedStatement pre=con.prepareStatement("update users set nomUser='"+t.getNomUser()+"',prenomUser='"+t.getPrenomUser()+"',emailUser='"+t.getEmailUser()+"',adresseUser='"+t.getAdresseUser()+"',numTelUser='"+t.getNumTelUser()+"',motDePasseUser='"+t.getMotDePasseUser()+"' where idUser="+t.getIdUser() );
                if(pre.executeUpdate()==1)
                    return true;
                
                
                
                return false;   
    }
        public boolean update(Personnel t,String id) throws SQLException {
PreparedStatement pre=con.prepareStatement("update users set nomUser='"+t.getNomUser()+"',prenomUser='"+t.getPrenomUser()+"',emailUser='"+t.getEmailUser()+"',adresseUser='"+t.getAdresseUser()+"',numTelUser='"+t.getNumTelUser()+"',motDePasseUser='"+t.getMotDePasseUser()+"' where idUser="+id );
                if(pre.executeUpdate()==1)
                    return true;
                
                
                
                return false;   
    }

    @Override
    public List<Personnel> readAll() throws SQLException {
 List<Personnel> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users where roleUser='Personnel'");
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
            Date dateEmbauchePr = rs.getDate("dateEmbaucheUser");
            String fonctionPr = rs.getString("domaineUser");
            String statutPr = rs.getString("statutUser");
            String picUser = rs.getString("picUser");
            Double salairePr = rs.getDouble("salaireUser");

                Personnel p = new Personnel(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser, statutPr, dateEmbauchePr, salairePr, fonctionPr);
            arr.add(p);
        }
        return arr;
    }    
        public ObservableList<Personnel> search(String nom) throws SQLException {
 ObservableList<Personnel> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users where roleUser='Personnel' and nomUser like '%"+nom+"%'");
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
            Date dateEmbauchePr = rs.getDate("dateEmbaucheUser");
            String fonctionPr = rs.getString("domaineUser");
            String statutPr = rs.getString("statutUser");
            String picUser = rs.getString("picUser");
            Double salairePr = rs.getDouble("salaireUser");

                Personnel p = new Personnel(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser, statutPr, dateEmbauchePr, salairePr, fonctionPr);
            arr.add(p);
        }
        return arr;
    } 
}

   


