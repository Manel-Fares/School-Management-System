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
import weboss.Entities.Rating;

/**
 *
 * @author asus
 */
public class RatingService implements IService<Rating> {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public RatingService() {
        cnx = Database.getInstance().getConnexion();
    }

    @Override
    public void ajouter(Rating t) throws SQLException {
        String req = "INSERT INTO rating (iduser,idClub,rating) values(?,?,?)";

        pst = cnx.prepareStatement(req);
        pst.setString(1, t.getEt().getIdUser());
        pst.setInt(2, t.getC().getIdClub());
        pst.setDouble(3, t.getRating());
        pst.execute();
    }

    @Override
    public List<Rating> affciher() throws SQLException {
        List<Rating> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select * from rating");
        while (rs.next()) {
            int id = rs.getInt("idrating");

            int idUser = rs.getInt("iduser");
            int idClub = rs.getInt("idClub");
            double idResponsable = rs.getDouble("rating");
            Rating c = new Rating(id, idResponsable, idClub, idUser);
            arr.add(c);
        }
        return arr;
    }

    public List<Double> recuperernbrRating(int id) throws SQLException {
        List<Double> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select rating from rating where idClub='" + id + "'");
        while (rs.next()) {
            double c = rs.getDouble("rating");
            arr.add(c);
        }
        return arr;
    }

    public int recupererRateEtudiant(int idc, int idu) throws SQLException {

        int arr = 0;
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select count(iduser) nbr from rating where idClub='" + idc + "' and idUser='" + idu + "'");
        while (rs.next()) {
            int c = rs.getInt(1);
            arr = c;
        }
        return arr;
    }

    public void calculerRateClub(int id) {
    }

    public List<Integer> recupereridEtudiant() throws SQLException {
        List<Integer> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select iduser from rating");
        while (rs.next()) {
            int c = rs.getInt("iduser");
            arr.add(c);
        }
        return arr;
    }

    public void modifier(Rating t, double nvrat) throws SQLException {
        String req = "UPDATE `rating` SET `rating` = '" + nvrat + "' where idClub='" + t.getC().getIdClub() + "' and idUser='" + t.getEt().getIdUser() + "'";
        pst = cnx.prepareStatement(req);
        pst.execute();
    }
   public  double ratingClub(int id) throws SQLException
    {//
double arr=0;
ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("SELECT AVG(rating) FROM `rating` WHERE idClub='"+id+"'");
        while (rs.next()) {
           
            
            double c = rs.getDouble(1);
           
            arr=c;
        }
        return arr;
    }
    @Override
    public void supprimer(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rating> recherche(String x) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Rating t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
