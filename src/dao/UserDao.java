/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class UserDao {
    
        private UserDao() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void save(User user) {
        String query = "insert into user(fullName,mobileNumber,email,password,securityQuestion,answer,status) values('"+user.getFullName()+"','"+user.getMobileNumber()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataorDelete(query, "Registered Successfully! Wait for Admin Approval! ");
                
    }
    
    public static User login(String email, String password) {
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("Select * from user where email = '"+email+"' and password = '"+password+"' ");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email) {
        User user = null;
        
        try{
            ResultSet rs = DbOperations.getData("select * from user where email =  '"+ email +"' ");
            while(rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
       
    }
    
    public static void update(String email, String newPassword) {
        String query = "Update user set password = '"+newPassword+"' where email = '"+email+"'";
        DbOperations.setDataorDelete(query, "Password Changed Successfully");
    }
    
    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from user where email like '%"+email+"%'");
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("fullName"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setEmail(rs.getString("email"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void changeStatus(String email, String status) {
    String query = "update user set status = '"+status+"' where email = '"+email+"'";
    DbOperations.setDataorDelete(query, "Status Changed Successfully");
    }
    
    public static void changePassword(String email, String oldPassword, String newPassword) {
    
        try{
            ResultSet rs = DbOperations.getData("select * from user where email = '"+email+"' and password = '"+oldPassword+"'");
            if(rs.next()) {
                update(email, newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Old Password is Wrong");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
