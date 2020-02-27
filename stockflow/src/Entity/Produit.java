/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.image.ImageView;

/**
 *
 * @author Dhia
 */
public class Produit {
    private ImageView imgg;
    private int id_produit;
    private String nom;
    private int quantite;
    private int id_categorie;
    private float prix;
    private String date;
    private String img;
    private int id_entrepot;
    private int id_utilisateur;



    public Produit() {
    }
    public Produit(int id_produit, String nom, int quantite,int id_categorie, float prix,ImageView imgg,int id_entrepot, int id_utilisateur) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.quantite = quantite;
        this.id_categorie=id_categorie;
        this.prix = prix;
        this.id_entrepot = id_entrepot;
        this.id_utilisateur = id_utilisateur;
        this.imgg=imgg;
    }
    
    public Produit(int id_produit, String nom, int quantite,int id_categorie, float prix,String img,int id_entrepot, int id_utilisateur) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.quantite = quantite;
        this.id_categorie=id_categorie;
        this.prix = prix;
        this.id_entrepot = id_entrepot;
        this.id_utilisateur = id_utilisateur;
        this.img=img;
    }
    public Produit(String nom, int quantite,int id_categorie, float prix,String img,int id_entrepot, int id_utilisateur) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.quantite = quantite;
        this.id_categorie=id_categorie;
        this.prix = prix;
        this.img=img;
        
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
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie=id_categorie;
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
        return "Produit{" + "id_produit=" + id_produit + ", nom=" + nom + ", quantite=" + quantite + ", id_categorie=" + id_categorie + ", prix=" + prix + ", id_entrepot=" + id_entrepot + ", id_utilisateur=" + id_utilisateur + '}';
    }
    
    
    
}
