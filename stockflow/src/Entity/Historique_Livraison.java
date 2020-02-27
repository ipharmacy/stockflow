/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public class Historique_Livraison {
     int idlivraison , idlivreur  ;
    String nomlivreur,prenomlivreur ; 

    
    java.util.Date datelivraison ; 
   java.util.Date   timelivraison ; 
int idcommande ; 
    String done ; 

    public int getIdlivraison() {
        return idlivraison;
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

    public Date getDatelivraison() {
        return datelivraison;
    }

    public Date getTimelivraison() {
        return timelivraison;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public String getDone() {
        return done;
    }

    public Historique_Livraison(int idlivraison, int idlivreur, String nomlivreur, String prenomlivreur, Date datelivraison, Date timelivraison, int idcommande, String done) {
        this.idlivraison = idlivraison;
        this.idlivreur = idlivreur;
        this.nomlivreur = nomlivreur;
        this.prenomlivreur = prenomlivreur;
        this.datelivraison = datelivraison;
        this.timelivraison = timelivraison;
        this.idcommande = idcommande;
        this.done = done;
    }
}
