/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Personne;
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
public class ServicePersonne {

    private Connection con;
    private Statement ste;

    public ServicePersonne() {
        con = DataBase.getInstance().getConnection();
    }

    public List<Personne> readAll() throws SQLException {
        List<Personne> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from personne");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String prenom = rs.getString(3);
            int age = rs.getInt("age");
            Personne p = new Personne(id, nom, prenom, age);
            arr.add(p);
        }
        return arr;
    }

    public void update(int pid, String pnom, String pprenom, int page) throws SQLException {
        String query = "UPDATE `personne` SET `nom`=?,`prenom`=?,`age`=? WHERE `id`=?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, pnom);
            stmt.setString(2, pprenom);
            stmt.setInt(3, page);
            stmt.setInt(4, pid);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int pid) throws SQLException {
        String query = "delete from `personne` where `id`=?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, pid);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void ajouter(Personne t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `testpi0`.`personne` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getAge() + "');";
        ste.executeUpdate(requeteInsert);
    }

}
