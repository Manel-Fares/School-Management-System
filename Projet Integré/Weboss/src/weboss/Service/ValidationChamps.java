/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Neifos
 */
public class ValidationChamps {
    public static boolean isTextFieldNotEmpty(TextField tf){
        boolean b = false;
        if(tf.getText().length() != 0 || !tf.getText().isEmpty())
            b = true;
        return b;
    }
    public static boolean isTextFieldNotEmpty(TextField tf,Label lb,String errorMessage){
        boolean b = true;
        String msg = null;
        if(!isTextFieldNotEmpty(tf)){
            b = false;
            msg= errorMessage;
        }
        lb.setText(msg);
        return b;
        
    }
    
}
