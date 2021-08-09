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
public class Delete {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    
    //Delete
    public void DeleteRecipes(Component comp,String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipies", "root", "");
            statement = conections.prepareStatement("delete from foods where ID = ?");
            statement.setInt(1, Integer.parseInt(id));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(comp, "Done");
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(comp, ex);
        }
    }
}
