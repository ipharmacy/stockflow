/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.entrepot1;
import Services.ControlleSaisie;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class AjoutentrepotalouerController implements Initializable {
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
    private Button LivreurBtn1;
    @FXML
    private TextField prix;
    @FXML
    private TextField surface;
    @FXML
    private TextField disponibilite;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private Button addb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Image img=new Image("uploads/home.png");
        dp.setImage(img);
        ControlleSaisie.estVide(email,email.getText());
                ControlleSaisie.estVide(adresse,adresse.getText());
                        ControlleSaisie.estVide(disponibilite,disponibilite.getText());
                                ControlleSaisie.estVide(surface,surface.getText());
                                        ControlleSaisie.estVide(prix,prix.getText());




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
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
    private void goCommandePage(ActionEvent event) {
    }

    @FXML
    private void goLivraisonPage(ActionEvent event) {
    }

    @FXML
    private void goLivreurPage(ActionEvent event) {
    }



  

    @FXML
    private void goLouer(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
    
         TLT ser = new TLT();
      entrepot1 E=new entrepot1();
        E.setId(0);
          E.setPrix(Integer.valueOf(prix.getText()));
                  E.setSurface(Integer.valueOf(surface.getText()));
        E.setDisponibilite(disponibilite.getText());
         E.setAdresse(adresse.getText());
        E.setEmail(email.getText());
      

        ser.ajouter1(E);
    
    }

   

   
    
    
}
