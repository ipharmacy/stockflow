/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.SQLException;
import Entity.Categorie;
import java.util.List;

/**
 *
 * @author Dhia
 */
abstract public class IServiceCategorie {
    abstract public void addCategorie(Categorie g) throws SQLException;
    abstract public void deleteCategorie(Categorie p) throws SQLException ;
    abstract public Categorie getCategorie(int id ) throws SQLException;
    abstract public List<Categorie> getCategories() throws SQLException;
    
}
