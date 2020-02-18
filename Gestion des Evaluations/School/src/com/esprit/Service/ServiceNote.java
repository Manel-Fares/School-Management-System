/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Note;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

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
        PreparedStatement pre = con.prepareStatement("INSERT INTO  `school`.`Note` ( `idEtudiant`, `idMatiere`, `dateNote`,`noteCC`, `noteDS`, `noteExam`) VALUES ( ?, ?, ?, ?, ?, ?);");
        pre.setInt(1, n.getIdEtudiant());
        pre.setInt(2, n.getIdMatiere());
        pre.setDate(3, new Date(n.getDateNote().getYear(), n.getDateNote().getMonth(), n.getDateNote().getDay()));
        pre.setFloat(4, n.getNoteCC());
        pre.setFloat(5, n.getNoteDS());
        pre.setFloat(6, n.getNoteExam());
        //   pre.setFloat(7, n.getMoyenne());
        pre.executeUpdate();
    }

    @Override
    public void delete(Note n) throws SQLException {
        String sql = "DELETE FROM Note WHERE idEtudiant=? and idMatiere=? and dateNote=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, n.getIdEtudiant());
        pre.setInt(2, n.getIdMatiere());
        pre.setDate(3, new Date(n.getDateNote().getYear(), n.getDateNote().getMonth(), n.getDateNote().getDay()));

        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("une note a été supprimer avec succès");
        }
    }

    @Override
    public void update(Note n) throws SQLException {
        String sql = "UPDATE Note SET noteCC=?, noteDS=?, noteExam=? WHERE idEtudiant=? and idMatiere=? and dateNote=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setFloat(1, n.getNoteCC());
        pre.setFloat(2, n.getNoteDS());
        pre.setFloat(3, n.getNoteExam());
        pre.setInt(4, n.getIdEtudiant());
        pre.setInt(5, n.getIdMatiere());
        pre.setDate(6, new Date(n.getDateNote().getYear(), n.getDateNote().getMonth(), n.getDateNote().getDay()));

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
            float noteCC = rs.getFloat("noteCC");
            float noteDS = rs.getFloat("noteDS");
            float noteExam = rs.getFloat("noteExam");
            float moyenne = rs.getFloat("moyenne");

            Note n = new Note(idEtudiant, idMatiere, d, noteCC, noteDS, noteExam, moyenne);
            arr.add(n);
        }
        return arr;

    }

    public List<Note> listeNoteEtudiant(int idE) throws SQLException {
        List<Note> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Note WHERE idEtudiant=" + Integer.toString(idE));
        while (rs.next()) {
            int idMatiere = rs.getInt("idMatiere");
            int idEtudiant = rs.getInt("idEtudiant");
            Date d = rs.getDate("dateNote");
            float noteCC = rs.getFloat("noteCC");
            float noteDS = rs.getFloat("noteDS");
            float noteExam = rs.getFloat("noteExam");
            float moyenne = rs.getFloat("moyenne");

            Note n = new Note(idEtudiant, idMatiere, d, noteCC, noteDS, noteExam, moyenne);
            arr.add(n);
        }
        return arr;

    }

    public float formuleNote(Note n) {

        return n.getNoteCC() * 0.3f + n.getNoteDS() *0.2f+ n.getNoteExam() * 0.5f;

    }
    //permet de calculter moyenne d'une seule matiere
    public void calculMoyenneNote(Note n) throws SQLException {
        String sql = "UPDATE Note SET moyenne=? WHERE idEtudiant=? and idMatiere=? and dateNote=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setFloat(1, formuleNote(n));
        pre.setInt(2, n.getIdEtudiant());
        pre.setInt(3, n.getIdMatiere());
        pre.setDate(4, new Date(n.getDateNote().getYear(), n.getDateNote().getMonth(), n.getDateNote().getDay()));

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
