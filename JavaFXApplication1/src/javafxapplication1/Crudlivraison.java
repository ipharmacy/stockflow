/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudlivraison;

import entite.Livreur;
import entite.Livraison;
import Service.ServiceLivreur;
import Service.ServiceLivraison;
import Service.ServiceRating;
import Utils.DataBase;
import entite.Rating;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date ;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;

public class Crudlivraison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       ServiceLivreur ser = new ServiceLivreur();
        ServiceRating ratings = new ServiceRating();
        Livreur p1 = new Livreur( "Belhsan", "bouseetta", 23, 45796322, "llrr@gmail.com");
        Livreur p2 = new Livreur("Yassine", "Smida",21,245639874,"rrefefc@gmail.com");
        Livreur p3 =new Livreur (82,"Kaki","Kaki",41,23652360,"tere@hotmail.com") ;
 //ser.ajouter(p1) ;      
//ser.ajouter(p2);

System.out.println("Affichage livreurs :"+ser.readAll());
//System.out.println(p3) ;
//ser.deleteId(81);
//ser.update(p3);


System.out.println("Affichage trié livreurs :"+ser.trierselonnote());

ser.recher("Amel") ;
  /*if (ser.getLivreur(80)!=null)
          ser.updateNote(80);
          else 
              System.out.println("livreur n'existe pas");*/


 Rating r1 = new Rating(13, 12, 11);
 //ratings.ajouter2(r1);
 System.out.println(ratings.readAll()) ; 
 ratings.deleteRatingId(21);
 Rating rupdate=new Rating (25,14,3,5,"un bon livreur") ;
 System.out.println(rupdate) ;
 ratings.updateRating(rupdate);
  






//ratings.ajouter(r);

//List<Rating> list5 = ratings.readAll();
            //System.out.println(list5);
        
        /*Livreur p2 = new Livreur(12,"Karray", "Gargouri");
        Livreur p3=new Livreur (38,15,"yousssef","benfarhat") ;
        System.out.println("aaaaaa");
        System.out.println(p3);
       // Livreur p3=new Livreur(12,30,) ;*/

 /*try {
        
          
            ser.ajouter(p1);
            List<Livreur> list = ser.readAll();
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
              System.out.println("eeeeeeeee");
        }*/
        /*ser.deleteId(31);
        ser.delete(p1);

        List<Livreur> list2 = ser.readAll();
        System.out.println(list2);

        // ser.update(p3);
        System.out.print("trieee");
        List<Livreur> list3 = ser.trierselonnote();
        System.out.println(list3);

        System.out.print("recherche");
        List<Livreur> list4 = ser.recher("Karray");
        System.out.println(list4);
        
        
       
        
        /*try {
        
          
            ratings.ajouter(r);
            List<Livreur> list = ser.readAll();
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
              System.out.println("eeeeeeeee");
        }*/
        
        //System.out.println("ajout livreur ");
        //Livreur liv1 =new Livreur ("Youssef","Ben Farhat") ;
        //ser.ajouter(liv1);
       /* System.out.println("affichage rating ");
        List<Rating> list5 = ratings.readAll();
         
        System.out.println(list5);
          System.out.println("update livreur ");
          Livreur pupadte=new Livreur (65,0,"TArek" ,"loukil");
          Livreur li =new Livreur (51,0,"Karray","Gargou") ;
          Livreur ltest= new Livreur (9,0,"Youssef","Ben Farhat") ;
          
          
          if (ser.getLivreur(65)!if=null)
          ser.updateNote(65);
          else 
              System.out.println("livreur n'exuste pas");
          
          //Rating rr =new Rating (11,12,1,"lazy one") ;
          Rating rr =new Rating (13,15,1,"bkhil") ;
         
          ratings.ajouter2(rr);
          ratings.readAll() ;
          
           
          System.out.println(ser.getLivreur(39));
          
          */
          
      /*Date datee,date2,daterecherche;
        datee = new Date (120,10,1,1,6);
         date2 = new Date (119,9,2,2,3);
        daterecherche =new Date (120,10,1,1,6) ;
       
       Livraison l =new Livraison(22, "youssef","jjj", datee,22,"oui") ; 
       Livraison lupdate =new Livraison(2,23, "Azza","benee", date2,12,"non") ; 
       ServiceLivraison livraisons =new ServiceLivraison() ;
      // livraisons.ajouter(l); 
       List<Livraison> listlivraison = livraisons.readAll();
            System.out.println(listlivraison);
            livraisons.deleteLivraisonId(4);
            livraisons.updateLivraison(lupdate);
            livraisons.trierselondate() ;
            
            List<Livraison> listlivraisontri = livraisons.trierselondate();
            System.out.println(listlivraisontri ) ;
            
            System.out.println("recherche : ");
            List<Livraison> listlivraisonrecher=livraisons.recherLivraisonselondate(daterecherche) ;*/
            
 
    }

}
