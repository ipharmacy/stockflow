/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import Entity.Transaction;
import javafx.collections.ObservableList;

/**
 *
 * @author chihe
 */
public interface IServiceTransaction {  
    public void addTransaction(Transaction tr) throws SQLException;
    public List <Transaction> displayTransaction() throws SQLException;
    public void updateTransaction(Transaction tr,int id) throws SQLException;
    public void deleteTransaction(int id) throws SQLException; 
    public Transaction rechercherTransaction(int id) throws SQLException;
    public float revenuesParJour(String date)throws SQLException;
    public float depensesParJour(String date)throws SQLException;
    public float tresorerieParJour(String date)throws SQLException;
    public List<Transaction> triTransactionParDate()throws SQLException;  
    public Map<String,Float> DisplayLoyalCustomers()throws SQLException;
    public ObservableList<Transaction> readAll() throws SQLException;
    public ObservableList<Transaction> rechercherTransactionParFiltre(String k) throws SQLException;   
}
