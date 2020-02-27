/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class Ajout_commandeController implements Initializable {

    @FXML
    private AnchorPane nav;
    @FXML
    private ImageView dp;
    @FXML
    private AnchorPane travailleIci;
    @FXML
    private Text Quantite;
    @FXML
    private TextField quantite_Tf;
    @FXML
    private TextField PrixTotale_Tf;
    @FXML
    private Text Adresse;
    @FXML
    private Text Nom_Produit;
    @FXML
    private TextField nom_Produit_Tf;
    @FXML
    private TextField Adresse_Tf;
    @FXML
    private TextField prop_Tf;
    @FXML
    private Text Adresse1;
    @FXML
    private TextField Prix_Unitaire_Tf;
    private PreparedStatement pst;
    private MaConnection conn;
    @FXML
    private Button acc;
    @FXML
    private Button affiche;
    @FXML
    private Button btn_cancel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    conn = MaConnection.getInstance();
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
    }    

  
    @FXML
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
    private void AddCommande(ActionEvent event) throws SQLException {
        conn = MaConnection.getInstance();
        String sql = "insert into commandes (quantite,Nom,proprietaire,prixT,prixU,adresse,Date) values (?,?,?,?,?,?,?)";

        String name = nom_Produit_Tf.getText();
        int quantite = Integer.valueOf(quantite_Tf.getText());
        String prop = prop_Tf.getText();
        float prixt = Float.valueOf(PrixTotale_Tf.getText());
        String adresse = Adresse_Tf.getText();
        float prixU = Float.valueOf(Prix_Unitaire_Tf.getText());
        Date d=java.sql.Date.valueOf(LocalDate.now());
                

        try {
            pst = conn.getConnection().prepareStatement(sql);
            pst.setInt(1, quantite);
            pst.setString(2, name);
            pst.setString(3, prop);
            pst.setFloat(4, prixU);
            pst.setFloat(5, prixt);
            pst.setString(6, adresse);
            pst.setDate(7, d);
            int i = pst.executeUpdate();
            if (i == 1) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION DIALOG");
                alert.setHeaderText(null);
                alert.setContentText("Commande ajoutée avec succèes");
                alert.showAndWait();

            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        pst.close();
    }

    @FXML
    private void affiche(ActionEvent event) throws IOException {
         AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/afficher_commande.fxml"));
        nav.getChildren().setAll(ach);
    }

    @FXML
    private void Cancel(ActionEvent event) throws IOException {
            AnchorPane ach=FXMLLoader.load(getClass().getResource("/gui/afficher_commande.fxml"));
        nav.getChildren().setAll(ach);
    }
    
}
