/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Entities;

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
    private String title;
    private String tag_name;
    public static int q;
    public static String qName;
    

    public Question(int id_question, String body, int vote, int id_tag, int id_personne, String title, String tag_name) {
        this.id_question = id_question;
        this.body = body;
        this.vote = vote;
        this.id_tag = id_tag;
        this.id_personne = id_personne;
        this.title = title;
        this.tag_name = tag_name;
    }
    public Question() {

    }
    
    
    
    public static int getQ() {
        return q;
    }

    public static void setQ(int q) {
        Question.q = q;
    }

    public Question(String body, int vote, int id_tag, int id_personne, String title, String tag_name) {
        this.body = body;
        this.vote = vote;
        this.id_tag = id_tag;
        this.id_personne = id_personne;
        this.title = title;
        this.tag_name = tag_name;
    }

    public Question(int id_question, String body) {
        this.id_question = id_question;
        this.body = body;
    }

    public Question(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
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
        return "Question{" + "id_question=" + id_question + ", body=" + body + ", vote=" + vote + ", id_tag=" + id_tag + ", id_personne=" + id_personne + ", title=" + title + ", tag_name=" + tag_name + '}';
    }

    

    

    
    
}
