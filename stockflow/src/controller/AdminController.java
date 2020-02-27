/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.User;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AdminController implements Initializable {

    @FXML
    private ImageView dp;
    @FXML
    private Button supprimer;
    @FXML
    private AnchorPane travailleIci;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, Integer> idCellColumn;
    @FXML
    private TableColumn<User,String> prenomCellColumn;
    @FXML
    private TableColumn<User,String> nomCellColulmn;
    @FXML
    private TableColumn<User,String> emailCellColumn;
    @FXML
    private TableColumn<User,String> LoginCellColumn;
    @FXML
    private TableColumn<User,String> mdpCellColumn;
    @FXML
    private TableColumn<User,String> typeCellColumn;
    @FXML
    private TableColumn<User,Integer> telCellColulmn;
    @FXML
    private Button Produitbtn;
    @FXML
    private Button LivreurBtn;
    @FXML
    private AnchorPane nav;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img=new Image("uploads/home.png");
        dp.setImage(img);
        idCellColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
        nomCellColulmn.setCellValueFactory(new PropertyValueFactory<User,String>("nom"));
        prenomCellColumn.setCellValueFactory(new PropertyValueFactory<User,String>("prenom"));
        emailCellColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        LoginCellColumn.setCellValueFactory(new PropertyValueFactory<User,String>("login"));
        mdpCellColumn.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        telCellColulmn.setCellValueFactory(new PropertyValueFactory<User,Integer>("tel"));
        typeCellColumn.setCellValueFactory(new PropertyValueFactory<User,String>("type"));
        
        //phoneColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("tel"));
        try {
            tableView.setItems(getUsers());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableView.setEditable(true);
        nomCellColulmn.setCellFactory(TextFieldTableCell.forTableColumn());
        prenomCellColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCellColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        LoginCellColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mdpCellColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeCellColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    

    private ObservableList<User> getUsers() throws SQLException {
        ServiceUser su=new ServiceUser();
        return su.readAll();
        
    }

    @FXML
    private void Anul(DragEvent event) {
    }

    @FXML
    private void DisplayEntrepots(MouseEvent event) {
    }

    @FXML
   public void changeNom(TableColumn.CellEditEvent edittedCell) throws SQLException{
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setPrenom(edittedCell.getNewValue().toString());
        ServiceUser su=new ServiceUser();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("User Updated!");
         alert.showAndWait();
        
    }
    
    
    
    
    @FXML
    public void changePrenom(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setNom(edittedCell.getNewValue().toString());
        ServiceUser su=new ServiceUser();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("User Updated!");
         alert.showAndWait();
    }
    @FXML
    public void changeEmail(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setEmail(edittedCell.getNewValue().toString());
        ServiceUser su=new ServiceUser();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("User Updated!");
         alert.showAndWait();
            
        
    }
    
    @FXML
    public void changelogin(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setLogin(edittedCell.getNewValue().toString());
        ServiceUser su=new ServiceUser();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("User Updated!");
         alert.showAndWait();
    }
    @FXML
    public void changepassword(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setPassword(edittedCell.getNewValue().toString());
        ServiceUser su=new ServiceUser();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("User Updated!");
         alert.showAndWait();
    }
    @FXML
    public void changetype(TableColumn.CellEditEvent edittedCell) throws SQLException{
        
        User userSelected = tableView.getSelectionModel().getSelectedItem();
        userSelected.setType(edittedCell.getNewValue().toString());
        ServiceUser su=new ServiceUser();
        su.update(userSelected, userSelected.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Update");
         alert.setHeaderText(null);
         alert.setContentText("User Updated!");
         alert.showAndWait();
    }
    
    @FXML
    public void deleteButton() throws SQLException{
        ServiceUser su=new ServiceUser();
        ObservableList<User> selectedRows ,allUsers;
        allUsers =tableView.getItems();
        selectedRows=tableView.getSelectionModel().getSelectedItems();
        
        for(User u:selectedRows){
            su.delete(u.getId());
            allUsers.remove(u);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Delete");
         alert.setHeaderText(null);
         alert.setContentText("User(s) Deleted!");
         alert.showAndWait();
    }
    

    @FXML
    public void logout(ActionEvent event) throws IOException{
        Parent register= FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
        Scene registerScene = new Scene(register);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
        
    } 


    

    
    
}
