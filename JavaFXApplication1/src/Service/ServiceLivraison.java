/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entite.Livraison;
import IService.IServiceLivraison;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase ;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.util.Date ; 


/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public  class ServiceLivraison implements IServiceLivraison<Livraison> {
    private Connection con;
    private Statement ste;

    public ServiceLivraison() {
        con = DataBase.getInstance().getConnection();

    }
    
    @Override
    public void ajouter(Livraison l) throws SQLException {
        
        java.sql.Date sqldate =new java.sql.Date(l.getDatelivraison().getTime());
        Time sqltime =new java.sql.Time(l.getDatelivraison().getTime()) ;
        sqldate = new java.sql.Date(l.getDatelivraison().getTime());
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `livraisons`.`livraison` (`idlivraison`, `datelivraison`,`time`, `idlivreur`, `nomlivreur`, `prenomlivreur`, `idcommande`, `done`) "
                + "VALUES " + "(NULL, '" + sqldate + "', '"+sqltime+"', '" + l.getIdlivraison() + "', '" + l.getNomlivreur()+ "', '" + l.getPrenomlivreur() + "',  '"+l.getIdcommande()+"', '"+l.getDone()+ "');";
        ste.executeUpdate(requeteInsert);
        
    }
    
    @Override
        public List<Livraison> readAll() throws SQLException
        {
            List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livraison");
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
               
     arr.add(p);
     }
    return arr;
        }
        
         public void deleteLivraisonId(int id) throws SQLException
         {
             
          ste = con.createStatement();
        //String requeteInsert = "delete from livreur where idLivreur=?+ ,nom=? ,prenom=?,notetotal=?";
         String requeteInsert = "delete from livraison where idlivraison="+id;
        ste.executeUpdate(requeteInsert); 
       
    
         }
         
         @Override
    public void updateLivraison(Livraison l) throws SQLException {
        
        PreparedStatement pre=con.prepareStatement( "UPDATE livraison SET  datelivraison=?,"
                +" time=?,idlivreur=?,nomlivreur=?,prenomlivreur=?,idcommande=?,done=? WHERE idlivraison=?");
        java.sql.Date sqldate =new java.sql.Date(l.getDatelivraison().getTime());
        Time sqltime =new java.sql.Time(l.getDatelivraison().getTime()) ;
        
        pre.setDate(1, sqldate);
        pre.setTime(2, sqltime);
        pre.setInt(3,l.getIdlivreur());
        pre.setString(4,l.getNomlivreur());
         pre.setString(5, l.getPrenomlivreur());
        pre.setInt(6, l.getIdlivreur());
        pre.setString(7, l.getDone());
       pre.setInt(8,l.getIdlivraison());
       System.out.println(l.getIdlivraison());
      
         pre.executeUpdate();
    }
    


    @Override
    public List<Livraison> trierselondate() throws SQLException {
  List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livraison order by  datelivraison ASC");
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
               
     arr.add(p);
    }
     return arr ;
    }
     public List<Livraison> recherLivraisonselondate(java.util.Date n) throws SQLException 
   {
       List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    
    java.sql.Date sqldate =new java.sql.Date(n.getTime()) ;
    ResultSet rs=ste.executeQuery("select * from livraison where datelivraison LIKE '"+sqldate+"%'");
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
     arr.add(p);
     
   }
    System.out.println(arr) ;
return arr ;
}

    
    
    
    
    


    

   
    
}

