/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Date;
import javafx.scene.control.Button;

/**
 *
 * @author asus
 */
public class Evenement {

    private int idEvenement;
    private String dateDebut;
    private String dateFin;
    private int idClub;
    private Button update=new Button("update");
    public Evenement() {

    }

    public Evenement(int idEvenement, String dateDebut, String dateFin, int idClub) {
        this.idEvenement = idEvenement;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClub = idClub;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public Evenement(String dateDebut, String dateFin, int idClub) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClub = idClub;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

   

    public int getIdClub() {
        return idClub;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

   

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvenement=" + idEvenement + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", idClub=" + idClub + '}';
    }

    
}
