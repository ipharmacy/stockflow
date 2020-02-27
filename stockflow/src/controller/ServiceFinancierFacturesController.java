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
public class ServiceFinancierFacturesController implements Initializable {

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
    private TableView<Facture> dataFactures;
    private final ObservableList<Facture> datafacture = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Facture,Integer> ID_FACTURE;
    @FXML
    private TableColumn<Facture,String> DESCRIPTION;
    @FXML
    private TableColumn<Facture,Float> FRAIS_SERVICES;
    @FXML
    private TableColumn<Facture,Integer> ID_TRANSACTION;
    @FXML
    private TableColumn<Facture,?> DATE_FACTURE;
    @FXML
    private TableColumn<Facture, ?> DATE_LIVRAISON;
    @FXML
    private TableColumn<Facture,String> TYPE;
    @FXML
    private TextField BillSearchtxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
             paneFinancier.setVisible(false);
              //FACTURES 
        ID_FACTURE.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("description"));
        FRAIS_SERVICES.setCellValueFactory(new PropertyValueFactory<>("fraisServices"));
        ID_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("idTransaction"));
        DATE_FACTURE.setCellValueFactory(new PropertyValueFactory<>("dateFacture"));
        DATE_LIVRAISON.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
       
        try {
            dataFactures.setItems(getFactures());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFinancierFacturesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dataFactures.setEditable(true);

        DESCRIPTION.setCellFactory(TextFieldTableCell.forTableColumn());
        TYPE.setCellFactory(TextFieldTableCell.forTableColumn());
             
             

    }    

    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) {
        
    }

    @FXML
    private void GoServiceFinancierPage(ActionEvent event) throws IOException {
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
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/AjoutFacture.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
             serviceFacture su = new serviceFacture();
        ObservableList<Facture> selectedRows, allUsers;
        allUsers = dataFactures.getItems();
        selectedRows = dataFactures.getSelectionModel().getSelectedItems();
        for (Facture c : selectedRows) {
            su.deleteFacture(c.getIdFacture());
            datafacture.remove(c);
            afficherFactures();
        }  
    }
    
    public void afficherFactures() {
         ID_FACTURE.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("description"));
        FRAIS_SERVICES.setCellValueFactory(new PropertyValueFactory<>("fraisServices"));
        ID_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("idTransaction"));
        DATE_FACTURE.setCellValueFactory(new PropertyValueFactory<>("dateFacture"));
        DATE_LIVRAISON.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("type")); 
        try {
            dataFactures.setItems(getFactures());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFinancierFacturesController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void changeDescription(CellEditEvent edittedCell) throws SQLException {
          Facture factutrselected = dataFactures.getSelectionModel().getSelectedItem();
        factutrselected.setDescription(edittedCell.getNewValue().toString());
        serviceFacture su = new serviceFacture();
        su.updateFacture(factutrselected, factutrselected.getIdFacture());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update");
        alert.setHeaderText(null);
        alert.setContentText("User Updated!");
        alert.showAndWait();
    }

    @FXML
    private void changeType(CellEditEvent edittedCell) throws SQLException {
                Facture factutrselected = dataFactures.getSelectionModel().getSelectedItem();
        factutrselected.setDescription(edittedCell.getNewValue().toString());
        serviceFacture su = new serviceFacture();
        su.updateFacture(factutrselected, factutrselected.getIdFacture());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update");
        alert.setHeaderText(null);
        alert.setContentText("User Updated!");
        alert.showAndWait();
    }
    
    private ObservableList<Facture> getFactures() throws SQLException {
        serviceFacture su = new serviceFacture();
        return su.readAll();

    }

    @FXML
    private void rechercherFactureF(KeyEvent event) throws SQLException {
           serviceFacture es = new serviceFacture();
        ObservableList<Facture> arrayList =es.rechercherFactureParFiltre(BillSearchtxt.getText());
        ObservableList obs = FXCollections.observableArrayList(arrayList);
        dataFactures.setItems(obs); 
        ID_FACTURE.setCellValueFactory(new PropertyValueFactory<>("idFacture"));
        DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("description"));
        FRAIS_SERVICES.setCellValueFactory(new PropertyValueFactory<>("fraisServices"));
        ID_TRANSACTION.setCellValueFactory(new PropertyValueFactory<>("idTransaction"));
        DATE_FACTURE.setCellValueFactory(new PropertyValueFactory<>("dateFacture"));
        DATE_LIVRAISON.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
        if(BillSearchtxt.getText().equals(""))
        {
            afficherFactures();
        }

    }
    
}
