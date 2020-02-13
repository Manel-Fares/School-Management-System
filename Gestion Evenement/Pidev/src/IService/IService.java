/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {

    void ajouter(T t) throws SQLException;

    List<T> affciher() throws SQLException;

    void modifier(T t, int id) throws SQLException;

    void supprimer(int id) throws SQLException;


  //  List<T> recherche(String x) throws SQLException;

}
