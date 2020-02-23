
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;


import Iservice.IService3;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import weboss.BD.Database;
import weboss.Entities.Note;
import weboss.Entities.User;

/**
 *
 * @author House
 */
public class ServiceNote implements IService3<Note> {

    private Connection con;
    private Statement ste;

    public ServiceNote() {
        con = Database.getInstance().getConnexion();
    }

    @Override
    public void ajouter(Note n) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO  `school`.`Note` ( `idEtudiant`, `idMatiere`,`idEnseignant`, `dateNote`,`noteCC`, `noteDS`, `noteExam`, `moyenne`) VALUES ( ?, ?, ? ,?, ?, ?, ?, ?);");
        pre.setInt(1, Integer.parseInt(n.getEtudiant().getIdUser()));
        pre.setInt(2, n.getMatiere().getIdMatiere());
        pre.setInt(3, Integer.parseInt(n.getEnseignant().getIdUser()));
        pre.setDate(4, n.getDateNote());
        pre.setDouble(5, n.getNoteCC());
        pre.setDouble(6, n.getNoteDS());
        pre.setDouble(7, n.getNoteExam());
        pre.setDouble(8, n.getMoyenne());
        
        //   pre.setFloat(7, n.getMoyenne());
        pre.executeUpdate();
    }

    @Override
    public void delete(Note n) throws SQLException {
        String sql = "DELETE FROM Note WHERE idEtudiant=? and idMatiere=? and dateNote=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, Integer.parseInt(n.getEtudiant().getIdUser()));
        pre.setInt(2, n.getMatiere().getIdMatiere());
        pre.setDate(3, n.getDateNote());

        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("une note a été supprimer avec succès");
        }
    }

    @Override
    public void update(Note n) throws SQLException {
        String sql = "UPDATE Note SET noteCC=?, noteDS=?, noteExam=? ,moyenne=? WHERE idEtudiant=? and idMatiere=? and dateNote=?";

        PreparedStatement pre = con.prepareStatement(sql);
        pre.setDouble(1, n.getNoteCC());
        pre.setDouble(2, n.getNoteDS());
        pre.setDouble(3, n.getNoteExam());
        pre.setDouble(4, n.getMoyenne());
        pre.setInt(5, Integer.parseInt(n.getEtudiant().getIdUser()));
        pre.setInt(6, n.getMatiere().getIdMatiere());
        pre.setDate(7, n.getDateNote());

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
/*
    public List<Note> getNotesEnseignant(String nomClasse, int idMat, int idEns) {

        List<Note> arr = new ArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("SELECT n.*, u.cinUser, u.nomUser, u.prenomUser from note n "
                    + "JOIN users u on n.idEtudiant = u.idUser where n.idEnseignant = " + Integer.toString(idEns) 
                    + "  and n.idMatiere = " + Integer.toString(idMat)+" and u.classeEtd like '"+nomClasse+"'");
            while (rs.next()) {
                String nom = rs.getString("nomUser");
                String prenom = rs.getString("prenomUser");
                int cin = rs.getInt("cinUser");
                int idEnseignant = rs.getInt("idEnseignant");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");
                User etd = new User(cin,nom, prenom);
                Note n = new Note(etd, noteCC, noteDS, noteExam, moyenne);
                
                arr.add(n);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }*/

     public ObservableList<Note> getNotesEnseignant1(String nomClasse, int idMat, int idEns) {

        ObservableList<Note> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("SELECT n.*, u.cinUser, u.nomUser, u.prenomUser from note n "
                    + "JOIN users u on n.idEtudiant = u.idUser where n.idEnseignant = " + Integer.toString(idEns) 
                    + "  and n.idMatiere = " + Integer.toString(idMat)+" and u.classeEtd like '"+nomClasse+"'");
            while (rs.next()) {
                int idEtudiant = rs.getInt("idEtudiant");
//                int idEnseignant = rs.getInt("idEnseignant");
//                int idMatiere = rs.getInt("idMatiere");
                Date dateNote = rs.getDate("dateNote");
                String nom = rs.getString("nomUser");
                String prenom = rs.getString("prenomUser");
                int cin = rs.getInt("cinUser");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");
                System.out.println(nom);
                System.out.println(prenom);
           //     Note n = new Note(cin, nom, prenom, noteCC, noteDS, noteExam, moyenne);
             //   System.out.println("cin= "+n.getEtudiant().getCin());
               // System.out.println("moyenne= "+n.getMoyenne());
               String info =Integer.toString(cin)+"            "+nom+"            "+prenom;
                  
                Note n = new Note(idEtudiant, idMat, idEtudiant, dateNote, noteCC, noteDS, noteExam, moyenne, info);

                
                arr.add(n);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }

         public ObservableList<User> getNotesEnseignant2(String nomClasse, int idMat, int idEns) {

        ObservableList<User> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("SELECT n.*, u.cinUser, u.nomUser, u.prenomUser from note n "
                    + "JOIN users u on n.idEtudiant = u.idUser where n.idEnseignant = " + Integer.toString(idEns) 
                    + "  and n.idMatiere = " + Integer.toString(idMat)+" and u.classeEtd like '"+nomClasse+"'");
            while (rs.next()) {
                String nom = rs.getString("nomUser");
                String prenom = rs.getString("prenomUser");
                int cin = rs.getInt("cinUser");


                System.out.println(nom);
                System.out.println(prenom);
   
                 User etd = new User(cin,nom, prenom);

                arr.add(etd);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }

    
    
    public ObservableList<String> GetNomMatiere(String idE, String nomClass) {

        String req = "SELECT nom from matier m join cours c on m.id = c.idMatiere "
                + "join classe cl on cl.Id = c.idClasse "
                + "where c.idEnseignant = " + idE + " and cl.Name like '" + nomClass + "'";

        ObservableList<String> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                arr.add(rs.getString("nom"));

            }
        } catch (SQLException ex) {
        }
        return arr;

    }

    public int GetIdMatiere(String nomMatiere, String nomClass) {

        String req = "SELECT m.id from matier m join cours c on m.id = c.idMatiere "
                + "join classe cl on cl.Id = c.idClasse "
                + "where m.nom like '" + nomMatiere + "' and cl.Name like '" + nomClass + "'";

        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                return rs.getInt("id");

            }
        } catch (SQLException ex) {
        }
        return 0;

    }

    public ObservableList<String> GetEtudFromClass(String classe) {

        String req = "select cinUser from users where classeEtd like '" + classe + "' and roleUser = 'Etudiant'";
        ObservableList<String> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                arr.add(Integer.toString(rs.getInt("cinUser")));

            }
        } catch (SQLException ex) {
        }
        return arr;

    }

    public ObservableList<String> GetClassesEnseignant(String idE) {

        String req = " SELECT Name from classe join cours c on Id = c.idClasse where c.idEnseignant = " + idE;

        ObservableList<String> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                arr.add(rs.getString("Name"));

            }
        } catch (SQLException ex) {
        }
        return arr;

    }

  /*  public ObservableList<Note> NoteEtudiant(String idE) {

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
*/
  /*  public List<Note> listeNoteEtudiant(int idE) throws SQLException {
        List<Note> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from Note WHERE idEtudiant=" + Integer.toString(idE));
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

    }*/
    public ObservableList<Note> listeNoteEtudiantinterface(String idE) {

        ObservableList<Note> arr = FXCollections.observableArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select n.*,m.nom,m.coef,m.id from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + idE);
            while (rs.next()) {
                int idEtudiant = rs.getInt("idEtudiant");
                int idEnseignant = rs.getInt("idEnseignant");
                int idMatiere = rs.getInt("id");
                String nomMatiere = rs.getString("nom");
                Date dateNote = rs.getDate("dateNote");
                float coefficient = rs.getFloat("coef");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");
                String info = coefficient+"            "+nomMatiere;
                System.out.println(moyenne);
                Note n = new Note(idEtudiant, idMatiere, idEnseignant, dateNote, noteCC, noteDS, noteExam, moyenne,info);
                n.getMatiere().setNomMatiere(nomMatiere);
                n.getMatiere().setCoefficient(coefficient);
                arr.add(n);
            }
        } catch (SQLException ex) {
        }
        return arr;

    }

    public List <Note> listeNoteEtudiant(int idE) {

        List <Note> arr = new ArrayList();
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("select n.*,m.nom,m.coef,m.id from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + idE);
            while (rs.next()) {
                int idEtudiant = rs.getInt("idEtudiant");
                int idEnseignant = rs.getInt("idEnseignant");
                int idMatiere = rs.getInt("id");
                String nomMatiere = rs.getString("nom");
                Date dateNote = rs.getDate("dateNote");
                float coefficient = rs.getFloat("coef");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");
                String info = coefficient+"            "+nomMatiere;
                System.out.println(moyenne);
                Note n = new Note(idEtudiant, idMatiere, idEnseignant, dateNote, noteCC, noteDS, noteExam, moyenne,info);
                n.getMatiere().setNomMatiere(nomMatiere);
                n.getMatiere().setCoefficient(coefficient);
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
            ResultSet rs = ste.executeQuery("select n.*,m.id,m.nom,m.coef from Note n join matier m "
                    + "on n.idMatiere=m.id WHERE idEtudiant=" + idE + " and n.moyenne < 8");
            while (rs.next()) {
                int idEtudiant = rs.getInt("idEtudiant");
                int idEnseignant = rs.getInt("idEnseignant");
                int idMatiere = rs.getInt("id");
                String nomMatiere = rs.getString("nom");
                Date dateNote = rs.getDate("dateNote");
                float coefficient = rs.getFloat("coef");
                double noteCC = rs.getDouble("noteCC");
                double noteDS = rs.getDouble("noteDS");
                double noteExam = rs.getDouble("noteExam");
                double moyenne = rs.getDouble("moyenne");
                String info = coefficient+"            "+nomMatiere;
                System.out.println(moyenne);
                Note n = new Note(idEtudiant, idMatiere, idEnseignant, dateNote, noteCC, noteDS, noteExam, moyenne,info);
                n.getMatiere().setNomMatiere(nomMatiere);
                n.getMatiere().setCoefficient(coefficient);
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

    public int getIdEtudiant(String cin) throws SQLException {

        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select idUser from users where cinUser = " + cin);
        while (rs.next()) {
            return rs.getInt("idUser");
        }
        return 0;

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
