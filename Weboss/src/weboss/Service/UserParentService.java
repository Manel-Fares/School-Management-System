/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import Iservice.IService1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import weboss.BD.Database;
import weboss.Entities.UserParent;

/**
 *
 * @author Neifos
 */
public class UserParentService implements IService1<UserParent>{
     private Connection con;
    private Statement ste;

    public UserParentService() {
        con = Database.getInstance().getConnexion();

    }

    @Override
    public void ajouter(UserParent t) throws SQLException {
 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement pre = con.prepareStatement("INSERT INTO `users` (`idUser`, `cinUser`,`nomUser`,`prenomUser`,`dateNaissanceUser`,`sexeUser`,`emailUser`,`adresseUser`,`numTelUser`,`roleUser`,`motDePasseUser`) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
        pre.setString(1, null);
        pre.setInt(2, t.getCinUser());
        pre.setString(3, t.getNomUser());
        pre.setString(4, t.getPrenomUser());
        pre.setString(5, dateFormat.format(t.getDateNaissanceUser()));
        pre.setString(6, t.getSexeUser());
        pre.setString(7, t.getEmailUser());
        pre.setString(8, t.getAdresseUser());
        pre.setInt(9, t.getNumTelUser());
        pre.setString(10, "Parent");
        pre.setString(11, t.getMotDePasseUser());
        
      

        pre.executeUpdate();   
    }

    @Override
    public boolean delete(UserParent t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserParent t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserParent> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
