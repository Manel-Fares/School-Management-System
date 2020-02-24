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
public class Parent extends User{
  

    public Parent(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser, String roleUser) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser);
       
    }

   

    @Override
    public String toString() {
        return "Parent{" +super.toString();
    }
    
}
