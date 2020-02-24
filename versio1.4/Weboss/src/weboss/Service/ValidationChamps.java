/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weboss.Service;

import com.jfoenix.controls.*;
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
    public static boolean isTextAreaNotEmpty(JFXTextArea tf,Label lb,String errorMessage){
        boolean b = true;
        String msg = null;
        if(tf.getText().length() == 0 || tf.getText().isEmpty()){
            b = false;
            msg= errorMessage;
        }
        lb.setText(msg);
        return b;
        
    }
        public static boolean isComboBoxNotEmpty(JFXComboBox tf,Label lb,String errorMessage){
        boolean b = true;
        String msg = null;
        if(tf.getValue().toString()==null){
            b = false;
            msg= errorMessage;
        }
        lb.setText(msg);
        return b;
        
    }
    public static boolean isDatePickerNotEmpty(JFXDatePicker tf,Label lb,String errorMessage){
        boolean b = true;
        String msg = null;
        if(tf.getValue().toString() == null){
            b = false;
            msg= errorMessage;
        }
        lb.setText(msg);
        return b;
        
    }
    public static boolean isMailField(TextField tf,Label lb,String errorMessage){
        boolean b = true;
        String msg = null;
        if(!tf.getText().matches("^[a-zA-Z]+[a-zA-Z0-9\\\\._-]*[a-zA-Z0-9]@[a-zA-Z]+\"\n" +
"                        + \"[a-zA-Z0-9\\\\._-]*[a-zA-Z0-9]+\\\\.[a-zA-Z]{2,4}$")){
            b = false;
            msg= errorMessage;
        }
        lb.setText(msg);
        return b;
        
    }
    
    public static boolean isDateEqToDate(JFXDatePicker tp,JFXDatePicker tp2,Label lb,String errorMessage){
        boolean b = true;
        String msg = null;
        if(tp.getValue().isAfter(tp2.getValue()) ){
            b = false;
            msg= errorMessage;
        }
        lb.setText(msg);
        return b;
        
    }

    public static boolean isTimeEqToTime(JFXTimePicker tp,JFXTimePicker tp2,Label lb,String errorMessage){
        boolean b = true;
        String msg = null;
        if(tp.getValue().isAfter(tp2.getValue()) ){
            b = false;
            msg= errorMessage;
        }
        lb.setText(msg);
        return b;
        
    }
    
}
