/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Livraison;
import IService.IServiceLivraison;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import Utils.DataBase ;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.util.Date ; 


/**
 *
 * @author YOUSSEF BEN FARHAT
 */
public  class ServiceLivraison implements IServiceLivraison<Livraison> {
    private Connection con;
    private Statement ste;

    public ServiceLivraison() {
        con = DataBase.getInstance().getConnection();

    }
    
    @Override
    public void ajouter(Livraison l) {
    
        
        System.out.println("hee");
        
             PreparedStatement ps;
             String query="INSERT INTO `livraison`( `datelivraison`, `time`, `idlivreur`, `nomlivreur`, `prenomlivreur`, `idcommande`, `done`) VALUES (?,?,?,?,?,?,?)";
             
        
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
    ResultSet rs=ste.executeQuery("select * from livraison");
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
        
         public void deleteLivraisonId(int id) throws SQLException
         {
             
          ste = con.createStatement();
        //String requeteInsert = "delete from livreur where idLivreur=?+ ,nom=? ,prenom=?,notetotal=?";
         String requeteInsert = "delete from livraison where idlivraison="+id;
        ste.executeUpdate(requeteInsert); 
       
    
         }
         
         @Override
    public void updateLivraison(Livraison l) throws SQLException {
        
        PreparedStatement pre=con.prepareStatement( "UPDATE livraison SET  datelivraison=?,"
                +" time=?,idlivreur=?,nomlivreur=?,prenomlivreur=?,idcommande=?,done=? WHERE idlivraison=?");
        java.sql.Date sqldate =new java.sql.Date(l.getDatelivraison().getTime());
        Time sqltime =new java.sql.Time(l.getDatelivraison().getTime()) ;
        
        pre.setDate(1, sqldate);
        pre.setTime(2, sqltime);
        pre.setInt(3,l.getIdlivreur());
        pre.setString(4,l.getNomlivreur());
         pre.setString(5, l.getPrenomlivreur());
        pre.setInt(6, l.getIdlivreur());
        pre.setString(7, l.getDone());
       pre.setInt(8,l.getIdlivraison());
       System.out.println(l.getIdlivraison());
      
         pre.executeUpdate();
    }
    


    @Override
    public List<Livraison> trierselondate() throws SQLException {
  List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from livraison order by  datelivraison ASC");
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
     return arr ;
    }
     public List<Livraison> recherLivraisonselondate(java.util.Date n) throws SQLException 
   {
       List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    
    java.sql.Date sqldate =new java.sql.Date(n.getTime()) ;
    ResultSet rs=ste.executeQuery("select * from livraison where datelivraison LIKE '"+sqldate+"%'");
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
    System.out.println(arr) ;
return arr ;
}
     
    
    public List<Livraison> rechercheavance(String nom) throws SQLException {
        List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    
    
    ResultSet rs=ste.executeQuery("select * from livraison where nomlivreur LIKE '%' ||'"+nom+"||'%''");
     while (rs.next()) {                
               int idlivrai=rs.getInt(1);
               java.sql.Date date=rs.getDate(2 );
               java.sql.Time time =rs.getTime(3);
               int idlivreur=rs.getInt(4) ; 
               //String nom=rs.getString(5) ; 
               String prenom=rs.getString(6) ; 
               int idcommande=rs.getInt(7) ; 
               java.util.Date datee =new java.util.Date(date.getTime());
           
               String done=rs.getString(8) ;
               Livraison p=new Livraison(idlivrai,idlivreur, nom,
                        prenom,date,time, idcommande,done) ;
     arr.add(p);
         
     }
    return arr ;}
     
     public void pdflivraison(int id) throws SQLException
     {
         
          List<Livraison> arr=new ArrayList<>();
    ste=con.createStatement();
    
   // java.sql.Date sqldate =new java.sql.Date(n.getTime()) ;
    ResultSet rs=ste.executeQuery("select * from livraison where idlivraison LIKE "+id);
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
     
     try{
        Document document =new Document ();
       PdfWriter.getInstance(document,new FileOutputStream("Livraison num"+id+".pdf"));
      document.open();  
      Paragraph para = new Paragraph();
      
             document.add(Image.getInstance("C:\\Users\\YOUSSEF BEN FARHAT\\Desktop\\esprit\\3A\\projet\\desktop\\Livraison\\src\\images\\stocklogo.png"));    
           
      //para.add("Text 1");
           // para.setAlignment(Element.ALIGN_CENTER);
            //document.add(para);
           Font f = new Font();
             f.setStyle(Font.BOLD);
            f.setSize(25);
           Paragraph p2 = new Paragraph(null,f);
            
         
            
            p2.add(" \n \n \n Date Livraison : "+date+"  "+time+"\n"+"Nom Livreur :"+nom+" "+prenom); //no alignment
            document.add(p2);
            
            document.close(); 
        // TOO code application logic here
    }catch(Exception e)
    {
        System.out.println(e);
    }
     
         
       
     }

    
     }
     
     public void pdftousleslivraison()throws SQLException
     {
       String etat="" ;
         List<Livraison>arr=new ArrayList() ;
    ste=con.createStatement();
   //java.sql.Date sqldate =new java.sql.Date(n.getTime()) ;
   ResultSet rs=ste.executeQuery("SELECT * FROM `livraison`");
   System.out.println("EEEEE");  
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
               
    System.out.println(arr);  

    
     try{
        Document document =new Document ();
       PdfWriter.getInstance(document,new FileOutputStream("Livraison num"+".pdf"));
      document.open(); 
       Font f2 = new Font() ;
            f2.setSize(25);
           
      Paragraph p1=new Paragraph(null,f2);
     p1.add("TOUTES LES COMMANDES ");
p1.setAlignment(Element.ALIGN_CENTER);
      
            document.add(Image.getInstance("C:\\Users\\YOUSSEF BEN FARHAT\\Desktop\\esprit\\3A\\projet\\desktop\\Livraison\\src\\images\\stocklogo.png"));  
       
           Font f = new Font();
             
            f.setSize(10);
           Paragraph p2 = new Paragraph(null,f);
            
         
            for (int i=0;i<arr.size();i++) { 
                if (arr.get(i).getDone().equals("non"))
                    etat="Pas Encore" ;
                else 
                    etat="Validée";
            p2.add(" \n \n \n Date Livraison : "+arr.get(i).getDatelivraison()+
                    "  "+arr.get(i).getTimelivraison()+"\n"+"Nom Livreur :"+arr.get(i).getNomlivreur()+
                    " "+arr.get(i).getPrenomlivreur()+" \n Etat :"+etat); 
           
            
            
             }
            document.add(p1)  ;
            document.add(p2);
            document.close();
        // TOO code application logic here
    }catch(Exception e)
    {
        System.out.println(e);
    }   
       
    }

    /*public void ajouter(Gui.Livraison p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
     }
     


