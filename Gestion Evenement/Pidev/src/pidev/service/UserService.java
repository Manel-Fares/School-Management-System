/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.BD.Database;

/**
 *
 * @author asus
 */
public class UserService {
      private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public UserService() {
                cnx = Database.getInstance().getConnexion();

    }
    
    public String getMail(int id) throws SQLException
    {
        List<Integer> arr = new ArrayList<>();
        ste = cnx.createStatement();
         String c="";
        ResultSet rs = ste.executeQuery("SELECT emailUser FROM `users` WHERE idUser='"+id+"'");
        while (rs.next()) {
      c=rs.getString("emailUser");
            
        }
    return c;
    }
    
}
