/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Livraison;
import Services.ServiceLivraison;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.transform.Transform.translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class LivraionWindowController implements Initializable {

     private double begin ; 
     ServiceLivraison sp = new ServiceLivraison();
Livraison li =new Livraison() ;
    
     @FXML
    private TextField tf_etat ;
    
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button ajouter;
    @FXML
    private TableView<Livraison> tableaffichagelivraisons;
    @FXML
    private TableColumn<Livraison,java.util.Date> date;
    @FXML
    private TableColumn<Livraison, java.sql.Time> horraire;
    @FXML
    private TableColumn<Livraison, String> nomlivreur;
    @FXML
    private TableColumn<Livraison, String> prenomlivreur;
    @FXML
    private TableColumn<Livraison, String> etat;
    
     public ObservableList<Livraison> data=FXCollections.observableArrayList() ;
   
    public ObservableList<String> heu=FXCollections.observableArrayList("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","00") ; ;
    
    public ObservableList<String> min=FXCollections.observableArrayList("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59") ;
 private Connection con;
    
 int idlivraison ;   
 
    
    
    @FXML
    private Label label;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
     @FXML
    private DatePicker date2;
    
     @FXML
       private ComboBox<String> heure ; 
       
    @FXML
       private ComboBox<String> minute ; 
    @FXML
    private Button boutontrier;
    @FXML
    private Button buttonsupprimerlivraison;
    @FXML
    private Button bouttonmodifier;
    @FXML
    private AnchorPane nav;
    @FXML
    private ImageView addBtn;
    @FXML
    private Button LivreurBtn;
    @FXML
    private Button LivraisonBtn;
    @FXML
    private Button CommandeBtn;
    @FXML
    private Button ServiceBtn;
    @FXML
    private Button Produitbtn;
    @FXML
    private Button buttonmodifierlivraison;
    @FXML
    private Button bouttonannuler;
    private TextField tfprenom2111;
    @FXML
    private ImageView dp;
    @FXML
    private Button boutonpdf;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
         nomlivreur.setCellValueFactory(new PropertyValueFactory<Livraison,String>("nomlivreur"));    

prenomlivreur.setCellValueFactory(new PropertyValueFactory<Livraison,String>("prenomlivreur"));
etat.setCellValueFactory(new PropertyValueFactory<Livraison,String>("done"));
date.setCellValueFactory(new PropertyValueFactory<Livraison,java.util.Date>("datelivraison"));
horraire.setCellValueFactory(new PropertyValueFactory<Livraison,java.sql.Time>("timelivraison"));
     heure.setItems(heu);
        minute.setItems(min);

        try {
            afficherLivraisons();
        } catch (SQLException ex) {
//            Logger.getLogger(LivraisonsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ModifierLivr(ActionEvent event) {
        
        TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label) ; 
        System.out.println("oui") ;
        System.out.println("eeeee"+begin);
         translate.setToX(-236*3-3);
        translate.play();
        //double x=label.getLayoutX()-(tableaffichagelivraisons.getPrefWidth()-vb.getPrefWidth());
        //System.out.println("ddddd"+vb.getPrefWidth());
        translate.play();
         Livraison livraison=(Livraison)tableaffichagelivraisons.getSelectionModel().getSelectedItem();
         tfnom.setText(livraison.getNomlivreur()); 
         tfprenom.setText(livraison.getPrenomlivreur()) ; 
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
String s = formatter.format(livraison.getDatelivraison());
         date2.setPromptText(s);
        //heure.setItems(livraison.getTimelivraison());
        tf_etat.setText(livraison.getDone());
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void ajouterlivraison(ActionEvent event) throws IOException {
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/AjouterLivraison.fxml"));
        nav.getChildren().setAll(ach);
        window.setFullScreen(false);
    }

    @FXML
    private void SupprimerLivraison(ActionEvent event) throws SQLException {
         System.out.println(tableaffichagelivraisons.getSelectionModel().getSelectedItem());
         Livraison livraison=(Livraison)tableaffichagelivraisons.getSelectionModel().getSelectedItem();
         System.out.println(livraison);
         sp.deleteLivraisonId(livraison.getIdlivraison());
         data.clear();
         afficherLivraisons() ;
    }

    
    private void afficherLivraisons () throws SQLException
    {
         try {
            con = MaConnection.getInstance().getConnection();
            
            ResultSet rs=con.createStatement().executeQuery("select * from livraison");
            while (rs.next()) {
                int idlivrai=rs.getInt(1);
                java.sql.Date date=rs.getDate(2 );
                java.sql.Time time =rs.getTime(3);
                int idlivreur=rs.getInt(4) ;
                String nom=rs.getString(5) ;
                String prenom=rs.getString(6) ;
                int idcommande=rs.getInt(7) ;
                java.util.Date datee =new java.util.Date(date.getTime());
                
                String done=rs.getString(8) ;
                Livraison p=new Livraison(idlivrai,idlivreur, nom,
                        prenom,date,time, idcommande,done) ;
                data.add(p);


            }
            
         tableaffichagelivraisons.setItems(data);  
                    rs.close();

    }catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        
        FilteredList<Livraison>f =new  FilteredList<>(data,e->true) ;
        tfrecherche.setOnKeyReleased(e->
                {
        tfrecherche.textProperty().addListener((observableValue,oldValue,newValue)-> 
        {
            f.setPredicate((Predicate<? super Livraison>) Livraison->{
                if (newValue==null || newValue.isEmpty())
                {
                    return true ;
                }
                String lowerCaseFilter=newValue.toLowerCase() ;
                if (Livraison.getNomlivreur().contains(newValue)){
                    return true ;
                }
                else if (Livraison.getNomlivreur().toLowerCase().contains(lowerCaseFilter))
                {
                    return true ;
                }
                else if (Livraison.getPrenomlivreur().toLowerCase().contains(lowerCaseFilter))
                {
                    return true ;
                }
                return false ;
            });
        });
                });
     SortedList<Livraison>sorteddata =new SortedList<>(f) ;
                sorteddata.comparatorProperty().bind(tableaffichagelivraisons.comparatorProperty()) ;
                
                tableaffichagelivraisons.setItems(sorteddata);
    }
    

    @FXML
    private void TrierLivraison(ActionEvent event) {
         data.clear();
        try {
            con = MaConnection.getInstance().getConnection();
            
            ResultSet rs=con.createStatement().executeQuery("select * from livraison order by  datelivraison ASC");
            while (rs.next()) {
                int idlivrai=rs.getInt(1);
                java.sql.Date date=rs.getDate(2 );
                java.sql.Time time =rs.getTime(3);
                int idlivreur=rs.getInt(4) ;
                String nom=rs.getString(5) ;
                String prenom=rs.getString(6) ;
                int idcommande=rs.getInt(7) ;
                java.util.Date datee =new java.util.Date(date.getTime());
                
                String done=rs.getString(8) ;
                Livraison p=new Livraison(idlivrai,idlivreur, nom,
                        prenom,date,time, idcommande,done) ;
                data.add(p);

tableaffichagelivraisons.setItems(data);// TODO
            }
            
           
                    rs.close();

    }catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        
    }

    @FXML
    private void goLivreurPage(ActionEvent event) {
    }

    @FXML
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
    private void goLivraisonPage(ActionEvent event) {
    }

    @FXML
    private void goCommandePage(ActionEvent event) {
    }

    @FXML
    private void ServiceFinancierModules(MouseEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) {
    }

    @FXML
    private void ModifierLivraison(ActionEvent event) throws ParseException, SQLException {
        String etat=tf_etat.getText();
      String nom=tfnom.getText() ;
      String prenom=tfprenom.getText();
       String datestring=date2.getEditor().getText() ;
        System.out.println("date string:" +datestring);
      Date time = new Date (120, 03 , 25, Integer.valueOf(heure.getSelectionModel().getSelectedItem()), Integer.valueOf(minute.getSelectionModel().getSelectedItem()), 00);
      
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Date newdate= formatter.parse(datestring) ;
        
         System.out.println("time :" +time);
        Livraison l =new Livraison(idlivraison,2, nom,prenom, newdate,time,19,etat);
        sp.updateLivraison(l);
        System.out.println(l);
        
         TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label) ; 
        
        translate.setToX(label.getLayoutX()-236*3+13);
        System.out.println("oui") ;
        translate.play();
        data.clear();
        afficherLivraisons();
        
    }

    @FXML
    private void annulermodif(ActionEvent event) {
        TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label) ; 
        
         translate.setToX(label.getLayoutX()-236*3+13);
         translate.play();
        
    }

    @FXML
    private void pdf(ActionEvent event) throws SQLException {
        
     
    
   
       
        sp.pdftousleslivraisonbyid();
        System.out.println("PDF tout");
        
    
   
    
    }
    
}
