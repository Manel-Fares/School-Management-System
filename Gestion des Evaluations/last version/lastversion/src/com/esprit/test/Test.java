/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Note;
import com.esprit.Entite.Resultat;

import com.esprit.Service.ServiceNote;
import com.esprit.Service.ServiceResultat;
import java.sql.*;
import java.util.*;

/**
 *
 * @author House
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        ServiceNote ser = new ServiceNote();

     /*   Note n1 = new Note(15, 3, new java.util.Date(2020, 02, 12), 12f, 13f, 18f);
        Note n2 = new Note(15, 2, new java.util.Date(2020, 02, 12), 15f, 7.25f, 19f);
        Note n3 = new Note(25, 2, new java.util.Date(2020, 11, 12), 5f, 15f, 11f);
        Note n4 = new Note(25, 4, new java.util.Date(2020, 11, 12), 15f, 15f, 12f);
        try {
//         
            // ser.ajouter(n4);

            ser.delete(n1);
            ser.ajouter(n1);
            ser.delete(n2);
            ser.ajouter(n2);
            //     ser.update(n2);

            List<Note> list = ser.readAll();

            List<Note> listAvant = ser.listeNoteEtudiant(15);
           List<Note> list2 = ser.listeNoteEtudiant(25);
           
            System.out.println(listAvant);

            ser.calculMoyennesNotes(listAvant);
            ser.calculMoyennesNotes(list2);

            List<Note> listApres = ser.listeNoteEtudiant(15);
            System.out.println(listApres);

            ServiceResultat sr = new ServiceResultat();

            Resultat r=new Resultat(15, new Date(2020, 02, 12));
          //  sr.ajouter(r);
              System.out.println(sr.calculResultatParEtudiant(25));*/
            //List<Integer> listEtud = sr.getListEtudiant();
             // sr.delete(r);
            // System.out.println(listEtud);
            //   sr.calculResultats(listEtud);
            // List<Resultat> lR = sr.readAll();
            // System.out.println(lR);
             ServiceResultat sr = new ServiceResultat();

            sr.enregistrerResultat(3);
            sr.enregistrerResultat(4);
            
     

    }

}
