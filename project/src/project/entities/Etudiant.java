/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.entities;

import java.util.Date;


/**
 *
 * @author Neifos
 */
public class Etudiant extends User {
    
    private String classeEtd;
    private Date inscriptionEtd;

    private String specialiteEtd;

    public Etudiant(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser,String classeEtd,Date inscriptionEtd,String specialiteEtd) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser);
        this.classeEtd = classeEtd;
        this.inscriptionEtd = inscriptionEtd;       
        this.specialiteEtd = specialiteEtd;
    }
   
    

   


    public String getClasseEtd() {
        return classeEtd;
    }

    public Date getInscriptionEtd() {
        return inscriptionEtd;
    }

    public String getSpecialiteEtd() {
        return specialiteEtd;
    }

    public void setClasseEtd(String classeEtd) {
        this.classeEtd = classeEtd;
    }

    public void setInscriptionEtd(Date inscriptionEtd) {
        this.inscriptionEtd = inscriptionEtd;
    }

    public void setSpecialiteEtd(String specialiteEtd) {
        this.specialiteEtd = specialiteEtd;
    }

    @Override
    public String toString() {
        return "Etudiant{" +super.toString()+ "classeEtd=" + classeEtd + ", inscriptionEtd=" + inscriptionEtd + ", specialiteEtd=" + specialiteEtd + '}';
    }
    

    
    
    

    
}