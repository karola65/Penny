/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author micro
 */
public class AddController implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private TextField name;
    @FXML
    private TextField keyword;
    @FXML
    private TextField location;
    @FXML
    private TextField id;
    @FXML
    private TextField description;
    @FXML
    private TextField purpose;
    @FXML
    private TextField path;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitChanges(MouseEvent event) {
        
        String a = id.getText();
        
        
        int b = Integer.parseInt(a);
        
        
        Charity charity = new Charity(location.getText(), name.getText(), purpose.getText(), b, keyword.getText(), description.getText(), path.getText()) ;
      
       
        
       
        
        try{
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
        Statement query = c.createStatement();
        
        
        String sql =  "INSERT INTO CHARITY "
                + "(LOCATION, NAME, PURPOSE, CHARITYID, KEYWORD, DESCRIPTION, PATH) "
                + "VALUES ('"
                +charity.getLocation()+"','"
                +charity.getName()+"','"
                +charity.getPurpose()+"',"
                +charity.getCharityID()+",'"
                +charity.getKeyword()+"','"
                +charity.getDescription()+
                "','"+charity.getPath()+"')";
        //System.out.println(query.executeQuery("SELECT * FROM * ;")); 
        
        query.executeUpdate(sql);
        
        JOptionPane.showMessageDialog(null,"Your charity has been registered");
            
        }
        catch(SQLException ex)
         {
                    System.out.println(ex);
         }
        
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("mainAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }
    
}
