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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author micro
 */
public class EditController implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private TextField name;
    @FXML
    private TextField keyword;
    @FXML
    private TextField location;
    @FXML
    private Text id;
    @FXML
    private TextField description;
    @FXML
    private TextField purpose;
    @FXML
    private TextField path;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Charity charity = Penny.charityGlobal;
        

        name.setText(charity.getName());
        location.setText(charity.getLocation());
        description.setText(charity.getDescription());
        purpose.setText(charity.getPurpose());
        path.setText(charity.getPath());
        keyword.setText(charity.getKeyword());
        id.setText(Integer.toString(charity.getCharityID()));
        
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
  
        
        String sql =  "UPDATE CHARITY SET LOCATION ='"+charity.getLocation()+
                "', NAME = '"+charity.getName()+
                "', PURPOSE = '"+charity.getPurpose()+
                "', KEYWORD = '"+charity.getKeyword()+
                "', DESCRIPTION ='"+charity.getDescription()+
                "', PATH = '"+charity.getPath()+
                "' WHERE CHARITYID ="+charity.getCharityID();
                
        //System.out.println(query.executeQuery("SELECT * FROM * ;")); 
        
        query.executeUpdate(sql);
        
        Penny.charityGlobal = charity;
        
        JOptionPane.showMessageDialog(null,"Your charity has been updated");
            
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

    @FXML
    private void delete(MouseEvent event) {
        
        String a = id.getText();
        
        
        int b = Integer.parseInt(a);
        
        
        Charity charity = new Charity(location.getText(), name.getText(), purpose.getText(), b, keyword.getText(), description.getText(), path.getText()) ;
      
       
        
       
        
        try{
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
        Statement query = c.createStatement();
  
        
        String sql =  "DELETE FROM CHARITY WHERE CHARITYID ="+charity.getCharityID();
                
        //System.out.println(query.executeQuery("SELECT * FROM * ;")); 
        
        query.executeUpdate(sql);
        
        Penny.charityGlobal = new Charity ("","","",100000,"","","");
        
        JOptionPane.showMessageDialog(null,"Your charity has been deleted");
            
        }
        catch(SQLException ex)
         {
                    System.out.println(ex);
         }
        
        
    }
    
}
