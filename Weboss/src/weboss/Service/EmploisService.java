/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;


import Iservice.IService2;
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
import weboss.Entities.Emplois;

/**
 *
 * @author Pytrooooo
 */
public class EmploisService implements IService2<Emplois>{
     private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public EmploisService() {
        cnx = Database.getInstance().getConnexion();
    }
    
    
     @Override
     public void AddEmplois(Emplois t) {
        String req = "Insert into Emplois ( date, heure , source)  values (?,?,?)";
        try {
            pst = cnx.prepareStatement(req);
             pst.setDate(1,t.getDate());
             pst.setTime(2,t.getHeure());
             pst.setString(3,t.getSource());
             
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmploisService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     @Override
       public ObservableList<Emplois> GetEmplois() {
        String req = "select * from Emplois";
        ObservableList<Emplois> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Emplois(rs.getInt("idemplois"), rs.getDate("date"), rs.getTime("heure"),rs.getString("source")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmploisService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       
       @Override  
       public void DeleteEmplois(int id) {
        String req = "delete from Emplois where idemplois = "+id+" ";
        try {
            ste = cnx.createStatement();
            //pst.setInt(1,id);
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EmploisService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
         @Override   
         public void UpdateEmplois(Emplois t) {
        String req = "update Emplois set date = ?,heure = ?,source = ? where idemplois = ? ";
        try {
            pst = cnx.prepareStatement(req);
              pst.setDate(1,t.getDate());
             pst.setTime(2,t.getHeure());
             pst.setString(3,t.getSource());
             pst.setInt(4,t.getIdEmplois());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmploisService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
         
          @Override
    public ObservableList<Emplois> SearchEmplois(String source) {
        String req = "select * from Emplois where source like '%"+source+"%' ";
        ObservableList<Emplois> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
                    
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Emplois(rs.getInt("idemplois"), rs.getDate("date"), rs.getTime("heure"),rs.getString("source")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void DeleteClass(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddClass(Emplois t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateClass(Emplois t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Emplois> GetClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Emplois> SearchClass(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
