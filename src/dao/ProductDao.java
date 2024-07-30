/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;


/**
 *
 * @author DELL
 */
public class ProductDao {

    private ProductDao() {
        throw new IllegalStateException("Utility class");
    }

    public static void save(Product product) {
        String query = "insert into product(fullName, category, price) values ('" + product.getFullName() + "', '" + product.getCategory() + "', '" + product.getPrice() + "')";
        DbOperations.setDataorDelete(query, "Product Added Successfully");
    }
    
    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product");
            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setFullName(rs.getString("fullName"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void update(Product product) {
        String query = "update product set name =  '"+product.getFullName()+"', category = '"+product.getCategory()+"', price = '"+product.getPrice()+"' where id = '"+product.getId()+"'";
        DbOperations.setDataorDelete(query, "Product Update Successfully");
    }
    
    public static void delete(String id) {
        String query = "delete from product where id = '"+id+"'";
        DbOperations.setDataorDelete(query, "Product Deleted Successfully");
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where category = '"+category+"'");
            while(rs.next()) {
                Product product = new Product();
                product.setFullName(rs.getString("fullName"));
                arrayList.add(product);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Product> filterProductByfullName(String fullName, String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where fullName like '%"+fullName+"%' and category = '"+category+"'");
            while(rs.next()) {
                Product product = new Product();
                product.setFullName(rs.getString("fullName"));
                arrayList.add(product);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static Product getProductByfullName(String fullName) {
        Product product = new Product();
        try{
            ResultSet rs = DbOperations.getData("select * from product where fullName = '"+fullName+"'");
            while(rs.next()) {
                product.setFullName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
