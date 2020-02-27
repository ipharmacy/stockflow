/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Entrepot;
import Entity.entrepot1;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import utils.MaConnection;

class TLT {
    
    private Connection con;
    private Statement ste;

    public TLT() {
        con = MaConnection.getInstance().getConnection();

    }

  
    public void ajouter1(entrepot1 E) throws SQLException
    {
   PreparedStatement ps = con.prepareStatement("insert into location values(?,?,?,?,?,?)");
                    
                        
                       
                        ps.setInt(1,E.getId());
			ps.setInt(2,E.getPrix());
                        ps.setInt(3,E.getSurface());
                        ps.setString(4,E.getDisponibilite());
                        ps.setString(5,E.getAdresse());
                        ps.setString(6,E.getEmail());
                       
                       
                        ps.executeUpdate();
    }
     public void modifier(String email, String disponibilite) throws SQLException {
       try {
            
            String req = "update location set disponibilite=? where email=? ";
            PreparedStatement pre = con.prepareStatement(req); 
            pre.setString(1, disponibilite);
            pre.setString(2,email);
            pre.executeUpdate();
            
        } catch (SQLException ex) {
          
        }
    }

     
       public boolean update(entrepot1 t,int id) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "UPDATE `gestion_entrepot`.`location` SET `adresse` ='"+t.getAdresse()+"',`disponibilite` ='"+t.getDisponibilite()+"', `email`='"+t.getEmail()+"' WHERE `id`="+id+" ; ";
        int x=ste.executeUpdate(requeteInsert);
        return x == 0;
    }
            
public boolean delete(int id) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "DELETE FROM `location` WHERE `id`="+id+";";
        int x=ste.executeUpdate(requeteInsert);
        return x == 0;
    }
 
  public ObservableList readAll() throws SQLException {
        ObservableList<entrepot1> arr=FXCollections.observableArrayList();
             System.out.println("eee");
        ste=con.createStatement();

    ResultSet rs=ste.executeQuery("select * from location");
     while (rs.next()) {                
              int id=rs.getInt(1);
               int prix=rs.getInt(2);
               int surface=rs.getInt(3);
               String disponibilite=rs.getString(4);
               String adresse=rs.getString(5);
               String email=rs.getString(6);           

               
               entrepot1 p=new entrepot1( id, prix, surface, disponibilite,adresse,email);
     arr.add(p);
     }
    return arr;
    }
 
  public String sendSms() {
		
			
	try {
  	String apiKey = "apikey=" + "oOJQEXEdvDQ-mV1RFHR3n4uxiF84fLlPjwwCa7k3wS	";
			String message = "&message=" + "This is your message";
			String sender = "&sender=" + "khalil";
			String numbers = "&numbers=" + "21622668152";
    
   // Send data
   HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
   String data = apiKey + numbers + message + sender;
   conn.setDoOutput(true);
   conn.setRequestMethod("POST");
   conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
   conn.getOutputStream().write(data.getBytes("UTF-8"));
   final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
   final StringBuffer stringBuffer = new StringBuffer();
   String line;
   while ((line = rd.readLine()) != null) {
    //stringBuffer.append(line);
    JOptionPane.showMessageDialog(null, "message"+line);
   }
   rd.close();
    
   //return stringBuffer.toString();
  } catch (HeadlessException | IOException e) {
   //System.out.println("Error SMS "+e);
    JOptionPane.showMessageDialog(null, e);
 
        
    //return "Error"+e;

 
      }  System.out.println("buhbvhyv");return "ssss";
}
    
}

