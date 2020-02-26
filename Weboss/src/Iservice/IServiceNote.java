/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import weboss.Entities.Note;
import weboss.Entities.User;

/**
 *
 * @author House
 */
public interface IServiceNote<T> {

    void ajouter(T t) throws SQLException;

    void delete(T t) throws SQLException;

    void update(T t) throws SQLException;

    List<T> readAll() throws SQLException;

    ObservableList<T> getNotes();

    public ObservableList<String> GetNomMatiere(String idE, String nomClass);

    public ObservableList<String> GetClassesEnseignant(String idE);

    public int GetIdMatiere(String nomMatiere, String nomClass);

    public double formuleNote(Note n);

    public int getIdEtudiant(String cin) throws SQLException;

    public ObservableList<Note> listeMoyenneNoteEtudiant(String idE);

    public ObservableList<Note> listeEtudiantCredit(String idE);

    public List<Note> listeNoteEtudiant(int idE);

    public ObservableList<Note> listeNoteEtudiantinterface(String idE);

    public ObservableList<String> GetEtudFromClass(String classe);

    public ObservableList<Note> getNotesEnseignant1(String nomClasse, int idMat, int idEns);
    
    public ObservableList<User> getNotesEnseignant2(String nomClasse, int idMat, int idEns);
}
