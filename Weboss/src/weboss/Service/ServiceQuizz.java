/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;


import Iservice.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import weboss.BD.Database;
import weboss.Entities.Chapitre;
import weboss.Entities.QuestionQuizz;
import weboss.Entities.Quizz;

/**
 *
 * @author bouch
 */
public class ServiceQuizz implements IService1<Quizz> {

    private Connection con;
    private Statement ste;

    public ServiceQuizz() {
        con = Database.getInstance().getConnexion();

    }

    public int getIdLast() throws SQLException {
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from quizz");
        rs.last();
        return rs.getInt(1);

    }

    public void ajouter1(Quizz p, int chid) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit1`.`Quizz` (`chapitre`) VALUES (?);");
        pre.setInt(1, p.getChapitre().getId());
        pre.executeUpdate();
        ServiceQuestionQuizz sqq = new ServiceQuestionQuizz();
        List<QuestionQuizz> l = sqq.findLById2(p);
        for (int i = 0; i < l.size(); i++) {
            PreparedStatement pre2 = con.prepareStatement("INSERT INTO `esprit1`.`QuestionQuizz` (`question`,`rep1`,`rep2`,`rep3`,`rep`,`quiz`)VALUES (?,?,?,?,?,?);");
            pre2.setString(1, l.get(i).getQuestion());
            pre2.setString(2, l.get(i).getRep1());
            pre2.setString(3, l.get(i).getRep2());
            pre2.setString(4, l.get(i).getRep3());
            pre2.setString(5, l.get(i).getRep());
            pre2.setInt(6, getIdLast());
            pre2.executeUpdate();
        }
    }

    @Override
    public boolean delete(Quizz t) throws SQLException {
        String sql = "DELETE FROM Quizz WHERE id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, t.getId());

        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Quizz t) throws SQLException {
        String sql = "UPDATE Quizz SET Chapitre=? WHERE id=" + t.getId();
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, t.getChapitre().getId());
        int rowsUpdated = pre.executeUpdate();
        if (rowsUpdated > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Quizz> readAll() throws SQLException {
        List<Quizz> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Quizz");

        ServiceChapitre sc = new ServiceChapitre();

        while (rs.next()) {
            int id = rs.getInt(1);
            Chapitre ch = sc.findById(rs.getInt(2));
            Quizz p = new Quizz(id, ch);
            arr.add(p);
        }
        rs.close();
        return arr;
    }

    public List<String> getql() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id,chapitre from quizz");
        while (rs.next()) {
            arr.add(rs.getInt(1) + " " + rs.getString(2));
        }
        rs.close();
        return arr;
    }
        ServiceChapitre sc=new ServiceChapitre();
/////////////////////////////
    public Quizz findById(int id) throws SQLException {
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from quizz where id = " + id);
        System.out.println(rs.first());
        int i = rs.getInt(2);
        System.out.println("donne2");
        rs.close();
        System.out.println("closed rs");
        Chapitre c = sc.findById(i);
        Quizz p = new Quizz(id, c);
        return p;
    }
////////////////////////////////
    @Override
    public void ajouter(Quizz t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
