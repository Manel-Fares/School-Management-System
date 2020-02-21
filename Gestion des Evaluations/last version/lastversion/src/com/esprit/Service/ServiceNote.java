/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Matiere;
import com.esprit.Entite.Note;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author House
 */
public class ServiceNote implements IService<Note> {

    private Connection con;
    private Statement ste;

    public ServiceNote() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Note n) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO  `school`.`Note` ( `idEtudiant`, `idMatiere`,`idEnseignant`, `dateNote`,`noteCC`, `noteDS`, `noteExam`) VALUES ( ?, ?, ? ,?, ?, ?, ?);");
        pre.setInt(1, n.getIdEtudiant());
        pre.setInt(2, n.getIdMatiere());
        pre.setInt(3, n.getIdEnseignant());
        pre.setDate(4, n.getDateNote());
        pre.setDouble(5, n.getNoteCC());
        pre.setDouble(6, n.getNoteDS());
        pre.setDouble(7, n.getNoteExam());
        //   pre.setFloat(7, n.getMoyenne());
        pre.executeUpdate();
    }

    @Override
    public void delete(Note n) throws SQLException {
        String sql = "DELETE FROM Note WHERE idEtudiant=? and idMatiere=? and dateNote=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, n.getIdEtudiant());
        pre.setInt(2, n.getIdMatiere());
        pre.setDate(3, n.getDateNote());

        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("une note a été supprimer avec succès");
        }
    }

    @Override
    public void update(Note n) throws SQLException {
        String sql = "UPDATE Note SET noteCC=?, noteDS=?, noteExam=? WHERE idEtudiant=? and idMatiere=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setDouble(1, n.getNoteCC());
        pre.setDouble(2, n.getNoteDS());
        pre.setDouble(3, n.getNoteExam());
        pre.setInt(4, n.getIdEtudiant());
        pre.setInt(5, n.getIdMatiere());
       // pre.setDate(6, n.getDateNote());

        int rowsUpdated = pre.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("une note existante a été mise à jour avec succès!");
        }

    }

    @Override
    public List<Note> readAll() throws SQLException {
        List<Note> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Note");
        while (rs.next()) {
            int idMatiere = rs.getInt("idMatiere");
            int idEtudiant = rs.getInt("idEtudiant");
            Date d = rs.getDate("dateNote");
            double noteCC = rs.getDouble("noteCC");
            double noteDS = rs.getDouble("noteDS");
            double noteExam = rs.getDouble("noteExam");
            double moyenne = rs.getDouble("moyenne");

            Note n = new Note(idEtudiant, idMatiere, d, noteCC, noteDS, noteExam, moyenne);
            arr.add(n);
        }
        return arr;

    }

    public ObservableList<Note> getNotes() {

        ObservableList<Note> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select * from Note ");
            while (rs.next()) {
                int idMatiere = rs.getInt("idMatiere");
                int idEtudiant = rs.getInt("idEtudiant");
                Date d = rs.getDate("dateNote");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");

                Note n = new Note(idEtudiant, idMatiere, d, noteCC, noteDS, noteExam, moyenne);
                arr.add(n);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }

    public ObservableList<Note> listeNoteEtudiant(String idE) {

        ObservableList<Note> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select n.*,m.nom,m.coef from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + idE);
            while (rs.next()) {
                int idMatiere = rs.getInt("idMatiere");
                int idEtudiant = rs.getInt("idEtudiant");
                Date d = rs.getDate("dateNote");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");
                float coefficient = rs.getFloat("coef");


                Note n = new Note(idEtudiant, idMatiere, d, noteCC, noteDS, noteExam, moyenne);
                n.setCoefficient(coefficient);
                arr.add(n);
            }
                    } catch (SQLException ex) {
        }
            return arr;


    }
    
    public ObservableList<Note> listeNoteEtudiantinterface(String idE) {

        ObservableList<Note> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select n.*,m.nom,m.coef from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + idE);
            while (rs.next()) {

                String nomMatiere = rs.getString("nom");
                System.out.println(nomMatiere);
                float coefficient = rs.getFloat("coef");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                //       double moyenne = rs.getDouble("moyenne");
            
                Note n = new Note(noteCC, noteDS, noteExam,nomMatiere, coefficient);
                arr.add(n);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }
    
     public ObservableList<Note> listeEtudiantCredit(String idE) {

        ObservableList<Note> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select n.*,m.nom,m.coef from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + idE+" and n.moyenne < 8");
            while (rs.next()) {

                String nomMatiere = rs.getString("nom");
                System.out.println(nomMatiere);
                float coefficient = rs.getFloat("coef");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");
                System.out.println(moyenne);
                Note n = new Note(noteCC, noteDS, noteExam, moyenne, nomMatiere, coefficient);
                arr.add(n);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }
    
    public ObservableList<Note> listeMoyenneNoteEtudiant(String idE) {

        ObservableList<Note> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select n.*,m.nom,m.coef from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + idE);
            while (rs.next()) {

                String nomMatiere = rs.getString("nom");
                double moyenne = rs.getDouble("moyenne");

                Note n = new Note(nomMatiere, moyenne);
                arr.add(n);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }

    public List<Note> listeNoteEtudiant(int idE) throws SQLException {
        List<Note> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select n.*,m.nom,m.coef from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + Integer.toString(idE));
        while (rs.next()) {
            int idMatiere = rs.getInt("idMatiere");
            int idEtudiant = rs.getInt("idEtudiant");
            Date d = rs.getDate("dateNote");
            double noteCC = rs.getDouble("noteCC");
            double noteDS = rs.getDouble("noteDS");
            double noteExam = rs.getDouble("noteExam");
            double moyenne = rs.getDouble("moyenne");

            Note n = new Note(idEtudiant, idMatiere, d, noteCC, noteDS, noteExam, moyenne);
            n.setCoefficient(rs.getFloat("coef"));
            arr.add(n);
        }
        return arr;

    }

    public double formuleNote(Note n) {

        return n.getNoteCC() * 0.3 + n.getNoteDS() * 0.2 + n.getNoteExam() * 0.5;

    }

    //permet de calculter moyenne d'une seule matiere
    public void calculMoyenneNote(Note n) throws SQLException {
        String sql = "UPDATE Note SET moyenne=? WHERE idEtudiant=? and idMatiere=? and dateNote=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setDouble(1, formuleNote(n));
        pre.setInt(2, n.getIdEtudiant());
        pre.setInt(3, n.getIdMatiere());
        pre.setDate(4, n.getDateNote());

        int rowsUpdated = pre.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("moyenne enregistrer avec succes!");
        }

    }

    public void calculMoyennesNotes(List<Note> l) throws SQLException {
        for (Note n : l) {
            calculMoyenneNote(n);
        }

    }
}
