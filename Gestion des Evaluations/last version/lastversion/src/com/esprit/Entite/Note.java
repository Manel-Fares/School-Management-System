/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

//import java.sql.Date;
import java.sql.Date;

public class Note {

    private int idEtudiant;
    private int idMatiere;
    private int idEnseignant;
    private Date dateNote;
    private double noteCC;
    private double noteDS;
    private double noteExam;
    private double moyenne;
    private String nomMatiere;
    private float coefficient;

    public Note(String nomMatiere, double moyenne) {
        this.nomMatiere = nomMatiere;
        this.moyenne = moyenne;
    }

    public Note(int idEtudiant, int idMatiere, Date dateNote, double noteCC, double noteDS, double noteExam) {
        this.idEtudiant = idEtudiant;
        this.idMatiere = idMatiere;
        this.dateNote = dateNote;
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
    }

    public Note(double noteCC, double noteDS, double noteExam, double moyenne, String nomMatiere, float coefficient) {
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
        this.moyenne = moyenne;
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
    }

  

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public Note(double noteCC, double noteDS, double noteExam, String nomMatiere, float coefficient) {
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
    }

    public Note(int idEtudiant, int idMatiere, Date dateNote, double noteCC, double noteDS, double noteExam, double moyenne) {
        this.idEtudiant = idEtudiant;
        this.idMatiere = idMatiere;
        this.dateNote = dateNote;
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
        this.moyenne = moyenne;
    }

    public Note(int idEtudiant, int idMatiere, Date dateNote, double noteCC, double noteDS, double noteExam, int idEnseignant) {
        this.idEtudiant = idEtudiant;
        this.idMatiere = idMatiere;
        this.idEnseignant = idEnseignant;
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

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public double getNoteCC() {
        return noteCC;
    }

    public double getNoteDS() {
        return noteDS;
    }

    public double getNoteExam() {
        return noteExam;
    }

    public double getMoyenne() {
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

    public void setNoteCC(double noteCC) {
        this.noteCC = noteCC;
    }

    public void setNoteDS(double noteDS) {
        this.noteDS = noteDS;
    }

    public void setNoteExam(double noteExam) {
        this.noteExam = noteExam;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public String toString() {
        return "\nNote :" + "\n    idEtudiant=" + idEtudiant + ", \n    idMatiere=" + idMatiere
                + ", \n    dateNote=" + dateNote + ", \n    noteCC=" + noteCC + ", \n    noteDS="
                + noteDS + ",\n    noteExam=" + noteExam + ", \n    moyenne=" + moyenne + "\n";
    }

}
