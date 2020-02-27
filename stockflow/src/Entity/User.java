/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Omar
 */
public class User {
    private int id,tel;
    private String type,nom,prenom,email,login,password;

    public User( String nom, String prenom, String email, String login, String password, int tel) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.password = password;
        this.tel = tel;
    }

    public User(int id, String nom, String prenom, String email, String login, String password,String type ,int tel) {
        this.id = id;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.password = password;
        this.type=type;
    }

    

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    @Override
    public String toString() {
        return "User{tel=" + tel + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login + ", password=" + password + '}';
    }

    public int getId() {
        return id;
    }

    public int getTel() {
        return tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
}
