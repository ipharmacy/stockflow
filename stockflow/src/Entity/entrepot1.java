/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Khalil
 */
public class entrepot1 {
      int id,surface,prix;
    String adresse,disponibilite,email;

    public entrepot1() {
        this.id=1;
    }

    public entrepot1(String adresse, String email,int surface, int prix) {
        this.surface = surface;
        this.prix = prix;
        this.adresse = adresse;
        this.email = email;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public entrepot1(int id, int surface, int prix, String adresse, String disponibilite, String email) {
        this.id = id;
        this.surface = surface;
        this.prix = prix;
        this.adresse = adresse;
        this.disponibilite = disponibilite;
        this.email = email;
    }
    
    
}
