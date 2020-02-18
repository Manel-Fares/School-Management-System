/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author asus
 */
public class DemandeEvenement {
    private int idclub;
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

    public DemandeEvenement(int idclub, int idDemandeEvenement, String description, String datedebut, String datefin, String etat, float budget, String image) {
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

    public DemandeEvenement(int idclub, String description, String datedebut, String datefin, String etat, float budget, String image) {
        this.idclub = idclub;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.etat = etat;
        this.budget = budget;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getDatedebut() {
        return datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public DemandeEvenement(int idclub, int idDemandeEvenement, String description, String datedebut, String datefin, String etat) {
        this.idclub = idclub;
        this.idDemandeEvenement = idDemandeEvenement;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.etat = etat;
    }

    public DemandeEvenement(int idclub, String description, String datedebut, String datefin) {
        this.idclub = idclub;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }


    public DemandeEvenement(int idclub, String description, String datedebut, String datefin, String etat) {
        this.idclub = idclub;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.etat = etat;
    }

 

    

    public DemandeEvenement(int idclub, int idDemandeEvenement, String description, String datedebut, String datefin) {
        this.idclub = idclub;
        this.idDemandeEvenement = idDemandeEvenement;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    

    public void setIdDemandeEvenement(int idDemandeEvenement) {
        this.idDemandeEvenement = idDemandeEvenement;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getIdDemandeEvenement() {
        return idDemandeEvenement;
    }

    public int getIdclub() {
        return idclub;
    }

    public String getDescription() {
        return description;
    }

    
    

    public String getEtat() {
        return etat;
    }
 public DemandeEvenement() {
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public float getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "DemandeEvenement{" + "idclub=" + idclub + ", idDemandeEvenement=" + idDemandeEvenement + ", description=" + description + ", datedebut=" + datedebut + ", datefin=" + datefin + ", etat=" + etat + ", budget=" + budget + ", image=" + image + '}';
    }


   

   
}
