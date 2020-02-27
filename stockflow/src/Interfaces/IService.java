/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Omar
 */
public interface IService<T> {
    void add(T t,String type) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(T t,int id) throws SQLException;
    List<T> readAll() throws SQLException;
    List<T> search(int id) throws SQLException;
    User search(String login,String pass) throws SQLException;
    
}
