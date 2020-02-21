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

    private int idEtudiant;
    private Date dateResultat;
    private float resultat;

    public Resultat(int idEtudiant, Date dateResultat) {
        this.idEtudiant = idEtudiant;
        this.dateResultat = dateResultat;
    }

    public Resultat(int idEtudiant, Date dateResultat, float resultat) {
        this.idEtudiant = idEtudiant;
        this.dateResultat = dateResultat;
        this.resultat = resultat;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setDateResultat(Date dateResultat) {
        this.dateResultat = dateResultat;
    }

    @Override
    public String toString() {
        return "\nResultat: " + "\n    idEtudiant=" + idEtudiant + ", \n    dateResultat=" + dateResultat 
                + ",\n    resultat=" + resultat ;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public Date getDateResultat() {
        return dateResultat;
    }

    public float getResultat() {
        return resultat;
    }

}
