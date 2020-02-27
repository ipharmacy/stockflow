/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import Api.TrayIconDemo;
import Entity.Produit;
import Entity.User;
import Services.ServiceCategorie;
import Services.ServiceEntrepot;
import Services.ServiceProduit;
import Services.ServiceUser;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.ProtocolException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import rest.file.uploader.tn.FileUploader;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ProduitAjoutWindowController implements Initializable {

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
    private Label imgUrl;
    @FXML
    private Button imgbtn;
    @FXML
    private ComboBox<String> cat;
     List<String> AP=new ArrayList();
     Services.ServiceCategorie SP = new ServiceCategorie();
     List<String> AT=new ArrayList();
     Services.ServiceEntrepot ST = new ServiceEntrepot();
    
    
    ObservableList<String> list;
    @FXML
    private Button ac;
    @FXML
    private TextField tprix;
    @FXML
    private TextField tquantite;
    @FXML
    private TextField tnom;
    @FXML
    private Label lab;
    @FXML
    private Button ac1;
    @FXML
    private TextField id_user;
    @FXML
    private ComboBox<String> cat1;
     String urlfinal;
     String imag;
    @FXML
    private Label labelerreur;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(ServiceUser.loggedUser.getId());
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
        id_user.setVisible(false);
        labelerreur.setVisible(false);
        
            try {
            AP =SP.getCategorie();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitAjoutWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cat.setItems((ObservableList<String>) AP);
    
        try {
            AT=ST.getEnt();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitAjoutWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
         cat1.setItems((ObservableList<String>) AT);
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
public boolean veriftextfiel (TextField t)
{
    if (t.getText().isEmpty() )
    return true ;
           return false; 
}
    @FXML
    private void RecupererUrl(ActionEvent event) throws IOException {
       //  FileChooser fc=new FileChooser();
       // fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files",".png"));
        //File f=fc.showOpenDialog(null);
        //if (f!=null)
        //{
          //  String t=f.getAbsolutePath();
           // t.replaceAll("\\", "/");
           
            
            //imgUrl.setText(t);
            //System.out.println("L url est"+imgUrl.getText());
       // }
       
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            tfrecherchelivreur.setText(file.getPath());
            System.out.println(file.toPath().toUri().toString());
            urlfinal=file.toPath().toUri().toString();
            imag=urlfinal.substring(8);
            System.out.println("urlFINAL "+urlfinal.substring(8));

        }
       
    }
public void  creeralert (String titre ,String text )
{
    Alert alert =new Alert (Alert.AlertType.ERROR) ;
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.show();
}

    @FXML
    private void ajoutcatg(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/gui/ProduitAjoutCategorieWindow.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
         Stage stage=new Stage();
        stage.setTitle("modifier");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void ajout(ActionEvent event) throws ProtocolException, SQLException, IOException, AWTException {
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/ProduitWindow.fxml"));
        Services.ServiceProduit ST = new ServiceProduit();
        Services.ServiceCategorie SG=new ServiceCategorie();
        Services.ServiceEntrepot SE=new ServiceEntrepot();
        String nom=tnom.getText();
        String url;
       //FileUploader fu = new FileUploader("c:/localhost/dhia");
         //      System.out.println("khaliiiiiiiiiiiil"+dhia.getText());

        url=tfrecherchelivreur.getText();
       
        
     
        //String nom2=nom+".png";
        //url.replace("\\", "/");

        
        //Upload
       
       
        
        //fu.upload(tfrecherchelivreur.getText());
        // ...
          
        
        //Delete
       // if(fu.delete(fileNameInServer)){
            //System.out.println("File "+fileNameInServer+" deleted.");
        
        
        //ftpclienttest.exportfile(url,nom2);
        //int x=Funct(u);
    //    Produit p1=new Produit(1,nom,quantite,categorie,prix,"localhost/image/uploads/" + fileNameInServer,entrepot,2);
      //url.replaceAll("\\","/");
   
       if (veriftextfiel(tnom)|veriftextfiel(tprix)|veriftextfiel(tquantite)  )
       {
             labelerreur.setVisible(true);
       }
       else  {
       int quantite= Integer.parseInt(tquantite.getText());
        float prix=Float.parseFloat(tprix.getText());
        if (quantite<0 | prix <0)
        {
             labelerreur.setVisible(true);
              creeralert("Erreur","Vérifier la quantité ou le prix");
             
        }else {
          int categorie=SG.SearchCategorie(cat.getValue());
        int entrepot=SE.SearchCategorie(cat1.getValue());
           Produit p1=new Produit(1,nom,quantite,categorie,prix,imag,entrepot,ServiceUser.loggedUser.getId());
        ST.addProduit(p1);
        Alert alert =new Alert (Alert.AlertType.INFORMATION) ;
        alert.setHeaderText(null);
        alert.setContentText("le produit "+p1.getNom()+"a été ajouter avec sucées");
        alert.show();
        tfrecherchelivreur.clear();
      //TrayIconDemo.main(null);
        
        nav.getChildren().setAll(ach);
       }   
        }
       // int ent=Integer.parseInt(cat1.getValue());
       
        
    }

    @FXML
    private void suppcatg(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/gui/ProduitSupprimerCategorieWindow.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
         Stage stage=new Stage();
        stage.setTitle("modifier");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    /* public static int Funct(User u)
    {
        
      return u.getId();  
    }
*/
     public int initdata(User s,String x){
        return s.getId();
   
    }
    
}
