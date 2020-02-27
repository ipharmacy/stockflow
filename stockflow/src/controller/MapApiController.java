/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 * FXML Controller class
 *
 * @author Chebbi
 */

public class MapApiController implements Initializable {

    private WebEngine webengine ;
    @FXML
    private WebView webview;
    private JSObject window ;
    @FXML 
    private Label textDeVerification ;
    String lieu  ="undefined" ; 
    String adresse="undefined" ;
    String cin;
    String facture; 
    FXMLLoader loader1 ; 
    @FXML
    private ImageView backImage; 
   // private JSObject window ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         webengine = webview.getEngine();
         window = (JSObject)webengine.executeScript("window");
         textDeVerification.setTextFill(Color.web("#0076a3"));
         
         
     
        
        
    }    
    public void loadMap(javafx.event.ActionEvent event)
    {
        final URL urlGoogleMaps = getClass().getResource("map.html");
        webengine.load(urlGoogleMaps.toExternalForm());
    }
    public void getAddresse (javafx.event.ActionEvent event)
    {
        System.out.println("get coordiantes ! ");
//        System.out.println(window.call("getCx"));
  //      System.out.println(window.call("getCy"));
    //    System.out.println(window.call("getAddress"));
        textDeVerification.setText("Lieu  : "+window.call("getCountry") + "Adresse :"+window.call("getAddress") );
        lieu=(String)window.call("getCountry");
        adresse=(String)window.call("getAddress");
        
    }
    public void confirmerAddress (javafx.event.ActionEvent event) throws IOException
    {
        if(adresse.compareTo("undefined")==0 | lieu.compareTo("undefined")==0)
        {
       //LivreurFXMLController.alert("warinig ", "svp choisir une adresse ", Alert.AlertType.WARNING);
        }
        else 
        {
        //LivreurFXMLController.alert("is this your addresse ", "lieu :"+window.call("getCountry")+"adresse :"+window.call("getAddress"), Alert.AlertType.CONFIRMATION);
      
          loader1 = new FXMLLoader(getClass().getResource("afficherLivraisonFront.fxml"));
          Parent root = (Parent)loader1.load();
         /* livraisonFXMLController l = loader1.getController();
         //l.setAdresse(adresse);
           l.setLieu(lieu);
           l.setAdresse(adresse);
           l.setCinClient(l.cin);
           l.setFacture(l.fac);*/
           Stage stage= new Stage();
           stage.setScene(new Scene(root));
           stage.show();
        }
        
        
        
    }
    
}
