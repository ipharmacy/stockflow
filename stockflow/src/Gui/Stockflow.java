/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entity.Livraison;
import Entity.Livreur;
import Service.ServiceLivraison;
import Service.ServiceLivreur;
import Service.ServiceRating;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public class Stockflow extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
         ServiceLivreur ser = new ServiceLivreur();
        ServiceRating ratings = new ServiceRating();
        //Livreur p1 = new Livreur( "Belhsan", "bouseetta", 23, 45796322, "llrr@gmail.com");
        
 //ser.ajouter(p1) ;
     Date datee,date2,daterecherche;
        datee = new Date (120,9,2,5,40);
  //  Livraison l =new Livraison(22, "Hatem","Ach", datee,19,"oui") ; 
       
       ServiceLivraison livraisons =new ServiceLivraison() ;
       //livraisons.ajouter(l);    
        System.out.println(ser.readAll());
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
