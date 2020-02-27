/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Categorie;
import Services.ServiceCategorie;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ProduitAjoutCategorieWindowController implements Initializable {

    @FXML
    private AnchorPane nav;
    @FXML
    private Label label;
    @FXML
    private ImageView bg;
    @FXML
    private TextField tnom;
    @FXML
    private TextField id;
    @FXML
    private TextField id_ent;
    @FXML
    private TextField id_util;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
          Services.ServiceCategorie SG = new ServiceCategorie();
        Categorie g1=new Categorie(1,tnom.getText());
        SG.addCategorie(g1);
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
    
}
