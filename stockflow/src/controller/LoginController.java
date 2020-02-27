/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.User;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class LoginController implements Initializable {
    
    
    
    @FXML TextField tf1;
    @FXML PasswordField tf2;
    public String ch1,ch2;
    @FXML
    private ImageView dp;
   // private AnchorPane nav1;
//    public void gotoregister(ActionEvent event) throws IOException{
//        Parent register= FXMLLoader.load(getClass().getResource("Register.fxml"));
//        Scene registerScene = new Scene(register);
//        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(registerScene);
//        window.show();
//    }
    @FXML
    private AnchorPane nav;
    
    
    @FXML
    public void login(ActionEvent event) throws SQLException, IOException{
        
        User s;
        //FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/gui/ProduitAjoutWindow.fxml"));
        //Parent root1=(Parent) fxmlLoader.load();
        ServiceUser su=new ServiceUser();
        s=su.search(tf1.getText(),tf2.getText());
        
        
        ch1=tf1.getText();
        ch2=tf2.getText();
        //ProduitAjoutWindowController secController=FxmlLoader.getController();
         //secController.Funct(s);
        if(s!=null){
            
            if(s.getType().equals("admin")){
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreen(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Logging in Status");
         alert.setHeaderText(null);
         alert.setContentText("Welcome "+s.getNom()+" "+s.getPrenom());
         alert.showAndWait();
         

        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/Admin.fxml"));
        nav.getChildren().setAll(ach);
        
       
      
            }else{
         Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreen(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Logging in Status");
         alert.setHeaderText(null);
         alert.setContentText("Welcome "+s.getNom()+" "+s.getPrenom());
         alert.showAndWait();
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/SecondWindow.fxml"));
        nav.getChildren().setAll(ach);
       
//        FXMLLoader loader=new FXMLLoader();
//        
//        loader.setLocation(getClass().getResource("/gui/SecondWindow.fxml"));
//       
//        
//            
//            Parent register=loader.load();
//            SecondWindowController controller=loader.getController();
//            controller.initdata(s);
            
         //    FXMLLoader loade2r=new FXMLLoader();
          //  loader.setLocation(getClass().getResource("/gui/ProduitAjoutWindow.fxml"));
        
            
            //Parent register2=loader.load();
            //ProduitAjoutWindowController controller2=loader.getController();
            //controller2.initdata(s,s.getNom());
           
            
                
                
                
           
        
         
//         FXMLLoader loader1=new FXMLLoader();
//        loader1.setLocation(getClass().getResource("SUInterface.fxml"));
//        
//            Parent register=loader1.load();
//            SUInterfaceController controller1=loader1.getController();
//            controller1.initdata(s);
         
//        Scene registerScene = new Scene(register);
//        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(registerScene);
            
            
            }
            
        }else{
             
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Logging in Status");
            
            alert.setContentText("Please check your informations!");

            alert.showAndWait();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img=new Image("uploads/login.png");
        dp.setImage(img);
         
    }    

    @FXML
    private void reg(ActionEvent event) throws IOException {
        Parent register= FXMLLoader.load(getClass().getResource("/gui/register.fxml"));
        Scene registerScene = new Scene(register);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("StockFlow");
        window.setScene(registerScene);
        window.show();
    }
   
    
}
