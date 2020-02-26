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
import weboss.Entities.Chapitre;
import weboss.Entities.Matiere;

/**
 *
 * @author bouch
 */
public class ServiceChapitre implements IService1<Chapitre>{
    
    private Connection con;
    private Statement ste;
    public ServiceChapitre() {
        con = Database.getInstance().getConnexion();

    }

    @Override
       public void ajouter(Chapitre p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit1`.`Chapitre` ( `nom`, `file`, `matier`) VALUES ( ?, ?, ?);");
        pre.setString(1, p.getNom());
        pre.setString(2, p.getFile());
        pre.setInt(3, p.getMatier().getIdMatiere());
        pre.executeUpdate();
    }

@Override
    public boolean delete(Chapitre t) throws SQLException {
        String sql = "DELETE FROM Chapitre WHERE id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, t.getId());

        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Chapitre t) throws SQLException {
        String sql = "UPDATE chapitre SET nom=?, file=?, matier=? WHERE id="+t.getId();

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, t.getNom());
        pre.setString(2, t.getFile());
        pre.setInt(3, t.getMatier().getIdMatiere());
        int rowsUpdated = pre.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("test succ");
            return true;
        }
        System.out.println("test fail");
        return false;             
    }
    @Override
    public List<Chapitre> readAll() throws SQLException {
        List<Chapitre> arr = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Chapitre");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString("nom");
            String file = rs.getString(3);
            ids.add(rs.getInt(4));
            Chapitre p = new Chapitre(nom, file);
            arr.add(p);
        }
        rs.close();
        for (int i= 0 ; i<ids.size();i++){
        ServiceMatier sm = new ServiceMatier();
        arr.get(i).setMatier(sm.findById(ids.get(i)));
        }
        return arr;
    }
        public List<String> getchap() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id,nom from chapitre");
        while (rs.next()) {
           arr.add(rs.getInt(1)+" "+rs.getString(2));
        }
        return arr;
    }
    public Chapitre findById(int id) throws SQLException{
        ste = con.createStatement();
        System.out.println("chap");
        ResultSet rs = ste.executeQuery("select * from chapitre where id = "+id);
        System.out.println("donne chap");
        rs.first();
        System.out.println(rs.first());
        int i =rs.getInt(1);
        String nom=rs.getString(2);
        String path=rs.getString(3);
        rs.close();
       ServiceMatier sm = new ServiceMatier();
       Matiere m = sm.findById(i);
        Chapitre p = new Chapitre(id,nom, path, m);
        return p;
    }

    public List<String> getchapsofsubj(int id) throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select file from chapitre where matier="+id);
        while (rs.next()) {
           arr.add(rs.getString(1));
        }
        return arr;
    }
}
