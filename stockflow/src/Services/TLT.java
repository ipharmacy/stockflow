/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.entrepot1;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.MaConnection;


/**
 *
 * @author Khalil
 */
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

            
 public void supprimer(int id) throws SQLException 
    { 
        System.out.println("tu as bien supprimé");
         ste=con.createStatement();
          
          String q ="delete from location where id="+id;
                
            
        ste.executeUpdate(q);
               System.out.println("tu as bien supprimé");
        
       
    
    
    
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
