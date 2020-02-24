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
public class Etudiant extends User {
    
    private String classeEtd;
    private Date inscriptionEtd;
    private Parent parent;
public static Etudiant etd=null;
    private String specialiteEtd;

<<<<<<< HEAD:versio1.4/Weboss/src/weboss/Entities/Etudiant.java
    public Etudiant(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser,String roleUser,String classeEtd,Date inscriptionEtd,String specialiteEtd,Parent p) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser);
=======
    public Etudiant(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser,String roleUser,String picUser,String classeEtd,Date inscriptionEtd,String specialiteEtd,UserParent p) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser,roleUser,picUser);
>>>>>>> be491afefe56576ceb1d1ea16807200dbee4e183:Weboss/src/weboss/Entities/Etudiant.java
        this.classeEtd = classeEtd;
        this.inscriptionEtd = inscriptionEtd;       
        this.specialiteEtd = specialiteEtd;
        this.parent = p;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent p) {
        this.parent = p;
    }

/*  @Override
    public String toString() {
        return "Etudiant{" +super.toString()+ "classeEtd=" + classeEtd + ", inscriptionEtd=" + inscriptionEtd + ", specialiteEtd=" + specialiteEtd + '}';
    }
      */
    @Override
    public String toString(){
    return this.nomUser;
    
}
    
    
    

    
}
