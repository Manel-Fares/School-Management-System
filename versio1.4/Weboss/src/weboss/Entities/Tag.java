/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

/**
 *
 * @author bensl
 */
public class Tag {
    
    private int id_tag;
    private String nom;
    private String description;

    public Tag(int id_tag, String nom, String description) {
        this.id_tag = id_tag;
        this.nom = nom;
        this.description = description;
    }

    public int getId_tag() {
        return id_tag;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tag{" + "id_tag=" + id_tag + ", nom=" + nom + ", description=" + description + '}';
    }
    
    
}
