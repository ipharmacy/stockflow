/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Service.ServiceLivraison;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import entite.Livraison ;
import entite.Livreur;
import Service.ServiceLivreur;
import Utils.DataBase;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author YOUSSEF BEN FARHAT
 */
public class LivraisonController implements Initializable {
 ServiceLivraison sp = new ServiceLivraison();
 ServiceLivreur livreurs=new  ServiceLivreur() ;
    
    
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private Button buttonajouterlivraison;
   
    @FXML
    private TableView<Livraison> tableaffichagelivraisons;
    
     @FXML
    private TableView<Livreur> tableaffichagelivreur;
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
    
    
    
    @FXML
    private TableColumn<Livreur, String> nom;
    @FXML
    private TableColumn<Livreur, String> prenom;
    @FXML
    private TableColumn<Livreur, Integer> age;
    
    @FXML
    private TableColumn<Livreur, Integer> numero;
    @FXML
    private TableColumn<Livreur, String> mail;
   
    @FXML
    private TableColumn<Livreur, Float> note;
   
    
    
    public ObservableList<Livraison> data=FXCollections.observableArrayList() ;
    public ObservableList<Livreur> datalivreur=FXCollections.observableArrayList() ;
    public ObservableList<String> heu=FXCollections.observableArrayList("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","00") ; ;
    
    public ObservableList<String> min=FXCollections.observableArrayList("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59") ;
 private Connection con;
    private Statement ste;
    @FXML
    private Button boutontrier;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Button boutonajouter;
    
    @FXML
    private Label label;
private double begin ; 
    @FXML
    private Button bouttonmodifier;
    @FXML
    private JFXTimePicker time;
    @FXML
    private JFXDatePicker date2;
    
    @FXML
       private ComboBox<String> heure ; 
       
    @FXML
       private ComboBox<String> minute ; 
    @FXML
    private AnchorPane anchorpanelivraison;
    @FXML
    private DatePicker datee;
    @FXML
    private Button buttonsupprimerlivraison;
    @FXML
    private Button boutonpdf;
    @FXML
    private Pane pnl_Livreur;
    @FXML
    private Pane pnl_Livraison;
    @FXML
    private Button btn_Livraison;
    @FXML
    private Button btn_Livreur;
    @FXML
    private AnchorPane anchorpanelivraison1;
    @FXML
    private TextField tfnom1;
    @FXML
    private Button buttonajouterlivraison1;
    @FXML
    private TextField tfprenom1;
    @FXML
    private Button bouttonmodifierlivreur;
    @FXML
    private TextField tfrecherchelivreur;
    @FXML
    private Button boutonajouterlivreur;
    @FXML
    private Button buttonsupprimerlivreur;
    @FXML
    private Button boutontrierlivreur;
    @FXML
    private Label label1;
    @FXML
    private Button boutonstats;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        heure.setItems(heu);
        minute.setItems(min);
       nomlivreur.setCellValueFactory(new PropertyValueFactory<Livraison,String>("nomlivreur"));    

prenomlivreur.setCellValueFactory(new PropertyValueFactory<Livraison,String>("prenomlivreur"));
etat.setCellValueFactory(new PropertyValueFactory<Livraison,String>("done"));
date.setCellValueFactory(new PropertyValueFactory<Livraison,java.util.Date>("datelivraison"));
horraire.setCellValueFactory(new PropertyValueFactory<Livraison,java.sql.Time>("timelivraison"));

nom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("nom"));
prenom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("prenom"));
age.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("age"));
numero.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("num"));
mail.setCellValueFactory(new PropertyValueFactory<Livreur,String>("mail"));
note.setCellValueFactory(new PropertyValueFactory<Livreur,Float>("notetotal"));





        afficherLivraisons() ;
        afficherLivreur();
       
           
        }
public void getLivraisonController()
{
    
    afficherLivraisons() ;
}

