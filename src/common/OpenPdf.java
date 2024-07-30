/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class OpenPdf {

    private OpenPdf() {
        throw new IllegalStateException("Utility class");
    }

    public static void openById(String id) {
        try {
            if ((new File("C:\\Users\\DELL\\OneDrive\\Documents\\MyPDF\\"+id+".pdf")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\DELL\\OneDrive\\Documents\\MyPDF\\"+id+".pdf");
            } else {
                JOptionPane.showMessageDialog(null, "file does not Exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
