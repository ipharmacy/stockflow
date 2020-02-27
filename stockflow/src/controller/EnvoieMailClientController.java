/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.net.Authenticator;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.mail.*;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class EnvoieMailClientController implements Initializable {

    @FXML
    private AnchorPane nav;
    @FXML
    private ImageView dp;
    @FXML
    private Button Produitbtn;
    @FXML
    private Button ServiceBtn;
    @FXML
    private Button CommandeBtn;
    @FXML
    private Button LivraisonBtn;
    @FXML
    private Button LivreurBtn;
    @FXML
    private Button modifier;
    @FXML
    private ImageView ModifierBtn;
    @FXML
    private TextField tfrecherchelivreur;
    @FXML
    private Button ajouter;
    @FXML
    private ImageView addBtn;
    @FXML
    private Button supprimer;
    @FXML
    private ImageView SupprimerBtn;
    @FXML
    private Button boutontrierlivreur;
    @FXML
    private AnchorPane paneFinancier;
    @FXML
    private Button Clientsbtn;
    @FXML
    private Button Transactionsbtn;
    @FXML
    private Button Facturesbtn;
    @FXML
    private TextField adresse;
    @FXML
    private TextArea messageE;
    @FXML
    private AnchorPane dd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void GoProduitPage(ActionEvent event) {
    }

    @FXML
    private void GoServiceFinancierPage(ActionEvent event) {
    }

    @FXML
    private void serviceFinancierModules(MouseEvent event) {
    }

    @FXML
    private void goCommandePage(ActionEvent event) {
    }

    @FXML
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
    private void goLivraisonPage(ActionEvent event) {
    }

    @FXML
    private void goLivreurPage(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void rechercher(KeyEvent event) {
    }

    @FXML
    private void Ajout(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void TrierLivreur(ActionEvent event) {
    }


    @FXML
    private void GestClients(ActionEvent event) {
    }

    @FXML
    private void GestTransactions(ActionEvent event) {
    }

    @FXML
    private void GestFactures(ActionEvent event) {
    }

    @FXML
    private void ExitServiceFinancierModules(MouseEvent event) {
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
           session=Session.getInstance(properties,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAcountEmail, password); 
            }
               
});
          
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
