/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

/**
 *
 * @author bouch
 */
public class Chapitre {
    private int id;
    private String nom;
    private String file;
    private Matiere matier;

    public Chapitre() {
    }

    public Chapitre( String nom, String file, Matiere matier) {
        this.nom = nom;
        this.file = file;
        this.matier = matier;
    }

    public Chapitre(int id, String nom, String file, Matiere matier) {
        this.id = id;
        this.nom = nom;
        this.file = file;
        this.matier = matier;
    }
    

    public Chapitre(String nom, String file) {
        this.nom = nom;
        this.file = file;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Matiere getMatier() {
        return matier;
    }

    public void setMatier(Matiere matier) {
        this.matier = matier;
    }

    
}
