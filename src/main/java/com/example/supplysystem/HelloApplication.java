package com.example.supplysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloApplication extends Application {

    public  static  databaseConnection connection;
    public  static Group root;
    public  static  String emailId;
    @Override
    public void start(Stage stage) throws Exception {
        emailId="";
        connection=new databaseConnection();
        root=new Group();
        header header=new header();
        productPage products=new productPage();
        ListView<HBox> productList=products.showProducts();
        AnchorPane productPane=new AnchorPane();
        productPane.setLayoutX(50);
        productPane.setLayoutY(100);
        productPane.getChildren().add(productList);
        root.getChildren().addAll(header.root,productPane);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Supply chain");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            try {
                connection.con.close();
                System.out.println("closed");
            }catch (SQLException ex){
               // ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}