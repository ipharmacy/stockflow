/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.User;
import Interfaces.IService;
import utils.MaConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Omar
 */
public class ServiceUser implements IService<User> {
    
    private final Connection con;
    private Statement ste;
    public static User loggedUser;
    public ServiceUser(){
        con = MaConnection.getInstance().getConnection();
    }

    @Override
    public void add(User t,String type) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `user` (`id`, `nom`, `prenom`, `Email`,`login`,`password`,`type`,`telephone`) VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getEmail() + "', '" + t.getLogin()+ "', '" + t.getPassword() + "', '" + type + "', '" + t.getTel() + "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "DELETE FROM `user` WHERE `id`="+id+";";
        int x=ste.executeUpdate(requeteInsert);
        return x == 0;
    }

    @Override
    public boolean update(User t,int id) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "UPDATE `user` SET `nom` ='"+t.getNom()+"',`prenom` ='"+t.getPrenom()+"', `email`='"+t.getEmail()+"',`login`='"+t.getLogin()+"',`password`='"+t.getPassword()+"',`type`='"+t.getType()+"',`telephone`="+t.getTel()+" WHERE `id`="+id+" ; ";
        int x=ste.executeUpdate(requeteInsert);
        return x == 0;
    }

    @Override
    public ObservableList readAll() throws SQLException {
        ObservableList<User> arr=FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user");
     while (rs.next()) {                
               int id=rs.getInt("id");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String login=rs.getString("login");
               String password=rs.getString("password");
               String type=rs.getString("type");
               int tel=rs.getInt("telephone");
               
               User p=new User( id,nom, prenom, email,login,password,type,tel);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public List<User> search(int id) throws SQLException {
        List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user where id="+id+";");
     while (rs.next()) {                
               
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String login=rs.getString("login");
               String password=rs.getString("password");
               int tel=rs.getInt("telephone");
               User p=new User( nom, prenom, email,login,password,tel);
     arr.add(p);
     }
     
     
    return arr;
    }
     public List<User> searchSession(int id) throws SQLException {
        List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from session where id="+id+";");
     while (rs.next()) {                
               int id1=rs.getInt("id");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String login=rs.getString("login");
               String password=rs.getString("password");
               int tel=rs.getInt("telephone");
               String type=rs.getString("type");
               User p=new User( id1,nom, prenom, email,login,password,type,tel);
     arr.add(p);
     }
     
     
    return arr;
    }
    

    @Override
    public User search(String login, String pass) throws SQLException {
        List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    User p = null;
    ResultSet rs=ste.executeQuery("select * from user where login='"+login+"' and password='"+pass+"' and (type like 'admin' or type like 'SU' );");
     while (rs.next()) {                
               int id=rs.getInt("id");
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String email=rs.getString("email");
               String log=rs.getString("login");
               String password=rs.getString("password");
               String type=rs.getString("type");
               int tel=rs.getInt("telephone");
               p=new User(id,nom, prenom, email,log,password,type,tel);
     arr.add(p);
     loggedUser=p;
     return p;
     
     
    }
     return null;
    }
}
