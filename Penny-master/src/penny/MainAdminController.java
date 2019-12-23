/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;

import java.io.IOException;
import java.lang.Exception;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static penny.Penny.users;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;

/**
 * FXML Controller class// grid layour
 */
 
public class MainAdminController implements Initializable {
    
     ArrayList<Charity> charities = new ArrayList<>();
     
     ArrayList<Charity> charitiesDisplayed = new ArrayList<>();
     
     boolean haveSearched = false;
       String byWhat;
       
       
     
      
  
   
   
    @FXML
    private TextField charityfinder;
    @FXML
    private Text charity3Name;
    @FXML
    private Text charity3Purpose;
    @FXML
    private Text charity3Location;
    @FXML
    private Text charity2Name;
    @FXML
    private Text charity2Purpose;
    @FXML
    private Text charity2Location;
    @FXML
    private Text charity1Name;
    @FXML
    private Text charity1Purpose;
    @FXML
    private Text charity1Location;
    
    @FXML
    private MenuItem name;
    @FXML
    private MenuItem location;
    @FXML
    private MenuButton category;
    @FXML
    private MenuItem keyword;
    @FXML
    private MenuItem purpose;
    @FXML
    private Button search;
    @FXML
    private Button add;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image1;
    
  

    /**
     * Initializes the controller class.
     * 
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
        charities.clear();
        charitiesDisplayed.clear();
        
         try {
             getAllCharities();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         
             try{
                     image1.setImage(new Image((charities.get(0).getPath())));
                     image2.setImage(new Image((charities.get(1).getPath())));
                     image3.setImage(new Image((charities.get(2).getPath())));
                 }
                catch(Exception e)
                {
            System.out.print("cant display picture");
                }
        charity1Name.setText(charities.get(0).getName());
        charity2Name.setText(charities.get(1).getName());
        charity3Name.setText(charities.get(2).getName());
        
        charity1Purpose.setText(charities.get(0).getPurpose());
        charity2Purpose.setText(charities.get(1).getPurpose());
        charity3Purpose.setText(charities.get(2).getPurpose());
        
        charity1Location.setText(charities.get(0).getLocation());
        charity2Location.setText(charities.get(1).getLocation());
        charity3Location.setText(charities.get(2).getLocation());
        
        
        
// TODO
    }    

     @FXML
    private void gotoCharity3(MouseEvent event) throws IOException {
        if (haveSearched)
        { 
        try{
        Penny.charityGlobal= charitiesDisplayed.get(3); 
        Parent root = FXMLLoader.load(getClass().getResource("charityDetailsForAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
        
        }
          catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Sorry this is just a green square not a charity");
                }
        }
        else
        {
            Penny.charityGlobal = charities.get(3);
            
        Parent root = FXMLLoader.load(getClass().getResource("charityDetailsForAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
        }
            
            
    }
    
    
    

    @FXML
    private void goToCharity2(MouseEvent event) throws IOException {
      if(haveSearched)
      {
          try{ 
        Penny.charityGlobal= charitiesDisplayed.get(1); 
        Parent root = FXMLLoader.load(getClass().getResource("charityDetailsForAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
       }
         catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Sorry this is just a green square not a charity");
                }
    }
     else
        {
            Penny.charityGlobal = charities.get(1);
            
        Parent root = FXMLLoader.load(getClass().getResource("charityDetailsForAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
        }
           
    }

    @FXML
    private void goToCharity1(MouseEvent event) throws Exception {
        
       if(haveSearched)
       {
        try{
        
        
        Penny.charityGlobal= charitiesDisplayed.get(0); 
        Parent root = FXMLLoader.load(getClass().getResource("charityDetailsForAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Sorry this is just a green square not a charity");
                }
       }
    else
        {
            Penny.charityGlobal = charities.get(0);
           
        Parent root = FXMLLoader.load(getClass().getResource("charityDetailsForAdmin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
        }
                  
    }


    @FXML
    private void findcharity(MouseEvent event) throws ClassNotFoundException, SQLException {
        
        haveSearched = true;
        
       CharityList charityList = CharityList.getInstance();
       charityList.getAllCharities();
        ArrayList <Charity> charitiesFound= new ArrayList<>();
       
         try{
                     image1.setImage(new Image("penny/logo.jpg"));
                     image2.setImage(new Image("penny/logo.jpg"));
                     image3.setImage(new Image("penny/logo.jpg"));
                 }
                catch(Exception e)
                {
            System.out.print("cant display picture");
                }
        charity1Name.setText("");
        charity2Name.setText("");
        charity3Name.setText("");
        
        charity1Purpose.setText("");
        charity2Purpose.setText("");
        charity3Purpose.setText("");
        
        charity1Location.setText("");
        charity2Location.setText("");
        charity3Location.setText("");
        
      if((byWhat==null) || charityfinder.getText()==null ) 
      {
          JOptionPane.showMessageDialog(null,"In order to search , please enter required information");
      }
        
      else if(byWhat.equals("location")) 
      {
          
         charitiesFound = charityList.findCharityByLocation(charityfinder.getText());
         showSearchResults(charitiesFound, charityList, charitiesDisplayed);
         
      }
      else if(byWhat.equals("name")) 
      {
          System.out.println("1");
         charitiesFound = charityList.findCharityByName(charityfinder.getText());
         System.out.println("2");
          showSearchResults(charitiesFound, charityList, charitiesDisplayed);
         
      }
      else if(byWhat.equals("keyword")) 
      {
          
         charitiesFound = charityList.findCharityByKeyword(charityfinder.getText());
          showSearchResults(charitiesFound, charityList, charitiesDisplayed);
         
      }
      else if(byWhat.equals("purpose")) 
      {
          
         charitiesFound = charityList.findCharityByPurpose(charityfinder.getText());
         showSearchResults(charitiesFound, charityList, charitiesDisplayed);
         
      }
       else
      {
           System.out.print("error in finding");
          
      }// CHAR[] DERARCH WORD = TOCHARARRAY();
        
        
    }



      public void getAllCharities() throws ClassNotFoundException, SQLException {
    
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/penny", "K","k");
    Statement query = conn.createStatement();    

   try {
        String sql = "SELECT * FROM CHARITY";

        ResultSet rs = query.executeQuery(sql);
        while (rs.next()) 
        {
            Charity charity = new Charity();

            charity.setName(rs.getString("NAME"));
            charity.setLocation(rs.getString("LOCATION"));
            charity.setKeyword(rs.getString("KEYWORD"));
            charity.setPurpose(rs.getString("PURPOSE"));
            charity.setDescription(rs.getString("DESCRIPTION"));
            charity.setCharityID(rs.getInt("CHARITYID"));
            charity.setPath(rs.getString("PATH"));


            charities.add(charity);

        }

    } catch (Exception e) {
        System.out.println("getAllCharities()");
        e.printStackTrace();
    }
   }

  


   

    @FXML
    private void findCharityByLocation(ActionEvent event) {
        
        category.setText("Location");
         byWhat="location";
    }

    @FXML
    private void findCharityByKeyword(ActionEvent event) {
        
          category.setText("Keyword");
         byWhat="keyword";
    }

    @FXML
    private void findCharityByPurpose(ActionEvent event) {
          category.setText("Purpose");
         byWhat="purpose";
    }

    @FXML
    private void findCharityByName(ActionEvent event) {
        
        category.setText("Name");
         byWhat="name";
    }

    public void showSearchResults(ArrayList <Charity> charitiesFound, CharityList charityList, ArrayList <Charity> charitiesDisplayed)
    {
        charitiesDisplayed.clear();
        int a = charitiesFound.size();
         
         if(a > 2)
        {
            
             try{
                     image1.setImage(new Image((charitiesFound.get(0).getPath())));
                     image2.setImage(new Image((charitiesFound.get(1).getPath())));
                     image3.setImage(new Image((charitiesFound.get(2).getPath())));
                 }
                catch(Exception e)
                {
            System.out.print("cant display picture");
                }
        charitiesDisplayed.add(0, charitiesFound.get(0));
        charitiesDisplayed.add(1, charitiesFound.get(1));
        charitiesDisplayed.add(2, charitiesFound.get(2));
        charity1Name.setText(charitiesFound.get(0).getName());
        charity2Name.setText(charitiesFound.get(1).getName());
        charity3Name.setText(charitiesFound.get(2).getName());
        
        charity1Purpose.setText(charitiesFound.get(0).getPurpose());
        charity2Purpose.setText(charitiesFound.get(1).getPurpose());
        charity3Purpose.setText(charitiesFound.get(2).getPurpose());
        
        charity1Location.setText(charitiesFound.get(0).getLocation());
        charity2Location.setText(charitiesFound.get(1).getLocation());
        charity3Location.setText(charitiesFound.get(2).getLocation());
         }
        else if(a==2)
         {
             
             try{
                     image1.setImage(new Image((charitiesFound.get(0).getPath())));
                     image2.setImage(new Image((charitiesFound.get(1).getPath())));
                                      }
                catch(Exception e)
                {
            System.out.print("cant display picture");
                }
         charitiesDisplayed.add(0, charitiesFound.get(0));
        charitiesDisplayed.add(1, charitiesFound.get(1));
        charity1Name.setText(charitiesFound.get(0).getName());
        charity2Name.setText(charitiesFound.get(1).getName());
       
        
        charity1Purpose.setText(charitiesFound.get(0).getPurpose());
        charity2Purpose.setText(charitiesFound.get(1).getPurpose());
       
        
        charity1Location.setText(charitiesFound.get(0).getLocation());
        charity2Location.setText(charitiesFound.get(1).getLocation());
       
         }
         else if(a==1)
         {
             
             try{
                     image1.setImage(new Image((charitiesFound.get(0).getPath())));
                     
                 }
                catch(Exception e)
                {
            System.out.print("cant display picture");
                }
        charitiesDisplayed.add(0, charitiesFound.get(0));
        charity1Name.setText(charitiesFound.get(0).getName()); 
        charity1Purpose.setText(charitiesFound.get(0).getPurpose());
        charity1Location.setText(charitiesFound.get(0).getLocation());
        
         }
         else{
         charity1Name.setText("Sorry, no charities match your search"); }
       }

    @FXML
    private void addCharity(MouseEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void findcharity(Event event) {
    }

  


          
    }
   
            
    

