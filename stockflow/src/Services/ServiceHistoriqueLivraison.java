/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Livraison;
import Interfaces.IServiceHistoriqueLivraison;
import Interfaces.IServiceLivraison;
import utils.MaConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public class ServiceHistoriqueLivraison implements IServiceHistoriqueLivraison<Livraison> {
     private Connection con;
    private Statement ste;

    public ServiceHistoriqueLivraison() {
        con = MaConnection.getInstance().getConnection();

    }
    
    @Override
    public void ajouter(Livraison l) {
    
        
        System.out.println("hee");
        
             PreparedStatement ps;
             String query="INSERT INTO `historique_livraison`( `datelivraison`, `time`, `idlivreur`, `nomlivreur`, `prenomlivreur`, `idcommande`, `done`) VALUES (?,?,?,?,?,?,?)";
             
        
        try {
            ps=con.prepareStatement(query);
          ps.setDate(1, new java.sql.Date(l.getDatelivraison().getTime()));
         ps.setTime(2, new java.sql.Time(l.getTimelivraison().getTime()));
          ps.setInt(3, l.getIdlivreur());
          ps.setString(4, l.getNomlivreur());
          ps.setString(5, l.getPrenomlivreur());
          ps.setInt(6, l.getIdcommande());
          ps.setString(7, l.getDone());
        ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   
        
        
        
        
        
    }
    
    @Override
        public List<Livraison> readAll() throws SQLException
        {
            List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from historique_livraison");
     while (rs.next()) {                
               int idlivrai=rs.getInt(1);
               java.sql.Date date=rs.getDate(2 );
               java.sql.Time time =rs.getTime(3);
               int idlivreur=rs.getInt(4) ; 
               String nom=rs.getString(5) ; 
               String prenom=rs.getString(6) ; 
               int idcommande=rs.getInt(7) ; 
               java.util.Date datee =new java.util.Date(date.getTime());
              
               String done=rs.getString(8) ;
               Livraison p=new Livraison(idlivrai,idlivreur, nom,
                        prenom,date,time, idcommande,done) ;
               
     arr.add(p);
     }
    return arr;
        }
        
}
