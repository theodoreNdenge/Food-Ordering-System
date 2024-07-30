/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class tables {
    public static void main(String[] args) {
        try{
            String userTable = "create table user(id int AUTO_INCREMENT primary key, fullName varchar(200), mobileNumber varchar(10), email varchar(200), password varchar(200), securityQuestion varchar(200), answer varchar(200), status varchar(20), UNIQUE (email)) ";
            String adminDetails = "insert into user(fullName, mobileNumber, email, password, securityQuestion, answer, status) values ('Admin','0812345678', 'admin@gmail.com', '1234567890', 'Where did you attend high school','WHS', 'true')";   
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key, fullName varchar(200))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key, fullName varchar(200), category varchar(200), price varchar(200))";
            String billTable = "create table bill(id int primary key, fullName varchar(200), mobileNumber varchar(200), email varchar(200), date varchar(50), total varchar(200), createdBy varchar(200))";
            DbOperations.setDataorDelete(userTable, "User table created successfully");
            DbOperations.setDataorDelete(adminDetails, "Admin details added successfully");
            DbOperations.setDataorDelete(categoryTable, "Category Table created successfully");
            DbOperations.setDataorDelete(productTable, "Product Table created successfully");
            DbOperations.setDataorDelete(billTable, "Bill Table created successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
