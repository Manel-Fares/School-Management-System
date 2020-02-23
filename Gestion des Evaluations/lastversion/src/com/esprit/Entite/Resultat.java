/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author Aymen
 */
public class Resultat {

    private User etudiant = new User();
    private Date dateResultat;
    private float resultat;

    public Resultat(int idE, Date dateResultat, float resultat) {
        this.getEtudiant().setId(idE);
        this.dateResultat = dateResultat;
        this.resultat = resultat;
    }
    public Resultat(int idE, Date dateResultat) {
        this.getEtudiant().setId(idE);
        this.dateResultat = dateResultat;
 
    }
    public User getEtudiant() {
        return etudiant;
    }

    public Date getDateResultat() {
        return dateResultat;
    }

    public float getResultat() {
        return resultat;
    }

    public void setEtudiant(User etudiant) {
        this.etudiant = etudiant;
    }

    public void setDateResultat(Date dateResultat) {
        this.dateResultat = dateResultat;
    }

    public void setResultat(float resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "Resultat{" + "etudiant=" + etudiant.getId() + ", dateResultat=" + dateResultat + ", resultat=" + resultat + '}';
    }





}
