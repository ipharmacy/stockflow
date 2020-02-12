/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import entite.Produit;
import Service.ServiceProduit;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MaConnection;

/**
 *
 * @author dhia
 */
public class Main {

  
  
  
    public static void main(String[] args) throws SQLException {
    Service.ServiceProduit SP = new ServiceProduit();
   Produit p1=new Produit("test2",17,"malboro",100.5f,1,2);
   List<Produit> A1=new ArrayList();
  // SP.addProduit(p1);
   //SP.SearchProduits("100.5");
 //  A1=SP.TrierProduits();
  //  A1=SP.getProduits();
    
    
 
 
   //for(Iterator it=A1.iterator(); it.hasNext();)

     //       System.out.println(it.next());
    // SP.deleteProduit(p1);
      String ch=SP.getHistorique();
        System.out.println(ch);
        
        try {
            System.out.println(SP.getById(3));
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
