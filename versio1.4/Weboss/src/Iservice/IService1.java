/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Neifos
 */
public interface IService1<Obj> {
       void ajouter(Obj t) throws SQLException;
    boolean delete(Obj t) throws SQLException;
    boolean update(Obj t) throws SQLException;
    List<Obj> readAll() throws SQLException;
    
}
