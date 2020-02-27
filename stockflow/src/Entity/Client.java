/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javafx.scene.control.CheckBox;

/**
 *
 * @author chihe
 */
public class Client {
    private int idClient;

    public int getIdClient() {
        return idClient;
    }
    
    private String nomClient;
    private String email; 
    private int tel;
    private CheckBox ch_box;

    public CheckBox getCh_box() {
        return ch_box;
    }

    public void setCh_box(CheckBox ch_box) {
        this.ch_box = ch_box;
    }

    public Client(int idClient, String nomClient, String email, int tel) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.email = email;
        this.tel = tel;
        this.ch_box=new CheckBox();
    }

    public Client(String nomClient, String email, int tel, CheckBox ch_box) {
        this.nomClient = nomClient;
        this.email = email;
        this.tel = tel;
    }

 

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", nomClient=" + nomClient + ", email=" + email + ", tel=" + tel + '}';
    }
    
    
    public Client(String nomClient, String email, int tel) {   
        this.nomClient = nomClient;
        this.email = email;
        this.tel = tel;
    } 
    
    public String getNomClient() {
        return nomClient;
    }
    
    public void setIdClient(int idClient)
    {
        this.idClient=idClient;
    }
            
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }  
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    } 
    
    public int getTel() {
        return tel;
    }
    
    public void setTel(int tel) {
        this.tel = tel;
    }
    
    
}
