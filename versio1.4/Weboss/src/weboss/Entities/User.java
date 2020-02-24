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
public class User {

    protected String idUser;
    protected int cinUser;
    protected String nomUser;
    protected String prenomUser;
    protected String emailUser;
    protected String adresseUser;
    protected int numTelUser;
    protected Date dateNaissanceUser;
    protected String sexeUser;
    protected String motDePasseUser;
    protected String roleUser;
    protected String picUser;
    public static User user=null;
    public static int code;

    public User() {
    }

    public User(int cinUser, String nomUser, String prenomUser) {
        this.cinUser = cinUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
    }

    
    
    public User(String idUser,int cinUser,String nomUser,String prenomUser,String emailUser,String adresseUser,int numTelUser,Date dateNaissanceUser,String sexeUser,String motDePasseUser,String roleUser,String picUser){
        this.cinUser = cinUser;
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.emailUser = emailUser;
        this.adresseUser = adresseUser;
        this.numTelUser = numTelUser;
        this.dateNaissanceUser = dateNaissanceUser;
        this.sexeUser = sexeUser;
        this.motDePasseUser = motDePasseUser;
        this.roleUser = roleUser;
        this.roleUser = picUser;
    }

    public User(String idUser, String nomUser, String prenomUser, String roleUser) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.roleUser = roleUser;
    }

    public User(String nomUser, String prenomUser) {
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
    }

    public String getPicUser() {
        return picUser;
    }

    public void setPicUser(String picUser) {
        this.picUser = picUser;
    }
    



    public String getMotDePasseUser() {
        return motDePasseUser;
    }
    public String getIdUser() {
        return idUser;
    }

    public int getCinUser() {
        return cinUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getAdresseUser() {
        return adresseUser;
    }

    public int getNumTelUser() {
        return numTelUser;
    }

    public Date getDateNaissanceUser() {
        return dateNaissanceUser;
    }

    public String getSexeUser() {
        return sexeUser;
    }
     public void setMotDePasseUser(String motDePasseUser) {
        this.motDePasseUser = motDePasseUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setCinUser(int cinUser) {
        this.cinUser = cinUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setAdresseUser(String adresseUser) {
        this.adresseUser = adresseUser;
    }

    public void setNumTelUser(int numTelUser) {
        this.numTelUser = numTelUser;
    }

    public void setDateNaissanceUser(Date dateNaissanceUser) {
        this.dateNaissanceUser = dateNaissanceUser;
    }

    public void setSexeUser(String sexeUser) {
        this.sexeUser = sexeUser;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    @Override
    public String toString() {
       return this.nomUser;
    }
    

}
