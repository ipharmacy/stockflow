/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class Modifier_commandeController implements Initializable {

    @FXML
    private ImageView dp;
    @FXML
    private Button acc;
    @FXML
    private Button affiche;
    @FXML
    private Button btn_cancel;
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
    @FXML
    private TextField idC_Tf;
      private MaConnection conn;
    private PreparedStatement pst;
    @FXML
    private AnchorPane nav;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         conn=MaConnection.getInstance();
      idC_Tf.setVisible(false);

    }    

    @FXML
    private boolean UpdateCommande(ActionEvent event) {
        try {
          conn = MaConnection.getInstance();

            String sql = "update commandes set quantite=?,Nom=?,adresse=?,Date=?,prixU=?,prixT=?,proprietaire=? where idC=?";

            pst = conn.getConnection().prepareStatement(sql);
              
            pst.setString(1, quantite_Tf.getText());
            pst.setString(2, nom_Produit_Tf.getText());
            pst.setString(3, Adresse_Tf.getText());
            pst.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            pst.setFloat(5, Float.valueOf(Prix_Unitaire_Tf.getText()));
            pst.setFloat(6, Float.valueOf(PrixTotale_Tf.getText()));
            pst.setString(7, prop_Tf.getText());
            pst.setString(8, idC_Tf.getText());

           
            if (quantite_Tf.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("INFORMATION DIALOG");
            alert.setHeaderText(null);
            alert.setContentText("Champ vide");
            alert.showAndWait();
            
            }else  
                pst.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION DIALOG");
            alert.setHeaderText(null);
            alert.setContentText("Commande modifiée");
            alert.showAndWait();


        } catch (SQLException ex) {

            System.err.println(ex);
        }
        return true;
    }

    @FXML
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
         Stage stage = (Stage) affiche.getScene().getWindow();
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/gui/Afficher_commande.fxml"));
        Parent root = (Parent) Loader.load();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void Cancel(ActionEvent event) throws IOException {
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage s1 = new Stage();
        FXMLLoader L = new FXMLLoader();
        Pane root = L.load(getClass().getResource("/gui/Afficher_commande.fxml"));
        Scene c = new Scene(root);

        s1.setScene(c);
    }
    
}
