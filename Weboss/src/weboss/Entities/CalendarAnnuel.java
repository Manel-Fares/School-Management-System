/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

import java.sql.Date;

/**
 *
 * @author Pytrooooo
 */
public class CalendarAnnuel {
    private int id;
    private String subject,term;
    private Date DateC;

    public CalendarAnnuel(int id, String subject, String term, Date DateC) {
        this.id = id;
        this.subject = subject;
        this.term = term;
        this.DateC = DateC;
    }
        public CalendarAnnuel( String term,String subject, String DateC) {
        this.subject = subject;
        this.term = term;
        String p=String.valueOf(this.DateC);
        p = DateC;
    }
                public CalendarAnnuel() {

    }
        public CalendarAnnuel(String subject, String term, Date DateC) {
        this.subject = subject;
        this.term = term;
        this.DateC = DateC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Date getDateC() {
        return DateC;
    }

    public void setDateC(Date DateC) {
        this.DateC = DateC;
    }

    @Override
    public String toString() {
        return this.subject +"  \n "+this.term +"  \n  "+this.DateC.toString();
    }
        
    
    
    
}
