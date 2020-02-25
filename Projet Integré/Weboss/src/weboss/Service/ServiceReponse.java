/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import Iservice.IServiceQA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import weboss.BD.Database;
import weboss.Entities.Reponse;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author bensl
 */
public class ServiceReponse {
    private Connection con;
    private Statement ste;

    public ServiceReponse() {
        con = Database.getInstance().getConnexion();
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
    
    public void ajouter2(Reponse r) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `reponse` (`body`, `vote_reponse`, `id_question`) VALUES ('"+r.getBody()+"', '"+r.getVote_reponse()+"', '"+r.getId_question()+"');";
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
    
//    public List<Reponse> findResponseByQuestion(int i) throws SQLException {
//        List<Reponse> arr = new ArrayList<>();
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery("SELECT * FROM `reponse` WHERE `id_question`= "+i);
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
    
    
    
//    public List<Reponse> findResponseByQuestionUser(int i, int u) throws SQLException {
//        List<Reponse> arr = new ArrayList<>();
//        ste = con.createStatement();
//        ResultSet rs = ste.executeQuery("SELECT * FROM `reponse` WHERE `id_question`= "+i);
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
    
    public List<String> findResponseByQuestion(int i) throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT `body` FROM `reponse` WHERE `id_question`= "+i);
        while (rs.next()) {
              String body = rs.getString(1);
              arr.add(body);
        }
        return arr;
    }
        
    public static void sendMail(String recepient,String subj,String desc) throws MessagingException{
        System.out.println("prep...");
        Properties prop = new Properties();
        
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");
        
        String from ="benslamawajih@gmail.com";
        String mdp = "Fsociety_NBM%22";
        
        Session session = Session.getInstance(prop,new Authenticator() {
            @Override
            protected  PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from, mdp);
              }
            });
        Message  message = prepareMessage(session,from,recepient,subj,desc);
        
        Transport.send(message);
        System.out.println("mail send");
    }
    private static Message prepareMessage(Session session, String from,String recepient,String subj,String desc){
        try{
            Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject(subj);
            message.setText(desc);
            return message;
        }catch(Exception ex){
            System.out.println("error send");
        }
        return null;
    }
    
}
