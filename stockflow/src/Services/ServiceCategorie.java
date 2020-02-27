/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Interfaces.IServiceCategorie;
import Entity.Categorie;
import Entity.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnection;

/**
 *
 * @author Dhia
 */
public class ServiceCategorie extends IServiceCategorie{
     Connection cnx;
      public ServiceCategorie() {
        cnx = MaConnection.getInstance().getConnection();
    }
 
   
    @Override
    public void addCategorie(Categorie g) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "INSERT INTO `categorie` (`id`, `nom`)"+"VALUES (NULL,'"+g.getNom()+"')";
       

        stm.executeUpdate(query); 
 
        
    }
  
     @Override
    public List<Categorie> getCategories() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `categorie`";
        ResultSet rst = stm.executeQuery(query);
        List<Categorie> Categories = new ArrayList<>();
        while (rst.next()) {
            Categorie p = new Categorie();
            p.setId(rst.getInt("id"));
            p.setNom(rst.getString("nom"));
           
            Categories.add(p);
        }
     return Categories;
    }
     
    public ObservableList<String> getCategorie() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `categorie`";
        ResultSet rst = stm.executeQuery(query);
          ObservableList<String> Categories =FXCollections.observableArrayList();
        while (rst.next()) {
            String p = new String();
           
            p=rst.getString("nom");
           
            Categories.add(p);
        }
     return Categories;
    }
     @Override
    public Categorie getCategorie(int id ) throws SQLException{
         Statement stm = cnx.createStatement();
        String query = "select * from `categorie where id='"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        Categorie p = new Categorie(); 
        while (rst.next()) {
            
            p.setId(rst.getInt("id"));
            p.setNom(rst.getString("nom"));
           
        
        }
      
     return p;
        
    }
     
      public void deleteCategorie(String nom) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "DELETE FROM categorie where nom= '"+nom+"'";
         
        stm.executeUpdate(query);
        
    }
       public int SearchCategorie(String chara) {
    String req="select * from categorie where nom  LIKE '"+chara+"%'" ;
    int id1 = 0;
        try {
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery(req); 
            
     while(rst.next()) 
    { 
        id1=rst.getInt("id");
    }
        } catch (SQLException ex) {
            System.out.println("pas de produit trouvé");
        }
        return id1;
    }
        public String SearchCategori(int id) {
    String req="select * from categorie where id  LIKE '"+id+"%'" ;
    String id1="";
        try {
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery(req); 
            
     while(rst.next()) 
    { 
        id1=rst.getString("id");
    }
        } catch (SQLException ex) {
            System.out.println("pas de produit trouvé");
        }
        return id1;
        }

    @Override
    public void deleteCategorie(Categorie p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
}
