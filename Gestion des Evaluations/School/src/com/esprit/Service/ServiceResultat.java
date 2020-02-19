/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Note;
import com.esprit.Entite.Resultat;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aymen
 */
public class ServiceResultat {

    private Connection con;
    private Statement ste;

    public ServiceResultat() {
        con = DataBase.getInstance().getConnection();
    }

    public void ajouter(Resultat r) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO  `school`.`Resultat` ( `idEtudiant`, `dateResultat`, `resultat`) VALUES ( ?, ?, ?);");
        pre.setInt(1, r.getIdEtudiant());
        pre.setDate(2, new Date(r.getDateResultat().getYear(), r.getDateResultat().getMonth(), r.getDateResultat().getDay()));
        pre.setFloat(3, 0.0f);
        pre.executeUpdate();
    }

    public List<Resultat> readAll() throws SQLException {
        List<Resultat> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Resultat");
        while (rs.next()) {
            int idEtudiant = rs.getInt("idEtudiant");
            Date d = rs.getDate("dateResultat");
            float resultat = rs.getFloat("resultat");

            Resultat r = new Resultat(idEtudiant, d, resultat);
            arr.add(r);
        }
        return arr;

    }

    public List<Integer> getListEtudiant() throws SQLException {
        List<Integer> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select idUser from users where roleUser = 'Etudiant'");
        while (rs.next()) {
            int id = rs.getInt("idUser");
            arr.add(id);
        }
        return arr;

    }
        public void delete(Resultat r) throws SQLException {
        String sql = "DELETE FROM Resultat WHERE idEtudiant=? ";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, r.getIdEtudiant());
        
        
     
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Resultat a été supprimer avec succès");
        }
    }
     public float calculcoeff(int c) throws SQLException {
         ResultSet rs = ste.executeQuery("select coef from matier WHERE id like 'c'");
            return rs.getInt("coef");
     }

    // public formuleResultat(int coeff,){}
    public float calculResultatParEtudiant(int idE) throws SQLException {
        ServiceNote ser = new ServiceNote();
        int coef=3;
        int sommeCoeff = 0;
        float sommeMoy = 0.0f;
        List<Note> listN = ser.listeNoteEtudiant(idE);
        for (Note n : listN) {
           /* ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select coef from matier WHERE id= 2");
            int coef = rs.getInt("coef");
            System.out.println(coef);*/
            sommeCoeff += coef;
            sommeMoy += (n.getMoyenne() * coef);
        }
        return (float) sommeMoy / sommeCoeff;
    }

    public void enregistrerResultat(int idE) throws SQLException {
        String sql = "UPDATE Resultat SET resultat=? WHERE idEtudiant=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setFloat(1, calculResultatParEtudiant(idE));
        pre.setInt(2, idE);

        int rowsUpdated = pre.executeUpdate();

        pre.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Resultat enregistrer avec succès!");
        }

    }

    public void calculResultats(List<Integer> l) throws SQLException {
        ServiceNote ser = new ServiceNote();
        Resultat r;
        for (Integer E : l) {
            r = new Resultat(E, new java.util.Date(2020, 02, 12));
            ajouter(r);
            enregistrerResultat(E);

        }

    }

}
