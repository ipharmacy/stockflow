/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Entrepot;
import Services.ServiceEntrepot;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class HomeController implements Initializable {
    
    @FXML
    private AnchorPane nav;
    @FXML
    private ImageView dp;
    @FXML
    private Button ServiceBtn;
    @FXML
    private AnchorPane travailleIci;
    @FXML
    private AnchorPane paneFinancier;
            private VBox v;
  
    ServiceEntrepot e1=new ServiceEntrepot();
    @FXML
  GridPane button_grid;
          Connection con= (Connection) MaConnection.getInstance().getConnection();
    /**
     * Initializes the controller class.
     */
          public Button Clientsbtn = new Button();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int index = 2;  
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
        ServiceEntrepot s=new ServiceEntrepot();
        
        
        paneFinancier.setVisible(false);
         try {
            // TODO
           
            
            ResultSet rs =  con.createStatement().executeQuery("SELECT * FROM entrepot");
            while(rs.next()) {
                for(int i=0;i<2;i++)
                {
               
                 Button sound_button = new Button();
                // sound_button.setId(Integer.toString(j));
                 
                
                 
                 sound_button.setText(rs.getString("nom"));
                 
         button_grid.add(sound_button,0,i);
         sound_button.setStyle("-fx-background-color:transparent");
          sound_button.setStyle("-fx-border-color:black");
           sound_button.setStyle("-fx-border-width:0px 0px 2px 0px");
           s.recupid(rs.getString(rs.getString("nom")));
           SecondWindowController sWC=new SecondWindowController();
           sound_button.setId(rs.getString("nom"));
        if ((sound_button.isPressed()))
        {
        // sWC.setIdUnique(s.recupid(sound_button.getText()));
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/SecondWindow.fxml"));
        nav.getChildren().setAll(ach);
         
        }
        index++;
                }
                
              //  Clientsbtn.setText(rs.getString("nom"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // TODO
   
    }    
    
  /* public int recupid() throws SQLException, IOException{
        ServiceEntrepot s=new ServiceEntrepot();
        int id=0;
         ResultSet rs =  con.createStatement().executeQuery("SELECT * FROM entrepot");
          while(rs.next()) {
                
                
               
         
             id= s.recupid(rs.getString(rs.getString("nom")));
           AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/SecondWindow.fxml"));
        travailleIci.getChildren().setAll(ach);
                }return id;}
                
              //  Clientsbtn.setText(rs.getString("nom"));
                
        
        
   */

    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void ServiceFinancierModules(MouseEvent event) {
        paneFinancier.setVisible(true);
    }


    private void GestTransactions(ActionEvent event) throws IOException {
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/secondWindow.fxml"));
        nav.getChildren().setAll(ach);
    }


    @FXML
    private void ExitServiceFinancierModules(MouseEvent event) {
         paneFinancier.setVisible(false);
    }

    @FXML
    private void recupid(MouseEvent event) {
    }
    
}
