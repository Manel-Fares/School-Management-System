/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

import java.util.List;

/**
 *
 * @author bouch
 */
public class Quizz {
    private int id;
    private Chapitre Chapitre;

    public Quizz(int id, Chapitre Chapitre) {
        this.id = id;
        this.Chapitre = Chapitre;
    }

    public Quizz() {
    }

    public Quizz(Chapitre Chapitre) {
        this.Chapitre = Chapitre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chapitre getChapitre() {
        return Chapitre;
    }

    public void setChapitre(Chapitre Chapitre) {
        this.Chapitre = Chapitre;
    }

    
    

}
