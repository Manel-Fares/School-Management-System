/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Tag;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bensl
 */
public class ServiceTag {
    private Connection con;
    private Statement ste;

    public ServiceTag() {
        con = DataBase.getInstance().getConnection();
    }
    
    public List<Tag> readAll() throws SQLException {
        List<Tag> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from tag");
        while (rs.next()) {
              int id_tag = rs.getInt(1);
              String nom = rs.getString(2);
              String description = rs.getString(3);
              
              Tag t1 = new Tag(id_tag, nom, description);
              arr.add(t1);
        }
        return arr;
    }
    
    public void update(int id_tag, String nom, String description) throws SQLException {
        String query = "UPDATE `tag` SET `nom`=?,`description`=? WHERE `id_tag`=?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
//            stmt.setString(1, pnom);
//            stmt.setString(2, pprenom);
//            stmt.setInt(3, page);
//            stmt.setInt(4, pid);
              stmt.setString(1, nom);
              stmt.setString(2, description);
              stmt.setInt(3, id_tag);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int pid) throws SQLException {
        String query = "DELETE FROM `tag` WHERE `id_tag`=?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, pid);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void ajouter(Tag t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tag` (`id_tag`, `nom`, `description`) VALUES ('"+t.getId_tag()+"', '"+t.getNom()+"', '"+t.getDescription()+"');";
        ste.executeUpdate(requeteInsert);
    }
}
