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

/**
 *
 * @author bouch
 */
public class ServiceMatier implements IService1<Matiere>{
    private Connection con;
    private Statement ste;
    private EnseignantService sp = new EnseignantService();
    public ServiceMatier() {
        con = Database.getInstance().getConnexion();
    }
    

    @Override
    public void ajouter(Matiere p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit1`.`Matier` ( `nom`, `coef`, `responsable`) VALUES ( ?, ?, ?);");
        pre.setString(1, p.getNomMatiere());
        pre.setFloat(2, p.getCoefficient());
        pre.setString(3, p.getResponsable().getIdUser());
        pre.executeUpdate();
    }

    @Override
    public boolean delete(Matiere t) throws SQLException {
        String sql = "DELETE FROM Matier WHERE id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, t.getIdMatiere());
        
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Matiere t) throws SQLException {
        String sql = "UPDATE matier SET nom=?, coef=?, responsable="+t.getResponsable().getIdUser()+" WHERE id="+t.getIdMatiere();
        System.out.println(t.getIdMatiere());
        System.out.println(t.getResponsable().getIdUser());
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1, t.getNomMatiere());
        pre.setFloat(2, t.getCoefficient());
        boolean updatedquery=pre.execute();
        return !updatedquery;             
    }
    @Override
    public List<Matiere> readAll() throws SQLException {
        List<Matiere> arr = new ArrayList<>();
        ste = con.createStatement();
        User p=new Enseignant();
        ResultSet rs = ste.executeQuery("select m.*,p.idUser,p.	nomUser,p.prenomUser from matier m join users p on m.responsable = p.id.idUser;");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nom = rs.getString(2);
            float coef = rs.getFloat(3);
            //User p=new Enseignant(rs.getString(4), rs.getString(4), rs.getString(4), rs.getString(4), rs.getString(4), nom, id, null, nom, nom, nom, nom, nom, Double.NaN, dateEmbaucheEnsg, nom);
            p.setIdUser(rs.getString(4));
            p.setNomUser(rs.getString(5));
            p.setPrenomUser(rs.getString(6));
            Matiere m = new Matiere(id, nom, coef, (Enseignant) p);
//            Matier m = new Matier(id, nom, coef);
            arr.add(m);
        }
            rs.close();
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
}
