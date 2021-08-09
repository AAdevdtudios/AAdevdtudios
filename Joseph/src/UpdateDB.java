
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */
public class UpdateDB {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    //name,dept,contact,hours,date,id,dialog
    //Name,Department,Contact,Hours,Date,Dialog
    UpdateDB(String name,String department,String contact,String hours,String date,int id,Component dialog){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            statement = conections.prepareStatement("update info set Name=?,Department=?,Contact=?,Hours=?,Date=? where Id = ?");
            
            
            statement.setString(1, name);
            statement.setString(2, department);
            statement.setString(3, contact);
            statement.setString(4, hours);
            statement.setString(5, date);
            statement.setInt(6, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(dialog, "Updated");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(dialog, ex);
        }
    }
}
