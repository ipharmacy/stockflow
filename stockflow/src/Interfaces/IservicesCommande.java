/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Commande;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author Etudiant
 */
public interface IservicesCommande  <T>{
    void AddCommande(T t) throws SQLException;
    boolean DeleteCommande(T t) throws SQLException;
    boolean UpdateCommande(T t) throws SQLException;
    void ShowCommandes() throws SQLException;


    
}
