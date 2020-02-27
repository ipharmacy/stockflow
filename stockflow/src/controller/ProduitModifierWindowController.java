/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Produit;
import Services.ServiceCategorie;
import Services.ServiceEntrepot;
import Services.ServiceProduit;
import com.sun.javafx.scene.SceneUtils;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ProduitModifierWindowController implements Initializable {

    @FXML
    private AnchorPane nav;
    @FXML
    private Label label;
    @FXML
    private ImageView bg;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tquantite;
    @FXML
    private TextField tprix;
    private TextField tcategorie;
    @FXML
    private TextField id;
    
    @FXML
    private TextField id_util;
    @FXML
    private Button imgbtn;
    @FXML
    private Label imgUrl;
    @FXML
    private TextField imgg;
    @FXML
    private ComboBox<String> cat;
    @FXML
    private ComboBox<String> cat1;
     List<String> AP=new ArrayList();
     Services.ServiceCategorie SP = new ServiceCategorie();
     List<String> AT=new ArrayList();
     Services.ServiceEntrepot ST = new ServiceEntrepot();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Image img=new Image("uploads/home.png");
        bg.setImage(img);
         id.setVisible(false);
        
        id_util.setVisible(false);
        imgg.setVisible(false);
          try {
            AP =SP.getCategorie();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitModifierWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cat.setItems((ObservableList<String>) AP);
    
        try {
            AT=ST.getEnt();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitModifierWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
         cat1.setItems((ObservableList<String>) AT);
    }
public void Funct(Produit p)
    {
        String Quant=Integer.toString(p.getQuantite());
        String pr=Float.toString(p.getPrix());
       
         String ent=Integer.toString(p.getId_entrepot());
          String util=Integer.toString(p.getId_utilisateur());
           String id2=Integer.toString(p.getId_produit());
           
           
        tnom.setText(p.getNom());
        tquantite.setText(Quant);
        tprix.setText(pr);
       
        id.setText(id2);
      
         id_util.setText(util);
         imgg.setText(p.getImg());
       
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
         Services.ServiceProduit SP = new ServiceProduit();
          Services.ServiceCategorie SG=new ServiceCategorie();
        Services.ServiceEntrepot SE=new ServiceEntrepot();
        String nom=tnom.getText();
        String url=imgUrl.getText();
       
        int quantite= Integer.parseInt(tquantite.getText());
        float prix=Float.parseFloat(tprix.getText());
       // int categorie= Integer.parseInt(tcategorie.getText());
         int id2= Integer.parseInt(id.getText());
         
           int util= Integer.parseInt(id_util.getText());
           int categorie=SG.SearchCategorie(cat.getValue());
         //  System.out.println("cat : "+cat.getValue());
        int entrepot=SE.SearchCategorie(cat1.getValue());
       //  System.out.println("cat : "+cat1.getValue());
        Produit p1=new Produit(id2,nom,quantite,categorie,prix,url,entrepot,util);
        SP.updateProduit(p1);
       
        
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void imgGetUrl(ActionEvent event) {
    }
    
    
}
