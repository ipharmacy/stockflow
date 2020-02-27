/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Entity.Livreur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author House
 */
public interface IService_1<T> {
    void ajouter(T t) throws SQLException;
     public Livreur getLivreurByIduser(int id)throws SQLException ;
     public List<Livreur> readAllAvecId(int id) throws SQLException;
   // int getId(T t)throws SQLException;
    void deleteId(int id) throws SQLException;
    public T getLivreur(int id)throws SQLException  ;
    void delete (T t)throws SQLException ;
    void update(T t) throws SQLException;
    void updateNote(int id) throws SQLException;
      public void updateNote2(int id) throws SQLException ;
    List<T> readAll() throws SQLException;
    List<T> trierselonnote() throws SQLException ;
     void rechercher(String n)throws SQLException ;
     public List<T> recher(String n) throws SQLException  ;
     public Livreur getLivreur(String nom,String prenom)throws SQLException ;
     
}

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
