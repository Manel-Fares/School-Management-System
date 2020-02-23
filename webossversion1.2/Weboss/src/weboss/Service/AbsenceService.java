/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import weboss.BD.Database;
import weboss.Entities.Absence;
import weboss.Entities.Matiere;
import weboss.Entities.User;

/**
 *
 * @author Pytrooooo
 */
public class AbsenceService {
       private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public AbsenceService() {
        cnx = Database.getInstance().getConnexion();
    }
    
    
       public void AddAbsence(Absence t) {
        String req = "Insert into Absence ( id_user, id_matiere ,Date, TimeDeb,TimeFin)  values (?,?,?,?,?)";
        try {
            pst = cnx.prepareStatement(req);
             pst.setInt(1,Integer.valueOf(t.getUser().getIdUser()));
             pst.setInt(2,t.getMatiere().getId());
             pst.setDate(3,t.getDate());
             pst.setTime(4,t.getTimeDeb());
             pst.setTime(5,t.getTimeFin());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public ObservableList<User> GetRole(String role) {
      
        String req = "select * from users where roleUser='"+role+"' and classeEtd is NULL ";
        
       
        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
           
            while (rs.next()) {
                list.add(new User (String.valueOf(rs.getInt("idUser")),rs.getString("nomUser"),rs.getString("prenomUser"),rs.getString("roleUser")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   public ObservableList<User> GetRole2(String role) {
      
        String req = "select * from users where roleUser='"+role+"'  ";
        
       
        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
           
            while (rs.next()) {
                list.add(new User (String.valueOf(rs.getInt("idUser")),rs.getString("nomUser"),rs.getString("prenomUser"),rs.getString("roleUser")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

      public ObservableList<String> GetNomMatiere() {
      
        String req = "select nom from matier ";
        
       
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            System.out.println(rs);
            while (rs.next()) {
                list.add(rs.getString("nom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
            public Matiere GetMatiere(String nom) {
      
        String req = "select * from matier where nom='"+nom+"' ";
                System.out.println("b");       
        Matiere m= new Matiere();
        System.out.println("bb"); 
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            System.out.println(rs);
            System.out.println("bbb"); 
            while (rs.next()) {
                Matiere mm = new Matiere(rs.getInt("id"),rs.getString("nom"));
                m=mm;
                System.out.println("bbbb"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("bbbbb"); 
        return m;
    }
            
        public int GetNbrAbsence(int id) {
      
        String req = "select count(id_user) from absence  where id_user='"+id+"' ";

        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
          
            while (rs.next()) {                 
                 return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return 0;
    }
        
                public ObservableList<Integer> StatNbrAbsence() {
      
        String req = "select count(*) from users u inner join classe c on u.classeEtd=c.Name GROUP by u.classeEtd  ";
        ObservableList<Integer> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
          
            while (rs.next()) {                 
                 list.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return list;
    }
    
                    public ObservableList<String> StatNomAbsence() {
      
        String req = "select c.Name from users u inner join classe c on u.classeEtd=c.Name GROUP by u.classeEtd  ";
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
          
            while (rs.next()) {                 
                 list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return list;
    }
            
            
            public ObservableList<Absence> GetAbsence() {
        String req = "select u.*,a.*,m.* from Absence a inner join users u on a.id_user =u.idUser INNER JOIN matier m on m.id=a.id_matiere";
        ObservableList<Absence> list = FXCollections.observableArrayList();
        int n=0;
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            ResultSetMetaData rsmd = rs.getMetaData();               
            while (rs.next()) {  
                 
            ////// bich ni5dem constructeur user 
            int id_user = rs.getInt("u.idUser");
            String nom_user=rs.getString("u.nomUser");
            String prenom_user=rs.getString("u.prenomUser");
            String role_user=rs.getString("u.roleUser");
            ///// bich ni5dem constructeur matiere
            int id_matiere=rs.getInt("m.id");
            String nom_matiere=rs.getString("m.nom");
            //// bich ni5dem constructeur Absence
            int id_absence=rs.getInt("a.id");
            Date date_absence=rs.getDate("a.Date");
            Time timedeb_absence=rs.getTime("a.TimeDeb");
            Time timefin_absence=rs.getTime("a.TimeFin");
            ///// importation
            User user=new User(String.valueOf(id_user),nom_user,prenom_user,role_user);
            Matiere matiere=new Matiere(id_matiere,nom_matiere);
            Absence absence=new Absence(id_absence,user,matiere,date_absence,timedeb_absence,timefin_absence);
            //// final etape bras omok e5dem 
            list.add(absence);
   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
                System.out.println(n);
        return list;
    }
            
            public ObservableList<Absence> SearchEmplois(String source) {
        String req = "select u.*,a.*,m.* from Absence a inner join users u on a.id_user =u.idUser INNER JOIN matier m on m.id=a.id_matiere  where u.nomUser like '%"+source+"%'";
        ObservableList<Absence> list = FXCollections.observableArrayList();
        int n=0;
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            ResultSetMetaData rsmd = rs.getMetaData();               
            while (rs.next()) {  
                 
            ////// bich ni5dem constructeur user 
            int id_user = rs.getInt("u.idUser");
            String nom_user=rs.getString("u.nomUser");
            String prenom_user=rs.getString("u.prenomUser");
            String role_user=rs.getString("u.roleUser");
            ///// bich ni5dem constructeur matiere
            int id_matiere=rs.getInt("m.id");
            String nom_matiere=rs.getString("m.nom");
            //// bich ni5dem constructeur Absence
            int id_absence=rs.getInt("a.id");
            Date date_absence=rs.getDate("a.Date");
            Time timedeb_absence=rs.getTime("a.TimeDeb");
            Time timefin_absence=rs.getTime("a.TimeFin");
            ///// importation
            User user=new User(String.valueOf(id_user),nom_user,prenom_user,role_user);
            Matiere matiere=new Matiere(id_matiere,nom_matiere);
            Absence absence=new Absence(id_absence,user,matiere,date_absence,timedeb_absence,timefin_absence);
            //// final etape bras omok e5dem 
            list.add(absence);
   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
                System.out.println(n);
        return list;
    }
    
  
}
