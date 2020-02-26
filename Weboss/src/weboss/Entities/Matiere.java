/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

/**
 *
 * @author Pytrooooo
 */
public class Matiere {
    private int idMatiere;
    private String nomMatiere;
    private float coefficient;
    private Enseignant Responsable;

    public Matiere() {
    }

    public Matiere(int idMatiere, String nomMatiere, float coefficient, Enseignant Responsable) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
        this.Responsable = Responsable;
    }

    public Matiere(String nomMatiere, float coefficient, Enseignant Responsable) {
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
        this.Responsable = Responsable;
    }

    public Matiere(int idMatiere, String nomMatiere, float coefficient) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
    }

    public Matiere(int idMatiere, String nomMatiere) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
    }

    public Matiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public Enseignant getResponsable() {
        return Responsable;
    }

    public void setResponsable(Enseignant Responsable) {
        this.Responsable = Responsable;
    }
    
    

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public float getCoefficient() {
        return coefficient;
    }

    @Override
    public String toString() {
        return  nomMatiere ;
    }
    
    
    
}
