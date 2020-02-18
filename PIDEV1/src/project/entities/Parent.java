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
public class Parent extends User{
    private String idParent;

    public Parent(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser, String roleUser,String id) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser);
        this.idParent=id;
    }

    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }

    @Override
    public String toString() {
        return "Parent{" +super.toString()+ "idParent=" + idParent + '}';
    }
    
}
