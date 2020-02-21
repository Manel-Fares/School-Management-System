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
public class Sondage {
    int idsondage;
    int idclub;
    String Titre;
    String description;
    String reponse;

    public Sondage(int idsondage, int idclub, String Titre, String description, String reponse) {
        this.idsondage = idsondage;
        this.idclub = idclub;
        this.Titre = Titre;
        this.description = description;
        this.reponse = reponse;
    }

    public Sondage(int idclub, String Titre, String description, String reponse) {
        this.idclub = idclub;
        this.Titre = Titre;
        this.description = description;
        this.reponse = reponse;
    }

    public Sondage(int idclub, String Titre, String description) {
        this.idclub = idclub;
        this.Titre = Titre;
        this.description = description;
    }

    public int getIdsondage() {
        return idsondage;
    }

    public int getIdclub() {
        return idclub;
    }

    public String getTitre() {
        return Titre;
    }

    public String getDescription() {
        return description;
    }

    public String getReponse() {
        return reponse;
    }

    public void setIdsondage(int idsondage) {
        this.idsondage = idsondage;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "Sondage{" + "idsondage=" + idsondage + ", idclub=" + idclub + ", Titre=" + Titre + ", description=" + description + ", reponse=" + reponse + '}';
    }
    
}
