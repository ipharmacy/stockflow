/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Client;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author chihe
 */
public interface IServiceClient {
    public void addClient(Client cl) throws SQLException;
    public List <Client> displayClients() throws SQLException;
    public void updateClient(Client cl,int id) throws SQLException;
    public void deleteClient(int id) throws SQLException; 
    public ObservableList<Client> readAll () throws SQLException;
    public Client rechercherClient(int id) throws SQLException;
    public List<Client> triClientsParNom()throws SQLException;
    public ObservableList<Client> rechercherClientParFiltre(String k) throws SQLException;

}
