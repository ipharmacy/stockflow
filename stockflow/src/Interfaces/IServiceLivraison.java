
package Interfaces;

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
    public void pdftousleslivraison()throws SQLException ;
        public List<T> rechercheavance(String nom) throws SQLException ;
           public void pdftousleslivraisonbyid()throws SQLException;

    
}
