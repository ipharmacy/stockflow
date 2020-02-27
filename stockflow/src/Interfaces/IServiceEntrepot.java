/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.SQLException;
import Entity.Entrepot;

/**
 *
 * @author Khalil
 */
public interface IServiceEntrepot {
     void ajouter( Entrepot t) throws SQLException;
    boolean delete(Entrepot t) throws SQLException;
    boolean update(Entrepot t) throws SQLException;
    
}
