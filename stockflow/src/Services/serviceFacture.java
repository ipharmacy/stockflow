/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Interfaces.IServiceFacture;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Entity.Facture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnection;

/**
 *
 * @author chihe
 */
public class serviceFacture implements IServiceFacture{
     Connection cnx;
    public serviceFacture()
    {
        cnx=MaConnection.getInstance().getConnection();
    }
    @Override
    public void addFacture(Facture fa) throws SQLException {
        
    Statement stm = cnx.createStatement();
    String query="INSERT INTO `facture` (`idFacture`, `description`, `fraisService`, `idTransaction`, `dateFacture`, `dateLivraison`, `type`) VALUES (NULL, '"+fa.getDescription()+"', '"+fa.getFraisServices()+"', '"+fa.getIdTransaction()+"', '"+fa.getDateFacture()+"', '"+fa.getDateLivraison()+"', '"+fa.getType()+"')" ;
    stm.executeUpdate(query);
    }
    @Override
    public List<Facture> displayFacture() throws SQLException {
         Statement stm=cnx.createStatement();
         String query ="SELECT * FROM `facture`"; 
         ResultSet rst = stm.executeQuery(query);
         ArrayList <Facture> factures = new ArrayList<>();
         while(rst.next())
         {
         Facture fa=new Facture();
         fa.setIdFacture(rst.getInt("idFacture"));
         fa.setDescription(rst.getString("description"));
         fa.setFraisServices(rst.getFloat("fraisService"));
         fa.setIdTransaction(rst.getInt("idTransaction"));
         fa.setDateFacture(rst.getTimestamp("dateFacture"));
         fa.setDateLivraison(rst.getDate("dateLivraison"));
         fa.setType(rst.getString("type"));
         factures.add(fa);
         }
         return factures;
    }
    @Override
    public void updateFacture(Facture fa, int id) throws SQLException {
    Statement stm=cnx.createStatement();
    String query="UPDATE `facture` SET `description` = '"+fa.getDescription()+"', `fraisService` = '"+fa.getFraisServices()+"', `idTransaction` = '"+fa.getIdTransaction()+"', `dateFacture` = '"+fa.getDateFacture()+"', `dateLivraison` = '"+fa.getDateLivraison()+"', `type` = '"+fa.getType()+"' WHERE `idFacture` = '"+id+"';";
    stm.executeUpdate(query);    
        
    }
    @Override
    public void deleteFacture(int id) throws SQLException {
    Statement stm=cnx.createStatement();
    String query="DELETE FROM `facture` WHERE `idFacture` ='"+id+"'";
    stm.executeUpdate(query);
    }
    @Override
    public Facture rechercherFacture(int id) throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `facture` WHERE `idFacture`='"+id+"'";
        ResultSet rst=stm.executeQuery(query);
        Facture fa=new Facture();
        while(rst.next()){
        fa.setIdFacture(rst.getInt("idFacture"));
        fa.setDescription(rst.getString("description"));
        fa.setFraisServices(rst.getFloat("fraisService"));
        fa.setIdTransaction(rst.getInt("idTransaction"));
        fa.setDateFacture(rst.getTimestamp("dateFacture"));
        fa.setDateLivraison(rst.getDate("dateLivraison"));
        fa.setType(rst.getString("type"));  
    }    
         return fa;
}

    @Override
    public List<Facture> triFactureParDate() throws SQLException {
        Statement stm=cnx.createStatement();
        String query="SELECT * FROM `facture` ORDER BY `dateFacture`";
        ResultSet rst = stm.executeQuery(query);
        ArrayList <Facture> factures = new ArrayList<>();
        while(rst.next())
        {
         Facture fa=new Facture();
         fa.setIdFacture(rst.getInt("idFacture"));
         fa.setDescription(rst.getString("description"));
         fa.setFraisServices(rst.getFloat("fraisService"));
         fa.setIdTransaction(rst.getInt("idTransaction"));
         fa.setDateFacture(rst.getTimestamp("dateFacture"));
         fa.setDateLivraison(rst.getDate("dateLivraison"));
         fa.setType(rst.getString("type"));
         factures.add(fa);
        }
        return factures;
    }

    @Override
    public ObservableList<Facture> readAll() throws SQLException {
            ObservableList<Facture> arr=FXCollections.observableArrayList();
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery("select * from `facture`");
        while (rst.next()) {                
        Facture fa=new Facture();
         fa.setIdFacture(rst.getInt("idFacture"));
         fa.setDescription(rst.getString("description"));
         fa.setFraisServices(rst.getFloat("fraisService"));
         fa.setIdTransaction(rst.getInt("idTransaction"));
         fa.setDateFacture(rst.getTimestamp("dateFacture"));
         fa.setDateLivraison(rst.getDate("dateLivraison"));
         fa.setType(rst.getString("type"));
         arr.add(fa);
     }
    return arr;
    }

    @Override
    public ObservableList<Facture> rechercherFactureParFiltre(String k) throws SQLException {
         Statement stm=cnx.createStatement();
        String query="SELECT * FROM `facture` WHERE CONCAT(`idFacture`,`description`,`fraisService`,`idTransaction`,`type`) like '%"+k+"%' ";
        ResultSet rst=stm.executeQuery(query);
        ObservableList<Facture> cl=FXCollections.observableArrayList();
        Facture c=new Facture();
        while(rst.next())
        {
         c.setIdFacture(rst.getInt("idFacture"));
         c.setDescription(rst.getString("description"));
         c.setFraisServices(rst.getFloat("fraisService"));
         c.setIdTransaction(rst.getInt("idTransaction"));
         c.setType(rst.getString("type"));  
         cl.add(c);
        }
        return cl; 
    }


}
