/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Department;
import model.entities.Seller;
import model.services.DepartmentService;
import model.services.SellerService;
import models.exceptions.ValidationException;

/**
 *
 * @author Gabriel
 */
public class SellerFormController implements Initializable {

    private Seller entity;
    private SellerService service;
    private DepartmentService departmentService;
    private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private DatePicker dpBirthDate;

    @FXML
    private TextField txtBaseSalary;

    @FXML
    ComboBox<Department> comboBoxDepartment;

    @FXML
    private Label labelErrorName;

    @FXML
    private Label labelErrorEmail;

    @FXML
    private Label labelErrorBirthDate;

    @FXML
    private Label labelErrorBaseSalary;

    @FXML
    private Button btSave;

    @FXML
    private Button btCancel;

    @FXML
    public void onBtsaveAction(ActionEvent event) {
        if (entity == null) {
            throw new IllegalStateException("entity was null");
        }
        if (service == null) {
            throw new IllegalStateException("Service was null");
        }
        try {
            entity = getFormData();
            service.saveOrupdate(entity);
            notifyDataChangeListeners();
            Utils.currentStage(event).close();
        } catch (ValidationException e) {
            setErrorMessages(e.getErros());
        } catch (DbException e) {
            Alerts.showAlert("Error saving object", null, e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void onBtCancelAction(ActionEvent event) {
        Utils.currentStage(event).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeNodes();
    }

    private ObservableList<Department> obsList;

    public void setSeller(Seller entity) {
        this.entity = entity;
    }

    public void setServices(SellerService service, DepartmentService departmentService) {
        this.service = service;
        this.departmentService = departmentService;
    }

    public void subscribeDatachangeListener(DataChangeListener listener) {
        dataChangeListeners.add(listener);
    }

    private void initializeNodes() {
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName, 70);
        Constraints.setTextFieldDouble(txtBaseSalary);
        Constraints.setTextFieldMaxLength(txtEmail, 60);
        Utils.formatDatePicker(dpBirthDate, "dd/MM/yyyy");
        initializeComboBoxDepartment();
    }

    @SuppressWarnings("empty-statement")
    public void updateFormData() {
        if (entity == null) {
            throw new IllegalStateException("entity was null");
        }
        txtId.setText(String.valueOf(entity.getId()));//converter int para String
        txtName.setText(entity.getName());
        txtEmail.setText(entity.getEmail());
        Locale.setDefault(Locale.US);
        txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
        if (entity.getBirthDate() != null) {
            Date input = entity.getBirthDate();
            Instant instant = input.toInstant();
            ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
            LocalDate date = zdt.toLocalDate();
            dpBirthDate.setValue(date);
        }
        if (entity.getDepartment() == null) {
            comboBoxDepartment.getSelectionModel().selectFirst();
        } else {
            comboBoxDepartment.setValue(entity.getDepartment());
        }

    }

    public void loadAssociatedObjects() {
        if (departmentService == null) {
            throw new IllegalStateException("DepartmentService was null");
        }
        List<Department> list = departmentService.findAll();
        obsList = FXCollections.observableArrayList(list);
        comboBoxDepartment.setItems(obsList);
    }

    private Seller getFormData() {
        Seller obj = new Seller();
        ValidationException exception = new ValidationException("validation error");

        obj.setId(Utils.tryPaerseToInt(txtId.getText()));
        if (txtName.getText() == null || txtName.getText().trim().equals("")) {
            exception.addError("name", "Field can't be empty");
        }
        obj.setName(txtName.getText());
        if (txtEmail.getText() == null || txtEmail.getText().trim().equals("")) {
            exception.addError("email", "Field can't be empty");
        }
        obj.setEmail(txtEmail.getText());

        if (dpBirthDate.getValue() == null) {
            exception.addError("birthDate", "Field can't be empty");
        } else {
            Instant instant = Instant.from(dpBirthDate.getValue().atStartOfDay(ZoneId.systemDefault()));
            obj.setBirthDate(Date.from(instant));
        }

        if (txtBaseSalary.getText() == null || txtBaseSalary.getText().trim().equals("")) {
            exception.addError("baseSalary", "Field can't be empty");
        }
        obj.setBaseSalary(Utils.tryPaerseToDouble(txtBaseSalary.getText()));
        obj.setDepartment(comboBoxDepartment.getValue());
        if (exception.getErros().size() > 0) {
            throw exception;
        }
        return obj;
    }

    private void notifyDataChangeListeners() {
        for (DataChangeListener listener : dataChangeListeners) {
            listener.onDataChanged();
        }
    }

    private void setErrorMessages(Map<String, String> error) {
        Set<String> fields = error.keySet();
        labelErrorName.setText(fields.contains("name") ? error.get("name") : "" );
        labelErrorEmail.setText(fields.contains("email") ? error.get("email") : "" );
        labelErrorBirthDate.setText(fields.contains("birthDate") ? error.get("birthDate") : "" );
        labelErrorBaseSalary.setText(fields.contains("baseSalary") ? error.get("baseSalary") : "" );
        
    }

    private void initializeComboBoxDepartment() {
        Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<Department>() {
            @Override
            protected void updateItem(Department item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxDepartment.setCellFactory(factory);
        comboBoxDepartment.setButtonCell(factory.call(null));
    }

}
