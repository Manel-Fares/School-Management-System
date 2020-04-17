/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.skins.JFXDatePickerSkin;
import com.mysql.jdbc.StringUtils;
import java.util.regex.Pattern;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

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
    public static boolean isEmailValid(TextField tf){
        boolean b = false;
        Pattern err = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
 
        if(err.matcher(tf.getText()).matches() &&  !tf.getText().isEmpty()  )
            b = true;
        return b;
    }
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        int d = Integer.parseInt(strNum);
       
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
     public static boolean isNumbervalid(TextField tf){
        boolean b = false;
        if(isNumeric(tf.getText()) &&  tf.getText().length()==8 )
            b = true;
        return b;
    }
     
       public static boolean isNumber(TextField tf,ImageView img,ImageView img1){
       // boolean b = true;
    
        if(!isNumbervalid(tf)){
         //   b = false;
           
             img.setVisible(false);
             img1.setVisible(true);
             return false;
        }
        img.setVisible(true);
         img1.setVisible(false);
        return true;
        
    }
    public static boolean isTextFieldNotEmpty(TextField tf,ImageView img,ImageView img1){
       // boolean b = true;
    
        if(!isTextFieldNotEmpty(tf)){
         //   b = false;
           
             img.setVisible(false);
             img1.setVisible(true);
             return false;
        }
        img.setVisible(true);
         img1.setVisible(false);
        return true;
        
    }
      public static boolean isEmail(TextField tf,ImageView img,ImageView img1){
       // boolean b = true;
    
        if(!isEmailValid(tf)){
         //   b = false;
           
             img.setVisible(false);
             img1.setVisible(true);
             return false;
        }
        img.setVisible(true);
         img1.setVisible(false);
        return true;
        
    }
        public static boolean isDateValid(JFXDatePicker D,JFXDatePicker D1){
        boolean b = true;
         if (D.getValue().compareTo(D1.getValue()) > 0) {
                
                return false;
            }
        return b;
    }
           public static boolean isdATE(JFXDatePicker D,JFXDatePicker D1,ImageView img,ImageView img1){
       // boolean b = true;
    
        if(!isDateValid(D,D1)){
         //   b = false;
           
             img.setVisible(false);
             img1.setVisible(true);
             return false;
        }
        img.setVisible(true);
         img1.setVisible(false);
        return true;
        
    }
      
    
}
