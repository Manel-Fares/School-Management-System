/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

/**
 *
 * @author asus
 */
public class Rating {
    private int  idR;
    private double  rating;
    private Club c ;
    private User et;

    public Rating() {
    }

    public Rating(int idR, double rating, int c, int et) {
        this.idR = idR;
        this.rating = rating;
        this.c.setIdClub(c);
        this.et.setIdUser(String.valueOf(et)); 
    }

    public int getIdR() {
        return idR;
    }

   

    public Club getC() {
        return c;
    }

    public User getEt() {
        return et;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

   


    public void setC(Club c) {
        this.c = c;
    }

    public void setEt(User et) {
        this.et = et;
    }

  
    
}
