package org.example.abstractemployee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class EmployeeController {
    @FXML
    private TextField NameField;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> columnName;

    @FXML
    private TableColumn<Employee, EmployeeType> columnType;

    @FXML
    private TableColumn<Employee, Double> columnSalary;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCalculateSalary;

    @FXML
    private RadioButton buttonContractor;

    @FXML
    private RadioButton buttonFullTime;

    @FXML
    private RadioButton buttonPartTime;

    @FXML
    private TextField fieldSalary;

    @FXML
    private Text hoursText;

    @FXML
    private TextField hoursField;

    @FXML
    private Text wageText;

    @FXML
    private TextField wageField;

    @FXML
    private ToggleGroup type;

    // Observable list to manage employee data
    private final ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        employeeTable.setItems(employeeList);

        // Set up radio button listener
        type.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                handleRadioButtonSelection(((RadioButton) newValue).getText());
            }
        });

        handleRadioButtonSelection(buttonFullTime.getText());
    }

    @FXML
    private void onAddEmployee() {
        String name = NameField.getText();
        String selectedType = ((RadioButton) type.getSelectedToggle()).getText();

        if (name.isEmpty()) {
            fieldSalary.setText("Name is required");
            return;
        }

        Employee employee = null;
        switch (selectedType) {
            case "Full-Time":
                employee = new FullTime(name);
                break;
            case "Part-Time":
                try {
                    double hourlyRate = Double.parseDouble(wageField.getText().trim());
                    double hoursWorked = Double.parseDouble(hoursField.getText().trim());
                    employee = new PartTime(name, hourlyRate, hoursWorked);
                } catch (NumberFormatException e) {
                    fieldSalary.setText("Invalid wage or hours");
                    return;
                }
                break;
            case "Contractor":
                try {
                    double hourlyRate = Double.parseDouble(wageField.getText().trim());
                    double hoursWorked = Double.parseDouble(hoursField.getText().trim());
                    employee = new Contractor(name, hourlyRate, hoursWorked);
                } catch (NumberFormatException e) {
                    fieldSalary.setText("Invalid wage or hours");
                    return;
                }
                break;
            default:
                fieldSalary.setText("Invalid Type");
                return;
        }

        if (employee != null) {
            employee.setSalary(employee.calculateSalary());
            employeeList.add(employee);
            clearFields();
        }
    }

    @FXML
    private void onCalculateSalary() {
        String selectedType = ((RadioButton) type.getSelectedToggle()).getText();

        double calculatedSalary = 0.0;

        switch (selectedType) {
            case "Full-Time":
                calculatedSalary = 50000;
                break;
            case "Part-Time", "Contractor":
                try {
                    double hoursWorked = Double.parseDouble(hoursField.getText().trim());
                    double hourlyRate = Double.parseDouble(wageField.getText().trim());
                    calculatedSalary = hoursWorked * hourlyRate;
                } catch (NumberFormatException e) {
                    fieldSalary.setText("Invalid wage or hours");
                    return;
                }
                break;
            default:
                fieldSalary.setText("Invalid Type Selected");
                return;
        }

        fieldSalary.setText(String.format("%.2f", calculatedSalary));
    }

    private void handleRadioButtonSelection(String selectedType) {
        switch (selectedType) {
            case "Full-Time":
                hoursText.setVisible(false);
                hoursField.setVisible(false);
                wageText.setVisible(false);
                wageField.setVisible(false);
                break;
            case "Part-Time", "Contractor":
                hoursText.setVisible(true);
                hoursField.setVisible(true);
                wageText.setVisible(true);
                wageField.setVisible(true);
                break;
        }
    }

    private void clearFields() {
        NameField.clear();
        fieldSalary.clear();
        hoursField.clear();
        wageField.clear();
    }
}
