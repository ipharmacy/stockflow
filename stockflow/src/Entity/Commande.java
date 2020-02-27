/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Dell
 */
public class Commande {
   private int id_commande;
   private Date date;
   private String nomProduit;
   private String prop_Commande;
   private int quantite;
   private String adresse;
   private float prixU;
   private float prixT;

    public Commande() {
    }

    public Commande(int id_commande, Date date, String nomProduit, String prop_Commande,int quanitite,String adresse, float prixU, float prixT) {
        this.id_commande = id_commande;
        this.date = date;
        this.nomProduit = nomProduit;
        this.prop_Commande = prop_Commande;
        this.prixU = prixU;
        this.prixT = prixT;
        this.quantite = quanitite;
        this.adresse = adresse;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getProp_Commande() {
        return prop_Commande;
    }

    public void setProp_Commande(String prop_Commande) {
        this.prop_Commande = prop_Commande;
    }

    public float getPrixU() {
        return prixU;
    }

    public void setPrixU(float prixU) {
        this.prixU = prixU;
    }

    public float getPrixT() {
        return prixT;
    }

    public void setPrixT(float prixT) {
        this.prixT = prixT;
    }
    
    
}