/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author Aymen
 */
public class Matiere {
    private int idMatiere;
    private String nomMatiere;
    private float coefficient;

    public Matiere() {
    }

    public Matiere(int idMatiere, String nomMatiere, float coefficient) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
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
    
    
    
}
