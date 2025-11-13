package com.example.mvcapplication;

import com.example.mvcapplication.controllers.DepartmentController;
import com.example.mvcapplication.controllers.EmployeeController;
import com.example.mvcapplication.controllers.ProjectController;
import com.example.mvcapplication.views.DepartmentView;
import com.example.mvcapplication.views.EmployeeView;
import com.example.mvcapplication.views.ProjectView;
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

        Stage stage3 = new Stage();
        ProjectController prContoller = new ProjectController();
        ProjectView PrView = new ProjectView(prContoller);
        Scene scene3 = new Scene(PrView, 400, 400);
        stage3.setTitle("Department");
        stage3.setScene(scene3);
        stage3.show();


    }



    public static void main(String[] args) {
        launch();
    }
}