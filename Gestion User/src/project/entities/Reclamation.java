/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.entities;

import java.util.Date;

/**
 *
 * @author Neifos
 */
public class Reclamation {
    private int idReclamation;
    private String sujetReclamation;
    private String descriptionReclamation;
    private String statutReclamation;
    private Date dateCreation;
    private Etudiant user;

    public Reclamation(int idReclamation, String sujetReclamation, String descriptionReclamation,String statutReclamation,Date dateCreation,Etudiant u) {
        this.idReclamation = idReclamation;
        this.sujetReclamation = sujetReclamation;
        this.descriptionReclamation = descriptionReclamation;
        this.statutReclamation = statutReclamation;
        this.dateCreation = dateCreation;
        this.user = u;
    }

    public Reclamation(String sujetReclamation, String descriptionReclamation, String statutReclamation, Date dateCreation,Etudiant u) {
        this.sujetReclamation = sujetReclamation;
        this.descriptionReclamation = descriptionReclamation;
        this.statutReclamation = statutReclamation;
        this.dateCreation = dateCreation;
          this.user = u;
    }

    public Reclamation() {
    }

    public String getStatutReclamation() {
        return statutReclamation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public String getSujetReclamation() {
        return sujetReclamation;
    }

    public String getDescriptionReclamation() {
        return descriptionReclamation;
    }

    public void setStatutReclamation(String statutReclamation) {
        this.statutReclamation = statutReclamation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setIdReclamation(int idReclamtion) {
        this.idReclamation = idReclamtion;
    }

    public void setSujetReclamation(String sujetReclamation) {
        this.sujetReclamation = sujetReclamation;
    }

    public void setDescriptionReclamation(String descriptionReclamation) {
        this.descriptionReclamation = descriptionReclamation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(Etudiant user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", sujetReclamation=" + sujetReclamation + ", descriptionReclamation=" + descriptionReclamation + ", statutReclamation=" + statutReclamation + ", dateCreation=" + dateCreation + '}';
    }
    
    
}
