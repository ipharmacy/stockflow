/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Livreur;
import Service.ServiceLivreur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author YOUSSEF BEN FARHAT
 */
public class ModifierLivreurController implements Initializable {

    @FXML
    private TextField tf_age_livreur;
    @FXML
    private TextField tf_numero_livreur;
    @FXML
    private TextField tf_mail_livreur;
    @FXML
    private TextField tf_note_livreur;
    @FXML
    private TextField tf_nom_livreur;
    @FXML
    private TextField tf_prenom_livreur;

    ServiceLivreur sp = new ServiceLivreur();
    
    int idlivreur ; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
     public void getModifierLivreur(Livreur l) {
        tf_nom_livreur.setText(l.getNom());
        tf_prenom_livreur.setText(l.getPrenom());
        tf_age_livreur.setText(Integer.toString(l.getAge()));
        tf_mail_livreur.setText(l.getMail());
        tf_note_livreur.setText(Float.toString(l.getNotetotal()));
        tf_numero_livreur.setText(Integer.toString(l.getNum()));
                
        idlivreur=l.getId();
         
       
    }    

    @FXML
    private void ModifierLivreur(ActionEvent event) throws SQLException {
       String nom=tf_nom_livreur.getText() ; 
       String prenom=tf_prenom_livreur.getText(); 
       int num=Integer.parseInt(tf_numero_livreur.getText()) ;
        int age=Integer.parseInt(tf_age_livreur.getText()) ;
        Float note=Float.parseFloat(tf_age_livreur.getText()) ;
      String mail=tf_mail_livreur.getText(); 
       FXMLLoader loader =new FXMLLoader() ;
       Livreur l =new Livreur(idlivreur,note,nom,prenom,age, num, mail) ;
        //System.out.println(l);
       sp.update(l);
      
       LivraisonController  livraisonController =(LivraisonController)loader.getController();
            livraisonController.getLivreur();
             System.out.println("youuuuuuuuu");
        
    }
    
}
