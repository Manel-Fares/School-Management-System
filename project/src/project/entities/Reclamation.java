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

    public Reclamation(int idReclamation, String sujetReclamation, String descriptionReclamation,String statutReclamation,Date dateCreation) {
        this.idReclamation = idReclamation;
        this.sujetReclamation = sujetReclamation;
        this.descriptionReclamation = descriptionReclamation;
        this.statutReclamation = statutReclamation;
        this.dateCreation = dateCreation;
    }

    public Reclamation(String sujetReclamation, String descriptionReclamation, String statutReclamation, Date dateCreation) {
        this.sujetReclamation = sujetReclamation;
        this.descriptionReclamation = descriptionReclamation;
        this.statutReclamation = statutReclamation;
        this.dateCreation = dateCreation;
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

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", sujetReclamation=" + sujetReclamation + ", descriptionReclamation=" + descriptionReclamation + ", statutReclamation=" + statutReclamation + ", dateCreation=" + dateCreation + '}';
    }
    
    
}
