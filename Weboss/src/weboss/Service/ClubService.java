/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import Iservice.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import weboss.BD.Database;
import weboss.Entities.Club;
import weboss.Entities.User;


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
        System.out.println(t.getResponsable().getIdUser());
        pst.setString(2, t.getResponsable().getIdUser());
        System.out.println("aaa");
        pst.setString(3, t.getDomaine());
        pst.execute();
    }

    @Override
    public void modifier(Club t, int id) throws SQLException {

        String req = "UPDATE `club` SET `domaine` ='" + t.getDomaine() + "', `nomClub`= '" + t.getNomClub() + "' WHERE `club`.`idClub`=" + id + "";
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
        ResultSet rs = ste.executeQuery("select c.*,u.* from club as c Inner join users as u on c.idResponsable=u.idUser ");
        while (rs.next()) {
            int id = rs.getInt("c.idClub");
            String nomClub = rs.getString("c.nomClub");
            String idResponsable = rs.getString("u.nomUser");
            String nomResponsable = rs.getString("u.prenomUser");
            String domaine = rs.getString("c.domaine");
            User u=new User(idResponsable, nomResponsable);
            Club c = new Club(id, u, nomClub, domaine);
            
            arr.add(c);
        }
        return arr;
    }

    public List<Integer> recuperer_id_clubs() throws SQLException {
        List<Integer> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select DISTINCT(club.idClub) from club INNER JOIN evenement on club.idClub=evenement.idClub");
        while (rs.next()) {
            int c = rs.getInt("idClub");
            arr.add(c);
        }
        return arr;
    }

    public Club RecupererClb(int idd) throws SQLException {

     Club cc=new Club();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select c.*,u.* from club as c Inner join users as u on c.idResponsable=u.idUser where c.idClub = '"+idd+"'");
        while (rs.next()) {
            int id = rs.getInt("c.idClub");
            String nomClub = rs.getString("c.nomClub");
            String idResponsable = rs.getString("u.nomUser");
            String nomResponsable = rs.getString("u.prenomUser");
            String domaine = rs.getString("c.domaine");
            User u=new User(idResponsable, nomResponsable);
            Club c = new Club(id, u, nomClub, domaine);
            cc=c;
        
        }
        return cc;
    }

    public Club recuperer_id_club(int id) throws SQLException {
        List<Integer> arr = new ArrayList<>();
        Club cc=new Club();
        ste = cnx.createStatement();
       // int c = 0;
        ResultSet rs = ste.executeQuery("select club.*,users.* from club INNER JOIN users on club.idResponsable=users.idUser where users.idUser='" + id + "'  ");
        while (rs.next()) {
            User u=new User(rs.getString("users.idUser"),rs.getString("users.nomUser"),rs.getString("users.prenomUser"));
            Club c=new Club(rs.getInt("club.idClub"),u,rs.getString("club.nomClub"),rs.getString("club.domaine"));
            cc=c;
        }
        return cc;
    }
       public int recupererResponsable(int id) throws SQLException {
        List<Integer> arr = new ArrayList<>();
        ste = cnx.createStatement();
        int c = 0;
        ResultSet rs = ste.executeQuery("select idResponsable from club where idClub='" + id + "'");
        while (rs.next()) {
            c = rs.getInt("idResponsable");
        }
        return c;
    }
       public User recupererInfoResponsable(String id) throws SQLException {
        User uu=new User();
        ste = cnx.createStatement();
        int c = 0;
        ResultSet rs = ste.executeQuery("select IdUser,nomUser,prenomUser from users where idUser='" + id + "'");
        while (rs.next()) {
            User u = new User(rs.getString("idUser"), rs.getString("nomUser"), rs.getString("prenomUser"));
            uu=u;
            System.out.println(uu);
        }
        return uu;
    }
    // select club.idClub from club INNER JOIN users on club.idResponsable=users.idUser

    public List<Club> recherche(String x) throws SQLException {
          List<Club> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select c.*,u.* from club as c Inner join users as u on c.idResponsable=u.idUser where c.nomClub like '%"+x+"%' ");
        while (rs.next()) {
            int id = rs.getInt("c.idClub");
            String nomClub = rs.getString("c.nomClub");
            String idResponsable = rs.getString("u.nomUser");
            String nomResponsable = rs.getString("u.prenomUser");
            String domaine = rs.getString("c.domaine");
            User u=new User(idResponsable, nomResponsable);
            Club c = new Club(id, u, nomClub, domaine);
            
            arr.add(c);
        }
        return arr;
    }
public int recupererResponsablExist(int id) throws SQLException {
        List<Integer> arr = new ArrayList<>();
        ste = cnx.createStatement();
        int c = 0;
        ResultSet rs = ste.executeQuery("select idClub from club where idResponsable='" + id + "'");
        while (rs.next()) {
            c = rs.getInt("idClub");
        }
        return c;
    }    /* @Override
    select club.idClub from club INNER JOIN users on club.idResponsable=users.idUser
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
        return arr;    */
}
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
