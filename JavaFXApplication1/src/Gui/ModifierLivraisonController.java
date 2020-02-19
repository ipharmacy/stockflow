/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Entite.Livraison ;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import IService.IServiceLivraison ; 
import Service.ServiceLivraison ; 
import java.sql.SQLException;
import java.util.Date;
import javafx.fxml.FXMLLoader;
/**
 * FXML Controller class
 *
 * @author YOUSSEF BEN FARHAT
 */
public class ModifierLivraisonController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private Button bouttonmodifier;

    ServiceLivraison sp = new ServiceLivraison();
    
    int idlivraison ; 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    public void getModifierLivraison(Livraison l) {
        tfnom.setText(l.getNomlivreur());
        tfprenom.setText(l.getPrenomlivreur());
        idlivraison=l.getIdlivraison() ;
         System.out.println("idlivraison :"+idlivraison);
       
    }    

    @FXML
    private void ModifierLivraison(ActionEvent event) throws SQLException {
       String nom=tfnom.getText() ; 
       String prenom=tfprenom.getText(); 
       Date datee;
        datee = new Date (120,10,1,1,6);
         System.out.println("idlivraison :"+idlivraison);
       //Livraison l =new Livraison(idlivraison,1,nom,prenom,datee,12,"non") ;
        //System.out.println(l);
       //sp.updateLivraison(l);
      
       FXMLLoader loader =new FXMLLoader() ;
       LivraisonController  livraisonController =(LivraisonController)loader.getController();
            livraisonController.getLivraisonController();
             System.out.println("youuuuuuuuu");
        
    }
    
}
