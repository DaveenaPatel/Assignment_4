package com.example.mvcapplication.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
    private final IntegerProperty id;
    private final StringProperty name;

    public Department(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public static ObservableList<Department> getAllDepartments() {
        ObservableList<Department> departmentData = FXCollections.observableArrayList();

        String query = "SELECT id, name FROM department";

        try (Connection conn = database.ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                departmentData.add(new Department(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentData;
    }
}