public void getLivreur()
{
    afficherLivreur();
}
        
    
    private void afficherLivraisons ()
    {
        
        try {
            con = DataBase.getInstance().getConnection();
            
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
    
    
    
    private void afficherLivreur ()
    {
        
        
         try {
            con = DataBase.getInstance().getConnection();
            
            ResultSet rs=con.createStatement().executeQuery("select * from livreur");
            while (rs.next()) {
                                 
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt(4);
               int num=rs.getInt(5);
               String mail=rs.getString(6);
               float note=rs.getInt(7);
               Livreur p=new Livreur(id,note, nom, prenom,age,num,mail);
     datalivreur.add(p);
     


            }
            
         tableaffichagelivreur.setItems(datalivreur);  
                    rs.close();

    }catch (SQLException ex) {
                System.out.println(ex);
    }
        
        FilteredList<Livreur>f =new  FilteredList<>(datalivreur,e->true) ;
        tfrecherchelivreur.setOnKeyReleased(e->
                {
        tfrecherchelivreur.textProperty().addListener((observableValue,oldValue,newValue)-> 
        {
            f.setPredicate((Predicate<? super Livreur>) Livreur->{
                if (newValue==null || newValue.isEmpty())
                {
                    return true ;
                }
                String lowerCaseFilter=newValue.toLowerCase() ;
                if (Livreur.getNom().contains(newValue)){
                    return true ;
                }
                else if (Livreur.getNom().toLowerCase().contains(lowerCaseFilter))
                {
                    return true ;
                }
                else if (Livreur.getPrenom().toLowerCase().contains(lowerCaseFilter))
                {
                    return true ;
                }
                return false ;
            });
        });
                });
     SortedList<Livreur>sorteddata =new SortedList<>(f) ;
                sorteddata.comparatorProperty().bind(tableaffichagelivreur.comparatorProperty()) ;
                
                tableaffichagelivreur.setItems(sorteddata);
}

    
    

            
            @FXML
            private void AjouterLivraison(ActionEvent event) throws IOException, ParseException {
           
                
                
            //AnchorPane root = FXMLLoader.load(getClass().getResource("Livraison.fxml"));
            String etat="non";
           
            //Scene scene = new Scene(root);
            String nom=tfnom.getText();
            String prenom=tfprenom.getText();
            String datestring=date2.getEditor().getText() ;
            //String timeee=time.getEditor().getText() ;
           // String timee  = String.valueOf(timeee.toCharArray(), 0, 4);
           
           
           
           
           
           
           
           Date time = new Date (120, 03 , 25, Integer.valueOf(heure.getSelectionModel().getSelectedItem()), Integer.valueOf(minute.getSelectionModel().getSelectedItem()), 00);
       
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Date newdate= formatter.parse(datestring) ;
        
      
        
        
           
            System.out.println("nom:"+tfnom.getText());
            System.out.println("prenom:"+tfprenom.getText());
        
         
            //Time timeutil = java.util.Date(ttime.getTime());
            Livraison l =new Livraison(22,2, nom,prenom, newdate,time,19,"oui");
    
           sp.ajouter(l);
       
                TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label) ; 
        
         translate.setToX(label.getLayoutX()-450);
        System.out.println("oui") ;
        translate.play();
            
            data.clear();
         afficherLivraisons() ;

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

    @FXML
    private void TrierLivraison(ActionEvent event) {
        data.clear();
        try {
            con = DataBase.getInstance().getConnection();
            
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
    private void pdf(ActionEvent event) throws SQLException {
    if (tableaffichagelivraisons.getSelectionModel().getSelectedItem()==null)
    {
        sp.pdftousleslivraison();
        System.out.println("PDF tout");
        
    }
    else 
    {
     Livraison l=(Livraison)tableaffichagelivraisons.getSelectionModel().getSelectedItem();
        sp.pdflivraison(l.getIdlivraison());
    }
    }

    private void rechercher(InputMethodEvent event) {
         try {
            sp.rechercheavance(tfrecherche.getText()) ;
            data.clear();
         afficherLivraisons() ;
        } catch (SQLException ex) {
            Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
       /* FilteredList<Livraison>f =new  FilteredList<>(data,e->true) ;
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
        
     SortedList<Livraison>sorteddata =new SortedList<>(f) ;
                sorteddata.comparatorProperty().bind(tableaffichagelivraisons.comparatorProperty()) ;
                
                tableaffichagelivraisons.setItems(sorteddata);
       */
         
       
    

    @FXML
    private void Ajouterlivraisonn(ActionEvent event) {
        
         TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label) ; 
        System.out.println("oui") ;
        System.out.println("eeeee"+begin);
         translate.setToX(-236*2+10);
        //double x=label.getLayoutX()-(tableaffichagelivraisons.getPrefWidth()-vb.getPrefWidth());
        //System.out.println("ddddd"+vb.getPrefWidth());
        translate.play();
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void ModifierLivraison(ActionEvent event) {
        
        System.out.println(tableaffichagelivraisons.getSelectionModel().getSelectedItem());
         Livraison livraison=(Livraison)tableaffichagelivraisons.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader =new FXMLLoader() ;
            Stage primaryStage =new Stage() ;
            Pane root=loader.load(getClass().getResource("ModifierLivraison.fxml").openStream()) ;
            
            ModifierLivraisonController  modifierLivraisonController =(ModifierLivraisonController)loader.getController();
            modifierLivraisonController.getModifierLivraison(livraison);
            
            Scene scene =new Scene(root) ;
            primaryStage.setScene(scene);
            primaryStage.show();
            
                
        } catch (IOException ex) {
            Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                }

    @FXML
    private void handleClicks(ActionEvent event) {
        
        if (event.getSource()==btn_Livreur)
        {
            pnl_Livreur.toFront();
        }
        if (event.getSource()==btn_Livraison)
        {
            pnl_Livraison.toFront();
        }
                
        
        
    }

    @FXML
    private void ModifierLivreur(ActionEvent event) {
        
        System.out.println(tableaffichagelivreur.getSelectionModel().getSelectedItem());
         Livreur livreur=( Livreur)tableaffichagelivreur.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader =new FXMLLoader() ;
            Stage primaryStage =new Stage() ;
            Pane root=loader.load(getClass().getResource("ModifierLivreur.fxml").openStream()) ;
            
            ModifierLivreurController  modifierLivreurController =(ModifierLivreurController)loader.getController();
            modifierLivreurController.getModifierLivreur(livreur);
            
            Scene scene =new Scene(root) ;
            primaryStage.setScene(scene);
            primaryStage.show();
            
                
        } catch (IOException ex) {
            Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ajouterlivreur(ActionEvent event) {
    }

    @FXML
    private void SupprimerLivreur(ActionEvent event) throws SQLException {
         System.out.println(tableaffichagelivreur.getSelectionModel().getSelectedItem());
         Livreur livreur=(Livreur)tableaffichagelivreur.getSelectionModel().getSelectedItem();
         
         livreurs.deleteId(livreur.getId());
         datalivreur.clear();
         
         afficherLivreur() ;
         
    }

    @FXML
    private void TrierLivreur(ActionEvent event) {
        datalivreur.clear();
        try {
            con = DataBase.getInstance().getConnection();
            
            ResultSet rs=con.createStatement().executeQuery("select * from livreur order by  notetotal DESC");
            while (rs.next()) {
                 int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt(4);
               int num=rs.getInt(5);
               String mail=rs.getString(6);
               float note=rs.getInt(7);
               Livreur p=new Livreur(id,note, nom, prenom,age,num,mail);
     datalivreur.add(p);
                

tableaffichagelivreur.setItems(datalivreur);// TODO
            }
            
           
                    rs.close();

    }catch (SQLException ex) {
                System.out.println(ex);
    }
        
        
    }

    @FXML
    private void stats(ActionEvent event) throws SQLException {
        //Livreur livreur=( Livreur)tableaffichagelivreur.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader =new FXMLLoader() ;
            Stage primaryStage =new Stage() ;
            Pane root=loader.load(getClass().getResource("stat.fxml").openStream()) ;
            List<Livreur> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livreur");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt(4);
               int num=rs.getInt(5);
               String mail=rs.getString(6);
               float note=rs.getInt(7);
               Livreur p=new Livreur(id,note, nom, prenom,age,num,mail);
     arr.add(p);
     }
            StatController  stats =(StatController)loader.getController();
           
            stats.best(arr);
            
            Scene scene =new Scene(root) ;
            primaryStage.setScene(scene);
            primaryStage.show();
            
                
        } catch (IOException ex) {
            Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



   

   
    
            
       
   
}
