/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

/**
 *
 * @author bouch
 */
public class teaching {
    private Matiere m;
    private Enseignant p;

    public Matiere getM() {
        return m;
    }

    public void setM(Matiere m) {
        this.m = m;
    }

    public Enseignant getP() {
        return p;
    }

    public void setP(Enseignant p) {
        this.p = p;
    }

    public teaching() {
    }

    public teaching(Matiere m, Enseignant p) {
        this.m = m;
        this.p = p;
    }

    
}
