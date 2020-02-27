/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Interfaces.IServiceClient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entity.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnection;


/**
 *
 * @author chihe
 */
public class servicesClient  implements IServiceClient{
    Connection cnx;
    public servicesClient()
    {
        cnx=MaConnection.getInstance().getConnection();
    }
    @Override
    public void addClient(Client cl) throws SQLException {
    Statement stm = cnx.createStatement();
    String query = "INSERT INTO `client` (`idClient`,`nomClient`,`email`,`telephone`) VALUES (NULL,'"+cl.getNomClient()+"','"+cl.getEmail()+"','"+cl.getTel()+"')";
    stm.executeUpdate(query);
    }
    @Override
    public List<Client> displayClients() throws SQLException {
        Statement stm=cnx.createStatement();
        String query ="SELECT * FROM `client`"; 
        ResultSet rst = stm.executeQuery(query);
        ArrayList <Client> clients = new ArrayList<>();
        while(rst.next())
        {
         Client cl=new Client();
         cl.setIdClient(rst.getInt("idClient"));
         cl.setNomClient(rst.getString("nomClient"));
         cl.setEmail(rst.getString("email"));
         cl.setTel(rst.getInt("telephone"));
         
         clients.add(cl);
        }
        return clients;
    }
    @Override
    public void updateClient(Client cl ,int id) throws SQLException{
    Statement stm=cnx.createStatement();
    String query="UPDATE `client` SET `nomClient`='"+cl.getNomClient()+"',`email`='"+cl.getEmail()+"',`telephone`='"+cl.getTel()+"' WHERE `idClient`='"+id+"'";
    stm.executeUpdate(query);
    }
    @Override
    public void deleteClient(int id) throws SQLException {
        Statement stm=cnx.createStatement();
        String query="DELETE FROM `client` WHERE `idClient`='"+id+"'";
        stm.executeUpdate(query);    
    }

    @Override
    public Client rechercherClient(int id) throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `client` WHERE `idClient`='"+id+"'";
        ResultSet rst=stm.executeQuery(query);
        Client cl=new Client();
        while(rst.next()){
        cl.setIdClient(rst.getInt("idClient"));
        cl.setNomClient(rst.getString("nomClient"));
        cl.setEmail(rst.getString("email"));
        cl.setTel(rst.getInt("telephone"));
        }
        return cl;
    }
    
   
         
    

    @Override
    public List<Client> triClientsParNom() throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `client` ORDER BY `nomClient`";
       ResultSet rst = stm.executeQuery(query);
        ArrayList <Client> clients = new ArrayList<>();
        while(rst.next())
        {
         Client cl=new Client();
         cl.setIdClient(rst.getInt("idClient"));
         cl.setNomClient(rst.getString("nomClient"));
         cl.setEmail(rst.getString("email"));
         cl.setTel(rst.getInt("telephone"));
         clients.add(cl);
        }
        return clients;
    }   



    @Override
    public ObservableList<Client> readAll() throws SQLException {
    ObservableList<Client> arr=FXCollections.observableArrayList();
    Statement stm=cnx.createStatement();
    ResultSet rst=stm.executeQuery("select * from client");
     while (rst.next()) {                
      Client cl=new Client();
         cl.setIdClient(rst.getInt("idClient"));
         cl.setNomClient(rst.getString("nomClient"));
         cl.setEmail(rst.getString("email"));
         cl.setTel(rst.getInt("telephone"));
         arr.add(cl);
     }
    return arr;
    }

    @Override
    public ObservableList<Client> rechercherClientParFiltre(String k) throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `client` WHERE CONCAT(`idClient`,`nomClient`,`email`,`telephone`) like '%"+k+"%' ";
        ResultSet rst=stm.executeQuery(query);
        ObservableList<Client> cl=FXCollections.observableArrayList();
        Client c=new Client();
        while(rst.next()){
        c.setIdClient(rst.getInt("idClient"));
        c.setNomClient(rst.getString("nomClient"));
        c.setEmail(rst.getString("email"));
        c.setTel(rst.getInt("telephone"));
        cl.add(c);
        }
        return cl; 
        
    }
}
