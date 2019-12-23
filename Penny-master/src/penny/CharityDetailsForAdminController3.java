/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;

import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author micro
 */
public class CharityDetailsForAdminController3 implements Initializable {

    @FXML
    private Text charityDescription;
    @FXML
    private Text charityName;
    @FXML
    private Text charityPurpoe;
    @FXML
    private Text charityLocation;
    @FXML
    private Button button;
    @FXML
    private ImageView image;
    @FXML
    private Button edit;

     Charity charity = Penny.charityGlobal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Image image1 = new Image((charity.getPath()));
      

        charityName.setText(charity.getName());
        charityLocation.setText(charity.getLocation());
        charityDescription.setText(charity.getDescription());
        charityPurpoe.setText(charity.getPurpose());
        
        try{
        image.setImage(image1);
        }
        catch(Exception e)
        {
            System.out.print("ff");
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
    private void edit(MouseEvent event) throws IOException {
        
       
         Penny.charityGlobal = charity;
         
         
        
         Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.show();

    }
    
}
