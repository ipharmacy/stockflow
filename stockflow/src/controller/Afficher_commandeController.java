/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Commande;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class Afficher_commandeController implements Initializable {

    @FXML
    private AnchorPane bp;
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
    private ImageView ModifierBtn;
    @FXML
    private TextField tfrecherchelivreur;
    @FXML
    private Button ajouter;
    @FXML
    private ImageView SupprimerBtn;
    @FXML
    private AnchorPane travailleIci;
      @FXML
    private TableView<Commande> table;
    private TableColumn<Commande, Integer> pr;
      @FXML
    private TableColumn<String, Commande> ColProduit;
    @FXML
    private TableColumn<Integer, Commande> ColQuantite;
    @FXML
    private TableColumn<Float, Commande> PrixUnitaire;
    @FXML
    private TableColumn<Float, Commande> PrixTotal;
    @FXML
    private TableColumn<String, Commande> col_prop;
     @FXML
    private TableColumn<Date, Commande> ColDate;
    @FXML
    private TableColumn<String, Commande> Col_Adresse;
    
     private PreparedStatement pst;
    @FXML
    private ImageView Btn_Ajouter;
      private ObservableList<Commande> c;

    private MaConnection conn;
    private ResultSet rs;
    @FXML
    private Button modif;
    @FXML
    private Button btn_supp;
    @FXML
    private Button expor;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           Image img=new Image("uploads/home.png");
        dp.setImage(img);
          conn = MaConnection.getInstance();
        try {
            ShowCommandes();
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_commandeController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    public boolean UpdateCommande(ActionEvent t) throws SQLException {
        
        try {
            stage = (Stage) modif.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/gui/modifier_commande.fxml"));
            bp= Loader.load();
            //scene = new Scene(root);
//            stage = new Stage();
            stage.setTitle("ADD Commande");
            stage.setScene(new Scene(bp));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Afficher_commandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    

       
    public void ShowCommandes() throws SQLException {
        conn = MaConnection.getInstance();

        try {

            c = FXCollections.observableArrayList();
            String sql = "SELECT * FROM commandes";
            rs = conn.getConnection().createStatement().executeQuery(sql);

            while (rs.next()) {
                conn = MaConnection.getInstance();
                //data.addAll(data);
                c.add(new Commande(rs.getInt("idC"), rs.getDate("Date"), rs.getString("Nom"),rs.getString("proprietaire"),rs.getInt("quantite"),rs.getString("adresse"), rs.getFloat("prixU"), rs.getFloat("prixT")));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        //Col_Id.setCellValueFactory(new PropertyValueFactory<>("IdM"));
        ColProduit.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
        ColQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        PrixUnitaire.setCellValueFactory(new PropertyValueFactory<>("prixU"));
        PrixTotal.setCellValueFactory(new PropertyValueFactory<>("prixT"));
        col_prop.setCellValueFactory(new PropertyValueFactory<>("prop_Commande"));
        ColDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Col_Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        table.setItems(null);
        table.setItems(c);
    }
    
        public ObservableList<Commande> rechercherCommandeParFiltre(String k) throws SQLException {
        conn = MaConnection.getInstance();
        
        Statement stm=conn.getConnection().createStatement();
        String query="SELECT * FROM `commandes` WHERE `proprietaire` like '%"+k+"%' ";
        ResultSet rst=stm.executeQuery(query);
        ObservableList<Commande> cl=FXCollections.observableArrayList();
        Commande c=new Commande();
        while(rst.next()){
            c.setDate(rst.getDate(2));
            c.setQuantite(rst.getInt(3));
            c.setNomProduit(rst.getString(4));
            c.setProp_Commande(rst.getString(5));
            c.setPrixU(rst.getFloat(6));
            c.setPrixT(rst.getFloat(7));
            c.setAdresse(rst.getString(8));
        cl.add(c);
        }
        return cl; 
        
    }
        

    

    @FXML
    public void AddCommande(ActionEvent event) throws SQLException {
        try {
            Stage stage = (Stage) Btn_Ajouter.getScene().getWindow();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/gui/Ajout_commande.fxml"));
            Parent root =(Parent) Loader.load();
            //scene = new Scene(root);
//            stage = new Stage();
            stage.setTitle("ADD Commande");
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Afficher_commandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public boolean DeleteCommande(ActionEvent t) throws SQLException {
              conn = MaConnection.getInstance();

        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        Commande c = (Commande) table.getSelectionModel().getSelectedItem();
        int tempItemTag = c.getId_commande();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Supprimer " + c.getNomProduit()+" De Mr/Mme"+c.getProp_Commande()+ " ?", ButtonType.YES, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                conn = MaConnection.getInstance();
                String sql = "DELETE FROM commandes WHERE idC = ?";
                pst = conn.getConnection().prepareStatement(sql);
                pst.setInt(1, tempItemTag);
                pst.execute();
                table.getItems().remove(selectedIndex);

            }

        }
     return true;
    }
    

   

    @FXML
    private void exporter(ActionEvent event) throws SQLException, IOException {
        try{
        conn = MaConnection.getInstance();
            Statement stmt1 = conn.getConnection().createStatement();
            //Variable counter for keeping track of number of rows inserted.  
            int counter = 1;
            FileOutputStream fileOut = null;
            //sql - query to be executed.  
            String sql = "Select * from commandes";

            //Creation of New Work Book in Excel and sheet.  
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("new sheet");
            //Creating Headings in Excel sheet.  
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell((short) 0).setCellValue("idC");//Row Name1  
            rowhead.createCell((short) 1).setCellValue("nom");//Row Name2  
            rowhead.createCell((short) 2).setCellValue("Date");//Row Name3  
            rowhead.createCell((short) 3).setCellValue("prop_Commande");//Row Name4
            rowhead.createCell((short) 4).setCellValue("prixU");//Row Name5 
            rowhead.createCell((short) 5).setCellValue("prixT");
            rowhead.createCell((short) 6).setCellValue("adresse");
            rowhead.createCell((short) 7).setCellValue("quanité");
            ResultSet rs = stmt1.executeQuery(sql);
            while (rs.next()) {
                //Insertion in corresponding row  
                HSSFRow row = sheet.createRow((int) counter);
                /* Activity, Username, TIME_OF_EVENT are row names  
          * corresponding to table  
          * in related Database. */
                CellStyle dateCellStyle = hwb.createCellStyle();
              
                CreationHelper createHelper = hwb.getCreationHelper();
                //Cell dateOfBirthCell = row.createCell(2);
//            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
//            dateOfBirthCell.setCellStyle(dateCellStyle);
                dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
                row.createCell((short) 0).setCellValue(rs.getInt("idC"));
                row.createCell((short) 1).setCellValue(rs.getString("Nom"));
               // row.createCell((short) 2).setCellValue(rs.getString("description"));

//                row.createCell((short) 3).setCellStyle(dateCellStyle);
//                row.createCell((short) 3).setCellValue(rs.getDate("date"));
                HSSFCell dateOfBirthCell = row.createCell((short) 2);
                dateOfBirthCell.setCellValue(rs.getDate("Date"));
                dateOfBirthCell.setCellStyle(dateCellStyle);

             
                //  row.createCell((short) 4).setCellValue(rs.getTime("time"));
                row.createCell((short) 3).setCellValue(rs.getString("proprietaire"));
                row.createCell((short) 4).setCellValue(rs.getString("prixU"));
                 row.createCell((short) 5).setCellValue(rs.getString("prixT"));
                  row.createCell((short) 6).setCellValue(rs.getString("adresse"));
                   row.createCell((short) 7).setCellValue(rs.getString("quantite"));
                  
                sheet.autoSizeColumn(1);
                sheet.autoSizeColumn(2);
                sheet.setColumnWidth(3, 256 * 25);

                sheet.setZoom(150);
                sheet.autoSizeColumn(1);
                sheet.autoSizeColumn(2);
                sheet.setColumnWidth(3, 256 * 25);

                sheet.setZoom(150);

                counter++;
                try {
                    //For performing write to Excel file  
                    fileOut = new FileOutputStream("commandes.xlsx");
                    hwb.write(fileOut);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //Close all the parameters once writing to excel is compelte.  
            fileOut.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION DIALOG");
            alert.setHeaderText(null);
            alert.setContentText("Liste Commandes exportée sous forme EXCEL.");
            alert.showAndWait();
            rs.close();
            stmt1.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    

        
        
        
        
    
}

    @FXML
    private void Anul(DragEvent event) {
    }

    

    @FXML
    private void rechercheCommande(KeyEvent event) throws SQLException { 
        ObservableList<Commande> arrayList =rechercherCommandeParFiltre(tfrecherchelivreur.getText());
        ObservableList obs = FXCollections.observableArrayList(arrayList);
        table.setItems(obs);
        ColProduit.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
        ColQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        PrixUnitaire.setCellValueFactory(new PropertyValueFactory<>("prixU"));
        PrixTotal.setCellValueFactory(new PropertyValueFactory<>("prixT"));
        col_prop.setCellValueFactory(new PropertyValueFactory<>("prop_Commande"));
        ColDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Col_Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
        
        
    }

   
}