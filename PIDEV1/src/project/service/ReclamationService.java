/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.service;

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
import project.IService.IService;
import project.Utils.DataBase;
import project.entities.Etudiant;
import project.entities.Reclamation;

/**
 *
 * @author Neifos
 */
public class ReclamationService implements IService<Reclamation> {

    private Connection con;
    private Statement ste;

    public ReclamationService() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Reclamation r) throws SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement pre = con.prepareStatement("INSERT INTO `reclamation` (`idReclamation`,`sujetReclamation`,`descriptionReclamation`,`dateCreation`) VALUES (NULL,?,?,?);");
        pre.setString(1, r.getSujetReclamation());
        pre.setString(2, r.getDescriptionReclamation());
        pre.setString(3, dateFormat.format(r.getDateCreation()));

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
            
            
            r = new Reclamation(idReclamation, sujetReclamation, descriptionReclamation, statutReclamation, dateCreation);
            
        }
        
        
        return r;
    }

    @Override
    public List<Reclamation> readAll() throws SQLException {
 List<Reclamation> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from reclamation");
        while (rs.next()) {
            int idReclamation = rs.getInt("idReclamation");
            String sujetReclamation = rs.getString("sujetReclamation");
            String descriptionReclamation = rs.getString("descriptionReclamation");
            String statutReclamation = rs.getString("statutReclamation");
            Date dateCreation = rs.getDate("dateCreation");
            
            
            Reclamation r = new Reclamation(idReclamation, sujetReclamation, descriptionReclamation, statutReclamation, dateCreation);
            arr.add(r);
        }
        return arr;    }

}
