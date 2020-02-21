/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class Livreur {
    int id ; 
    float notetotal ;
    String nom,prenom ;
int age, num ; 
String mail ;

    public Livreur(int id, float notetotal, String nom, String prenom, int age, int num, String mail) {
        this.id = id;
        this.notetotal = notetotal;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.num = num;
        this.mail = mail;
    }
    public Livreur(int id, String nom, String prenom, int age, int num, String mail) {
        this.id = id;
        
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.num = num;
        this.mail = mail;
        notetotal=0 ;
    }

    public Livreur(float notetotal, String nom, String prenom, int age, int num, String mail) {
        this.notetotal = notetotal;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.num = num;
        this.mail = mail;
    }

public Livreur( String nom, String prenom, int age, int num, String mail) {
        this.notetotal =0;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.num = num;
        this.mail = mail;
    }
    
    @Override
    public String toString() {
        return "Livreur{" + "id=" + id + ", age=" + age + ", num=" + num + ", notetotal=" + notetotal + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + '}';
    }

    public int getAge() {
        return age;
    }

    public int getNum() {
        return num;
    }

    public String getMail() {
        return mail;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNotetotal(float notetotal) {
        this.notetotal = notetotal;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    

    

    public void setId(int id) {
        this.id = id;
    }

    public void setNotetotal(int notetotal) {
        this.notetotal = notetotal;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public float getNotetotal() {
        return notetotal;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Livreur()
    {
        
    }

    
    
    public Livreur(int id, float notetotal, String nom, String prenom) {
        this.id = id;
        this.notetotal = notetotal;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Livreur( String nom, String prenom) {
        
        this.nom = nom;
        this.prenom = prenom;
    }
    public Livreur( float notetotal, String nom, String prenom) {
       
        this.notetotal = notetotal;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
}
