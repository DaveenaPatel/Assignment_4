package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DepartmentController {

    public DepartmentController() {

    }

    public ObservableList<Department> getDepartments() {
        return Department.getAllDepartments();
    }
}