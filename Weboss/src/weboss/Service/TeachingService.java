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
import java.util.ArrayList;
import java.util.List;
import weboss.BD.Database;
import weboss.Entities.Enseignant;
import weboss.Entities.Matiere;
import weboss.Entities.User;
import weboss.Entities.teaching;

/**
 *
 * @author bouch
 */
public class TeachingService implements IService1<teaching>{
    private Connection con;
    private Statement ste;
    private EnseignantService sp = new EnseignantService();
    private ServiceMatier sm= new ServiceMatier();
    public TeachingService() {
         con = Database.getInstance().getConnexion();
    }
    

    
    public void ajouter(Matiere p,Enseignant e) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO Teaching ( `idMatiere`, `idEnseignant`) VALUES ( ?, ?);");
        pre.setInt(1, p.getIdMatiere());
        pre.setString(2, e.getIdUser());
        pre.executeUpdate();
    }

    public boolean delete(Matiere t,Enseignant e) throws SQLException {
        String sql = "DELETE FROM teaching WHERE idMatiere=? and idEnseignant=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, t.getIdMatiere());
        pre.setString(2, e.getIdUser());
        
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(teaching t) throws SQLException {
        return false;
    }
    @Override
    public List<teaching> readAll() throws SQLException {
        List<teaching> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<String> arr3 = new ArrayList<>();
        ste = con.createStatement();
        User p=new Enseignant();
        ResultSet rs = ste.executeQuery("select * from enseigner;");
        
        while (rs.next()) {
            arr2.add(rs.getInt(2));
            arr3.add(rs.getString(1));
            
//User p=new Enseignant(rs.getString(4), rs.getString(4), rs.getString(4), rs.getString(4), rs.getString(4), nom, id, null, nom, nom, nom, nom, nom, Double.NaN, dateEmbaucheEnsg, nom);
        }
            rs.close();
            for(int j=0;j<arr2.size();j++){
                
            Matiere m =sm.findById(arr2.get(j));
            p=(Enseignant) sp.findById(arr3.get(j));
            teaching t=new teaching(m, (Enseignant) p);
            arr.add(t);
            }
        return arr;
    }
        public List<String> getMat() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id,nom from matier");
        while (rs.next()) {
           arr.add(rs.getInt(1)+" "+rs.getString(2));
        }
        return arr;
    }
    public Matiere findById(int id) throws SQLException{
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from matier where id = "+id);
        rs.first();
        if (rs.getInt(4)>0){
            String i =rs.getString(4);
            String nom =rs.getString(2);
            Float coef = rs.getFloat(3);
        rs.close();
        Enseignant res = (Enseignant) sp.findById(i);
        Matiere p = new Matiere(id,nom, coef, res);
        return p;
        }else{
        Matiere p = new Matiere(id,rs.getString(2), Float.parseFloat(rs.getString(3)),null);
        rs.close();
        return p;
            
        }
        
    }

    @Override
    public void ajouter(teaching t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(teaching t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}