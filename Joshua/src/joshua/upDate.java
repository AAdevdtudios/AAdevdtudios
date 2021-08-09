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
public class upDate {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    
    //Update Student
    public void UpdateFoodRecipes(Component comp,String foodname, String recipies,String time, String id){
        //ID,foodname,recipes,time
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipies", "root", "");
            statement = conections.prepareStatement("update foods set foodname=?,recipes=?,time=? where ID = ?");
            
            
            statement.setString(1, foodname);
            statement.setString(2, recipies);
            statement.setString(3, time);
            statement.setInt(4, Integer.parseInt(id));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(comp, "Data sent");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(comp, ex);
        }
    }
}
