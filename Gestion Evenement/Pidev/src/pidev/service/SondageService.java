/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.service;

import IService.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.BD.Database;
import pidev.entities.Sondage;

/**
 *
 * @author asus
 */
public class SondageService implements IService<Sondage>{
private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public SondageService() {
            cnx = Database.getInstance().getConnexion();
}

    @Override
    public void ajouter(Sondage t) throws SQLException {
  String req = "INSERT INTO sondage (id_club,titre,description,	reponse) values(?,?,?,?)";
        pst = cnx.prepareStatement(req);
        pst.setInt(1, t.getIdclub());
        pst.setString(2, t.getTitre());
        pst.setString(3, t.getDescription());
        pst.setString(4, "Null");
        pst.execute();   
    }

   
    public List<Sondage> affciher_club(int id) throws SQLException {
         List<Sondage> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select * from Sondage where id='"+id+"'");
        while (rs.next()) {
            int ids = rs.getInt("id_sondage");
            int idc = rs.getInt("idClub");
            String titre = rs.getString("titre");
            String desc = rs.getString("description");
            String rep = rs.getString("reponse");
           
            Sondage c = new Sondage(ids, idc, titre, desc, rep);
            arr.add(c);
        }
        return arr;
    }

    @Override
    public void modifier(Sondage t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id) throws SQLException {
        
        String req = "DELETE FROM `sondage` WHERE `club`.`idClub` = " + id + "";
        pst = cnx.prepareStatement(req);

        pst.execute();
    }

    @Override
    public List<Sondage> affciher() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sondage> recherche(String x) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
