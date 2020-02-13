
package Service;

import entite.Rating;
import IService.IServiceRating;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase ;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public class ServiceRating implements IServiceRating {
    private Connection con;
    private Statement stee;
    
    public ServiceRating() {
        con=DataBase.getInstance().getConnection();
    }
    

public Rating getRating(int idrating)throws SQLException  
{
    String req = "SELECT * FROM `rating` WHERE idrating = " + idrating;
	stee = con.createStatement();
	ResultSet rs = stee.executeQuery(req);
	if(rs.next()){
            return new Rating(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getString(5));
        }
	return null;
}
    @Override
     public void ajouter(Rating r) throws SQLException {      
        stee = con.createStatement();
        String requeteInsert = "INSERT INTO `livraisons`.`rating` (`idrating`,`idlivreur`, `note`,`iduser` ,`commentaire`  ) VALUES (NULL,  '" + r.getIdlivreur()+ "', '" + r.getNote()+"', '"+r.getIduser()+"', '"+r.getCommentaire()+ "');";
        
        stee.executeUpdate(requeteInsert);
        System.out.print("ajouté rating");
    }
     
    
     public void ajouter2(Rating r) throws SQLException {      
         List<Integer> arr=new ArrayList<>();
    stee=con.createStatement();
    
    int i ;
    ResultSet rs=stee.executeQuery("select * from rating where iduser="+r.getIduser());
     
               System.out.println("ID USER :"+r.getIduser());
               
        while (rs.next()) {                
               i=rs.getInt(1);
               
               System.out.println("deja noté");
              
               arr.add(i);
        }
               for(int j=0; j< arr.size(); j++)
            {
           
               
                System.out.println(j);
            }
     if (arr.size()==0){
         
     
         
         stee = con.createStatement();
        String requeteInsert = "INSERT INTO `livraisons`.`rating` (`idrating`,`idlivreur`, `note`,`iduser` ,`commentaire`  ) VALUES (NULL,  '" + r.getIdlivreur()+ "', '" + r.getNote()+"', '"+r.getIduser()+"', '"+r.getCommentaire()+ "');";
        
        stee.executeUpdate(requeteInsert);
        System.out.print("ajouté rating");
     }
    }
     

    

    

    @Override
    public List<Rating> readAll() throws SQLException {
        List<Rating> arr=new ArrayList<>();
        System.out.println("SALUT") ;
    stee=con.createStatement();
    
    ResultSet rs;
        rs = stee.executeQuery("SELECT * FROM `rating`");
    
    
     while (rs.next()) {  
         Rating p=new Rating() ;
               p.setIdrating(rs.getInt(1));
               p.setIdlivreur(rs.getInt(2)) ; 
               p.setNote(rs.getInt(3)) ;
     arr.add(p);
     }
     
    return arr;
    }
    
    public void deleteRatingId(int id) throws SQLException
    {
         stee = con.createStatement();
        String requeteInsert = "delete from rating where idrating="+id ;
        stee.executeUpdate(requeteInsert); 
    }
    
     public void updateRating(Rating l) throws SQLException {
     PreparedStatement pre=con.prepareStatement( "UPDATE rating SET idlivreur=?, note=?,iduser=?,commentaire=? WHERE idlivreur=?");
                
        
        pre.setInt(1, l.getIdlivreur());
        pre.setInt(2, l.getNote());
        pre.setInt(3, l.getIduser()) ; 
        pre.setString(4, l.getCommentaire()) ; 
          pre.setInt(5, l.getIdlivreur()) ;
        
       
        pre.executeUpdate();
     }

    
    }

    

