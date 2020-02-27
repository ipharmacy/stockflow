/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Interfaces.IServiceProduit;
import Entity.Produit;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;
import java.util.Date;

import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author dhia
 */
public class ServiceProduit implements IServiceProduit {
    Connection cnx;

    public ServiceProduit() {
        cnx = MaConnection.getInstance().getConnection();
    }

    @Override
    public void addProduit(Produit p) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "INSERT INTO `produit` (`id_produit`, `nom`, `quantite`, `id_categorie`, `prix`,`date`,`img`, `id_entrepot`, `id_utilisateur`)"
                + "     VALUES (NULL, '"+p.getNom()+"', '"+p.getQuantite()+"', '"+p.getId_categorie()+"', '"+p.getPrix()+"', '"+p.getDate()+"', '"+p.getImg()+"','"+p.getId_entrepot()+"', '"+p.getId_utilisateur()+"')";
        String Description="L id du client "+p.getId_utilisateur()+" a ajouter le produit "+p.getNom()+" le "+p.getDate();
        String query2="INSERT INTO `historique_produit` (`id`, `description`) VALUES (NULL, '"+Description+"' )";

        stm.executeUpdate(query); 
        stm.executeUpdate(query2);
        
    }

    @Override
    public List<Produit> getProduits() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `produit`";
        ResultSet rst = stm.executeQuery(query);
        List<Produit> produits = new ArrayList<>();
        while (rst.next()) {
            Produit p = new Produit();
            p.setId_produit(rst.getInt("id_produit"));
            p.setNom(rst.getString("nom"));
            p.setQuantite(rst.getInt("quantite"));
            p.setId_categorie(rst.getInt("id_categorie"));            
            p.setPrix(rst.getFloat("prix"));
            p.setImg(rst.getString("img"));
            p.setId_entrepot(rst.getInt("id_entrepot"));
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
            produits.add(p);
        }
     return produits;
    }
     
    public ObservableList<Produit> getProduct() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `produit`";
        ResultSet rst = stm.executeQuery(query);
        ObservableList<Produit> produits =FXCollections.observableArrayList();
        while (rst.next()) {
            Produit p = new Produit();
            p.setId_produit(rst.getInt("id_produit"));
            p.setNom(rst.getString("nom"));
            p.setQuantite(rst.getInt("quantite"));
            p.setId_categorie(rst.getInt("id_categorie"));            
            p.setPrix(rst.getFloat("prix"));
              p.setImg(rst.getString("img"));
            p.setId_entrepot(rst.getInt("id_entrepot"));
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
            produits.add(p);
        }
     return produits;
    }
    
    public Produit getProduit(int id ) throws SQLException{
         Statement stm = cnx.createStatement();
        String query = "select * from `produit where id_produit='"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        Produit p = new Produit(); 
        while (rst.next()) {
            
            p.setId_produit(rst.getInt("id_produit"));
            p.setNom(rst.getString("nom"));
            p.setQuantite(rst.getInt("quantite"));
            p.setId_categorie(rst.getInt("id_categorie"));                
            p.setPrix(rst.getFloat("prix"));
              p.setImg(rst.getString("img"));
            p.setId_entrepot(rst.getInt("id_entrepot"));
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
        
        }
      
     return p;
        
    }
     public String getHistorique() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `historique_produit`";
        ResultSet rst = stm.executeQuery(query);
       String ch="L'historique des produits sont : \n\r";
        while (rst.next()) {
            
            ch=ch+" \n\r"+(rst.getString("description"));
           
        }
     return ch;
    }

    @Override
    public List<Produit> TrierProduits() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `produit` ORDER BY prix DESC";
        ResultSet rst = stm.executeQuery(query);
        List<Produit> produits = new ArrayList<>();
        while (rst.next()) {
            Produit p = new Produit();
            p.setId_produit(rst.getInt("id_produit"));
            p.setNom(rst.getString("nom"));
            p.setQuantite(rst.getInt("quantite"));
              p.setId_categorie(rst.getInt("id_categorie"));                  
            p.setPrix(rst.getFloat("prix"));
              p.setImg(rst.getString("img"));
            p.setId_entrepot(rst.getInt("id_entrepot"));
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
            produits.add(p);
        }
     return produits;
    }

    @Override
    public Produit getById(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from produit where id_produit= '"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Produit p = new Produit();
        
        while (rst.next()) {
            
            p.setId_produit(rst.getInt("id_produit"));
            p.setNom(rst.getString("nom"));
            p.setQuantite(rst.getInt("quantite"));
              p.setId_categorie(rst.getInt("id_categorie"));                 
            p.setPrix(rst.getFloat("prix"));
              p.setImg(rst.getString("img"));
            p.setId_entrepot(rst.getInt("id_entrepot"));
            p.setId_utilisateur(rst.getInt("id_utilisateur"));
            
        }
     return p;
    }

    @Override
    public void deleteProduit(Produit p) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "DELETE FROM produit where id_produit= '"+p.getId_produit()+"'";
         String Description="L id du client "+p.getId_utilisateur()+" a supprimer le produit "+p.getNom()+" le "+p.getDate();
        String query2="INSERT INTO `historique_produit` (`id`, `description`) VALUES (NULL, '"+Description+"' )";
        stm.executeUpdate(query);
         stm.executeUpdate(query2);
    }

    @Override
    public void deleteProduit(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "DELETE FROM produit where id_produit= '"+id+"'";
       
       
        stm.executeUpdate(query);
     
    }

    @Override
    public void updateProduit(Produit p) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "UPDATE produit SET nom= '"+p.getNom()+"', quantite= '"+p.getQuantite()+"', id_categorie= '"+p.getId_categorie()+"', prix= '"+p.getPrix()+"',img='"+p.getImg()+"', id_entrepot= '"+p.getId_entrepot()+"' WHERE id_produit='"+p.getId_produit()+"'";
        stm.executeUpdate(query);
    }

    @Override
    public void SearchProduits(String chara) {
    String req="select * from produit where nom  LIKE '"+chara+"%'" ;
        try {
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery(req);    
     while(rst.next()) 
    { 
        System.out.println("Produit : "+rst.getString("nom")+" quantite :"+rst.getInt("quantite")+"id_categorie :"+rst.getInt("id_categorie")+"date : "+rst.getString("date") );
    }
        } catch (SQLException ex) {
            System.out.println("pas de produit trouvé");
        }
    }


    
    

}
