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
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import static javafx.scene.input.KeyCode.T;
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
        loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }
    
    @FXML
    public void onMenuItemAboutAction(){
        loadView("/gui/About.fxml", x -> {});
    }
    
 
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
    }
    //synchronized garante que não seja interrompido durante o multi threading
    private synchronized <T>void loadView(String absolutName, Consumer<T> initializingAction){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
            VBox newVbox = loader.load();
            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVbox.getChildren());
            T controller = loader.getController();
            initializingAction.accept(controller);
        } catch (IOException e) {
            Alerts.showAlert("Io Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
    
    
    
}
