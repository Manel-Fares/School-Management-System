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
public class Question {
    
    private int id_question;
    private String body;
    private int vote;
    private int id_tag;
    private int id_personne;

    public Question(int id_question, String body, int vote, int id_tag, int id_personne) {
        this.id_question = id_question;
        this.body = body;
        this.vote = vote;
        this.id_tag = id_tag;
        this.id_personne = id_personne;
    }

    public Question(String body, int vote, int id_tag, int id_personne) {
        this.body = body;
        this.vote = vote;
        this.id_tag = id_tag;
        this.id_personne = id_personne;
    }

    public Question(int id_question, String body) {
        this.id_question = id_question;
        this.body = body;
    }

    public Question(String body) {
        this.body = body;
    }
    
    
    
    public int getId_question() {
        return id_question;
    }

    public String getBody() {
        return body;
    }

    public int getVote() {
        return vote;
    }

    public int getId_tag() {
        return id_tag;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    @Override
    public String toString() {
        return "Question{" + "id_question=" + id_question + ", body=" + body + ", vote=" + vote + ", id_tag=" + id_tag + ", id_personne=" + id_personne + '}';
    }

    
    
}
