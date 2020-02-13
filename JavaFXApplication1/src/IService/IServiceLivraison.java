/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public interface IServiceLivraison<T> {
       public void ajouter(T t) throws SQLException;
 public List<T> readAll() throws SQLException ;
 public void deleteLivraisonId(int id) throws SQLException;
  public void updateLivraison(T t) throws SQLException ;
  List<T> trierselondate() throws SQLException ;
   public List<T> recherLivraisonselondate(java.util.Date n) throws SQLException  ;
    
}
