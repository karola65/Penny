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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author micro
 */
public class MonthlyDonationController implements Initializable {

    @FXML
    private TextField cardNumber;
    @FXML
    private TextField nameOnCard;
    @FXML
    private MenuButton type;
    @FXML
    private MenuItem visa;
    @FXML
    private MenuItem masterCard;
    @FXML
    private MenuItem anericanExpress;
    @FXML
    private PasswordField securityNumber;
    @FXML
    private DatePicker dateOfPayment;
    @FXML
    private TextField amount;
    @FXML
    private DatePicker dateExpire;
    
    String typeChosen;
    @FXML
    private Button donate;
    @FXML
    private Button button;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void visa(ActionEvent event) {
        typeChosen = "visa";
        type.setText("Visa");
    }

    @FXML
    private void masterCard(ActionEvent event) {
        
         typeChosen = "masterCard";
        type.setText("MasterCard");
    }

    @FXML
    private void amerianExpress(ActionEvent event) {
        
         typeChosen = "americanExpress";
        type.setText("AmercianExpress");
    }

    @FXML
    private void donate(MouseEvent event) {
        
        Card card = new Card(nameOnCard.getText(), cardNumber.getText(), dateExpire.getAccessibleText(), typeChosen, securityNumber.getAnchor() );
        Monthly mdonation = new Monthly (Integer.parseInt(amount.getText()), Penny.charityGlobal.getCharityID(), dateOfPayment.getValue().toString(), Penny.charityGlobal.getName());
         try{
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
        Statement query = c.createStatement();
        
        
        String sql =  "INSERT INTO CARD (USERL, NAMEONCARD, TYPE, SECURITY, CARDNUMBER) VALUES ('"+Penny.userGlobal.getUserName()+"','"+card.getNameOnCard()+"','"+typeChosen+"',"+card.getSecurityNumber()+",'"+card.getCardNumber()+"')";
        //System.out.println(query.executeQuery("SELECT * FROM * ;")); 
        String sql1 =  "INSERT INTO DONATION (AMOUNT, CHARITYN, DATE, USERL) VALUES ("+Integer.parseInt(amount.getText())+",'"+Penny.charityGlobal.getName()+"','"+dateOfPayment.getValue()+"','"+Penny.userGlobal.getUserName()+"')";
        
        query.executeUpdate(sql);
        query.executeUpdate(sql1);
        
        JOptionPane.showMessageDialog(null,"Your donation has been added! Thank you!");
            
        }
        catch(SQLException ex)
         {
                    System.out.println(ex);
         }
    }

    @FXML
    private void date(ActionEvent event) {
        
        dateOfPayment.setPromptText(dateOfPayment.getValue().toString());
    }

    @FXML
    private void dateE(ActionEvent event) {
        
        dateExpire.setPromptText(dateExpire.getValue().toString());
    }

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        
          
         Parent root = FXMLLoader.load(getClass().getResource("charityDetails.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();

    }
    
    
}
