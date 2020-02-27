/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Services.serviceTransaction;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
 * @author Dhia
 */
public class BilanController implements Initializable {

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
    private TextField searchTextField;
    @FXML
    private AnchorPane paneDepense;
    @FXML
    private DatePicker dateDepense;
    @FXML
    private TextArea depenseArea;
    @FXML
    private AnchorPane paneRevenue;
    @FXML
    private DatePicker dateRevenue;
    @FXML
    private TextArea revenueArea;
    @FXML
    private Label tresorerieLabel;
    @FXML
    private TextArea tresorerieArea;
    @FXML
    private DatePicker dateTres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
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
    private void rechercherClientF(KeyEvent event) {
    }

    @FXML
    private void depensesJour(ActionEvent event) {
    }

    @FXML
    private void revenuesJour(ActionEvent event) {
    }

    @FXML
    private void tresorerieJour(ActionEvent event) {
                tresorerieArea.setVisible(true);
        tresorerieLabel.setVisible(true);
                dateTres.setVisible(true);
    }

    @FXML
    private void afficherDepenses(ActionEvent event) throws SQLException {
           float depense=0;
        Services.serviceTransaction st=new serviceTransaction();
        depense=st.depensesParJour(dateDepense.getValue().toString()); 
        depenseArea.setText("Vos depenses pour le jour \n"+dateDepense.getValue()+"sont :"+depense);
    }

    @FXML
    private void afficherRevenues(ActionEvent event) throws SQLException {
        float revenue=0;
        Services.serviceTransaction st=new serviceTransaction();
        revenue=st.revenuesParJour(dateRevenue.getValue().toString()); 
        revenueArea.setText("Vos depenses pour le jour \n"+dateDepense.getValue()+"sont :"+revenue);
    }

    @FXML
    private void dateTT(ActionEvent event) throws SQLException {
        float treso=0;
        Services.serviceTransaction st=new serviceTransaction();
        treso=st.tresorerieParJour(dateTres.getValue().toString()); 
        tresorerieArea.setText("La  depenses pour le jour \n"+dateDepense.getValue()+"sont :"+treso);
    }
    
}
