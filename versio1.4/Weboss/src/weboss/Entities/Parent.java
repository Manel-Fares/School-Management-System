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
  

<<<<<<< HEAD:versio1.4/Weboss/src/weboss/Entities/Parent.java
    public Parent(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser, String roleUser) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser);
=======
    public UserParent(String idUser, int cinUser, String nomUser, String prenomUser, String emailUser, String adresseUser, int numTelUser, Date dateNaissanceUser, String sexeUser, String motDePasseUser, String roleUser,String picUser) {
        super(idUser, cinUser, nomUser, prenomUser, emailUser, adresseUser, numTelUser, dateNaissanceUser, sexeUser, motDePasseUser, roleUser,picUser);
>>>>>>> be491afefe56576ceb1d1ea16807200dbee4e183:Weboss/src/weboss/Entities/UserParent.java
       
    }

   

    @Override
    public String toString() {
        return "Parent{" +super.toString();
    }
    
}
