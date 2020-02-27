/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Facture;
import Services.serviceFacture;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
public class AjoutFactureController implements Initializable {

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
    private Label lab;
    @FXML
    private Label typeLabel;
    @FXML
    private Label typeLabel1;
    @FXML
    private Label typeLabel2;
    @FXML
    private Label typeLabel3;
    @FXML
    private Label typeLabel5;
    @FXML
    private TextField desc;
    @FXML
    private TextField frais;
    @FXML
    private TextField idTr;
    @FXML
    private DatePicker dateF;
    @FXML
    private TextField type;
    @FXML
    private Button addF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
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
    private void Description(ActionEvent event) {
    }

    @FXML
    private void Frais(ActionEvent event) {
    }

    @FXML
    private void idTransaction(ActionEvent event) {
    }

    @FXML
    private void dateFacture(ActionEvent event) {
    }

    @FXML
    private void Type(ActionEvent event) {
    }

    @FXML
    private void AddFacture(ActionEvent event) throws SQLException, IOException {
         serviceFacture sf=new serviceFacture();
        java.util.Date date1=new java.util.Date();
        LocalDate myDate =dateF.getValue();
        java.sql.Date sqlDate = java.sql.Date.valueOf( myDate );
        Facture f =new Facture(desc.getText(),Float.parseFloat(frais.getText()),Integer.parseInt(idTr.getText()),sqlDate,type.getText());
        sf.addFacture(f);
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/serviceFinancierFactures.fxml"));
        nav.getChildren().setAll(ach);
    }
    
}
