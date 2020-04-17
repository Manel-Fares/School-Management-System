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
public class Club {
    private int idClub;  
    private User Responsable ;
    private String nomClub;
    private String domaine;
        

    public Club() {
    }

    public Club(int idClub) {
        this.idClub = idClub;
    }
    

    public Club(int idClub, String nomClub, String domaine) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.domaine = domaine;
    }
    

    public Club(int idClub, User Responsable, String nomClub, String domaine) {
        this.idClub = idClub;
        this.Responsable = Responsable;
        this.nomClub = nomClub;
        this.domaine = domaine;
    }

    public Club(User Responsable, String nomClub, String domaine) {
        this.Responsable = Responsable;
        this.nomClub = nomClub;
        this.domaine = domaine;
    }

    public Club(String nomClub, String domaine) {
        this.nomClub = nomClub;
        this.domaine = domaine;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public User getResponsable() {
        return Responsable;
    }

    public void setResponsable(User Responsable) {
        this.Responsable = Responsable;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return nomClub;
    }

  
  


  
    
    
}
