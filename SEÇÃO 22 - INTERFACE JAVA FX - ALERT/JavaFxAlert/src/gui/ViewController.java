
package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


public class ViewController {
    @FXML
    private Button btTest; //declarando o botão do FXML
    
    @FXML
    public void onBtTestAction(){
        Alerts.showAlert("Alert title", "Alert header", "Hello", AlertType.ERROR);
    }
}
