/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Client;
import Services.servicesClient;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ServiceFinancierClientsWindowController implements Initializable {

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
    private TableView<Client> dataCLients;
    private final ObservableList<Client> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Client,Integer> IdCLIENT;
    @FXML
    private TableColumn<Client,String> columnName;
    @FXML
    private TableColumn<Client,String> columnEmail;
    @FXML
    private TableColumn<Client,Integer> columnTelephone;
    @FXML
    private TableColumn<?, ?> action;

    @FXML
    private TextField searchTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Image img=new Image("uploads/home.png");
        dp.setImage(img);
        //CLIENTS
        IdCLIENT.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        action.setCellValueFactory(new PropertyValueFactory<>("ch_box"));

 
        try {
            dataCLients.setItems(getClients());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFinancierClientsWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        dataCLients.setEditable(true);
//        IdCLIENT.setCellFactory(TextFieldTableCell.forTableColumn());
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        dataCLients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    

    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) throws IOException {
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ProduitWindow.fxml"));
        nav.getChildren().setAll(ach);
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
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void Ajout(ActionEvent event) throws IOException {
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/AjoutClient.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
           servicesClient su = new servicesClient();
        ObservableList<Client> selectedRows, allUsers;
        allUsers = dataCLients.getItems();
        selectedRows = dataCLients.getSelectionModel().getSelectedItems();

        for (Client c : selectedRows) {
            su.deleteClient(c.getIdClient());
            data.remove(c);
            afficherClients();   
    }
    }
    
    public void afficherClients()
    {
            IdCLIENT.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("tel"));

        try {
            dataCLients.setItems(getClients());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFinancierClientsWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void TrierLivreur(ActionEvent event) {
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
    private void serviceFinancierModules(MouseEvent event) {
                   paneFinancier.setVisible(true);

    }
// @FXML
//    private void changeNameClient(CellEditEvent edittedCell) throws SQLException {
//        Client clientSelected = dataCLients.getSelectionModel().getSelectedItem();
//        clientSelected.setNomClient(edittedCell.getNewValue().toString());
//        servicesClient su = new servicesClient();
//        su.updateClient(clientSelected, clientSelected.getIdClient());
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Update");
//        alert.setHeaderText(null);
//        alert.setContentText("User Updated!");
//        alert.showAndWait();
//        
//    }
// @FXML
//    private void changeEmailClient(CellEditEvent edittedCell) throws SQLException {
//        Client clientSelected = dataCLients.getSelectionModel().getSelectedItem();
//        clientSelected.setEmail(edittedCell.getNewValue().toString());
//        servicesClient su = new servicesClient();
//        su.updateClient(clientSelected, clientSelected.getIdClient());
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Update");
//        alert.setHeaderText(null);
//        alert.setContentText("User Updated!");
//        alert.showAndWait();
//    }

    
       private ObservableList<Client> getClients() throws SQLException {
        servicesClient su = new servicesClient();
        return su.readAll();

    }
       


    @FXML
    private void rechercherClientF(KeyEvent event) throws SQLException {
         servicesClient es = new servicesClient();
        ObservableList<Client> arrayList =es.rechercherClientParFiltre(searchTextField.getText());
        ObservableList obs = FXCollections.observableArrayList(arrayList);
        dataCLients.setItems(obs);
        IdCLIENT.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        if (searchTextField.getText().equals(""))
        {
            afficherClients();
        }
    }

    @FXML
    private void changeClientName(CellEditEvent edittedCell) throws SQLException {
          Client clientSelected = dataCLients.getSelectionModel().getSelectedItem();
       clientSelected.setNomClient(edittedCell.getNewValue().toString());
       servicesClient su = new servicesClient();
       su.updateClient(clientSelected, clientSelected.getIdClient());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Update");
        alert.setHeaderText(null);
       alert.setContentText("User Updated!");
       alert.showAndWait();
    }

    @FXML
    private void changeEmailClient(CellEditEvent edittedCell) throws SQLException {
        Client clientSelected = dataCLients.getSelectionModel().getSelectedItem();
        clientSelected.setEmail(edittedCell.getNewValue().toString());
        servicesClient su = new servicesClient();
        su.updateClient(clientSelected, clientSelected.getIdClient());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update");
        alert.setHeaderText(null);
        alert.setContentText("User Updated!");
        alert.showAndWait();
        
    }

    @FXML
    private void changePhone(CellEditEvent edittedCell) {
        
    }

    @FXML
    private void mailaf(ActionEvent event) throws IOException {
              Parent register= FXMLLoader.load(getClass().getResource("/gui/ekhdem.fxml"));
        Scene registerScene = new Scene(register);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("StockFlow");
        window.setScene(registerScene);
        window.show();
        
    }



  


}
