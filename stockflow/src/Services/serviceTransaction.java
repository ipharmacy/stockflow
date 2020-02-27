/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Interfaces.IServiceTransaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Entity.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnection; 

/**
 *
 * @author chihe
 */
public class serviceTransaction implements IServiceTransaction{
    Connection cnx;
    public serviceTransaction()
    {
        cnx=MaConnection.getInstance().getConnection();
    }
    
    @Override
    public void addTransaction(Transaction tr) throws SQLException {
    Statement stm = cnx.createStatement();
    String query = "INSERT INTO `transaction` (`idTransaction`,`type`,`montant`,`paiement`,`idClient`,`dateTransaction`) VALUES (NULL,'"+tr.getType()+"','"+tr.getMontant()+"','"+tr.getPaiement()+"','"+tr.getIdClient()+"','"+tr.getDate()+"')";
    stm.executeUpdate(query);       
    }

    @Override
    public List<Transaction> displayTransaction() throws SQLException {
       Statement stm=cnx.createStatement();
        String query ="SELECT * FROM `transaction`"; 
        ResultSet rst = stm.executeQuery(query);
        ArrayList <Transaction> transactions = new ArrayList<>();
        while(rst.next())
        {
         Transaction tr=new Transaction();
         tr.setIdTransaction(rst.getInt("idTransaction"));
         tr.setType(rst.getString("type"));
         tr.setMontant(rst.getFloat("montant"));
         tr.setPaiement(rst.getString("paiement"));
         tr.setIdClient(rst.getInt("idClient"));
         tr.setDate(rst.getDate("dateTransaction"));
         transactions.add(tr);
        }
        return transactions;    
    }

    @Override
    public void updateTransaction(Transaction tr, int id) throws SQLException {
     Statement stm=cnx.createStatement();
    String query="UPDATE `transaction` SET `type`='"+tr.getType()+"',`montant`='"+tr.getMontant()+"',`paiement`='"+tr.getPaiement()+"',`idClient`='"+tr.getIdClient()+"',`dateTransaction`='"+tr.getDate()+"' WHERE `idTransaction`='"+id+"'";
    stm.executeUpdate(query);   
    }

    @Override
    public void deleteTransaction(int id) throws SQLException {
        Statement stm=cnx.createStatement();
        String query="DELETE FROM `transaction` WHERE `idTransaction`='"+id+"'";
        stm.executeUpdate(query);  
    }

    @Override
    public Transaction rechercherTransaction(int id) throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `transaction` WHERE `idTransaction`='"+id+"'";
        ResultSet rst=stm.executeQuery(query);
        Transaction tr=new Transaction();
        while(rst.next()){
        tr.setIdTransaction(rst.getInt("idTransaction"));
        tr.setType(rst.getString("type"));
        tr.setMontant(rst.getFloat("montant"));
        tr.setPaiement(rst.getString("paiement"));
        tr.setIdClient(rst.getInt("idClient"));
        tr.setDate(rst.getDate("dateTransaction")); 
        }
        return tr;
    }

    @Override
    public float revenuesParJour(String date) throws SQLException {
        float revenues=0;
        LocalDate myDate =LocalDate.parse(date);
        Statement stm=cnx.createStatement();
        String query="select sum(montant) as montant from `transaction` where `dateTransaction`='"+myDate+"'and `type`='vente'";
        ResultSet rst = stm.executeQuery(query);
       while(rst.next()){
       revenues=revenues+rst.getFloat("montant");
       }
       return revenues ; 
    }

    @Override
    public float depensesParJour(String date) throws SQLException {
        float depenses=0;
         LocalDate myDate =LocalDate.parse(date);
        Statement stm=cnx.createStatement();
        String query="select sum(montant) as montant from `transaction` where `dateTransaction`='"+myDate+"'and `type`='achat'";
        ResultSet rst = stm.executeQuery(query);
       while(rst.next())
       {
        depenses=depenses+rst.getFloat("montant");
       }
       return depenses;
    }

    @Override
    public float tresorerieParJour(String date) throws SQLException { 
        return revenuesParJour(date)-depensesParJour(date);
    }

    @Override
    public List<Transaction> triTransactionParDate() throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `transaction` ORDER BY `dateTransaction`";
        ResultSet rst = stm.executeQuery(query);
        ArrayList <Transaction> transactions = new ArrayList<>();
        while(rst.next())
        {
        Transaction tr=new Transaction();
        tr.setIdTransaction(rst.getInt("idTransaction"));
        tr.setType(rst.getString("type"));
        tr.setMontant(rst.getFloat("montant"));
        tr.setPaiement(rst.getString("paiement"));
        tr.setIdClient(rst.getInt("idClient"));
        tr.setDate(rst.getDate("dateTransaction"));
        transactions.add(tr);
        }
        return transactions;
    }

    @Override
    public  Map <String,Float> DisplayLoyalCustomers() throws SQLException {
    Statement stm=cnx.createStatement();
    Map <String,Float> map=new HashMap();
    String query ="select idClient,sum(montant) as montant from `transaction` group by `idClient`";
    ResultSet rst = stm.executeQuery(query);
    while(rst.next())
    {
        if (rst.getFloat("montant") >(float)2.200)
        {
          map.put(rst.getString(1),rst.getFloat(2));
        }
    }
    return map;
    }

    @Override
    public ObservableList<Transaction> readAll() throws SQLException{
     ObservableList<Transaction> arr=FXCollections.observableArrayList();
     Statement stm=cnx.createStatement();
    ResultSet rst=stm.executeQuery("select * from `transaction`");
     while (rst.next()) {                
         Transaction tr=new Transaction();
         tr.setIdTransaction(rst.getInt("idTransaction"));
         tr.setType(rst.getString("type"));
         tr.setMontant(rst.getFloat("montant"));
         tr.setPaiement(rst.getString("paiement"));
         tr.setIdClient(rst.getInt("idClient"));
         tr.setDate(rst.getDate("dateTransaction"));
         arr.add(tr);
     }
    return arr;
    }

    @Override
    public ObservableList<Transaction> rechercherTransactionParFiltre(String k) throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `transaction` WHERE CONCAT(`idTransaction`,`type`,`montant`,`paiement`,`idClient`) like '%"+k+"%' ";
        ResultSet rst=stm.executeQuery(query);
        ObservableList<Transaction> cl=FXCollections.observableArrayList();
        Transaction tr=new Transaction();
        while(rst.next())
        {
         tr.setIdTransaction(rst.getInt("idTransaction"));
         tr.setType(rst.getString("type"));
         tr.setMontant(rst.getFloat("montant"));
         tr.setPaiement(rst.getString("paiement"));
         tr.setIdClient(rst.getInt("idClient"));
         cl.add(tr);
        }
        return cl;
    }

    

  

 
  
    
    
}
