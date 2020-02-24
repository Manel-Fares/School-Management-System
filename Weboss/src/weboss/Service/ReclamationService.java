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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import weboss.BD.Database;
import weboss.Entities.Etudiant;
import weboss.Entities.Reclamation;


/**
 *
 * @author Neifos
 */
public class ReclamationService implements IService1<Reclamation> {

    private Connection con;
    private Statement ste;

    public ReclamationService() {
        con = Database.getInstance().getConnexion();

    }

    @Override
    public void ajouter(Reclamation r) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement pre = con.prepareStatement("INSERT INTO `reclamation` (`idReclamation`,`sujetReclamation`,`descriptionReclamation`,`dateCreation`,`idEtd`) VALUES (NULL,?,?,?,?);");
        pre.setString(1, r.getSujetReclamation());
        pre.setString(2, r.getDescriptionReclamation());
        pre.setString(3, dateFormat.format(r.getDateCreation()));
        pre.setString(4, r.getUser().getIdUser());
      

        pre.executeUpdate();
    }
    public void ajouter(Reclamation r,String id) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement pre = con.prepareStatement("INSERT INTO `reclamation` (`idReclamation`,`sujetReclamation`,`descriptionReclamation`,`dateCreation`,`idEtd`) VALUES (NULL,?,?,?,?);");
        pre.setString(1, r.getSujetReclamation());
        pre.setString(2, r.getDescriptionReclamation());
        pre.setString(3, dateFormat.format(r.getDateCreation()));
        pre.setString(4, id);

        pre.executeUpdate();
    }

    @Override
    public boolean delete(Reclamation t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("delete from reclamation where idReclamation=" + t.getIdReclamation());
        if (pre.executeUpdate() == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean update(Reclamation t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update reclamation set descriptionReclamation='" + t.getDescriptionReclamation()+ "' where idReclamation=" + t.getIdReclamation());
        if (pre.executeUpdate() == 1) {
            return true;
        }

        return false;
    }

    public boolean updateEtat(Reclamation t) throws SQLException {
        PreparedStatement pre = con.prepareStatement("update reclamation set statutReclamation='" + t.getStatutReclamation() + "' where idReclamation=" + t.getIdReclamation());
        if (pre.executeUpdate() == 1) {
            return true;
        }

        return false;
    }
    public Reclamation search(int id) throws SQLException{
        Reclamation r=null;
         ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from reclamation where idReclamation="+id);
         
        while(rs.next()){
             int idReclamation = rs.getInt("idReclamation");
            String sujetReclamation = rs.getString("sujetReclamation");
            String descriptionReclamation = rs.getString("descriptionReclamation");
            String statutReclamation = rs.getString("statutReclamation");
            Date dateCreation = rs.getDate("dateCreation");
            
            
            r = new Reclamation(idReclamation, sujetReclamation, descriptionReclamation, statutReclamation, dateCreation,null);
            
        }
        
        
        return r;
    }

    @Override
    public List<Reclamation> readAll() throws SQLException {
 List<Reclamation> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select r.*,us.* from reclamation r join users us on us.idUser=r.idEtd");
        while (rs.next()) {
            int idReclamation = rs.getInt("r.idReclamation");
            String sujetReclamation = rs.getString("r.sujetReclamation");
            String descriptionReclamation = rs.getString("r.descriptionReclamation");
            String statutReclamation = rs.getString("r.statutReclamation");
            Date dateCreation = rs.getDate("r.dateCreation");
               String idUser = rs.getString("us.idUser");
           int cinUser = rs.getInt("us.cinUser");
            String nomUser = rs.getString("us.nomUser");
            String prenomUser = rs.getString("us.prenomUser");
            java.sql.Date dateNaissanceUser = rs.getDate("us.dateNaissanceUser");
           String sexeUser = rs.getString("us.sexeUser");
            String emailUser = rs.getString("us.emailUser");
            String adresseUser = rs.getString("us.adresseUser");
           int numTelUser = rs.getInt("us.numTelUser");
            String motDePasseUser = rs.getString("us.motDePasseUser");
            String roleUser = rs.getString("us.roleUser");
            String picUser = rs.getString("us.picUser");
            
            String classeEtd = rs.getString("us.classeEtd");
            java.sql.Date inscriptionEtd = rs.getDate("us.inscriptionEtd");
            String specialiteEtd = rs.getString("us.specialiteEtd");
            String idParent = rs.getString("us.idParent");
            
            Etudiant etd = new Etudiant(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser,picUser, classeEtd, inscriptionEtd, specialiteEtd, null);
            
            
            Reclamation r = new Reclamation(idReclamation, sujetReclamation, descriptionReclamation, statutReclamation, dateCreation,etd);
            arr.add(r);
        }
        return arr;    
    }


   public List<Reclamation> readAllParEtudiant(Etudiant e)  throws SQLException {
 List<Reclamation> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from reclamation where idEtd='"+e.getIdUser()+"'");
        while (rs.next()) {
            int idReclamation = rs.getInt("idReclamation");
            String sujetReclamation = rs.getString("sujetReclamation");
            String descriptionReclamation = rs.getString("descriptionReclamation");
            String statutReclamation = rs.getString("statutReclamation");
            Date dateCreation = rs.getDate("dateCreation");
            
            
            Reclamation r = new Reclamation(idReclamation, sujetReclamation, descriptionReclamation, statutReclamation, dateCreation,null);
            arr.add(r);
        }
        return arr;   
}
 
}
