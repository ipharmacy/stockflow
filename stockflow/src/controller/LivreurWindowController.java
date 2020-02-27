/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Livreur;
import controller.ModifierLivreurController;
import Services.ServiceLivreur;
import utils.MaConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class LivreurWindowController implements Initializable {
     private double begin ; 
     private Connection con;
     private Statement ste;
     int iduser =2; 
    
    @FXML
    private ImageView dp;
    @FXML
    private Label label1;
    @FXML
    private Button bouttonajouter;
    @FXML
    private AnchorPane anchorpanestat;
    @FXML
    private BarChart<String, Float> statbarchart;
    @FXML
    private Button boutondisplaystats;
    private TableView<Livreur> tableaffichagelivreur;
   

    private TableColumn<Livreur, String> nom;
    private TableColumn<Livreur, String> prenom;
    private TableColumn<Livreur, Integer> age;
    
    private TableColumn<Livreur, Integer> numero;
    private TableColumn<Livreur, String> mail;
   
    private TableColumn<Livreur, Float> note;
   
    public ObservableList<Livreur> datalivreur=FXCollections.observableArrayList() ;
    ServiceLivreur livreurs=new  ServiceLivreur() ;
    @FXML
    private AnchorPane barre;
    @FXML
    private TextField tf_prenom_livreur_a_ajouter;
    @FXML
    private TextField tf_nom_livreur_a_ajouter;
    @FXML
    private TextField tf_age_livreur_a_ajouter;
    @FXML
    private TextField tf_mail_livreur_a_ajouter;
    @FXML
    private Button buttonajouterlivreur;
    @FXML
    private TextField tf_numero_livreur_a_ajouter1;
    @FXML
    private Button buttonannuler;
    @FXML
    private Button boutonstats;
    @FXML
    private Label labelerreur;
    @FXML
    private ScrollPane affichageListe;
    @FXML
    private Button buttonactualiser;
    @FXML
    private AnchorPane ach;
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
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
          Image img=new Image("uploads/home.png");
        dp.setImage(img);  
        labelerreur.setVisible(false);
        anchorpanestat.setVisible(false);
          
           boutonstats.setVisible(true);
        try {
            /*        nom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("prenom"));
            age.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("age"));
            numero.setCellValueFactory(new PropertyValueFactory<Livreur,Integer>("num"));
            mail.setCellValueFactory(new PropertyValueFactory<Livreur,String>("mail"));
            note.setCellValueFactory(new PropertyValueFactory<Livreur,Float>("notetotal"));*/
            //afficherLivreur();
            labelerreur.toBack();
            // TODO
            /*ServiceLivreur op=new ServiceLivreur();
            try {
            AnchorPane parentListe=new AnchorPane();
            int i=0;
            for(Livreur l:op.readAllAvecId(iduser)){
            AnchorPane element=new AnchorPane();
            element.setPrefWidth(500);
            element.setStyle("-fx-background-color: #CFCEC9;-fx-border-insets:10;-fx-border-width:6;");
            
            element.setLayoutX(0);
            element.setLayoutY(i*150);
            Label nom=new Label(l.getNom());
            Label prenom=new Label(l.getPrenom());
            Label numero=new Label(String.valueOf(l.getNum()));
            Label mail=new Label(l.getMail());
            Label age=new Label(String.valueOf(l.getAge()));
            Label noteTotal=new Label(String.valueOf(l.getNotetotal()));
            
            Button supprimer=new Button("Supprimer") ;
            Button modif=new Button ("Modifier") ;
            
            nom.setPrefWidth(200);
            nom.setPrefHeight(5);
            nom.setStyle("-fx-background-color:transparent");
            nom.setLayoutX(6);
            nom.setLayoutY(0);
            
            prenom.setPrefWidth(200);
            prenom.setPrefHeight(5);
            prenom.setStyle("-fx-background-color:transparent");
            prenom.setLayoutX(6);
            prenom.setLayoutY(12+5);
            
            
            
            
            
            mail.setPrefWidth(200);
            mail.setPrefHeight(5);
            mail.setStyle("-fx-background-color:transparent");
            mail.setLayoutX(6);
            mail.setLayoutY(25+5);
            //element.getChildren().add(mail);
            
            age.setPrefWidth(200);
            age.setPrefHeight(5);
            age.setStyle("-fx-background-color:transparent");
            age.setLayoutX(6);
            age.setLayoutY(5+43);
            
            numero.setPrefWidth(200);
            numero.setPrefHeight(5);
            numero.setStyle("-fx-background-color:transparent");
            numero.setLayoutX(6);
            numero.setLayoutY(5+56);
            
            
            //element.getChildren().add(age);
            
            noteTotal.setPrefWidth(200);
            noteTotal.setPrefHeight(5);
            noteTotal.setStyle("-fx-background-color:transparent");
            noteTotal.setLayoutX(6);
            noteTotal.setLayoutY(74+5);
            
            modif.setPrefHeight(20);
            modif.setPrefWidth(100);
            supprimer.setPrefHeight(20);
            supprimer.setPrefWidth(100);
            
            modif.setLayoutX(170) ;
            modif.setLayoutY(40);
            supprimer.setLayoutX(170);
            
            
            element.getChildren().addAll(nom,prenom,mail,age,numero,noteTotal,supprimer,modif);
            
            
            parentListe.getChildren().add(element);
            
            i++;
            }
            affichageListe.setContent(parentListe);
            } catch (SQLException ex) {
            Logger.getLogger(LivreurController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            afficherLivreur();
        } catch (SQLException ex) {
            Logger.getLogger(LivreurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }   
    
    public void getLivreur()
{
    //afficherLivreur();
}
    
    public void afficherLivreur() throws SQLException
    {
      // ServiceLivreur op=new ServiceLivreur();
       AnchorPane parentListe=new AnchorPane();
       int i=0;
       for(Livreur l:livreurs.readAllAvecId(iduser)){
           AnchorPane element=new AnchorPane();
           element.setPrefWidth(500);
           element.setStyle("-fx-background-color: #CFCEC9;-fx-border-insets:10;-fx-border-width:6;");
           
           element.setLayoutX(0);
           element.setLayoutY(i*150);
           Label nom=new Label("NOM :"+l.getNom());
           Label prenom=new Label("PRENOM :"+l.getPrenom());
           Label numero=new Label("NUMERO "+String.valueOf(l.getNum()));
           Label mail=new Label("MAIL :"+l.getMail());
           Label age=new Label("AGE :"+String.valueOf(l.getAge()));
           Label noteTotal=new Label("NOTETOTAL :"+String.valueOf(l.getNotetotal()));
           
           Button supprimer=new Button("Supprimer") ;
           Button modif=new Button ("Modifier") ;
            supprimer.setStyle("");
           nom.setPrefWidth(200);
           nom.setPrefHeight(5);
           nom.setStyle("-fx-background-color:transparent");
           nom.setLayoutX(6);
           nom.setLayoutY(0);
           
           prenom.setPrefWidth(200);
           prenom.setPrefHeight(5);
           prenom.setStyle("-fx-background-color:transparent");
           prenom.setLayoutX(6);
           prenom.setLayoutY(12+5);
           
           
           
           
           
           mail.setPrefWidth(200);
           mail.setPrefHeight(5);
           mail.setStyle("-fx-background-color:transparent");
           mail.setLayoutX(6);
           mail.setLayoutY(25+5);
           //element.getChildren().add(mail);
           
           age.setPrefWidth(200);
           age.setPrefHeight(5);
           age.setStyle("-fx-background-color:transparent");
           age.setLayoutX(6);
           age.setLayoutY(5+43);
           
           numero.setPrefWidth(200);
           numero.setPrefHeight(5);
           numero.setStyle("-fx-background-color:transparent");
           numero.setLayoutX(6);
           numero.setLayoutY(5+56);
           
           
           //element.getChildren().add(age);
           
           noteTotal.setPrefWidth(200);
           noteTotal.setPrefHeight(5);
           noteTotal.setStyle("-fx-background-color:transparent");
           noteTotal.setLayoutX(6);
           noteTotal.setLayoutY(74+5);
           
           modif.setPrefHeight(20);
           modif.setPrefWidth(100);
           supprimer.setPrefHeight(20);
           supprimer.setPrefWidth(100);
           
           modif.setLayoutX(170) ;
           modif.setLayoutY(40);
           supprimer.setLayoutX(170);
           
           
           element.getChildren().addAll(nom,prenom,mail,age,numero,noteTotal,supprimer,modif);
           
           parentListe.getChildren().add(element);
           supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        Livreur vs=new Livreur();
                       
                        l.getId() ;
                        livreurs.deleteId(l.getId());
                        livreurs.delete(vs);
                        Parent root;
                       
                   afficherLivreur();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(LivreurController.class.getName()).log(Level.SEVERE, null, ex);
                    }
           

                }
    
});
           
           modif.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    
                   
           try {
            
               FXMLLoader loader =new FXMLLoader() ;
            Stage primaryStage =new Stage() ;
            
            Pane root=loader.load(getClass().getResource("/gui/ModifierLivreur.fxml").openStream()) ;
           
            
          ModifierLivreurController  modifierLivreurController =(ModifierLivreurController)loader.getController();
            modifierLivreurController.getModifierLivreur(l);
            
            Scene scene =new Scene(root) ;
            primaryStage.setScene(scene);
            primaryStage.show();
          
        }catch (IOException ex) {
            System.out.println(ex);
        }

                }
    
});
           
           i++;
       }
       affichageListe.setContent(parentListe);
    }
       
        /*FilteredList<Livreur>f =new  FilteredList<>(datalivreur,e->true) ;
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
     SortedList<Livreur>sorteddata =new SortedList<>(f) ;*/
       
    
    
   /*  private void afficherLivreur ()
    {
        
        
         try {
            con = DataBase.getInstance().getConnection();
            
            ResultSet rs=con.createStatement().executeQuery("select * from livreur where iduser="+iduser);
            while (rs.next()) {
                                 
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt(4);
               int num=rs.getInt(5);
               String mail=rs.getString(6);
               float note=rs.getInt(7);
               Livreur p=new Livreur(id,note, nom, prenom,age,num,mail,iduser);
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
}*/

    
    
    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void DisplayEntrepots(MouseEvent event) {
        
    }

    private void ModifierLivreur(ActionEvent event) {
        System.out.println(tableaffichagelivreur.getSelectionModel().getSelectedItem());
         Livreur livreur=( Livreur)tableaffichagelivreur.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader =new FXMLLoader() ;
            Stage primaryStage =new Stage() ;
            Pane root=loader.load(getClass().getResource("ModifierLivreur.fxml").openStream()) ;
            
/*            ModifierLivreurController  modifierLivreurController =(ModifierLivreurController)loader.getController();
            modifierLivreurController.getModifierLivreur(livreur);*/
            
            Scene scene =new Scene(root) ;
            primaryStage.setScene(scene);
            primaryStage.show();
            
                
        } catch (IOException ex) {
           // Logger.getLogger(LivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void ajouterlivreur(ActionEvent event) {
        TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label1) ; 
        System.out.println("oui") ;
        System.out.println("eeeee"+begin);
         translate.setToX(-236*3-3);
        translate.play();
    }
    

    private void SupprimerLivreur(ActionEvent event) throws SQLException {
         System.out.println(tableaffichagelivreur.getSelectionModel().getSelectedItem());
         Livreur livreur=(Livreur)tableaffichagelivreur.getSelectionModel().getSelectedItem();
         
         livreurs.deleteId(livreur.getId());
         datalivreur.clear();
         
        // afficherLivreur() ;
    }
    

    private void TrierLivreur(ActionEvent event) throws SQLException {
         AnchorPane parentListe=new AnchorPane();
       int i=0;
       for(Livreur l:livreurs.trierselonnoteByid(iduser)){
           AnchorPane element=new AnchorPane();
           element.setPrefWidth(500);
           element.setStyle("-fx-background-color: #CFCEC9;-fx-border-insets:10;-fx-border-width:6;");
           
           element.setLayoutX(0);
           element.setLayoutY(i*150);
           Label nom=new Label(l.getNom());
           Label prenom=new Label(l.getPrenom());
           Label numero=new Label(String.valueOf(l.getNum()));
           Label mail=new Label(l.getMail());
           Label age=new Label(String.valueOf(l.getAge()));
           Label noteTotal=new Label(String.valueOf(l.getNotetotal()));
           
           Button supprimer=new Button("Supprimer") ;
           Button modif=new Button ("Modifier") ;
           
           nom.setPrefWidth(200);
           nom.setPrefHeight(5);
           nom.setStyle("-fx-background-color:transparent");
           nom.setLayoutX(6);
           nom.setLayoutY(0);
           
           prenom.setPrefWidth(200);
           prenom.setPrefHeight(5);
           prenom.setStyle("-fx-background-color:transparent");
           prenom.setLayoutX(6);
           prenom.setLayoutY(12+5);
           
           
           
           
           
           mail.setPrefWidth(200);
           mail.setPrefHeight(5);
           mail.setStyle("-fx-background-color:transparent");
           mail.setLayoutX(6);
           mail.setLayoutY(25+5);
           //element.getChildren().add(mail);
           
           age.setPrefWidth(200);
           age.setPrefHeight(5);
           age.setStyle("-fx-background-color:transparent");
           age.setLayoutX(6);
           age.setLayoutY(5+43);
           
           numero.setPrefWidth(200);
           numero.setPrefHeight(5);
           numero.setStyle("-fx-background-color:transparent");
           numero.setLayoutX(6);
           numero.setLayoutY(5+56);
           
           
           //element.getChildren().add(age);
           
           noteTotal.setPrefWidth(200);
           noteTotal.setPrefHeight(5);
           noteTotal.setStyle("-fx-background-color:transparent");
           noteTotal.setLayoutX(6);
           noteTotal.setLayoutY(74+5);
           
           modif.setPrefHeight(20);
           modif.setPrefWidth(100);
           supprimer.setPrefHeight(20);
           supprimer.setPrefWidth(100);
           
           modif.setLayoutX(170) ;
           modif.setLayoutY(40);
           supprimer.setLayoutX(170);
           
           
           element.getChildren().addAll(nom,prenom,mail,age,numero,noteTotal,supprimer,modif);
           
           parentListe.getChildren().add(element);
           supprimer.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        Livreur vs=new Livreur();
                       
                        l.getId() ;
                        livreurs.deleteId(l.getId());
                        livreurs.delete(vs);
                        Parent root;
                       
                   afficherLivreur();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(LivreurController.class.getName()).log(Level.SEVERE, null, ex);
                    }
           

                }
    
});
           
           modif.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    
                   
           try {
            
               FXMLLoader loader =new FXMLLoader() ;
            Stage primaryStage =new Stage() ;
            
            Pane root=loader.load(getClass().getResource("/Gui/ModifierLivreur.fxml").openStream()) ;
           
            
/*            ModifierLivreurController  modifierLivreurController =(ModifierLivreurController)loader.getController();
            modifierLivreurController.getModifierLivreur(l);*/
            
            Scene scene =new Scene(root) ;
            primaryStage.setScene(scene);
            primaryStage.show();
          
        }catch (IOException ex) {
            System.out.println(ex);
        }

                }
    
});
           
           i++;
       }
       affichageListe.setContent(parentListe);
       
    }
        
    
    



    @FXML
    private void displaystats(ActionEvent event) {
        anchorpanestat.setVisible(false);
    }
