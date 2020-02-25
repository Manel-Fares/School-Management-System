/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



/**
 *
 * @author Pytrooooo
 */
public class JavaFXApplication2 extends Application {
   // public static final String ACCOUNT_SID = "ACb90b92da7197182698f75774f6a1aa57";
// public static final String AUTH_TOKEN = "54eeb85f3bf3bc9584438763cda46cf5";
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("dd");
        Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
       /* Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        PhoneNumber to =new PhoneNumber("+21624281526");
        PhoneNumber from =new PhoneNumber("+12015089210");
        Message message=Message.creator(to, from, "test").create();*/
        System.out.println("ss");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
