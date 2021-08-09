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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joshua
 */
public class ViewItem {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    
    //Gets all the students in from Database
    public final void Recipes(Component comp,javax.swing.JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        //ID,foodname,recipes,time
        try{
            int ammount;
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipies", "root", "");
            statement = conections.prepareStatement("SELECT * FROM foods");
            results = statement.executeQuery();
            ResultSetMetaData resultSet = results.getMetaData();
            ammount = resultSet.getColumnCount();
            model.setRowCount(0);
            while(results.next()){
                Vector vectorData = new Vector();
                boolean res;
                for(int i = 1; i<= ammount; i++){
                    vectorData.add(results.getInt("ID"));
                    vectorData.add(results.getString("foodname"));
                    vectorData.add(results.getString("recipes"));
                    vectorData.add(results.getString("time"));
                }
                model.addRow(vectorData);
            }
            System.out.println("Internet Connection");
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(comp, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(comp, ex);
        }
    }
    
}
