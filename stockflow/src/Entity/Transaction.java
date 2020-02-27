/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import javafx.scene.control.CheckBox;

/**
 *
 * @author chihe
 */
public class Transaction {
    private int idTransaction;
    private String type;
    private float montant;
    private String paiement;
    private int idClient;
    java.util.Date myDate=new java.util.Date();
    private java.sql.Date date;
    private CheckBox ch_box;


    
    
    public Transaction(String type, float montant, String paiement, int idClient) {
        this.type = type;
        this.montant = montant;
        this.paiement = paiement;
        this.idClient = idClient;
        this.date=new java.sql.Date(myDate.getTime());
        this.ch_box=new CheckBox();
    }

    public Transaction(int idTransaction, String type, float montant, String paiement, int idClient, java.sql.Date date) {
        this.idTransaction = idTransaction;
        this.type = type;
        this.montant = montant;
        this.paiement = paiement;
        this.idClient = idClient;
        this.date = date;
        this.ch_box=new CheckBox();
    }
    
    public Transaction()
    {
        
    }

    public Transaction(String type, float montant, String paiement, int idClient, java.sql.Date date) {
        this.type = type;
        this.montant = montant;
        this.paiement = paiement;
        this.idClient = idClient;
        this.date = date;
                this.ch_box=new CheckBox();

    }

   

    @Override
    public String toString() {
        return "Transaction{" + "idTransaction=" + idTransaction + ", type=" + type + ", montant=" + montant + ", paiement=" + paiement + ", idClient=" + idClient + '}';
    }
    
    public int getIdTransaction()
    {
      return idTransaction;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public float getMontant() {
        return montant;
    }
    
    public void setMontant(float montant) {
        this.montant = montant;
    } 
    public String getPaiement() {
        return paiement;
    } 
    
    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }
    
    public int getIdClient() {
        return idClient;
    }
    
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }   
    /**
     * @param idTransaction the idTransaction to set
     */
    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    /**
     * @return the date
     */
    public java.sql.Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    /**
     * @return the ch_box
     */
    public CheckBox getCh_box() {
        return ch_box;
    }

    /**
     * @param ch_box the ch_box to set
     */
    public void setCh_box(CheckBox ch_box) {
        this.ch_box = ch_box;
    }
       
}
