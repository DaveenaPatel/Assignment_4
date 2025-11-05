package com.example.mvcapplication.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final DoubleProperty salary;
    private final IntegerProperty departmentId;

    public Employee(int id, String firstName, String lastName, double salary, int departmentId) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.salary = new SimpleDoubleProperty(salary);
        this.departmentId = new SimpleIntegerProperty(departmentId);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public static ObservableList<Employee> getAllEmployees() {
        ObservableList<Employee> employeeData = FXCollections.observableArrayList();

        String query = "SELECT Id, last_name, first_name, salary, id_departement FROM employee";

        try (Connection conn = database.ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("Id");
                String lastName = rs.getString("last_name");   // corrected
                String firstName = rs.getString("first_name"); // corrected
                double salary = rs.getDouble("salary");
                int departmentId = rs.getInt("id_departement");

                employeeData.add(new Employee(id, firstName, lastName, salary, departmentId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeData;
    }
}