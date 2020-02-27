/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Api.pdf;
import Entity.Livraison;
import Entity.Produit;
import Entity.User;
import Services.ServiceCategorie;
import Services.ServiceProduit;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ProduitWindowController implements Initializable {

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
    private TextField tfrecherche;
    @FXML
    private Button ajouter;
    @FXML
    private ImageView addBtn;
    @FXML
    private Button supprimer;
    @FXML
    private Button boutontrierlivreur;
    @FXML
    private AnchorPane travailleIci;
    @FXML
    private AnchorPane nav;
    @FXML
    private ImageView ModifierBtn;
    @FXML
    private ImageView SupprimerBtn;
   @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit,String> nom;
    @FXML
    private TableColumn<Produit,String> quantite;
    @FXML
    private TableColumn<Produit,Float> prix;
    @FXML
    private TableColumn<Produit,Integer> categorie;
    @FXML
    private TableColumn<Produit, String> img;     
    
    public ObservableList<Produit> data=FXCollections.observableArrayList() ;
   
 private Connection con;
    @FXML
    private AnchorPane ik;
    User x;
    @FXML
    private ImageView photoproduit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
        Services.ServiceProduit SP = new ServiceProduit();
        Services.ServiceCategorie SG = new ServiceCategorie();
        List<Produit> AP=new ArrayList();
        Produit p=new Produit();
        
      /* 
        try {
            AP=SP.getProduct();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           */
      
              nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
              quantite.setCellValueFactory(new PropertyValueFactory<Produit,String>("quantite"));
              prix.setCellValueFactory(new PropertyValueFactory<Produit,Float>("prix"));
              categorie.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id_categorie"));
              this.img.setCellValueFactory(new PropertyValueFactory<Produit,String>("img"));
              try {
                  data.clear();
            afficherProduits(ServiceUser.loggedUser.getId());
        } catch (SQLException ex) {
//            Logger.getLogger(LivraisonsController.class.getName()).log(Level.SEVERE, null, ex);
        }
              data.clear();
        try {      
            afficherProduits(ServiceUser.loggedUser.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ProduitWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
     private void afficherProduits (int idd) throws SQLException
    {
         try {
            con = MaConnection.getInstance().getConnection();
            
            ResultSet rs=con.createStatement().executeQuery("select * from produit where id_utilisateur='"+idd+"'");
            while (rs.next()) {
                int id_produit=rs.getInt(1);
                
                
                String nom=rs.getString(2) ;
                int quantite=rs.getInt(3) ;
                float prix=rs.getFloat(4) ;
                int cat = 0;
                String url = rs.getString("img");
                int ent = 0;
                int util = 0;
              // ImageView emp=new ImageView(new Image(this.getClass().getResourceAsStream(url)));
               Produit P=new Produit(id_produit, nom, quantite, cat, prix, url, ent, util);
                data.add(P);


            }
            
         table.setItems(data);  

                table.setOnMouseClicked((MouseEvent e)->{
                   int selectedIndex = table.getSelectionModel().getSelectedIndex();
                         if (selectedIndex!=-1) {
                             System.out.println("chak");
                    Produit pi = (Produit) table.getSelectionModel().getSelectedItem();
                             System.out.println("path :"+pi.getImg());
                    photoproduit.setImage(new Image("file:/"+pi.getImg()));                 
                         }                
                });

                    rs.close();

    }catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        
        FilteredList<Produit>f =new  FilteredList<>(data,e->true) ;
        tfrecherche.setOnKeyReleased(e->
                {
        tfrecherche.textProperty().addListener((observableValue,oldValue,newValue)-> 
        {
            f.setPredicate((Predicate<? super Produit>) Produit->{
                if (newValue==null || newValue.isEmpty())
                {
                    return true ;
                }
                String lowerCaseFilter=newValue.toLowerCase() ;
                if (Produit.getNom().contains(newValue)){
                    return true ;
                }
               
                return false ;
            });
        });
                });
     SortedList<Produit>sorteddata =new SortedList<>(f) ;
                sorteddata.comparatorProperty().bind(table.comparatorProperty()) ;
                
                table.setItems(sorteddata);
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
    private void rechercher(KeyEvent event) {
    }



    @FXML
    private void Ajout(ActionEvent event) throws IOException {
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ProduitAjoutWindow.fxml"));
        nav.getChildren().setAll(ach);
        
    }

    @FXML
    private void actualiser(ActionEvent event) throws IOException {
          AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ProduitWindow.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        try{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/gui/ProduitModifierWindow.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
         //String nom2=nom.getText()+".png";
              // ftpclienttest.importFile(nom2);
        Produit p = (Produit) table.getSelectionModel().getSelectedItem(); 
        ProduitModifierWindowController secController=fxmlLoader.getController();
         secController.Funct(p);
        Stage stage=new Stage();
        stage.setTitle("modifier");
        stage.setScene(new Scene(root1));
        stage.show();
      }catch(Exception e){
          System.out.println("cannot load");
      }
         data.clear();
        afficherProduits(ServiceUser.loggedUser.getId());
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
         int selectedIndex = table.getSelectionModel().getSelectedIndex();
        Produit p = (Produit) table.getSelectionModel().getSelectedItem();
        Services.ServiceProduit SP = new ServiceProduit();
        SP.deleteProduit(p);
         data.clear();
        afficherProduits(ServiceUser.loggedUser.getId());
    }

   
    @FXML
    private void ExportPage1(ActionEvent event) throws Exception {
         pdf.main(null);
    }

  
    
}
