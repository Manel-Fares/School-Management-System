/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Pytrooooo
 */
public class Emplois {
    private int IdEmplois;
    private Date Date;
    private String Heure;
    private String Source;

    public Emplois(int IdEmplois, Date Date, String Heure, String Source) {
        this.IdEmplois = IdEmplois;
        this.Date = Date;
        this.Heure = Heure;
        this.Source = Source;
    }
    public Emplois( Date Date, String Heure, String Source) {
        this.IdEmplois = IdEmplois;
        this.Date = Date;
        this.Heure = Heure;
        this.Source = Source;
    }

    public int getIdEmplois() {
        return IdEmplois;
    }

    public void setIdEmplois(int IdEmplois) {
        this.IdEmplois = IdEmplois;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String Heure) {
        this.Heure = Heure;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }
    
    
    
}
