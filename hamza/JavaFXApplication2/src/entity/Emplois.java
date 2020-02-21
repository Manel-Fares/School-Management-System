/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Pytrooooo
 */
public class Emplois {
    private int IdEmplois;
    private Date Date;
    private Time Heure;
    private String Source;

    public Emplois(int IdEmplois, Date Date, Time Heure, String Source) {
        this.IdEmplois = IdEmplois;
        this.Date = Date;
        this.Heure = Heure;
        this.Source = Source;
    }
    public Emplois( Date Date, Time Heure, String Source) {
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

    public Time getHeure() {
        return Heure;
    }

    public void setHeure(Time Heure) {
        this.Heure = Heure;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    @Override
    public String toString() {
        return "Emplois{" + "IdEmplois=" + IdEmplois + ", Date=" + Date + ", Heure=" + Heure + ", Source=" + Source + '}';
    }
    
    
    
}
