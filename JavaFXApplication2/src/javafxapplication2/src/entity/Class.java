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
public class Class {
    private int Id,Nbr_Etudiant;
    private String Name,Niveau,Spec,Description;

    public Class(int Id, String Name, String Niveau,String Spec,int Nbr_Etudiant, String Description) {
        this.Id = Id;
        this.Nbr_Etudiant = Nbr_Etudiant;
        this.Name = Name;
        this.Niveau = Niveau;
        this.Spec = Spec;
        this.Description = Description;
    }


     public Class(String Name, String Niveau,String Spec,int Nbr_Etudiant, String Description) {
        this.Nbr_Etudiant = Nbr_Etudiant;
        this.Name = Name;
        this.Niveau = Niveau;
        this.Spec = Spec;
        this.Description = Description;
    }
    
    
    public String getSpec() {
        return Spec;
    }

    public void setSpec(String Spec) {
        this.Spec = Spec;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getNbr_Etudiant() {
        return Nbr_Etudiant;
    }

    public void setNbr_Etudiant(int Nbr_Etudiant) {
        this.Nbr_Etudiant = Nbr_Etudiant;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String Niveau) {
        this.Niveau = Niveau;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Class{" + "Id=" + Id + ", Nbr_Etudiant=" + Nbr_Etudiant + ", Name=" + Name + ", Niveau=" + Niveau + ", Description=" + Description + '}';
    }
    
    
    
    
}
