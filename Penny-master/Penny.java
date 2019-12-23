/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penny;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author micro
 */
public class Penny extends Application {

    /**
     * @param args the command line arguments
     */
    public void start(Stage stage) throws Exception
    {
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
    
}
