/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dhia
 */
public class Produit {
    private int id_produit;
    private String nom;
    private int quantite;
    private String type;
    private float prix;
    private String date;
    private int id_entrepot;
    private int id_utilisateur;



    public Produit() {
    }
    
    public Produit(int id_produit, String nom, int quantite, String type, float prix,int id_entrepot, int id_utilisateur) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.quantite = quantite;
        this.type = type;
        this.prix = prix;
        this.id_entrepot = id_entrepot;
        this.id_utilisateur = id_utilisateur;
    }
    public Produit(String nom, int quantite, String type, float prix, int id_entrepot, int id_utilisateur) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.quantite = quantite;
        this.type = type;
        this.prix = prix;
        
        this.id_entrepot = id_entrepot;
        this.id_utilisateur = id_utilisateur;
    }
    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }
     public String getDate() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
         Date date = new Date();
        
         return format.format(date);
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_entrepot() {
        return id_entrepot;
    }

    public void setId_entrepot(int id_entrepot) {
        this.id_entrepot = id_entrepot;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom=" + nom + ", quantite=" + quantite + ", type=" + type + ", prix=" + prix + ", id_entrepot=" + id_entrepot + ", id_utilisateur=" + id_utilisateur + '}';
    }
    
    
    
}
