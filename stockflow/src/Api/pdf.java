/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dhia
 */
public class pdf {
        public static void main(String args[]) throws Exception 
    {
        Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:\\Users\\Dhia\\Desktop\\pii\\Final_Project\\Stockflow\\historique.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(2);
       table.addCell("id");
       table.addCell("description");
      


       
       
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_entrepot", "root", "");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("Select * from historique_produit ");
       while(rs.next()){
       table.addCell(rs.getString("id"));
       table.addCell(rs.getString("description"));
      

       }
       document.add(table);
       document.close();
   }
    }
