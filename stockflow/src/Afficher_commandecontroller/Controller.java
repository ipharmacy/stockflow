/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Afficher_commandecontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class Controller implements Initializable {

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
    private AnchorPane travailleIci;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> ColProduit;
    @FXML
    private TableColumn<?, ?> ColQuantite;
    @FXML
    private TableColumn<?, ?> PrixUnitaire;
    @FXML
    private TableColumn<?, ?> PrixTotal;
    @FXML
    private TableColumn<?, ?> col_prop;
    @FXML
    private TableColumn<?, ?> ColDate;
    @FXML
    private TableColumn<?, ?> Col_Adresse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void UpdateCommande(ActionEvent event) {
    }

    @FXML
    private void Ajout(ActionEvent event) {
    }

    @FXML
    private void DeleteCommande(ActionEvent event) {
    }

    @FXML
    private void exporter(ActionEvent event) {
    }
    
}
