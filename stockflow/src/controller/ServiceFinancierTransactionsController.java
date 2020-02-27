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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
public class ServiceFinancierTransactionsController implements Initializable {

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
    private AnchorPane paneFinancier;
    @FXML
    private Button Clientsbtn;
    @FXML
    private Button Transactionsbtn;
    @FXML
    private Button Facturesbtn;
    @FXML
    private TableView<Transaction> dataTransaction;
    private final ObservableList<Transaction> datatransaction = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Transaction,Integer> ID_TRANS;
    @FXML
    private TableColumn<Transaction,String> TYPE_TRANSACTION;
    @FXML
    private TableColumn<Transaction,Float> MONTANT_TRANSACTION;
    @FXML
    private TableColumn<Transaction,String> PAIEMENT_TRANSACTION;
    @FXML
    private TableColumn<Transaction,Integer> ID_CLIENT;
    @FXML
    private TableColumn<Transaction,Date> DATE_TRANSACTION;
    @FXML
    private TextField transactionSearchtxt;
    @FXML
    private Button bilan;
    @FXML
    private ImageView bilanImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
         paneFinancier.setVisible(false);
                 //TRANSACTIONS
        ID_TRANS.setCellValueFactory(new PropertyValueFactory<>("idTransaction"));
        TYPE_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("type"));
        MONTANT_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("montant"));
        PAIEMENT_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("paiement"));
        ID_CLIENT.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        DATE_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("date"));
      
        try {
            dataTransaction.setItems(getTransaction());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFinancierTransactionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        dataTransaction.setEditable(true);
        TYPE_TRANSACTION.setCellFactory(TextFieldTableCell.forTableColumn());
        PAIEMENT_TRANSACTION.setCellFactory(TextFieldTableCell.forTableColumn());

    }    

    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) {
    }

    @FXML
    private void GoServiceFinancierPage(ActionEvent event) throws IOException {
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ProduitWindow.fxml"));
        nav.getChildren().setAll(ach);
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
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void Ajout(ActionEvent event) throws IOException {   
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/AjoutTransaction.fxml"));
        nav.getChildren().setAll(ach);   
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
               serviceTransaction su = new serviceTransaction();
        ObservableList<Transaction> selectedRows, allUsers;
        allUsers = dataTransaction.getItems();
        selectedRows = dataTransaction.getSelectionModel().getSelectedItems();
        for (Transaction c : selectedRows) {
            su.deleteTransaction(c.getIdTransaction());
            datatransaction.remove(c);
            afficherTransactions();
        }
        
    }
    
     public void afficherTransactions() {
        ID_TRANS.setCellValueFactory(new PropertyValueFactory<>("idTransaction"));
        TYPE_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("type"));
        MONTANT_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("montant"));
        PAIEMENT_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("paiement"));
        ID_CLIENT.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        DATE_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("date"));
        try {
            dataTransaction.setItems(getTransaction());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFinancierTransactionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void TrierLivreur(ActionEvent event) {
    }

    @FXML
    private void serviceFinancierModules(MouseEvent event) {
                     paneFinancier.setVisible(true);

    }

    @FXML
    private void GestClients(ActionEvent event) throws IOException {
            AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/serviceFinancierClientsWindow.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void GestTransactions(ActionEvent event) throws IOException {
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/serviceFinancierTransactions.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void GestFactures(ActionEvent event) throws IOException {
           AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/serviceFinancierFactures.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void ExitServiceFinancierModules(MouseEvent event) {
             paneFinancier.setVisible(false);

    }

    @FXML
    private void changeTypeTransaction(CellEditEvent edittedCell) throws SQLException {
        Transaction transactionelected = dataTransaction.getSelectionModel().getSelectedItem();
        transactionelected.setType(edittedCell.getNewValue().toString());
        serviceTransaction su = new serviceTransaction();
        su.updateTransaction(transactionelected, transactionelected.getIdTransaction());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update");
        alert.setHeaderText(null);
        alert.setContentText("User Updated!");
        alert.showAndWait();
    }

    @FXML
    private void changePaiement(CellEditEvent edittedCell) throws SQLException {
         Transaction transactionelected = dataTransaction.getSelectionModel().getSelectedItem();
        transactionelected.setType(edittedCell.getNewValue().toString());
        serviceTransaction su = new serviceTransaction();
        su.updateTransaction(transactionelected, transactionelected.getIdTransaction());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update");
        alert.setHeaderText(null);
        alert.setContentText("User Updated!");
        alert.showAndWait();
        
    }
    
    
    private ObservableList<Transaction> getTransaction() throws SQLException {
        serviceTransaction su = new serviceTransaction();
        return su.readAll();
    }

    @FXML
    private void rechercherTransactionT(KeyEvent event) throws SQLException {
        serviceTransaction es = new serviceTransaction();
        ObservableList<Transaction> arrayList =es.rechercherTransactionParFiltre(transactionSearchtxt.getText());
        ObservableList obs = FXCollections.observableArrayList(arrayList);
        dataTransaction.setItems(obs);  
        ID_TRANS.setCellValueFactory(new PropertyValueFactory<>("idTransaction"));
        TYPE_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("type"));
        MONTANT_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("montant"));
        PAIEMENT_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("paiement"));
        ID_CLIENT.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        DATE_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("date"));
        if(transactionSearchtxt.getText().equals(""))
        {
            afficherTransactions();
        }
    }

    @FXML
    private void afficherBilan(ActionEvent event) throws IOException {
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/bilan.fxml"));
        nav.getChildren().setAll(ach); 
        
    }
    
}
