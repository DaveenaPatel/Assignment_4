package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.models.Department;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class DepartmentView extends VBox {
    private final TableView<Department> tableView;
    private final DepartmentController controller;

    public DepartmentView(DepartmentController controller) {
        this.controller = controller;
        this.tableView = new TableView<>();
        this.createTable();
        this.getChildren().add(tableView);
        this.bindTableData();
    }

    private void createTable() {
        TableColumn<Department, Integer> idCol = new TableColumn<>("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Department, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableView.getColumns().addAll(idCol, nameCol);
    }

    private void bindTableData() {
        ObservableList<Department> departments = controller.getDepartments();
        tableView.setItems(departments);
    }
}