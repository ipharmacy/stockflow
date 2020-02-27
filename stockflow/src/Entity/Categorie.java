/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Dhia
 */
public class Categorie {
    private int id;
    private String nom;

    
      public Categorie() {
    }
     public Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    
    
    @Override
    public String toString() {
        return "categorie{" + "id=" + id + ", nom=" + nom + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

   
  
    
}
