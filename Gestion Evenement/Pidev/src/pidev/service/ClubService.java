/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.service;

import IService.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pidev.BD.Database;
import pidev.entities.Club;
import IService.*;
/**
 *
 * @author asus
 */
public class ClubService implements IService<Club> {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public ClubService() {
        cnx = Database.getInstance().getConnexion();
    }

    @Override
    public void ajouter(Club t) throws SQLException {
        String req = "INSERT INTO club (nomClub,idResponsable,domaine) values(?,?,?)";
       
        pst = cnx.prepareStatement(req);
        pst.setString(1, t.getNomClub());
        pst.setInt(2, t.getIdResponsable());
         System.out.println("aaa");
        pst.setString(3, t.getDomaine());
        pst.execute();
    }

    @Override
    public void modifier(Club t, int id) throws SQLException {
        int idd = t.getIdResponsable();
        String nom = t.getNomClub();
        System.out.println(idd);
        System.out.println(nom);

        String req = "UPDATE `club` SET `idResponsable` ='" + idd + "', `nomClub`= '" + nom + "' WHERE `club`.`idClub`=" + id + "";
        pst = cnx.prepareStatement(req);
        pst.execute();
    }

    @Override
    public void supprimer(int id) throws SQLException {

        String req = "DELETE FROM `club` WHERE `club`.`idClub` = " + id + "";
        pst = cnx.prepareStatement(req);

        pst.execute();
    }

    @Override
    public List<Club> affciher() throws SQLException {
        List<Club> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select * from club");
        while (rs.next()) {
            int id = rs.getInt("idClub");
            String nomClub = rs.getString("nomClub");
            int idResponsable = rs.getInt("idResponsable");
            String domaine =rs.getString("domaine");
            Club c = new Club(id, idResponsable, nomClub,domaine);
            arr.add(c);
        }
        return arr;
    }

   
   /* @Override
    public List<Club> recherche(String x) throws SQLException {
List<Club> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select * from club where idClub like '%"+x+"%'");
        while (rs.next()) {
            int id = rs.getInt("idClub");
            String nomClub = rs.getString("nomClub");
            int idEtudiant = rs.getInt("idEtudiant");
            Club c = new Club(id, idEtudiant, nomClub);
            arr.add(c);
        }
        return arr;    */}
//}
/*public void afficherClubcv ()
    { //List<Club> l=new Vector<>();
        try {
            String req="SELECT * FROM club ";
            ste = cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next())
            {
                System.out.println("id"+rs.getString("nomClub"));     
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public void ajouterClub(Club x) {
        try {        


            String req = "INSERT INTO club (nomClub,idEtudiant) values(?,?)";
            pst = cnx.prepareStatement(req);
            pst.setString(1, x.getNomClub());
            pst.setInt(2, x.getIdEtudiant());
            pst.execute();
        } catch (SQLException e) {
            e.getMessage();
        }

    }
    public  void supprimerClub(int id)
    {
 try {        


            String req = "DELETE FROM `club` WHERE `club`.`idClub` = "+id+"";
            pst = cnx.prepareStatement(req);
           
            pst.execute();
        } catch (SQLException e) {
            e.getMessage();
        }
    
    
    }
   
     public  void modefierClub(int id,String nom,int idd)
    {
 try {        


            String req = "UPDATE `club` SET `idEtudiant` = '"+idd+"', `nomClub` = '"+nom+" WHERE `club`.`idClub` = "+id+"";
            pst = cnx.prepareStatement(req);        
            pst.execute();
        } catch (SQLException e) {
            e.getMessage();
        }
    
    
    }

 */
