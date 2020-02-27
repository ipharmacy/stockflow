/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Entrepot;
import Interfaces.IServiceEntrepot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import utils.MaConnection;

/**
 *
 * @author Khalil
 */
public class ServiceEntrepot  implements IServiceEntrepot {
    
     private Connection con;
    private Statement ste;
    
    
      public ServiceEntrepot(){
        con = MaConnection.getInstance().getConnection();
    }
     public int recupid(String nom) throws SQLException{
               int index = 2;  
               int id;

     try {
            // TODO
           
            
            ResultSet rs =  con.createStatement().executeQuery("SELECT id FROM entrepot where nom=?"+nom);
            while(rs.next()) {
             
                 nom=rs.getString(nom);
                 id=rs.getInt("id");
       
       
        index++;
        
        return id;
            }}
    
         catch (SQLException ex) {
             System.out.println("hhhhhhhhhhhhhhhhhh");}
         return 0;
     } 
    
     public void ajouter(Entrepot t) throws SQLException
    {
 ste = con.createStatement();
        System.out.println("nooooooooooooooooooo");
        String requeteInsert = "INSERT INTO gestion_entrepot.`entrepot` (id, longitude, largitude, adresse,`etat`,`id_utilisateur`,`nom`) VALUES (NULL, '" + t.getLongitude() + "', '" + t.getLargitude() + "', '" + t.getAdresse() + "', '" + t.getEtat()+ "', '" + t.getId_utilisateur() + "', '" + t.getNom() + "');";
        ste.executeUpdate(requeteInsert);
    }
     
     
    
       
     public boolean update(Entrepot t,int id) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "UPDATE `gestion_entrepot`.`entrepot` SET `nom` ='"+t.getNom()+"',`longitude` ='"+t.getLongitude()+"', `largitude`='"+t.getLargitude()+"',`adresse`='"+t.getAdresse()+"' WHERE `id`="+id+" ; ";
        int x=ste.executeUpdate(requeteInsert);
        return x == 0;
    }

 public void delete(int Etat) throws SQLException 
    { 
        System.out.println("tu as bien supprimé");
         ste=con.createStatement();
          
          String q ="delete from entrepot where Etat="+Etat;
                
            
        ste.executeUpdate(q);
               System.out.println("tu as bien supprimé");
        
       
    
    
    
    }

     public ObservableList readAll() throws SQLException {
        ObservableList<Entrepot> arr=FXCollections.observableArrayList();
             System.out.println("eee");
        ste=con.createStatement();

    ResultSet rs=ste.executeQuery("select * from entrepot");
     while (rs.next()) {                
              int id=rs.getInt(1);
               int longitude=rs.getInt(2);
               int largitude=rs.getInt(3);
               String adresse=rs.getString(4);
               int  etat=rs.getInt(5);
               int id_utilisateur=rs.getInt(6);
               String nom=rs.getString(7);

               
               Entrepot p=new Entrepot( id, longitude, largitude, adresse, etat,id_utilisateur,nom);
     arr.add(p);
     }
    return arr;
    }
    
    
    
 
    @Override
    public boolean delete(Entrepot t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Entrepot t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      public ObservableList<String> getEnt() throws SQLException {
        Statement stm = con.createStatement();
        String query = "select * from `entrepot`";
        ResultSet rst = stm.executeQuery(query);
          ObservableList<String> Categories =FXCollections.observableArrayList();
        while (rst.next()) {
            String p = new String();
           
            p=rst.getString("nom");
           
            Categories.add(p);
        }
     return Categories;
    }
         public int SearchCategorie(String chara) {
    String req="select * from entrepot where nom  LIKE '"+chara+"%'" ;
    int id1 = 0;
        try {
            Statement stm=con.createStatement();
            ResultSet rst=stm.executeQuery(req); 
            
     while(rst.next()) 
    { 
        id1=rst.getInt("id");
    }
        } catch (SQLException ex) {
            System.out.println("pas de produit trouvé");
        }
        return id1;
    }
  
    
}
