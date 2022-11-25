package com.example.supplysystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class headerController {

    @FXML
    Button loginbutton;
    @FXML
    Label email;
    @FXML
    TextField searchtext;
    @FXML
    Button logoutButton;
    @FXML
    public  void initialize(){
        if(!HelloApplication.emailId.equals("")){
            loginbutton.setOpacity(0);
            email.setText(HelloApplication.emailId);
        }
    }
    public void search(MouseEvent event) throws IOException, SQLException {
        header header=new header();
       productPage products=new productPage();
       AnchorPane productPane=new AnchorPane();
       productPane.getChildren().add(products.showProductsbyName(searchtext.getText()));
        productPane.setLayoutX(150);
        productPane.setLayoutY(100);
       HelloApplication.root.getChildren().clear();
       HelloApplication.root.getChildren().addAll(header.root,productPane);
    }
    @FXML
    public void login(MouseEvent event) throws IOException {
        AnchorPane loginpage= FXMLLoader.load((getClass().getResource("Loginpage.fxml")));
        HelloApplication.root.getChildren().add(loginpage);
    }
    public void logout(MouseEvent event) throws IOException, SQLException {
        if(logoutButton.getOpacity()==0) {
            logoutButton.setOpacity(1);
            logoutButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    HelloApplication.emailId="";
                    logoutButton.setOpacity(0);
                    try {
                        header header=new header();
                        HelloApplication.root.getChildren().add(header.root);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        else
            logoutButton.setOpacity(0);

    }
}