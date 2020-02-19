/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Resultat;
import com.esprit.Service.ServiceResultat;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Aymen
 */
public class InterfacePersonnelResultatController implements Initializable {

    @FXML
    private Button calculer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void calculerAciiton(ActionEvent event) throws SQLException {
        ServiceResultat sr = new ServiceResultat();
        List<Integer> listeEtudiant = sr.getListEtudiant();
        sr.calculResultats(listeEtudiant);
    }
    
}
