/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Entrepot;
import Entity.User;
import Entity.entrepot1;
import Services.ServiceEntrepot;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
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
import Services.*;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
 
public class EntrepotalouerController implements Initializable {

    @FXML
    private ImageView dp;
    @FXML
    private AnchorPane nav;
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
    private Button LivreurBtn1;
    @FXML
    private Button LivreurBtn2;
       private TextField adresse;
    private TextField surface;
    private TextField disponibilite;
    private TextField prix;
    private TextField email;
    @FXML
    private TableView<entrepot1> tableview;
    @FXML
    private TableColumn<entrepot1,String> adresse1;
    @FXML
    private TableColumn<entrepot1,String> surface1;
    @FXML
    private TableColumn<entrepot1,String> prix1;
    @FXML
    private TableColumn<entrepot1,String> email1;
    @FXML
    private TableColumn<entrepot1,String> disponibilite1;
    @FXML
    private Button s;
    @FXML
    private AnchorPane h;
    @FXML
    private Button c;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
        
        dp.setImage(img);
      
               adresse1.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
                 email1.setCellValueFactory(new PropertyValueFactory<>("email"));
                prix1.setCellValueFactory(new PropertyValueFactory<>("prix"));
                 //surface1.setCellValueFactory(new PropertyValueFactory<>("surface"));
                  disponibilite1.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));
        try {
             // TODO
            
           tableview.setItems(getUsers());
         } catch (SQLException ex) {
             Logger.getLogger(SecondWindowController.class.getName()).log(Level.SEVERE, null, ex);
         }
                tableview.setEditable(true);

           
                adresse1.setCellFactory(TextFieldTableCell.forTableColumn());
                email1.setCellFactory(TextFieldTableCell.forTableColumn());
                 disponibilite1.setCellFactory(TextFieldTableCell.forTableColumn());
                  surface1.setCellFactory(TextFieldTableCell.forTableColumn());
             
          
           tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
     private ObservableList<entrepot1> getUsers() throws SQLException {
        TLT su=new TLT();
       return su.readAll();
        
    }
     
        @FXML
            public void changeAdresse(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        entrepot1 userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setAdresse((String) edittedCell.getNewValue());
        TLT su=new TLT();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("Updated!");
         alert.showAndWait();
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
            public void changeEmail(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        entrepot1 userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setEmail((String) edittedCell.getNewValue());
        TLT su=new TLT();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("Updated!");
         alert.showAndWait();
    }

       @FXML
            public void changeDisponibilite(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        entrepot1 userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setDisponibilite((String) edittedCell.getNewValue());
        TLT su=new TLT();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("Updated!");
         alert.showAndWait();
    }

           @FXML
    public void supprimer() throws SQLException{
        TLT su=new TLT();
        ObservableList<entrepot1> selectedRows ,allUsers;
        allUsers =tableview.getItems();
        selectedRows=tableview.getSelectionModel().getSelectedItems();
        
        for(entrepot1 u:selectedRows){
            su.delete(u.getId());
            allUsers.remove(u);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Delete");
         alert.setHeaderText(null);
         alert.setContentText("User(s) Deleted!");
         alert.showAndWait();
    }

    

    @FXML
    private void sms(ActionEvent event) {
         TLT su=new TLT();
         su.sendSms();
    }

    @FXML
    private void goLouer(ActionEvent event) {
    }

    @FXML
    private void go(ActionEvent event) throws IOException {
              AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ajoutentrepotalouer.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void goo(ActionEvent event) throws IOException {
              AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ajoutentrepotalouer.fxml"));
        nav.getChildren().setAll(ach);
    }

  
    
}
