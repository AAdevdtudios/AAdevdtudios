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
public class MainDB {
    Connection connectors;
    PreparedStatement prest;
    ResultSet result;
    String owner,dr,plate,model;
    boolean ros;
    
    MainDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("select * from report");
            System.out.println("Working");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void UpdateCode(Component parentComponent,String dr, String plate,boolean road, String owner, String model){
        //Name Built Capacity,Country,City
        if(dr.isEmpty()|| plate.isEmpty()||owner.isEmpty()||model.isEmpty()){
            JOptionPane.showMessageDialog(parentComponent, "A field is Empty");
        }else{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("update records set Drivers=?, Plate=?, Road=?, Owner=?,Model=? where Drivers = ?");
            
            
            prest.setString(1, dr);
            prest.setString(2, plate);
            prest.setBoolean(3, road);
            prest.setString(4, owner);
            prest.setString(5, model);
            prest.setString(6, dr);
            prest.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Updated");
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
        
    }
    public void ViewTable(Component parentComponent,javax.swing.JTable jTable1){
        //Name Built Capacity,Country,City
        int c;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("select * from records");
            result = prest.executeQuery();
            ResultSetMetaData red = result.getMetaData();
            c = red.getColumnCount();
            
            DefaultTableModel dft = (DefaultTableModel) jTable1.getModel();
            dft.setRowCount(0);
            
            while(result.next()){
                Vector v2 = new Vector();
                for(int i = 1; i<= c; i++){
                    v2.add(result.getString("Drivers"));
                    v2.add(result.getString("Plate"));
                    v2.add(result.getBoolean("Road"));
                    v2.add(result.getString("Owner"));
                    v2.add(result.getString("Model"));
                }
                dft.addRow(v2);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    
    public void ViewName(Component parentComponent,String dr){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("select * from records where Drivers=?");
            prest.setString(1, dr);
            result = prest.executeQuery();
            
            while(result.next()){
                    //dr = result.getString("Drivers");
                    plate = result.getString("Car plate no");
                    ros = result.getBoolean("Road");
                    owner=result.getString("Owner");
                    model = result.getString("Car Model");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void AddRecord(Component parentComponent,String Dr, String plate,boolean road,String owner,String model){
        if(Dr.isEmpty()|| plate.isEmpty()||owner.isEmpty()||model.isEmpty()){
            JOptionPane.showMessageDialog(parentComponent, "A field is Empty");
        }else{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectors = DriverManager.getConnection("jdbc:mysql://localhost:3306/road", "root", "");
            prest = connectors.prepareStatement("INSERT INTO records(Drivers,Plate,Road,Owner,Model)VALUES(?,?,?,?,?)");
            
            prest.setString(1, Dr);
            prest.setString(2, plate);
            prest.setBoolean(3, road);
            prest.setString(4, owner);
            prest.setString(5, model);
            prest.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Added Record");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    }
}
