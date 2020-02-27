/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Transaction;
import Services.serviceTransaction;
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
public class AjoutTransactionController implements Initializable {

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
    private Label amountLabel;
    @FXML
    private Label paiementLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Button addTr;
    @FXML
    private DatePicker datetransaction;
    @FXML
    private TextField typetransaction;
    @FXML
    private TextField amounttransaction;
    @FXML
    private TextField paymentmethod;
    @FXML
    private TextField idclienttransaction;

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
    private void addTransaction(ActionEvent event) throws SQLException, IOException {
    Services.serviceTransaction st=new serviceTransaction();
    LocalDate myDate =datetransaction.getValue();
    java.sql.Date sqlDate = java.sql.Date.valueOf( myDate );
    Transaction tr=new Transaction(typetransaction.getText(),Float.parseFloat(amounttransaction.getText()),paymentmethod.getText(),Integer.parseInt(idclienttransaction.getText()),sqlDate);
    st.addTransaction(tr);  
       AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/serviceFinancierTransactions.fxml"));
        nav.getChildren().setAll(ach);
    }
    
}
