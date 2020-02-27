/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class EkhdemController implements Initializable {

    @FXML
    private AnchorPane nav;
    @FXML
    private TextField adresse;
    @FXML
    private TextArea messageE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Envoi(ActionEvent event) throws AddressException, MessagingException {
          
        System.out.println("preparing to send email ");  
         Properties properties = new Properties() ; 
         properties.put("mail.smtp.auth","true") ; 
         properties.put("mail.smtp.starttls.enable","true") ; 
         properties.put("mail.smtp.host", "smtp.gmail.com") ;
         properties.put("mail.smtp.port", "587") ;
         
      String myAcountEmail="stock.flow10@gmail.com";
      String password ="stockflow123";
         
            Session session ;
            session=Session.getInstance(properties,new Authenticator() {
    protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                                    return new javax.mail.PasswordAuthentication(myAcountEmail, password);
                                }});
  
                            
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(myAcountEmail));
              System.out.println("message envoye avec succees ");
              message.setRecipient(Message.RecipientType.TO,new InternetAddress(adresse.getText()));
              message.setText(messageE.getText()+"\n"+"******veuillez consulter la plateforme employe pour plus d'informations******");
              message.setSubject("tache a faire ");
              Transport.send(message);
              JOptionPane.showMessageDialog(null, "Email sent successfully!"); 
        
        
    }
    
}
