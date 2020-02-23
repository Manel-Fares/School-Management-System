/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Personne;
import Entite.Question;
import Entite.Reponse;
import Entite.Tag;
import Service.ServicePersonne;
import Service.ServiceQuestion;
import Service.ServiceReponse;
import Service.ServiceTag;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bensl
 */
public class Test {
    public static void main(String[] args) {
        
        ServicePersonne ser = new ServicePersonne();
        ServiceQuestion serQ = new ServiceQuestion();
        ServiceReponse serR = new ServiceReponse();
        ServiceTag serT = new ServiceTag();
        
        Personne p1 = new Personne("sana", "ben fadhel", 10);
        Question q1 = new Question("body 22", 2, 2, 2, "title2 test", "tagtest2");
        Reponse r1 = new Reponse(6, "body 6", 2, 1);
        Tag t1 = new Tag(4, "mobile", "desc mobile");
        
        try {
            //ser.ajouter(p1);
            
            List<Personne> list = ser.readAll();
            List<Question> listQ = serQ.readAll();
            List<Reponse> listR = serR.readAll();
            List<Tag> listT = serT.readAll();
            
            //System.out.println(list);
            //ser.ajouter(p1);
            //ser.delete(2);
            //ser.update(2, "wajihii", "ben slamaii", 35);
            
            //System.out.println(listQ);
            //serQ.update(3, "ques3", 0, 0, 0);
            //serQ.ajouter(q1);
            //serQ.ajouter2(q1);
            //serQ.readAll();
            
            //System.out.println(listR);
            //serR.ajouter(r1);
            //serR.update(3, "v", 4, 2);
            
            //System.out.println(listT);
            //serT.ajouter(t1);
            //serT.update(4, "mob", "mobdex");
            
            //System.out.println(serQ.readAll());
            //System.out.println(serQ.readRecherche("body 1"));
            //System.out.println(serR.findResponseByQuestion(1));
            System.out.println(serQ.readQTitle(4));
            
            
            //System.out.println(serR.readAll());
            
            //System.out.println(serR.findResponseByQuestion(1));
            //System.out.println(serT.readAll());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
}
