package com.example.mvcapplication.views;


import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.models.Employee;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class EmployeeView extends VBox {
    private final TableView<Employee> tableView;
    private final EmployeeController controller;

    public EmployeeView(EmployeeController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();
        this.createTable();
        this.getChildren().add(tableView);
        this.bindTableData();
    }

    private void createSearchBar(){
        Label searchlabel = new Label("First Name");
        this.getChildren().add(searchlabel);

        TextField searchTextField = new TextField();
        this.getChildren().add(searchTextField);

        Button searchBtn = new Button("Search");
        HBox searchbox = new HBox(10);
        searchbox.getChildren().addAll(searchlabel,searchTextField, searchBtn);
        this.getChildren().add(searchbox);

        searchBtn.setOnAction(event ->{
            String firstName = searchTextField.getText();
            if (firstName == null) firstName = "";

            ObservableList<Employee> searchFirstName = FXCollections.observableArrayList();

            for (Employee emp : controller.getEmployees()) {
                String empName = String.valueOf(emp.firstNameProperty().get());
                if (empName.equalsIgnoreCase(firstName)) {
                    searchFirstName.add(emp);
                    tableView.setItems(searchFirstName);
                    break;
                }
                tableView.setItems(controller.getEmployees());
            }
        });
    }

    private void createTable() {
        TableColumn<Employee, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, Double> salaryCol = new TableColumn<>("Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, salaryCol);

    }

    private void bindTableData() {
        tableView.setItems(controller.getEmployees());
    }
}