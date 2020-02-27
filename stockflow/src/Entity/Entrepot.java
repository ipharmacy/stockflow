/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;



public class Entrepot {
    private int id;
    private int longitude;
    private int largitude;
    private String adresse;
    private int etat;
    private  int id_utilisateur;
    private String nom;

    public Entrepot(Integer d, Integer c, String text, String text0, int i) {
        this.adresse=text;
        this.adresse=text0;
        this.largitude=d;
        this.longitude=c;
        this.etat=i;
    }
   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Entrepot(int longitude, int largitude, String adresse, int etat, int id_utilisateur, String nom) {
        this.longitude = longitude;
        this.largitude = largitude;
        this.adresse = adresse;
        this.etat = etat;
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
    }
    
    

    public Entrepot(int id, int longitude, int largitude, String adresse, int etat, int id_utilisateur) {
        this.id = id;
        this.longitude = longitude;
        this.largitude = largitude;
        this.adresse = adresse;
        this.etat = etat;
        this.id_utilisateur = id_utilisateur;
    }

    public Entrepot(int longitude, int largitude, String adresse, int etat) {
        this.longitude = longitude;
        this.largitude = largitude;
        this.adresse = adresse;
        this.etat = etat;
    }

    public Entrepot(int id, int longitude, int largitude, String adresse, int etat, int id_utilisateur, String nom) {
        this.id = id;
        this.longitude = longitude;
        this.largitude = largitude;
        this.adresse = adresse;
        this.etat = etat;
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;

    }

  

    public Entrepot() {
    }

   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLargitude() {
        return largitude;
    }

    public void setLargitude(int largitude) {
        this.largitude = largitude;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    
    
}
