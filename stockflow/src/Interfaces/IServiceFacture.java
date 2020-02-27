/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Facture;
import javafx.collections.ObservableList;

/**
 *
 * @author chihe
 */
public interface IServiceFacture {
    public void addFacture(Facture fa) throws SQLException;
    public List <Facture> displayFacture() throws SQLException; 
    public void updateFacture(Facture fa,int id) throws SQLException;
    public void deleteFacture(int id) throws SQLException;
    public Facture rechercherFacture(int id) throws SQLException;
    public List<Facture> triFactureParDate()throws SQLException;
    public ObservableList<Facture> readAll() throws SQLException;
    public ObservableList<Facture> rechercherFactureParFiltre(String k) throws SQLException;


    
}
