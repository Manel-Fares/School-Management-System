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
public class Club {
    private int idClub;  
    private int idResponsable ;
    private String nomClub;
    private String domaine;
        

    public Club() {
    }

    public Club(int idClub, int idResponsable, String nomClub, String domaine) {
        this.idClub = idClub;
        this.idResponsable = idResponsable;
        this.nomClub = nomClub;
        this.domaine = domaine;
    }
    public Club( int idResponsable, String nomClub, String domaine) {
        
        this.idResponsable = idResponsable;
        this.nomClub = nomClub;
        this.domaine = domaine;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

   

   
    public int getIdClub() {
        return idClub;
    }

   

    public String getNomClub() {
        return nomClub;
    }

   
    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }
    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    @Override
    public String toString() {
        return "Club{" + "idClub=" + idClub + ", idResponsable=" + idResponsable + ", nomClub=" + nomClub + ", domaine=" + domaine + '}';
    }

   
   

  
    
    
}
