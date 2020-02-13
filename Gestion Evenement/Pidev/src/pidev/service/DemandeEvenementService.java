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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pidev.BD.Database;
import pidev.entities.Club;
import pidev.entities.DemandeEvenement;

/**
 *
 * @author asus
 */
public class DemandeEvenementService implements IService<DemandeEvenement> {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public DemandeEvenementService() {
        cnx = Database.getInstance().getConnexion();
    }

    @Override
    public void ajouter(DemandeEvenement t) throws SQLException {

        String req = "INSERT INTO demandeevenement (Description,DateDebut,DateFin,Etat,	idClub,budget) values(?,?,?,?,?,?)";

        pst = cnx.prepareStatement(req);
        pst.setString(1, t.getDescription());
        pst.setString(2, t.getDatedebut());
        pst.setString(3, t.getDatefin());
        pst.setString(4, "Non valider");
        pst.setInt(5, t.getIdclub());
        pst.setFloat(6, t.getBudget());
        System.out.println("aaaaaaaaaaaaaaa");
        pst.execute();
    }

    @Override
    public void modifier(DemandeEvenement t, int id) throws SQLException {

        String req = "UPDATE `demandeevenement` SET `Description` = '" + t.getDescription() + "', `DateDebut` = '" + t.getDatedebut() + "', `DateFin` = '" + t.getDatefin() + "' WHERE `demandeevenement`.`idDemandeEvenement` =" + id + "";
        pst = cnx.prepareStatement(req);
        pst.execute();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM `demandeevenement` WHERE `demandeevenement`.`iddemandeevenement` = " + id + "";
        pst = cnx.prepareStatement(req);
        pst.execute();
    }

    @Override
    public List<DemandeEvenement> affciher() throws SQLException {
        List<DemandeEvenement> arr = new ArrayList<>();
        ste = cnx.createStatement();
        ResultSet rs = ste.executeQuery("select * from demandeevenement");
        while (rs.next()) {
            int id = rs.getInt("idDemandeEvenement");
            int idClub = rs.getInt("idClub");
            String Description = rs.getString("Description");
            Date dd = rs.getDate("DateDebut");
            Date df = rs.getDate("DateFin");
            String etat = rs.getString("Etat");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ddd = dateFormat.format(dd);
            DateFormat dateFormat0 = new SimpleDateFormat("yyyy-MM-dd");
            String dff = dateFormat0.format(df);
            DemandeEvenement dv = new DemandeEvenement(idClub, id, Description, ddd, dff, etat, id);
            arr.add(dv);

        }
        return arr;
    }

    public List<DemandeEvenement> afficherDemandeSpecifique(int idd) throws SQLException {
        List<DemandeEvenement> arr = new ArrayList<>();
        ste = cnx.createStatement();
        idd = 123;
        ResultSet rs = ste.executeQuery("select * from demandeevenement where  idClub='" + idd + "'");
        while (rs.next()) {
            int id = rs.getInt("idDemandeEvenement");
            int idClub = rs.getInt("idClub");
            String Description = rs.getString("Description");
            Date dd = rs.getDate("DateDebut");
            Date df = rs.getDate("DateFin");
            float budget = rs.getFloat("budget");

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String ddd = dateFormat.format(dd);
            DateFormat dateFormat0 = new SimpleDateFormat("yyyy-MM-dd");
            String dff = dateFormat0.format(df);
            DemandeEvenement dv = new DemandeEvenement(idClub, Description, ddd, dff, budget);
            arr.add(dv);
        }
        return arr;
    }

    public void valider(int id) throws SQLException {
        String etat = "valider";
        String req = "UPDATE `demandeevenement` SET `etat` = '" + etat + "' WHERE `demandeevenement`.`idDemandeEvenement` =" + id + "";
        pst = cnx.prepareStatement(req);
        pst.execute();
    }
    

    /*@Override
    public List<DemandeEvenement> recherche(String x) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
/*public void ajouterDemandeEvenement(DemandeEvenement Dev) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date_debut = dateFormat.format(Dev.getDatedebut());
        DateFormat dateFormat0 = new SimpleDateFormat("yyyy-MM-dd");
        String date_fin = dateFormat0.format(Dev.getDatefin());
        try {

            String req = "INSERT INTO demandeevenement (Description,DateDebut,DateFin,Etat) values(?,?,?,?)";
            pst = cnx.prepareStatement(req);
            pst.setString(1, Dev.getDescription());
            pst.setString(2, date_debut);
            pst.setString(3, date_fin);
            pst.setString(4, Dev.getEtat());
            pst.execute();
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    public void afficherDemandeEvenement() {
        try {
            String req = "SELECT * FROM demandeevenement ";
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                System.out.println("etat est :" + rs.getString("etat"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void supprimerDemandeEvenement(int id) {
        try {
            String req = "DELETE FROM `demandeevenement` WHERE `demandeevenement`.`iddemandeevenement` = " + id + "";
            pst = cnx.prepareStatement(req);
             pst.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modefierDemandeEvenement(int id, String des, Date dd, Date df) {
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date_debut = dateFormat.format(dd);
        DateFormat dateFormat0 = new SimpleDateFormat("yyyy-MM-dd");
        String date_fin = dateFormat0.format(df);
        try {
            String req = "UPDATE `demandeevenement` SET `Description` = '"+des+"', `DateDebut` = '"+date_debut+"', `DateFin` = '"+date_fin+"' WHERE `demandeevenement`.`idDemandeEvenement` ="+id+"";
             pst = cnx.prepareStatement(req);        
             pst.execute();
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public void ajouter(Object obj) {
        DemandeEvenement Dev =(DemandeEvenement) obj;
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date_debut = dateFormat.format(Dev.getDatedebut());
        DateFormat dateFormat0 = new SimpleDateFormat("yyyy-MM-dd");
        String date_fin = dateFormat0.format(Dev.getDatefin());
        try {

            String req = "INSERT INTO demandeevenement (Description,DateDebut,DateFin,Etat) values(?,?,?,?)";
            pst = cnx.prepareStatement(req);
            pst.setString(1, Dev.getDescription());
            pst.setString(2, date_debut);
            pst.setString(3, date_fin);
            pst.setString(4, Dev.getEtat());
            pst.execute();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
 */
