/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

//import java.sql.Date;
import java.sql.Date;

public class Note {

    private User etudiant = new User();
    private User enseignant = new User();
    private Matiere matiere = new Matiere();
    private Date dateNote;
    private double noteCC;
    private double noteDS;
    private double noteExam;
    private double moyenne;
    private String info;
   // private String nomMatiere;
   // private float coefficient;

    public Note(String nomMatiere, double moyenne) {
        this.info = nomMatiere;
        this.moyenne = moyenne;
    }

    public Note(int idEtudiant, int idMatiere, Date dateNote, double noteCC, double noteDS, double noteExam, double moyenne) {
        this.etudiant.setId(idEtudiant);
        this.matiere.setIdMatiere(idMatiere);
        this.dateNote = dateNote;
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
        this.moyenne = moyenne;

    }

//pour le modification
    public Note(int idEtudiant, int idMatiere, int idEnseignant, Date dateNote, double noteCC, double noteDS, double noteExam, double moyenne, String info) {
        this.etudiant.setId(idEtudiant);
        this.matiere.setIdMatiere(idMatiere);
        this.enseignant.setId(idEnseignant);
        this.dateNote = dateNote;
        this.noteCC = noteCC;
        this.noteDS = noteDS;
        this.noteExam = noteExam;
        this.moyenne = moyenne;
        this.info = info;
    }

    public User getEtudiant() {
        return etudiant;
    }

    public User getEnseignant() {
        return enseignant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }


    public int getIdEtudiant() {
        return enseignant.getId();
    }

    public int getIdMatiere() {
        return matiere.getIdMatiere();
    }

    public void setIdEnseignant(int idEnseignant) {
        this.enseignant.setId(idEnseignant);
    }


    public int getIdEnseignant() {
        return enseignant.getId();
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
        this.etudiant.setId(idEtudiant);
    }

    public void setIdMatiere(int idMatiere) {
        this.matiere.setIdMatiere(idMatiere);
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

    public void setEtudiant(User etudiant) {
        this.etudiant = etudiant;
    }

    public void setEnseignant(User enseignant) {
        this.enseignant = enseignant;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "\nNote :" + "\n    idEtudiant=" + enseignant.getId() + ", \n    idMatiere=" + matiere.getIdMatiere()
                + ", \n    dateNote=" + dateNote + ", \n    noteCC=" + noteCC + ", \n    noteDS="
                + noteDS + ",\n    noteExam=" + noteExam + ", \n    moyenne=" + moyenne + "\n";
    }

}
