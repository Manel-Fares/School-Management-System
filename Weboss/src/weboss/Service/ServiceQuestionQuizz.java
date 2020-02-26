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
import weboss.Entities.QuestionQuizz;
import weboss.Entities.Quizz;

/**
 *
 * @author bouch
 */
public class ServiceQuestionQuizz implements IService1<QuestionQuizz> {

    private Connection con;
    private Statement ste;
    ServiceQuizz sq = new ServiceQuizz();
    
    public ServiceQuestionQuizz() {
        con = Database.getInstance().getConnexion();
    }
    
    @Override
    public void ajouter(QuestionQuizz p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit1`.`QuestionQuizz` ( `question`, `rep1`, `rep2`, `rep3`, `rep`) VALUES ( ?, ?, ?, ?, ?);");
        pre.setString(1, p.getQuestion());
        pre.setString(2, p.getRep1());
        pre.setString(3, p.getRep2());
        pre.setString(4, p.getRep3());
        pre.setString(5, p.getRep());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(QuestionQuizz t) throws SQLException {
        String sql = "DELETE FROM QuestionQuizz WHERE id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, t.getId());
        
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean update(QuestionQuizz t) throws SQLException {
        String sql = "UPDATE questionquizz SET question=?, rep1=?, rep2=?, rep3=?, rep=? WHERE id=?";
        
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, t.getQuestion());
        pre.setString(2, t.getRep1());
        pre.setString(3, t.getRep2());
        pre.setString(4, t.getRep3());
        pre.setString(5, t.getRep());
        pre.setInt(6, t.getId());
        int rowsUpdated = pre.executeUpdate();
        if (rowsUpdated > 0) {
            return true;
        }
        return false;        
    }

    @Override
    public List<QuestionQuizz> readAll() throws SQLException {
        List<QuestionQuizz> arr = new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from questionquizz");
        while (rs.next()) {
            int id = rs.getInt(1);
            Quizz ch;
            String question = rs.getString(2);
            String rep1 = rs.getString(3);
            String rep2 = rs.getString(4);
            String rep3 = rs.getString(5);
            String rep = rs.getString(6);
            li.add(rs.getInt(7));
            QuestionQuizz p = new QuestionQuizz(id,question, rep1, rep2, rep3, rep,null);
            arr.add(p);
        }
        rs.close();
        for (int i =0 ; i <li.size();i++){
            if(li.get(i)>0){
                System.out.println(li.get(i));
                arr.get(i).setQ(sq.findById(li.get(i)));
            
            }
        }
        return arr;
        
    }

    public List<String> getqq(int id) throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id,question,rep1,rep2,rep3,rep from questionquizz where quiz =" + id);
        while (rs.next()) {
            arr.add(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
        }
        rs.close();
        return arr;
    }

    public QuestionQuizz findById(int id) throws SQLException {
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from questionquizz where id = " + id);
        int i=rs.getInt(7);
        rs.close();
        QuestionQuizz p = new QuestionQuizz(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), sq.findById(i));
        return p;
    }

    public List<QuestionQuizz> findLById() throws SQLException {
        ste = con.createStatement();
       
        List<QuestionQuizz> arr = new ArrayList<>();
       
            ResultSet rs = ste.executeQuery("select * from questionquizz where quiz is null");
            while (rs.next()) {
                arr.add(new QuestionQuizz(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
            rs.close();
        return arr;
    }

    public List<QuestionQuizz> findLById2(Quizz q) throws SQLException {
        ste = con.createStatement();
       
        List<QuestionQuizz> arr = new ArrayList<>();
       
            ResultSet rs = ste.executeQuery("select * from questionquizz where quiz = "+q.getId());
          
            while (rs.next()) {
                arr.add(new QuestionQuizz(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),q));
            }
    rs.close();
        return arr;
    }
}
