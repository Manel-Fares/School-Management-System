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
import weboss.Entities.Enseignant;


/**
 *
 * @author Neifos
 */
public class EnseignantService implements IService1<Enseignant> {

    private Connection con;
    private Statement ste;

    public EnseignantService() {
        con = Database.getInstance().getConnexion();

    }

    @Override
    public void ajouter(Enseignant e) throws SQLException {
        System.out.println("cc");

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
        pre.setString(10, "Enseignant");
        pre.setString(11, dateFormat.format(e.getDateEmbaucheEnsg()));
        pre.setString(12, e.getMotDePasseUser());
        pre.setString(13, e.getStatutEnsg());
        pre.setDouble(14, e.getSalaireEnsg());
        pre.setString(15, e.getDomaineEnsg());

        pre.executeUpdate();
    }

    @Override
    public boolean delete(Enseignant t) throws SQLException {
        PreparedStatement pre=con.prepareStatement("delete from users where idUser="+t.getIdUser());
                if(pre.executeUpdate()==1)
                    return true;
                
                
                return false;
    }

    @Override
    public boolean update(Enseignant t) throws SQLException {
 PreparedStatement pre=con.prepareStatement("update users set nomUser='"+t.getNomUser()+"',prenomUser='"+t.getPrenomUser()+"',emailUser='"+t.getEmailUser()+"',adresseUser='"+t.getAdresseUser()+"',numTelUser='"+t.getNumTelUser()+"',motDePasseUser='"+t.getMotDePasseUser()+"' where idUser="+t.getIdUser() );
                if(pre.executeUpdate()==1)
                    return true;
                
                
                
                return false;   
    }
       public boolean update(Enseignant t,String id) throws SQLException {
 PreparedStatement pre=con.prepareStatement("update users set nomUser='"+t.getNomUser()+"',prenomUser='"+t.getPrenomUser()+"',emailUser='"+t.getEmailUser()+"',adresseUser='"+t.getAdresseUser()+"',numTelUser='"+t.getNumTelUser()+"',motDePasseUser='"+t.getMotDePasseUser()+"' where idUser="+id );
                if(pre.executeUpdate()==1)
                    return true;
                
                
                
                return false;   
    }

    @Override
    public List<Enseignant> readAll() throws SQLException {

        List<Enseignant> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users where roleUser='Enseignant'");
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
            String statutEnsg = rs.getString("statutUser");
            double salaireEnsg = rs.getDouble("salaireUser");
            Date dateEmbaucheEnsg = rs.getDate("dateEmbaucheUser");
            String domaineEnsg = rs.getString("domaineUser");
            String picUser = rs.getString("picUser");
           

            Enseignant u = new Enseignant(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser, statutEnsg,salaireEnsg,dateEmbaucheEnsg,domaineEnsg);

            arr.add(u);
        }
        return arr;
    }   
    public ObservableList<Enseignant> search(String nom) throws SQLException {

        ObservableList<Enseignant> arr = FXCollections.observableArrayList();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users where roleUser='Enseignant' and nomUser like '%"+nom+"%'");
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
            String statutEnsg = rs.getString("statutUser");
            double salaireEnsg = rs.getDouble("salaireUser");
            Date dateEmbaucheEnsg = rs.getDate("dateEmbaucheUser");
            String domaineEnsg = rs.getString("domaineUser");
            String picUser = rs.getString("picUser");
           

            Enseignant u = new Enseignant(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser, statutEnsg,salaireEnsg,dateEmbaucheEnsg,domaineEnsg);

            arr.add(u);
        }
        return arr;
    } 

  


}
