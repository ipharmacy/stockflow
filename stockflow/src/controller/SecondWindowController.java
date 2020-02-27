/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Entrepot;
import Entity.User;
import Services.ServiceEntrepot;
import Services.ServiceUser;
import api.Mapa;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class SecondWindowController implements Initializable {
    
    @FXML
    private ImageView dp;
    @FXML
    private Button modifier;
    @FXML
    private TextField tfrecherchelivreur;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button boutontrierlivreur;
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
    private AnchorPane travailleIci;
    @FXML
    private ImageView addBtn;
    @FXML
    private AnchorPane nav;
    @FXML
    private AnchorPane paneFinancier;
    @FXML
    private Button Clientsbtn;
    @FXML
    private Button Transactionsbtn;
    @FXML
    private Button Facturesbtn;
    @FXML
    private TableColumn<Entrepot,String> adresse;
    @FXML
    private TableColumn<Entrepot,Integer> longitude;
    @FXML
    private TableColumn<Entrepot,Integer> largitude;
    @FXML
    private TableColumn<Entrepot,Integer> etat;
    @FXML
    private TableView<Entrepot> tableview;
     Connection cnx = (Connection) MaConnection.getInstance().getConnection();
     private static int idUnique;
     User x;
    @FXML
    private Button LivreurBtn1;

    
//    public void initdata(User s){
//        System.out.println(s.getId());
//        this.x=s;
//         
//    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(ServiceUser.loggedUser.getId());
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
//        user_nom.setVisible(true);
  //      user_nom.setText("dddd");
        
        paneFinancier.setVisible(false);
                 adresse.setCellValueFactory(new PropertyValueFactory<Entrepot,String>("adresse"));
                longitude.setCellValueFactory(new PropertyValueFactory<Entrepot,Integer>("longitude"));
                 largitude.setCellValueFactory(new PropertyValueFactory<Entrepot,Integer>("largitude"));
                etat.setCellValueFactory(new PropertyValueFactory<Entrepot,Integer>("etat"));
        try {
             // TODO
            
           tableview.setItems(getUsers());
         } catch (SQLException ex) {
             Logger.getLogger(SecondWindowController.class.getName()).log(Level.SEVERE, null, ex);
         }
                tableview.setEditable(true);

           
                adresse.setCellFactory(TextFieldTableCell.forTableColumn());
             
          
           tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
     
    }    
    
    
  /*  @FXML
     public void changeEtat(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        Entrepot userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setEtat(Integer.valueOf(edittedCell.getNewValue().toString()));
        ServiceEntrepot su=new ServiceEntrepot();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("Updated!");
         alert.showAndWait();
    }*/
     
         
   /* @FXML
     public void changeLongitude(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        Entrepot userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setLongitude(Integer.valueOf(edittedCell.getNewValue().toString()));
        ServiceEntrepot su=new ServiceEntrepot();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("Updated!");
         alert.showAndWait();
    }*/
    
  /*  @FXML
       public void changeLargitude(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        Entrepot userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setLargitude(Integer.valueOf(edittedCell.getNewValue().toString()));
        ServiceEntrepot su=new ServiceEntrepot();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("Updated!");
         alert.showAndWait();
    }*/
    
    @FXML
            public void changeAdresse(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        Entrepot userSelected = tableview.getSelectionModel().getSelectedItem();
        userSelected.setAdresse((String) edittedCell.getNewValue());
        ServiceEntrepot su=new ServiceEntrepot();
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
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
    private void ModifierLivreur(ActionEvent event) {
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void SupprimerLivreur(ActionEvent event) {
    }

    @FXML
    private void TrierLivreur(ActionEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) throws IOException {
      /*  FXMLLoader loader2=new FXMLLoader();
         loader2.setLocation(getClass().getResource("/gui/ProduitWindow.fxml"));
          ProduitWindowController controlle=loader2.getController();
         controlle.initdata(x);
        */
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ProduitWindow.fxml"));
        nav.getChildren().setAll(ach);
    }

    private void GoServiceFinancierPage(ActionEvent event) throws IOException {
 
        
    }

    @FXML
    private void goCommandePage(ActionEvent event) throws IOException {
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/afficher_commande.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void goLivraisonPage(ActionEvent event) throws IOException {
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/LivraionWindow.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void goLivreurPage(ActionEvent event) throws IOException {
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/livreurWindow.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void ServiceFinancierModules(MouseEvent event) {
           paneFinancier.setVisible(true);
        
        
    }
      
     private ObservableList<Entrepot> getUsers() throws SQLException {
        ServiceEntrepot su=new ServiceEntrepot();
        return su.readAll();
        
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

    void setIdUnique(int recupid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    public void supprimer() throws SQLException
    {
    ServiceEntrepot s=new ServiceEntrepot();
    s.delete(0);
    
    }

    @FXML
    private void GoAjouter(ActionEvent event) throws IOException {
           AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/AjoutEntrepotWindow.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void mapi(ActionEvent event) throws IOException {
     //
    AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/mapApi.fxml"));
        nav.getChildren().setAll(ach);  
    }

    @FXML
    private void go(ActionEvent event) throws IOException {
              AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/Entrepotalouer.fxml"));
        nav.getChildren().setAll(ach);
    }
    
    

    
}