public void  creeralert (String titre ,String text )
{
    Alert alert =new Alert (Alert.AlertType.ERROR) ;
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.show();
}
public boolean veriftextfiel (TextField t)
{
    if (t.getText().isEmpty() )
    return true ;
           return false; 
}
    @FXML
    private void AjouterLivreur(ActionEvent event) throws SQLException {
        
         
          System.out.print("fffffff");
           if (veriftextfiel(tf_nom_livreur_a_ajouter)|veriftextfiel(tf_prenom_livreur_a_ajouter)|veriftextfiel(tf_numero_livreur_a_ajouter1)|
                   veriftextfiel(tf_mail_livreur_a_ajouter)|veriftextfiel(tf_age_livreur_a_ajouter))
           {
               System.out.print("fffffff");
               labelerreur.setVisible(true);
           }
           else 
           {
                 String nom=tf_nom_livreur_a_ajouter.getText();
           String prenom=tf_prenom_livreur_a_ajouter.getText();
           int num=Integer.parseInt(tf_numero_livreur_a_ajouter1.getText()) ;
           String mail=tf_mail_livreur_a_ajouter.getText() ;
           int age=Integer.parseInt(tf_age_livreur_a_ajouter.getText()) ;
               System.out.print("vvvv");
               Livreur l =new Livreur(0,nom,prenom,age,num,mail,iduser );
            if (tf_numero_livreur_a_ajouter1.getText().length()!=8)
            {
                creeralert("ERREUR NUMERO","LONGEUR INCORRECTE DU NUMERO");
            }
            if (!tf_mail_livreur_a_ajouter.getText().contains("@")  )
            {
                creeralert("ERREUR MAIL","MAIL INCORRECTE");
            }
            else if (!tf_mail_livreur_a_ajouter.getText().contains(".")  )
            {
                creeralert("ERREUR MAIL","MAIL INCORRECTE");
            }
            
        if (tf_numero_livreur_a_ajouter1.getText().length()==8 &&tf_mail_livreur_a_ajouter.getText().contains("@") && tf_mail_livreur_a_ajouter.getText().contains("."))    
    
        {
            if (livreurs.getLivreur(nom, prenom)!=null)
    {
        System.out.println("existe");
        Alert alert =new Alert (Alert.AlertType.ERROR) ;
        alert.setHeaderText(null);
        alert.setContentText(nom+ "" +prenom +"existe déja");
        alert.show();
        
        
    }
    else 
    {
        System.out.println("n' existe pas");
        
           livreurs.ajouter(l);
           Alert alert =new Alert (Alert.AlertType.INFORMATION) ;
        alert.setHeaderText(null);
        alert.setContentText(nom+ "" +prenom +"ajouté");
        alert.show();
       
                TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label1) ; 
        
         translate.setToX(label1.getLayoutX()-236*3+55);
        System.out.println("oui") ;
        translate.play();
            
            datalivreur.clear();
         afficherLivreur() ;
        
    }
    }
           }
    }

    @FXML
    private void AnnulerAjouterLivreur(ActionEvent event) {
        TranslateTransition translate =new TranslateTransition (Duration.seconds(1.2),label1) ; 
        
         translate.setToX(label1.getLayoutX()-236*3+55);
         translate.play();
        
    }

    @FXML
    private void stats(ActionEvent event) throws SQLException {
        
       // List<Livreur> arr=new ArrayList<>();
        anchorpanestat.setVisible(true);
        System.out.println("rrrrr"+livreurs.getLivreurByIduser(iduser )) ;
        statlivreur((ArrayList<Livreur>) livreurs.readAllAvecId(iduser));
       // boutonstats.setVisible(false);
        
        
    }

    public void statlivreur (ArrayList <Livreur> list)
    {
        
        XYChart.Series set1 =new XYChart.Series<String,Float>() ;
       
        for (int i=0 ;i<list.size();i++)
        {
         
             String p=list.get(i).getNom()+" "+list.get(i).getPrenom()+"("+list.get(i).getNotetotal()+")";
             Float a =list.get(i).getNotetotal();
             System.out.println(p);
             System.out.println(a);
            set1.getData().add(new XYChart.Data(p,a));
              
        }
        statbarchart.getData().addAll(set1) ;
    }

    @FXML
    private void actualiser(ActionEvent event) throws SQLException {
        afficherLivreur();
    }

    @FXML
    private void goLivreurPage(ActionEvent event) {
    }

    @FXML
    private void goLivraisonPage(ActionEvent event) {
    }

    @FXML
    private void goCommandePage(ActionEvent event) {
    }

    @FXML
    private void GoServiceFinancierPage(ActionEvent event) {
    }

    @FXML
    private void serviceFinancierModules(MouseEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) {
    }
    
    
}
