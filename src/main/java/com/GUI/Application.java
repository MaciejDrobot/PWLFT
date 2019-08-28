package com.GUI;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("configFX.fxml"));
        primaryStage.setTitle("PWLFT Application");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


}
