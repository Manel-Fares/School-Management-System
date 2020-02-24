/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;
import javafx.collections.ObservableList;
import weboss.Entities.Emplois;


/**
 *
 * @author Pytrooooo
 */
public interface IService2<T> {
    
       public void AddClass(T t);
       public ObservableList<T> GetClass();
       public ObservableList<T> SearchClass(String nom);
       public void DeleteClass(int id);      
       public void UpdateClass(T t);
       public void AddEmplois(Emplois t);
       public ObservableList<Emplois> GetEmplois();   
        public ObservableList<Emplois> SearchEmplois(String source);
       public void DeleteEmplois(int id);  
       public void UpdateEmplois(Emplois t);
  
    
}
