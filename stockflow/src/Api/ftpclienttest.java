/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Dhia
 */
public class ftpclienttest {
    public static void main(String[] args) {
   
    }
    public static void exportfile(String url,String nom)
    {
         String server = "localhost";
        int port = 21;
        String user = "admin";
        String pass = "123456";
        FTPClient ftpClient=new FTPClient();
         try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
            // APPROACH #1: uploads first file using an InputStream
            File firstLocalFile = new File(url);
            String firstRemoteFile =nom;
            InputStream inputStream = new FileInputStream(firstLocalFile);
 
            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }
 
           
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    
    
    
    }
    }
     public static void importFile(String nom) {
        String server = "localhost";
        int port = 21;
        String user = "admin";
        String pass = "123456";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
 
            // APPROACH #1: using retrieveFile(String, OutputStream)
            String current = new java.io.File( "." ).getCanonicalPath();
            String remoteFile1 = "stockf.png";
           
            File downloadFile1 = new File("C:/Users/Dhia/Desktop/ftp/admin/stockf.png");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();
 
            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }
            else
            {
                System.out.println("erreuuuur");
            }
 
            // APPROACH #2: using InputStream retrieveFileStream(String)
       
 
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
     
}

