/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

import java.sql.Date;

/**
 *
 * @author Neifos
 */
public class Personnel extends User{
    
    private String fonctionPr;
    private Date dateEmbauchePr;
    private double salairePr;
    private String statutPr;
    public static Personnel pr=null;
    
    
    public Personnel(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser,String roleUser,String picUser,String statutPr,Date dateEmbauchePr,double  salairePr,String fonctionPr) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser);
        this.salairePr = salairePr;
        this.dateEmbauchePr = dateEmbauchePr;
        this.fonctionPr = fonctionPr;
        this.statutPr = statutPr;
                
    }

    public String getStatutPr() {
        return statutPr;
    }

    public String getFonctionPr() {
        return fonctionPr;
    }

    public Date getDateEmbauchePr() {
        return dateEmbauchePr;
    }

    public double getSalairePr() {
        return salairePr;
    }

    public void setStatutPr(String statutPr) {
        this.statutPr = statutPr;
    }

    public void setFonctionPr(String fonctionPr) {
        this.fonctionPr = fonctionPr;
    }

    public void setDateEmbauchePr(Date dateEmbauchePr) {
        this.dateEmbauchePr = dateEmbauchePr;
    }

    public void setSalairePr(double salairePr) {
        this.salairePr = salairePr;
    }

    @Override
    public String toString() {
        return "Personnel{"+super.toString() + "fonctionPr=" + fonctionPr + ", dateEmbauchePr=" + dateEmbauchePr + ", salairePr=" + salairePr + ", statutPr=" + statutPr + '}';
    }
    
    
}
