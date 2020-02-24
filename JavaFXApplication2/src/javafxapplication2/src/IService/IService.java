/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;
import entity.Emplois;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.EmploisService;


/**
 *
 * @author Pytrooooo
 */
public interface IService {
    
       public void AddClass(entity.Class t);
       public ObservableList<entity.Class> GetClass();
       public ObservableList<entity.Class> SearchClass(String nom);
       public void DeleteClass(int id);      
       public void UpdateClass(entity.Class t);
       public void AddEmplois(Emplois t);
       public ObservableList<Emplois> GetEmplois();   
        public ObservableList<Emplois> SearchEmplois(String source);
       public void DeleteEmplois(int id);  
       public void UpdateEmplois(Emplois t);
  
    
}
