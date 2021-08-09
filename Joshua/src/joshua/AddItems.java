/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joshua;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Joshua
 */
public class AddItems {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    
    //Add Student
    public void AddRecipes(Component parentComponent,String foodname, String recipies,String time){
        //ID,foodname,recipes,time
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipies", "root", "");
            statement = conections.prepareStatement("INSERT INTO foods(foodname,recipes,time)VALUES(?,?,?)");
            
            statement.setString(1, foodname);
            statement.setString(2, recipies);
            statement.setString(3, time);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Recipie added for review");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
