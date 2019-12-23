/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.DriverManager;

/**
 * FXML Controller class
 *
 * @author micro
 */
public class RegisterController implements Initializable {
    

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Button submit;
    @FXML
    private Text login;
    @FXML
    private AnchorPane box;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit(MouseEvent event) throws IOException{
        
        User user1 = new User(firstName.getText(), lastName.getText(), email.getText(), userName.getText(), password.getText()) ;
      
       
        Penny.users.add(user1);
        
       // JOptionPane.showMessageDialog(null,"Your account has been registered");
        
        try{
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
        Statement query = c.createStatement();
        
        
        String sql =  "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, EMAIL, PASSWORD) VALUES ('"+user1.getFirstName()+"','"+user1.getLastName()+"','"+user1.getUserName()+"','"+user1.getEmail()+"','"+user1.getPassword()+"')";
        //System.out.println(query.executeQuery("SELECT * FROM * ;")); 
        
        query.executeUpdate(sql);
            
        }
        catch(SQLException ex)
         {
                    System.out.println(ex);
         }
        
       Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
       
       
    }

    @FXML
    private void login(MouseEvent event) throws Exception
    {
        
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
    
}
