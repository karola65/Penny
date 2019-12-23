/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.swing.*;
import javafx.stage.Stage;
import javafx.scene.Node;

   

/**
 * FXML Controller class
 *
 * @author micro
 */
public class LoginController implements Initializable {
    
  
    

    @FXML
    private TextField userNameBox;
    @FXML
    private Button button;
    @FXML
    private TextField passwordBox;
    @FXML
    private Text register;
    @FXML
    private Text register1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // JOptionPane.showMessageDialog(null,"JDJHEEEEEEEEEEEEJD");
    }    

    @FXML
    private void login(ActionEvent event) throws Exception {
        
        //JOptionPane.showMessageDialog(null,"JDJDJDJD");
        //RegisterController rc = new RegisterController();
        //rc.initialize(null,null);
        //THIS IS THE STUFF THAT CREATES A NEW PAGE!
        
       if (userNameBox.getText().equals("Admin") && passwordBox.getText().equals("1234"))
       {
         Parent root = FXMLLoader.load(getClass().getResource("mainAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
       }
       else
       {
        boolean userFound = false;
        for (int x=0;x<Penny.users.size();x++)
        {
        if(Penny.users.get(x).getFirstName().equals(userNameBox.getText()) && Penny.users.get(x).getPassword().equals(passwordBox.getText()) )
        {
        Penny.userGlobal =Penny.users.get(x);
        userFound = true;
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
            
        }
       
        }
        if (userFound==false)
        {
         
          
             JOptionPane.showMessageDialog(null,"Sorry your password is wrong or empty try again or register!");
    
        
        }
       }
        
    }

    @FXML
    private void register(MouseEvent event) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void forgetpassword(MouseEvent event) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("forgetpassword.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
    
}
