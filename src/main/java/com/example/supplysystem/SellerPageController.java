package com.example.supplysystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class SellerPageController {
    @FXML
    TextField name;
    @FXML
    TextField price;
    @FXML
    TextField email;
    @FXML
    Button logout;
        public void logout(MouseEvent event) throws IOException {
                AnchorPane loginpage= FXMLLoader.load((getClass().getResource("Loginpage.fxml")));
                HelloApplication.root.getChildren().add(loginpage);
            }

    public void Add(MouseEvent event) throws SQLException {
        ResultSet res=HelloApplication.connection.executeQuery("select max(productId) from product");
        int productID=0;
        if(res.next())
            productID=res.getInt("max(productId)")+1;
        String query=String.format("Insert Into product values(%s,'%s',%s,'%s')",productID,name.getText(),price.getText(),email.getText());
        int response=HelloApplication.connection.executeUpdate(query);
        Dialog<String> dialog=new Dialog<>();
        dialog.setTitle("Product Add");
        ButtonType type=new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        if(response>0){
            dialog.setContentText("The new product is Added");
        }
        else {
            dialog.setContentText("The new product is not Added");
        }
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

}