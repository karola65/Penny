/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.scene.Node;
import javafx.event.ActionEvent;


/**
 *
 * @author micro
 */
public class Penny extends Application {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<User> users = new ArrayList ();
    public static Charity charityGlobal;
    public static User userGlobal;
    

        
    public void start(Stage stage) throws Exception
    {   
  
        getAllUsers();
        
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
        // TODO code application logic here
    }
    
 
    
   public void getAllUsers() throws ClassNotFoundException, SQLException {
    
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
    Statement query = conn.createStatement();    
      
  
   try {
        String sql = "SELECT * FROM USERS";

        ResultSet rs = query.executeQuery(sql);
        while (rs.next()) 
        {
            User user = new User();

            user.setFirstName(rs.getString("FIRSTNAME"));
            user.setLastName(rs.getString("LASTNAME"));
            user.setUserName(rs.getString("USERNAME"));
            user.setEmail(rs.getString("EMAIL"));
            user.setPassword(rs.getString("PASSWORD"));

            users.add(user);

        }

    } catch (Exception e) {
        System.out.println("getAllUsers()");
        e.printStackTrace();
    }

  
}
    
}
