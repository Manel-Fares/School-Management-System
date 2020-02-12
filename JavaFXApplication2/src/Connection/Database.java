/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Pytrooooo
 */
public class Database {
     
    private String url="jdbc:mysql://localhost/PiDev";
    private String username="root";
    private String password="";
    private Connection connexion;
    private static Database instance;

    private Database() {
         try {
            connexion=DriverManager.getConnection(url, username, password);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnexion() {
        return connexion;
    }
    
    
    
    public static Database getInstance(){
        if(instance==null)
            instance=new Database();
        return instance;
    }
}
