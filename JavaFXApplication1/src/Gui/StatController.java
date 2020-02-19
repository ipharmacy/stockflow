/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Livreur;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author YOUSSEF BEN FARHAT
 */
public class StatController implements Initializable {

    @FXML
    private BarChart<?, ?> noteschart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void best(List<Livreur> list)
    {
        System.out.println(list.size()) ;
       
         XYChart.Series set1 =new XYChart.Series<String,Float>() ;
        for (int i=0 ;i<list.size();i++)
        {
            // set1.getData().add(new XYChart.Data("fffffff",1));
            // System.out.println(list.get(i).getNotetotal());
             String p=list.get(i).getNom()+" "+list.get(i).getPrenom();
            set1.getData().add(new XYChart.Data(p,list.get(i).getNotetotal()));
              noteschart.getData().addAll(set1) ;
        }
    }
    
}
