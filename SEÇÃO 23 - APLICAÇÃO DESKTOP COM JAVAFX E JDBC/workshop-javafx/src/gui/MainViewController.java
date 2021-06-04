/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application.Main;
import gui.util.Alerts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

/**
 *
 * @author Gabriel
 */
public class MainViewController implements Initializable{
    @FXML
    private MenuItem menuItemSeller;
    
    @FXML
    private MenuItem menuItemDepartment;
    
    @FXML
    private MenuItem menuItemAbout;
    
    @FXML
    public void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }
    
    @FXML
    public void onMenuItemDepartmentAction(){
        loadView2("/gui/DepartmentList.fxml");
    }
    
    @FXML
    public void onMenuItemAboutAction(){
        loadView("/gui/About.fxml");
    }
    
 
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
    }
    //synchronized garante que não seja interrompido durante o multi threading
    private synchronized void loadView(String absolutName){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
        try {
            VBox newVbox = loader.load();
            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVbox.getChildren());
        } catch (IOException e) {
            Alerts.showAlert("Io Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
    
    private synchronized void loadView2(String absolutName){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
        try {
            VBox newVbox = loader.load();
            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVbox.getChildren());
            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        } catch (IOException e) {
            Alerts.showAlert("Io Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
    
}
