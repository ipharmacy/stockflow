/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Api.TrayIconDemo;
import Entity.Entrepot;
import Services.ControlleSaisie;
import Services.ServiceEntrepot;
import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AjoutEntrepotWindowController implements Initializable {

    @FXML
    private AnchorPane nav;
    @FXML
    private ImageView dp;
    @FXML
    private Button Produitbtn;
    @FXML
    private Button ServiceBtn;
    @FXML
    private Button CommandeBtn;
    @FXML
    private Button LivraisonBtn;
    @FXML
    private Button LivreurBtn;
    @FXML
    private Button modifier;
    @FXML
    private ImageView ModifierBtn;
    @FXML
    private TextField tfrecherchelivreur;
    @FXML
    private Button ajouter;
    @FXML
    private ImageView addBtn;
    @FXML
    private Button supprimer;
    @FXML
    private ImageView SupprimerBtn;
    @FXML
    private Button boutontrierlivreur;
    @FXML
    private Button ac;
    @FXML
    private TextField longitude;
    @FXML
    private TextField adresse;
    @FXML
    private TextField nom;
    @FXML
    private Label lab;
    @FXML
    private TextField largitude;
    @FXML
    private TextField etat;
    @FXML
    private Button LivreurBtn1;

    /**
     * Initializes the controller class.
     */
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
        ControlleSaisie.estVide(longitude, longitude.getText());
                ControlleSaisie.estVide(largitude, largitude.getText());
                        ControlleSaisie.estVide(adresse, adresse.getText());
                                ControlleSaisie.estVide(etat, etat.getText());



        
    }    

    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) {
    }

    @FXML
    private void GoServiceFinancierPage(ActionEvent event) {
    }

    @FXML
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
    private void goCommandePage(ActionEvent event) {
    }

    @FXML
    private void goLivraisonPage(ActionEvent event) {
    }

    @FXML
    private void goLivreurPage(ActionEvent event) {
    }

    @FXML
    private void ModifierLivreur(ActionEvent event) {
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void Ajout(ActionEvent event) {
    }

    @FXML
    private void SupprimerLivreur(ActionEvent event) {
    }

    @FXML
    private void TrierLivreur(ActionEvent event) {
    }


    @FXML
    private void ajout(ActionEvent event) throws SQLException, AWTException {
     ServiceEntrepot s = new ServiceEntrepot();
        Entrepot e=new Entrepot();
      
    
        e.setId(0);
        e.setNom(nom.getText());
        e.setLargitude(Integer.valueOf(longitude.getText()));
        e.setLongitude(Integer.valueOf(longitude.getText()));
        e.setAdresse(adresse.getText());
      
        e.setEtat(Integer.valueOf(etat.getText()));
    
       // TrayIconDemo.main(null);
          //  e.setEtat(Integer.valueOf(Integer.valueOf(0)));
          
      

         s.ajouter(e);
        
    }

    @FXML
    private void goentrepot() throws IOException
    {
     AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/Entrepotalouer.fxml"));
        nav.getChildren().setAll(ach);
    }

}
