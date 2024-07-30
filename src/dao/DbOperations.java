/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbOperations {
        private static final Logger LOGGER = Logger.getLogger(DbOperations.class.getName());
           // Private constructor to prevent instantiation
    private DbOperations() {
        throw new IllegalStateException("Utility class");
    }

public static void setDataorDelete(String Query,String msg) {
    try (Connection con = ConnectionProvider.getCon();
         Statement st = con.createStatement()) {
        st.executeUpdate(Query);
        if(!msg.equals(""))
            JOptionPane.showMessageDialog(null, msg);
    }
    catch(java.sql.SQLException e){
        JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        LOGGER.log(Level.SEVERE, e.getMessage(), e);
    }
}

public static ResultSet getData(String query) {
    try{
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        return rs;
    }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    
}
}

