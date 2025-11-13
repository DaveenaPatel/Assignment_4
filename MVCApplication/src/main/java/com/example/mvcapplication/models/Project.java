package com.example.mvcapplication.models;

import database.ConnectionManager;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Project {
    private final IntegerProperty id;
    private final StringProperty name;

    public Project(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name =  new SimpleStringProperty(name);
    }

    public IntegerProperty idProperty() {
        return id;
    }
    public StringProperty nameProperty() {
        return name;
    }

    public static ObservableList<Project> getAllProject(){
        ObservableList<Project> projectData = FXCollections.observableArrayList();
        String spl = "SELECT * FROM project";

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement pstm = conn.prepareStatement(spl);) {
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                int id = rs.getInt("Id");
                String name = rs.getString("name");

                Project project = new Project(id, name);
                projectData.add(project);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectData;
    }

}
