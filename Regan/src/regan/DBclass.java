/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regan;

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
 * @author regan
 * Name, DOB, Address, Gender, License, CarInfo
 */
public class DBclass {
    Connection con;
    PreparedStatement pst;
    ResultSet datas;
    
    DBclass(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://DriversInfo.accdb");
            pst = con.prepareStatement("select * from records");
            System.out.println("Working");
            
        }catch(Exception ex){
            System.out.println("Not Working");
        }
    }
    public void DeleteItem(Component parentComponent,int ID){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://DriversInfo.accdb");
            pst = con.prepareStatement("delete from records where id = ?");
            pst.setInt(1, ID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Done");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void UpdateItem(Component parentComponent,int ID,String Name, String DOB, String Address, String Gender, String License, String CarInfo){
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://DriversInfo.accdb");
            pst = con.prepareStatement("update records set Name=?,DOB=?,Address=?,Gender=?,License=?,CarInfo=? where id = ?");
            
            
            pst.setString(1, Name);
            pst.setString(2, DOB);
            pst.setString(3, Address);
            pst.setString(4, Gender);
            pst.setString(5, License);
            pst.setString(6, CarInfo);
            pst.setInt(7, ID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void ViewItems(Component parentComponent,javax.swing.JTable jTable1){
        int c;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://DriversInfo.accdb");
            pst = con.prepareStatement("select * from records");
            datas = pst.executeQuery();
            ResultSetMetaData red = datas.getMetaData();
            c = red.getColumnCount();
            
            DefaultTableModel dft = (DefaultTableModel) jTable1.getModel();
            dft.setRowCount(0);
            
            while(datas.next()){
                Vector v2 = new Vector();
                for(int i = 1; i<= c; i++){
                    //v2.add(datas.getString("ID"));
                    v2.add(datas.getString("Name"));
                    v2.add(datas.getString("DOB"));
                    v2.add(datas.getString("Address"));
                    v2.add(datas.getString("Gender"));
                    v2.add(datas.getString("License"));
                    v2.add(datas.getString("CarInfo"));
                    v2.add(datas.getString("ID"));
                }
                dft.addRow(v2);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void writeToDB(Component parentComponent,String Name, String DOB, String Address, String Gender, String License, String CarInfo){
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://DriversInfo.accdb");
            pst = con.prepareStatement("INSERT INTO records(Name,DOB,Address,Gender,License,CarInfo)VALUES(?,?,?,?,?,?)");
            
            pst.setString(1, Name);
            pst.setString(2, DOB);
            pst.setString(3, Address);
            pst.setString(4, Gender);
            pst.setString(5, License);
            pst.setString(6, CarInfo);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
