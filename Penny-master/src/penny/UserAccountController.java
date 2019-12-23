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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author micro
 * @author Kuvit
 */
public class UserAccountController implements Initializable {

    @FXML
    private Label firstNamelabel;
    @FXML
    private Label lastNamelabel;
    @FXML
    private Label emaillabel;
    @FXML
    private Label userNamelabel;
  
    /**
     * Initializes the controller class.
     */

    private User user1 = Penny.userGlobal;
ArrayList<Monthly> donations = new ArrayList<>();
    //user info
    


    //user charity table info
    @FXML private TableView<Monthly> tableView;
    @FXML private TableColumn<Monthly, Integer> amountColumn;
    @FXML private TableColumn<Monthly, String> charityNameColumn;
    @FXML private TableColumn<Monthly, LocalDate> dateColumn;

 ObservableList<Monthly> oblist = FXCollections.observableArrayList();  
    //go back action
   /* private void handleButtonAction(MouseEvent event) throws Exception {
      Parent mainPageParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
      Scene mainPageScene = new Scene(mainPageParent);
      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.setScene(mainPageScene);
      window.show();
    }*/
    @FXML
    private Button button;

    //display user info
    public void initData(User user1){ 
        
        System.out.println("1");

        firstNamelabel.setText(user1.getFirstName()); 
        lastNamelabel.setText(user1.getLastName());
        emaillabel.setText(user1.getEmail());
        userNamelabel.setText(user1.getUserName());
    }
    @Override

    //display user charity table info
    public void initialize(URL url, ResourceBundle rb) {
    
        System.out.println("1");
        initData(user1);
        try { 
            getAllDonations();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
              System.out.println(ex);}
        String a = null;
        for ( int i = 0; i<donations.size(); i++)
        {
       a = Integer.toString(donations.get(i).getAmount());
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        charityNameColumn.setCellValueFactory(new PropertyValueFactory<>("CharityName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("DateOfPayment"));
           tableView.setItems(oblist);;
        }
          
           

      
        // TODO
    }  
    
    public void getAllDonations() throws ClassNotFoundException, SQLException {
    
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
    Statement query = conn.createStatement();    
      
 
   try {
        String sql = "SELECT * FROM DONATION WHERE USERL='"+ user1.userName+"'";
        
        ResultSet rs = query.executeQuery(sql);
        while (rs.next()) 
        {
            Monthly donation = new Monthly();

            donation.setAmount(rs.getInt("AMOUNT"));
            donation.setCharityName(rs.getString("CHARITYN"));
            donation.setDateOfPayment(rs.getDate("DATE").toString());
            System.out.println(donation.getDateOfPayment());
            donations.add(donation);

            oblist.add(donation);

        }

    } catch (Exception e) {
        System.out.println("getAllCharities()");
        e.printStackTrace();
    }

   

}

    @FXML
    private void goBack(MouseEvent event) throws IOException {
        
       
      Parent mainPageParent = FXMLLoader.load(getClass().getResource("main.fxml"));
      Scene mainPageScene = new Scene(mainPageParent);
      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.setScene(mainPageScene);
      window.show();
    
    }
}


