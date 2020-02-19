/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Neifos
 */
public class User {

    private int id;
    private String nom,prenom,role,classe;

    public User(int id, String nom, String prenom, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }  
     public User(String nom) {
        
        this.nom = nom;
        
    }  
     
        public User( String nom, String prenom) {      
        this.nom = nom;
        this.prenom = prenom;
        
    }
    public User( String nom, String prenom, String role) {      
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public User() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.nom;
    }



   
    
  
}
