package com.example.supplysystem;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
void placeOrder(String productID) throws SQLException {
    ResultSet res = HelloApplication.connection.executeQuery("select max(orderId) from orders");
    int orderID = 0;
    if (res.next())
        orderID=res.getInt("max(orderId)")+1;

 String query=String.format("Insert Into orders values(%s,%s,'%s')",orderID,productID,HelloApplication.emailId);
 int respose=HelloApplication.connection.executeUpdate(query);
 if(respose>0){
     Dialog<String> dialog=new Dialog<>();
     dialog.setTitle("Order confirmation");
     ButtonType type=new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
     dialog.setContentText("Your order has been placed...");
     dialog.getDialogPane().getButtonTypes().add(type);
     dialog.showAndWait();
     System.out.println("Order is placed");
 }
}
}
