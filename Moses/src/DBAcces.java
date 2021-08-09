/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
 * @author Owolabi
 */
public class DBAcces {
    Connection connectors;
    PreparedStatement prest;
    ResultSet result;
    
    DBAcces(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("select * from report");
            System.out.println("Working");
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }
    }
    public void DeleteFunction(Component parentComponent,String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("delete from report where Id = ?");
            prest.setInt(1, Integer.parseInt(id));
            prest.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Done");
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void UpdateCode(Component parentComponent,String Id, String dr, String rp){
        //Name Built Capacity,Country,City
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("update report set Drivers=?,report=? where Id = ?");
            
            
            prest.setString(1, dr);
            prest.setString(2, rp);
            prest.setInt(3, Integer.parseInt(Id));
            prest.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Updated");
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void ViewTable(Component parentComponent,javax.swing.JTable jTable1){
        //Name Built Capacity,Country,City
        int c;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("select * from report");
            result = prest.executeQuery();
            ResultSetMetaData red = result.getMetaData();
            c = red.getColumnCount();
            
            DefaultTableModel dft = (DefaultTableModel) jTable1.getModel();
            dft.setRowCount(0);
            
            while(result.next()){
                Vector v2 = new Vector();
                for(int i = 1; i<= c; i++){
                    //v2.add(result.getString("ID"));
                    v2.add(result.getInt("Id"));
                    v2.add(result.getString("Drivers"));
                    v2.add(result.getString("report"));
                }
                dft.addRow(v2);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void AddRecord(Component parentComponent,String Dr, String report){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("INSERT INTO report(Drivers,report)VALUES(?,?)");
            
            prest.setString(1, Dr);
            prest.setString(2, report);
            prest.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Added");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
