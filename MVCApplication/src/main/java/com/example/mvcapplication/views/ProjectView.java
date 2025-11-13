package com.example.mvcapplication.views;

import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.models.Project;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProjectView extends VBox {
    private final TableView<Project> tableView;
    private final ProjectController controller;

    public ProjectView(ProjectController controller) {
        this.controller = controller;
        this.tableView =  new TableView<>();
        this.createTable();
        this.getChildren().add(tableView);
        this.bindTableData();
    }

    private void createTable(){
        TableColumn<Project, Integer> idCol = new TableColumn<>("Project Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Project, String> nameCol = new TableColumn<>("Project Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableView.getColumns().addAll(idCol, nameCol);
    }

    private void bindTableData() {
        tableView.setItems(controller.getProjects());
    }

}
