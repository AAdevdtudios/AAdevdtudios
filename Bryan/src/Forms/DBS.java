/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan
 */
public class DBS {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    String type,year,location;
    
    
    public final void Crimes(Component component,javax.swing.JTable jTable1){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            int ammount;
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
            statement = conections.prepareStatement("SELECT * FROM records");
            results = statement.executeQuery();
            ResultSetMetaData resultSet = results.getMetaData();
            ammount = resultSet.getColumnCount();
            model.setRowCount(0);
            while(results.next()){
                Vector vectorData = new Vector();
                boolean res;
                for(int i = 1; i<= ammount; i++){
                    vectorData.add(results.getInt("ID"));
                    vectorData.add(results.getInt("year"));
                    vectorData.add(results.getString("type"));
                    vectorData.add(results.getString("location"));
                }
                model.addRow(vectorData);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(component, ex);
        }
    }
    
    //Delete from database By selecting
    public void DeleteCrimeInfo(Component parentComponent,int id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
            statement = conections.prepareStatement("delete from records where ID = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Deleted");
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    
    public void UpdateCrime(Component parentComponent,int id,int years, String type, String location){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
            statement = conections.prepareStatement("update records set year=?,type=?,location=? where ID = ?");
            
            
            statement.setInt(1, years);
            statement.setString(2, type);
            statement.setString(3, location);
            statement.setInt(4, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Updated");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    
    
    public void AddCrime(Component parentComponent,int years, String type, String location){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime", "root", "");
            statement = conections.prepareStatement("INSERT INTO records(year,type,location)VALUES(?,?,?)");
            
            statement.setInt(1, years);
            statement.setString(2, type);
            statement.setString(3, location);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Crime case added");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
