/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public class Livraison {
    int idlivraison , idlivreur  ;
    String nomlivreur,prenomlivreur ; 

    
    java.util.Date datelivraison ; 
   java.util.Date   timelivraison ; 
int idcommande ; 
    String done ; 

    public Livraison(int idlivraison, int idlivreur, String nomlivreur, String prenomlivreur, java.util.Date datelivraison, java.util.Date timelivraison, int idcommande, String done) {
        this.idlivraison = idlivraison;
        this.idlivreur = idlivreur;
        this.nomlivreur = nomlivreur;
        this.prenomlivreur = prenomlivreur;
        this.datelivraison = datelivraison;
        this.timelivraison = timelivraison;
        this.idcommande = idcommande;
        this.done = done;
    }


    public java.util.Date getTimelivraison() {
        return timelivraison;
    }

  
 

       

   

   

    public int getIdlivraison() {
        return idlivraison;
    }

    @Override
    public String toString() {
        return "Livraison{" + "idlivraison=" + idlivraison + ", idlivreur=" + idlivreur + ", nomlivreur=" + nomlivreur + ", prenomlivreur=" + prenomlivreur + ", datelivraison=" + datelivraison + ", timelivraison="+timelivraison+" idcommande=" + idcommande + ", done=" + done + '}';
    }

    public void setIdlivraison(int idlivraison) {
        this.idlivraison = idlivraison;
    }

    public void setIdlivreur(int idlivreur) {
        this.idlivreur = idlivreur;
    }

    public void setNomlivreur(String nomlivreur) {
        this.nomlivreur = nomlivreur;
    }

    public void setPrenomlivreur(String prenomlivreur) {
        this.prenomlivreur = prenomlivreur;
    }

    public void setDatelivraison(java.util.Date datelivraison) {
        this.datelivraison = datelivraison;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public int getIdlivreur() {
        return idlivreur;
    }

    public String getNomlivreur() {
        return nomlivreur;
    }

    public String getPrenomlivreur() {
        return prenomlivreur;
    }

    public java.util.Date getDatelivraison() {
        return datelivraison;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public String getDone() {
        return done;
    }


    
   
    
    
}
