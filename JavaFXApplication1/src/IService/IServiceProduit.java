/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IService;

import java.sql.SQLException;
import java.util.List;
import entite.Produit;

/**
 *
 * @author dhia
 */
public interface IServiceProduit {
    
    public void addProduit(Produit p) throws SQLException;

    public List<Produit> getProduits() throws SQLException;
    
    public List<Produit> TrierProduits() throws SQLException;

    public Produit getById(int id) throws SQLException;

    public void deleteProduit(Produit p) throws SQLException;

    public void deleteProduit(int id) throws SQLException;

    public void updateProduit(Produit p) throws SQLException; 

    public void SearchProduits(String character) ;
    
}
