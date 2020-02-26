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
public class Enseignant extends User{
    
    private String domaineEnsg;
    private String statutEnsg;
    private double salaireEnsg;
    private Date dateEmbaucheEnsg;
    public static Enseignant ensg=null;

    public Enseignant() {
    }
    
    public Enseignant(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser,String roleUser,String picUser,String statutEnsg,Double salaireEnsg,Date dateEmbaucheEnsg,String domaineEnsg) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser);
        this.statutEnsg = statutEnsg;
        this.salaireEnsg = salaireEnsg;
        this.dateEmbaucheEnsg = dateEmbaucheEnsg;
        this.domaineEnsg = domaineEnsg;
    }

    public String getDomaineEnsg() {
        return domaineEnsg;
    }

    public String getStatutEnsg() {
        return statutEnsg;
    }

    public double getSalaireEnsg() {
        return salaireEnsg;
    }

    public Date getDateEmbaucheEnsg() {
        return dateEmbaucheEnsg;
    }

    public void setDomaineEnsg(String domaineEnsg) {
        this.domaineEnsg = domaineEnsg;
    }

    public void setStatutEnsg(String statutEnsg) {
        this.statutEnsg = statutEnsg;
    }

    public void setSalaireEnsg(double salaireEnsg) {
        this.salaireEnsg = salaireEnsg;
    }

    public void setDateEmbaucheEnsg(Date dateEmbaucheEnsg) {
        this.dateEmbaucheEnsg = dateEmbaucheEnsg;
    }

    @Override
    public String toString() {
        return "Enseignant{"+super.toString() + "domaineEnsg=" + domaineEnsg + ", statutEnsg=" + statutEnsg + ", salaireEnsg=" + salaireEnsg + ", dateEmbaucheEnsg=" + dateEmbaucheEnsg + '}';
    }

   
    
}
