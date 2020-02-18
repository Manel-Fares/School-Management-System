/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

//import java.sql.Date;

import java.util.Date;


public class Note {
    private int idEtudiant;
    private int idMatiere;
    private Date dateNote;
    private float noteCC;
    private float noteDS;
    private float noteExam;
    private float moyenne;

    public Note(int idEtudiant, int idMatiere, Date dateNote, float noteCC, float noteDS, float noteExam, float moyenne) {
        this.idEtudiant = idEtudiant;
        this.idMatiere = idMatiere;
        this.dateNote = dateNote;
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
        this.moyenne = moyenne;
    }

    public Note(int idEtudiant, int idMatiere, Date dateNote, float noteCC, float noteDS, float noteExam) {
        this.idEtudiant = idEtudiant;
        this.idMatiere = idMatiere;
        this.dateNote = dateNote;
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public float getNoteCC() {
        return noteCC;
    }

    public float getNoteDS() {
        return noteDS;
    }

    public float getNoteExam() {
        return noteExam;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }

    public void setNoteCC(float noteCC) {
        this.noteCC = noteCC;
    }

    public void setNoteDS(float noteDS) {
        this.noteDS = noteDS;
    }

    public void setNoteExam(float noteExam) {
        this.noteExam = noteExam;
    }

    public void setMoyenne(int moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public String toString() {
        return "\nNote :" + "\n    idEtudiant=" + idEtudiant + ", \n    idMatiere=" + idMatiere 
                + ", \n    dateNote=" + dateNote + ", \n    noteCC=" + noteCC + ", \n    noteDS=" 
                + noteDS + ",\n    noteExam=" + noteExam + ", \n    moyenne=" + moyenne +"\n";
    }


    
}
