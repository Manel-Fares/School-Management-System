/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Pytrooooo
 */
public class Matiere {
    private int id;
    private String nom;

    public Matiere(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
        public Matiere( String nom) {       
        this.nom = nom;
    }

    public Matiere() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
    
    
     public String toNom() {
        return this.nom;
    }
    
    
}
