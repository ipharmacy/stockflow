/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Livraison;
import Services.ServiceHistoriqueLivraison;
import Services.ServiceLivraison;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AjouterLivraisonController implements Initializable {

     ServiceLivraison sp =new ServiceLivraison() ;
    ServiceHistoriqueLivraison h=new ServiceHistoriqueLivraison( );
    

    public ObservableList<String> heu=FXCollections.observableArrayList("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","00") ; ;
    
    public ObservableList<String> min=FXCollections.observableArrayList("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59") ;
    
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private JFXComboBox<String> minute;
    @FXML
    private JFXComboBox<String> heure;
    @FXML
    private DatePicker date2;
    @FXML
    private Button buttonajouterlivraison;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        heure.setItems(heu);
        minute.setItems(min);
        // TODO
    }    


    @FXML
    private void AjouterLivraison(ActionEvent event) throws ParseException {
        String etat="non";
           
            //Scene scene = new Scene(root);
            String nom=tfnom.getText();
            String prenom=tfprenom.getText();
            String datestring=date2.getEditor().getText() ;
            //String timeee=time.getEditor().getText() ;
           // String timee  = String.valueOf(timeee.toCharArray(), 0, 4);
           
           
           
           
           
           
           
           Date time = new Date (120, 03 , 25, Integer.valueOf((String) heure.getSelectionModel().getSelectedItem()), Integer.valueOf(minute.getSelectionModel().getSelectedItem()), 00);
       
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Date newdate= formatter.parse(datestring) ;
        
      
        
        
           
            System.out.println("nom:"+tfnom.getText());
            System.out.println("prenom:"+tfprenom.getText());
        
         
            //Time timeutil = java.util.Date(ttime.getTime());
            Livraison l =new Livraison(22,2, nom,prenom, newdate,time,19,"non livré");
    
           sp.ajouter(l);
           h.ajouter(l);
    }

    
}
