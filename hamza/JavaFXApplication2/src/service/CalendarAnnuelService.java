/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connection.Database;
import IService.IService;
import entity.CalendarAnnuel;
import entity.Class;
import entity.Emplois;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    
    
  
}
