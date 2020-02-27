/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Timestamp;
import javafx.scene.control.CheckBox;


/**
 *
 * @author chihe
 */
public class Facture {
    private int idFacture;
    private String description;
    private float fraisServices;
    private int idTransaction;
    java.util.Date date=new java.util.Date(); 
    private java.sql.Timestamp dateFacture;
    private java.sql.Date dateLivraison; 
    private String type;
    
    private CheckBox ch_box;

    public CheckBox getCh_box() {
        return ch_box;
    }

    public void setCh_box(CheckBox ch_box) {
        this.ch_box = ch_box;
    }

   
    
    public Facture() {
    }

    public Facture(String description, float fraisServices, int idTransaction, java.sql.Date dateLivraison,String type) {
        this.description = description;
        this.fraisServices = fraisServices;
        this.idTransaction = idTransaction;
        this.dateLivraison = dateLivraison;
        this.dateFacture=new java.sql.Timestamp(this.date.getTime());
        this.type=type;
        this.ch_box=new CheckBox();
    }

    public Facture(int idFacture, String description, float fraisServices, int idTransaction, Timestamp dateFacture, Date dateLivraison, String type) 
    {
        this.idFacture = idFacture;
        this.description = description;
        this.fraisServices = fraisServices;
        this.idTransaction = idTransaction;
        this.dateFacture = dateFacture;
        this.dateLivraison = dateLivraison;
        this.type = type;
        this.ch_box=new CheckBox();
    }
    


    

    public int getIdFacture() {
        return idFacture;
    }

    /**
     * @param idFacture the idFacture to set
     */
    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the fraisServices
     */
    public float getFraisServices() {
        return fraisServices;
    }

    /**
     * @param fraisServices the fraisServices to set
     */
    public void setFraisServices(float fraisServices) {
        this.fraisServices = fraisServices;
    }

    /**
     * @return the idTransaction
     */
    public int getIdTransaction() {
        return idTransaction;
    }

    /**
     * @param idTransaction the idTransaction to set
     */
    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    /**
     * @return the dateFacture
     */
    public java.sql.Timestamp getDateFacture() {
        return dateFacture;
    }

   
    
    

    /**
     * @return the dateLivraison
     */
    public java.sql.Date getDateLivraison() {
        return dateLivraison;
    }

    /**
     * @param dateLivraison the dateLivraison to set
     */
    public void setDateLivraison(java.sql.Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    /**
     * @param dateFacture the dateFacture to set
     */
    public void setDateFacture(java.sql.Timestamp dateFacture) {
        this.dateFacture = dateFacture;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Facture{" + "idFacture=" + idFacture + ", description=" + description + ", fraisServices=" + fraisServices + ", idTransaction=" + idTransaction + ", date=" + date + ", dateFacture=" + dateFacture + ", dateLivraison=" + dateLivraison + ", type=" + type + '}';
    }
    
    
    
}
