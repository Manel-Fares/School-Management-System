/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import java.util.Date;

/**
 *
 * @author Neifos
 */
public class User {

    private int id,cin;
    private String nom,prenom,role,classe;

    public User() {
    }

    public User(int cin, String nom, String prenom) {

        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getRole() {
        return role;
    }

    public String getClasse() {
        return classe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }


    @Override
    public String toString() {
        return this.nom;
    }



   
    
  
}
