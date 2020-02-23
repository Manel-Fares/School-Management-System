/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author bensl
 */
public class Reponse {
    private int id_reponse;
    private String body;
    private int vote_reponse;
    private int id_question;

    public Reponse(int id_reponse, String body, int vote_reponse, int id_question) {
        this.id_reponse = id_reponse;
        this.body = body;
        this.vote_reponse = vote_reponse;
        this.id_question = id_question;
    }

    public Reponse(String body, int vote_reponse, int id_question) {
        this.body = body;
        this.vote_reponse = vote_reponse;
        this.id_question = id_question;
    }
    

    public int getId_reponse() {
        return id_reponse;
    }

    public String getBody() {
        return body;
    }

    public int getVote_reponse() {
        return vote_reponse;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setVote_reponse(int vote_reponse) {
        this.vote_reponse = vote_reponse;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_reponse=" + id_reponse + ", body=" + body + ", vote_reponse=" + vote_reponse + ", id_question=" + id_question + '}';
    }
    
    
}
