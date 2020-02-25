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
public class Absence {
    private int id;
    private User user;
    private Matiere matiere;
    private Date date;
    private Time timeDeb,timeFin;

    public Absence() {
    }

     public Absence(Date date, Time timedeb,Time timefin) {
        this.id = id;
        this.date = date;
        this.timeDeb = timedeb;
        this.timeFin = timefin;
    }
    public Absence(int id, User user, Matiere matiere, Date date, Time timedeb,Time timefin) {
        this.id = id;
        this.user = user;
        this.matiere = matiere;
        this.date = date;
        this.timeDeb = timedeb;
        this.timeFin = timefin;
    }
    
    public Absence( User user, Matiere matiere, Date date,Time timedeb,Time timefin) {      
        this.user = user;
        this.matiere = matiere;
        this.date = date;
        this.timeDeb = timedeb;
        this.timeFin = timefin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeDeb() {
        return timeDeb;
    }

    public void setTimeDeb(Time timeDeb) {
        this.timeDeb = timeDeb;
    }

    public Time getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(Time timeFin) {
        this.timeFin = timeFin;
    }

    @Override
    public String toString() {
        return "Absence{" + "id=" + id + ", user=" + user + ", matiere=" + matiere + ", date=" + date + ", timeDeb=" + timeDeb + ", timeFin=" + timeFin + '}';
    }

   
    
    
    
}
