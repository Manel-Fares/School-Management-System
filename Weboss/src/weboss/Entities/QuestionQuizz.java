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
public class QuestionQuizz {
    private int id;
    private String question;
    private String rep1;
    private String rep2;
    private String rep3;
    private String rep;
    private Quizz q;

    public QuestionQuizz() {
    }

    public QuestionQuizz(String question, String rep1, String rep2, String rep3, String rep) {
        this.question = question;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.rep = rep;
    }
    
    public QuestionQuizz(int id, String question, String rep1, String rep2, String rep3, String rep, Quizz q) {
        this.id = id;
        this.question = question;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.rep = rep;
        this.q = q;
    }
    

    public QuestionQuizz(String question, String rep1, String rep2, String rep3, String rep, Quizz ch) {
        this.question = question;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.rep = rep;
        this.q = ch;
    }

    public Quizz getQ() {
        return q;
    }

    public void setQ(Quizz q) {
        this.q = q;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }
    
}
