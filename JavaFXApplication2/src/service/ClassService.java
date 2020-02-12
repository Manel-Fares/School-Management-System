/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connection.Database;
import IService.IService;
import entity.Class;
import entity.Emplois;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Pytrooooo
 */
public class ClassService implements IService{
       private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public ClassService() {
        cnx = Database.getInstance().getConnexion();
    }
    
       @Override
     public void AddClass(Class t) {
        String req = "Insert into classe ( name, niveau , nbr_etudiant,Description)  values (?,?,?,?)";
        try {
            pst = cnx.prepareStatement(req);
             pst.setString(1,t.getName());
             pst.setString(2,t.getNiveau());
             pst.setInt(3,t.getNbr_Etudiant());
             pst.setString(4,t.getDescription());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     @Override
       public ObservableList<Class> GetClass() {
        String req = "select * from classe";
        ObservableList<Class> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Class(rs.getInt("id"), rs.getString("name"), rs.getString("niveau"),rs.getInt("nbr_etudiant"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       
       @Override  
       public void DeleteClass(int id) {
        String req = "delete from classe where id = "+id+" ";
        try {
            ste = cnx.createStatement();
            //pst.setInt(1,id);
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
         @Override   
         public void UpdateClass(Class t) {
        String req = "update classe set name =?,niveau =?,nbr_etudiant =?,description =? where id =? ";
        try {
            pst = cnx.prepareStatement(req);
             pst.setString(1,t.getName());
             pst.setString(2,t.getNiveau());
             pst.setInt(3,t.getNbr_Etudiant());
             pst.setString(4,t.getDescription());
             pst.setInt(5,t.getId());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
         @Override
    public ObservableList<Class> SearchClass(String nom) {
        String req = "select * from classe where name like '%"+nom+"%' ";
        ObservableList<Class> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
                    
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Class(rs.getInt("id"), rs.getString("name"), rs.getString("niveau"),rs.getInt("nbr_etudiant"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void AddEmplois(Emplois t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Emplois> GetEmplois() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteEmplois(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateEmplois(Emplois t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Emplois> SearchEmplois(String source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
  
}
