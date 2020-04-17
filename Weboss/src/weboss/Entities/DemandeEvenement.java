/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

/**
 *
 * @author asus
 */
public class DemandeEvenement {
    private Club idclub;
    private int idDemandeEvenement;
    private String description;
    private String datedebut;
    private String datefin;
    private String etat;
    private float budget;
    private String image;

    public DemandeEvenement(String description, String datedebut, String datefin, float budget) {
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.budget = budget;
    }

    public DemandeEvenement(Club idclub, String description, String datedebut, String datefin, String etat, float budget, String image) {
        this.idclub = idclub;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.etat = etat;
        this.budget = budget;
        this.image = image;
    }

    public Club getIdclub() {
        return idclub;
    }

    public void setIdclub(Club idclub) {
        this.idclub = idclub;
    }

    public int getIdDemandeEvenement() {
        return idDemandeEvenement;
    }

    public void setIdDemandeEvenement(int idDemandeEvenement) {
        this.idDemandeEvenement = idDemandeEvenement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    public DemandeEvenement(Club idclub, int idDemandeEvenement, String description, String datedebut, String datefin, String etat, float budget, String image) {
        this.idclub = idclub;
        this.idDemandeEvenement = idDemandeEvenement;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.etat = etat;
        this.budget = budget;
        this.image = image;
    }

   

    public DemandeEvenement(int idDemandeEvenement, String description, String datedebut, String datefin, String etat, float budget) {
        this.idDemandeEvenement = idDemandeEvenement;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.etat = etat;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "DemandeEvenement{" + "idclub=" + idclub + ", idDemandeEvenement=" + idDemandeEvenement + ", description=" + description + ", datedebut=" + datedebut + ", datefin=" + datefin + ", etat=" + etat + ", budget=" + budget + ", image=" + image + '}';
    }

   


   

   
}
