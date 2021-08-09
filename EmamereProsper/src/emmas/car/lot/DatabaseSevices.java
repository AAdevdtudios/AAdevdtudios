/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmas.car.lot;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emamera
 * ID, Name,Make,Model, (int)Year,Colour,Plate,License
 */
public class DatabaseSevices {
    Connection conections;
    PreparedStatement prepared;
    ResultSet results;
    
    DatabaseSevices(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conections = DriverManager.getConnection("jdbc:ucanaccess://Emmas.accdb");
            prepared = conections.prepareStatement("select * from info");
            System.out.println("Working");
            
        }catch(Exception ex){
            System.out.println("Not Working");
        }
    }
    public void Add(Component parentComponent,String Name, String Make, String Model, int Year, String Colour, String Plate, String License){
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conections = DriverManager.getConnection("jdbc:ucanaccess://Emmas.accdb");
            prepared = conections.prepareStatement("INSERT INTO info(Name,Make,Model,Year,Colour,Plate,License)VALUES(?,?,?,?,?,?,?)");
            
            prepared.setString(1, Name);
            prepared.setString(2, Make);
            prepared.setString(3, Model);
            prepared.setInt(4, Year);
            prepared.setString(5, Colour);
            prepared.setString(6, Plate);
            prepared.setString(7, License);
            prepared.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Vehicle added to Databbase");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void Update(Component parentComponent,int ID,String Name, String Make, String Model, int Year, String Colour, String Plate, String License){
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conections = DriverManager.getConnection("jdbc:ucanaccess://Emmas.accdb");
            prepared = conections.prepareStatement("update info set Name=?,Make=?,Model=?,Year=?,Colour=?,Plate=?,License=? where id = ?");
            
            
            prepared.setString(1, Name);
            prepared.setString(2, Make);
            prepared.setString(3, Model);
            prepared.setInt(4, Year);
            prepared.setString(5, Colour);
            prepared.setString(6, Plate);
            prepared.setString(7, License);
            prepared.setInt(8, ID);
            prepared.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void View(Component parentComponent,javax.swing.JTable dataTable){
        try {
            int ammount;
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conections = DriverManager.getConnection("jdbc:ucanaccess://Emmas.accdb");
            prepared = conections.prepareStatement("select * from info");
            results = prepared.executeQuery();
            ResultSetMetaData resultSet = results.getMetaData();
            ammount = resultSet.getColumnCount();
            
            DefaultTableModel tableItem = (DefaultTableModel) dataTable.getModel();
            tableItem.setRowCount(0);
            
            while(results.next()){
                Vector vectorData = new Vector();
                for(int i = 1; i<= ammount; i++){
                    //String Name, String Make, String Model, int Year, String Colour, String Plate, String License
                    vectorData.add(results.getString("ID"));
                    vectorData.add(results.getString("Name"));
                    vectorData.add(results.getString("Make"));
                    vectorData.add(results.getString("Model"));
                    vectorData.add(results.getInt("Year"));
                    vectorData.add(results.getString("Colour"));
                    vectorData.add(results.getString("Plate"));
                    vectorData.add(results.getString("License"));
                }
                tableItem.addRow(vectorData);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void DeleteItem(Component parentComponent,int ID){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conections = DriverManager.getConnection("jdbc:ucanaccess://Emmas.accdb");
            prepared = conections.prepareStatement("delete from info where id = ?");
            prepared.setInt(1, ID);
            prepared.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Done");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
