/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import java.sql.SQLException;
import java.util.List;
import Entity.Rating;
/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public interface IServiceRating <T> {
    public void ajouter(Rating r) throws SQLException;
    public void ajouter2(Rating r) throws SQLException;
    public T getRating(int idrating)throws SQLException  ;
    public List<Rating> readAll() throws SQLException;
    public void deleteRatingId(int id) throws SQLException;
    public void updateRating(Rating l) throws SQLException ;
     public List<T> recherRatingselonIdlivreur(int n) throws SQLException  ;
    
}
