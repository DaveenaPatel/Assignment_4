package com.example.mvcapplication;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.views.DepartmentView;
import com.example.mvcapplication.views.EmployeeView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        EmployeeController controller = new EmployeeController();
        EmployeeView view = new EmployeeView(controller);

        Scene scene = new Scene(view, 400, 300);
        stage.setTitle("Employee Table (MVC)");
        stage.setScene(scene);
        stage.show();

        Stage stage2 = new Stage();
        DepartmentController Depcontroller = new DepartmentController();
        DepartmentView DepView = new DepartmentView(Depcontroller);
        Scene scene2 = new Scene(DepView, 300, 300);
        stage2.setTitle("Department");
        stage2.setScene(scene2);
        stage2.show();


    }



    public static void main(String[] args) {
        launch();
    }
}