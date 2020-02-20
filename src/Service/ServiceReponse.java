/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entite.Reponse;
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
public class ServiceReponse {
    private Connection con;
    private Statement ste;

    public ServiceReponse() {
        con = DataBase.getInstance().getConnection();
    }
    
    public List<Reponse> readAll() throws SQLException {
        List<Reponse> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM `reponse`");
        while (rs.next()) {
//            int id = rs.getInt(1);
//            String nom = rs.getString("nom");
//            String prenom = rs.getString(3);
//            int age = rs.getInt("age");
              int id_reponse = rs.getInt(1);
              String body = rs.getString(2);
              int vote_reponse = rs.getInt(3);
              int id_question = rs.getInt(4);
              Reponse r = new Reponse(id_reponse, body, vote_reponse, id_question);
              arr.add(r);
            //Personne p = new Personne(id, nom, prenom, age);
            //arr.add(p);
        }
        return arr;
    }
    
    public void ajouter(Reponse r) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `reponse` (`id_reponse`, `body`, `vote_reponse`, `id_question`) VALUES ('"+r.getId_reponse()+"', '"+r.getBody()+"', '"+r.getVote_reponse()+"', '"+r.getId_question()+"');";
        ste.executeUpdate(requeteInsert);
    }
    
    public void update(int pid_reponse, String pbody, int pvote_reponse, int pid_question) throws SQLException {
        String query = "UPDATE `reponse` SET `body`=?,`vote_reponse`=?,`id_question`=? WHERE `id_reponse`=?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
              stmt.setString(1, pbody);
              stmt.setInt(2, pvote_reponse);
              stmt.setInt(3, pid_question);
              stmt.setInt(4, pid_reponse);
              stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int pid) throws SQLException {
        String query = "DELETE FROM `reponse` WHERE `id_reponse`=?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, pid);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public List<Reponse> findResponseByQuestion(int i) throws SQLException {
        List<Reponse> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT * FROM `reponse` WHERE `id_question`= "+i);
        while (rs.next()) {
              int id_reponse = rs.getInt(1);
              String body = rs.getString(2);
              int vote_reponse = rs.getInt(3);
              int id_question = rs.getInt(4);
              Reponse r = new Reponse(id_reponse, body, vote_reponse, id_question);
              arr.add(r);
        }
        return arr;
    }
    
//    public List<Reponse> findResponseByQuestionUser(int i, int u) throws SQLException {
//        List<Reponse> arr = new ArrayList<>();
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery("SELECT * FROM `reponse` WHERE `id_question`= "+i+" AND `personne_id`= "+u);
//        while (rs.next()) {
//              int id_reponse = rs.getInt(1);
//              String body = rs.getString(2);
//              int vote_reponse = rs.getInt(3);
//              int id_question = rs.getInt(4);
//              Reponse r = new Reponse(id_reponse, body, vote_reponse, id_question);
//              arr.add(r);
//        }
//        return arr;
//    }
    
}
