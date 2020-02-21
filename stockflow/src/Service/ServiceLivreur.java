/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;



import Entity.Livreur;

import IService.IService;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase ;
import Entity.Rating;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ServiceLivreur  implements IService<Livreur> {

    private Connection con;
    private Statement ste;

    public ServiceLivreur() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Livreur t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `gestion_entrepot`.`livreur` (`idlivreur`,`nom`, `prenom`,`age`,`numero`,`mail` ,`notetotal`) VALUES (NULL,  '" + t.getNom() + "', '"
                + t.getPrenom()+ "','"+t.getAge()+"','"+t.getNum()+"','"+t.getMail()+"','"+ 0+ "');";
        
        
        ste.executeUpdate(requeteInsert);
        System.out.print("ajouté");
    }

    public Livreur getLivreur(int id)throws SQLException 
    {
        
	String req = "SELECT * FROM `livreur` WHERE idlivreur = " + id;
	ste = con.createStatement();
	ResultSet rs = ste.executeQuery(req);
	if(rs.next()){
            return new Livreur(rs.getInt(1), rs.getFloat(4), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
        }
	return null;
    }
    
    
   /* public void delete(Livreur t) throws SQLException {
         ste = con.createStatement();
        String requeteInsert = "delete from livreur where idlivreur="+ t.getId() ;
        ste.executeUpdate(requeteInsert); 
        
    }*/
    @Override
    public void deleteId (int id)throws SQLException {
          ste = con.createStatement();
        String requeteInsert = "delete from livreur where idlivreur="+id ;
        ste.executeUpdate(requeteInsert); 
    }
    @Override
     public void delete (Livreur l)throws SQLException {
          ste = con.createStatement();
        //String requeteInsert = "delete from livreur where idLivreur=?+ ,nom=? ,prenom=?,notetotal=?";
         String requeteInsert = "delete from livreur where idlivreur="+l.getId();
        ste.executeUpdate(requeteInsert); 
       
    }
    

    @Override
    public void update(Livreur t) throws SQLException {
        
        PreparedStatement pre=con.prepareStatement( "UPDATE livreur SET nom=?, prenom=?,age=?,numero=?,mail=?"
                +"  WHERE idlivreur=?");
        
        pre.setString(1, t.getNom());
        pre.setString(2, t.getPrenom());
        pre.setInt(3, t.getAge()) ; 
        pre.setInt(4, t.getNum()) ; 
        pre.setString(5, t.getMail()) ;
        
        pre.setInt(6, t.getId()) ; 
      System.out.println("eeeeeeeeee");
        pre.executeUpdate();
    }
    
    

    @Override
   public List<Livreur> readAll() throws SQLException {
    List<Livreur> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livreur");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt(4);
               int num=rs.getInt(5);
               String mail=rs.getString(6);
               float note=rs.getInt(7);
               Livreur p=new Livreur(id,note, nom, prenom,age,num,mail);
     arr.add(p);
     }
    return arr;
    }
   
   public List<Livreur> trierselonnote() throws SQLException 
   {
       List<Livreur> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livreur order by  notetotal DESC");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt(4);
               int num=rs.getInt(5);
               String mail=rs.getString(6);
               float note=rs.getInt(7);
               Livreur p=new Livreur(id,note, nom, prenom,age,num,mail);
     arr.add(p);
     
     }
    return arr;
   }
   
    @Override
   public void rechercher(String n)throws SQLException
   {
       ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livreur where nom="+n) ;
    
   }
    
   public List<Livreur> recher(String n) throws SQLException 
   {
       List<Livreur> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livreur where nom LIKE '"+n+"%'");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String nom=rs.getString("nom");
               String prenom=rs.getString(3);
               int age=rs.getInt(4);
               int num=rs.getInt(5);
               String mail=rs.getString(6);
     float note=rs.getInt(7);
               Livreur p=new Livreur(id,note, nom, prenom,age,num,mail);
     arr.add(p);
     System.out.println(arr) ;
   }
   
return arr ;
}

   
    
    public void updateNote(int id) throws SQLException
    {
        List<Float> arr=new ArrayList<>();
    ste=con.createStatement();
    int i=0 ;
    float note=0,notefinal=0 ;
    ResultSet rs=ste.executeQuery("select * from rating where idlivreur="+id);
               
        while (rs.next()) {                
               float noterating=rs.getFloat(3);
               
              System.out.println(noterating);
     arr.add(noterating);
     }
            for(int j=0; j< arr.size(); j++)
            {
                note=note+arr.get(j) ; 
                i++ ;
                System.out.println(i);
            }
        
     notefinal=note/i ;
     System.out.println(notefinal);
     
     PreparedStatement pre=con.prepareStatement( "UPDATE livreur SET  notetotal= ?  WHERE idlivreur=?") ; 
      pre.setFloat(1,notefinal);
        pre.setInt(2,id);
         pre.executeUpdate();
     
             
    }
    
     public void updateNote2(int id) throws SQLException
    {
        
        List<Float> arr=new ArrayList<>();
    ste=con.createStatement();
    
    float note=0,notefinal=0 ;
    ResultSet rs=ste.executeQuery("select AVG(note) from rating where idlivreur="+id);
                
        while (rs.next()) {                
               float noterating=rs.getFloat(1);
               note=noterating ;
               System.out.println("eeee");
              System.out.println(noterating);
     arr.add(noterating);
     }
        PreparedStatement pre=con.prepareStatement( "UPDATE livreur SET  notetotal= ?  WHERE idlivreur=?") ; 
         pre.setFloat(1,note);
        pre.setInt(2,id);
         pre.executeUpdate();
        
         
    }

    
    
}

    

