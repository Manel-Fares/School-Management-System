/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import weboss.BD.Database;
import weboss.Entities.CalendarAnnuel;

/**
 *
 * @author Pytrooooo
 */
public class CalendarAnnuelService {
       private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public CalendarAnnuelService() {
        cnx = Database.getInstance().getConnexion();
    }
    
  

    
    public void AddCalendar(CalendarAnnuel t) {
        String req = "Insert into calendarannuel ( subject, term ,DateC)  values (?,?,?)";
        try {
            pst = cnx.prepareStatement(req);
             pst.setString(1,t.getSubject());
             pst.setString(2,t.getTerm());
             pst.setDate(3,t.getDateC());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
            public ObservableList<CalendarAnnuel> GetCalendar() {
        String req = "select * from calendarannuel";
        ObservableList<CalendarAnnuel> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new CalendarAnnuel(rs.getInt("id"),rs.getString("subject"), rs.getString("term"), rs.getDate("DateC")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
                        public ObservableList<CalendarAnnuel> GetDateCalendar() {
        String req = "select * from calendarannuel ";
        ObservableList<CalendarAnnuel> list = FXCollections.observableArrayList();
        CalendarAnnuel ca=new CalendarAnnuel();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
              list.add(new CalendarAnnuel(rs.getInt("id"),rs.getString("subject"), rs.getString("term"), rs.getDate("DateC")));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
                        
        public void DeleteCalendar(int id) {
        String req = "delete from calendarannuel where id = "+id+" ";
        try {
            ste = cnx.createStatement();
            //pst.setInt(1,id);
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CalendarAnnuelService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
           
         public void UpdateCalendar(CalendarAnnuel t) {
        String req = "update calendarannuel set subject =?,term =?,datec=? where id =? ";
        try {
            pst = cnx.prepareStatement(req);
             pst.setString(1,t.getSubject());
             pst.setString(2,t.getTerm());
             pst.setDate(3,t.getDateC());
             pst.setInt(4,t.getId());

            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CalendarAnnuelService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  
}
