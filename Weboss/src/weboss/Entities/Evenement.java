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
public class Evenement {

    private int idEvenement;
    private String dateDebut;
    private String dateFin;
    private Club idClub;
    private String image;

    public Evenement() {

    }

    public Evenement(int idEvenement, String dateDebut, String dateFin, Club idClub, String image) {
        this.idEvenement = idEvenement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClub = idClub;
        this.image = image;
    }
    

    public Evenement(String dateDebut, String dateFin, Club idClub, String image) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClub = idClub;
        this.image = image;
    }

   

    public Evenement(String dateDebut, String dateFin, String image) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.image = image;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public Club getIdClub() {
        return idClub;
    }

    public void setIdClub(Club idClub) {
        this.idClub = idClub;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvenement=" + idEvenement + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", idClub=" + idClub + ", image=" + image + '}';
    }

   
    
}
