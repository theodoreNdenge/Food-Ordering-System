/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;

/**
 *
 * @author DELL
 */
public class BillDao {

    private BillDao() {
        throw new IllegalStateException("Utility class");
    }

    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    public static void save(Bill bill) {
        String query = "insert into bill values ('" + bill.getId() + "','" + bill.getFullName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "' )";
        DbOperations.setDataorDelete(query, "Bill Details Added Successfully");
    }
    
    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from bill where date like '%"+date+"%'");
            while(rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setFullName(rs.getString("fullName"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy("createdBy");
                arrayList.add(bill);                
            }
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
        public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from bill where date like '%"+date+"%' Order by id DESC");
            while(rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setFullName(rs.getString("fullName"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy("createdBy");
                arrayList.add(bill);                
            }
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

}
