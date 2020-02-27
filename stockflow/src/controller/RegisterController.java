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
public class RegisterController implements Initializable {

    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private PasswordField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private TextField tf7;
    @FXML
    private AnchorPane nav;
    @FXML
    private ImageView dp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Image img=new Image("uploads/home.png");
        dp.setImage(img);
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent register= FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene registerScene = new Scene(register);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("StockFlow");
        window.setScene(registerScene);
        window.show();
    }

    @FXML
    private void reg(ActionEvent event) throws IOException {
        String ch1=tf1.getText();
        if (!"".equals(ch1)){
        for(int i=0;i<ch1.length();i++){
            if(!Character.isAlphabetic(ch1.charAt(i))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("must be alphabetic!!");

            alert.showAndWait();
            
            return;
                
                
            }
        }}else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("must contain last name");

            alert.showAndWait();
            return;
        }
        
        String ch2=tf2.getText();
        if (!"".equals(ch2)){
        for(int i=0;i<ch2.length();i++){
            if(!Character.isAlphabetic(ch2.charAt(i))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("must be alphabetic!!");

            alert.showAndWait();
            tf2.setText("");
            return;
                
                
            }
        }}else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("must contain first name");

            alert.showAndWait();
            return;
        }
        
        String ch3=tf3.getText();
        if (!"".equals(ch3)){
        for(int i=0;i<ch3.length();i++){
            if(!ch3.contains("@")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("please check your email!!");

            alert.showAndWait();
            
            return;
                
                
            }
        }}else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("must contain Email");

            alert.showAndWait();
            return;
        }
        
        String ch4=tf4.getText();
        if ("".equals(ch4)){
             Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Register Status");
         alert.setHeaderText(null);
         alert.setContentText("must contain login!");
         alert.showAndWait();
         return;
        }
        if(!tf5.getText().equals("")){
        if(!tf5.getText().equals(tf6.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
         alert.setHeaderText(null);
         alert.setContentText("passwords doesn't match");
         alert.showAndWait();
         return;
        }}else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
         alert.setHeaderText(null);
         alert.setContentText("must contain password");
         alert.showAndWait();
         return ;
        }
        
        if ((!"".equals(tf7.getText())) && tf7.getText().length()==8){
        for(int i=0;i<tf7.getText().length();i++){
            if(!Character.isDigit(tf7.getText().charAt(i))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("must be a NUMBER!!");

            alert.showAndWait();
            
            return;
                
                
            }
        }}else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("must contain Phone Number of 8 digits");

            alert.showAndWait();
            return;
        }
        
        
        //sending infos
        ServiceUser su=new ServiceUser();
        int x=Integer.parseInt(tf7.getText());
         User u =new User(tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText(),tf5.getText(),x);
        try {
            su.add(u,"SU");
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register Status");
            
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();
        }
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Register Status");
         alert.setHeaderText(null);
         alert.setContentText("Well Done!\nRegistering Completed");
         alert.showAndWait();
         Parent register= FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene registerScene = new Scene(register);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
         
    }
    
}
