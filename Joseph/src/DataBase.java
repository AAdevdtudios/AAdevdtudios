
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */
public class DataBase {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    String name,dept,contact,hours,date;
    
    DataBase(javax.swing.JTable jTable1){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try{
            int ammount;
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            statement = conections.prepareStatement("SELECT * FROM info");
            results = statement.executeQuery();
            ResultSetMetaData resultSet = results.getMetaData();
            ammount = resultSet.getColumnCount();
            model.setRowCount(0);
            while(results.next()){
                Vector vectorData = new Vector();
                boolean res;
                for(int i = 1; i<= ammount; i++){
                    vectorData.add(results.getInt("Id"));
                    vectorData.add(results.getString("Name"));
                    vectorData.add(results.getString("Department"));
                    vectorData.add(results.getString("Contact"));
                    vectorData.add(results.getString("Hours"));
                    vectorData.add(results.getString("Date"));
                }
                model.addRow(vectorData);
            }
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(this, ex);
            System.out.println(ex);
        }
    }
    //Delete Record
    DataBase(int id,Component dialog){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            statement = conections.prepareStatement("delete from info where Id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(dialog, "Employee Deleted");
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(dialog, ex);
        }
    }
    //Name,Department,Contact,Hours,Date,Dialog
    DataBase(String name,String department,String contact,String hours,String date){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            statement = conections.prepareStatement("INSERT INTO info(Name,Department,Contact,Hours,Date)VALUES(?,?,?,?,?)");
            
            statement.setString(1, name);
            statement.setString(2, department);
            statement.setString(3, contact);
            statement.setString(4, hours);
            statement.setString(5, date);
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    DataBase(int id){
        //name,dept,contact,hours,date
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            statement = conections.prepareStatement("SELECT * from info where Id = ?");
            statement.setInt(1, id);
            results = statement.executeQuery();
            while(results.next()){
                name = results.getString("Name");
                dept = results.getString("Department");
                contact = results.getString("Contact");
                hours = results.getString("Hours");
                date = results.getString("Date");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
