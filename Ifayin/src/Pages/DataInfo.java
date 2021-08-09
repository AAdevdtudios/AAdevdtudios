/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;

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
 * @author Ifayin
 */
public class DataInfo {
    Connection con;
    PreparedStatement pst;
    ResultSet datas;
    
    DataInfo(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sec", "root", "");
            pst = con.prepareStatement("select * from info");
            System.out.println("Working");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void Delete(Component parentComponent,String name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sec", "root", "");
            pst = con.prepareStatement("delete from info where Houseno = ?");
            pst.setString(1, name);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Done");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void Update(Component parentComponent,String name, String houseno, String visitorsno, String resno, String timein, String timeout){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sec", "root", "");
            pst = con.prepareStatement("update info set Name=?,Houseno=?,Vistorno=?,Resno=?,Timein=?,Timeout=? where Houseno = ?");
            
            
            pst.setString(1, name);
            pst.setString(2, houseno);
            pst.setString(3, visitorsno);
            pst.setString(4, resno);
            pst.setString(5, timein);
            pst.setString(6, timeout);
            pst.setString(7, houseno);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void View(Component parentComponent,javax.swing.JTable jTable1){
        int c;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sec", "root", "");
            pst = con.prepareStatement("select * from info");
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
                    v2.add(datas.getString("Houseno"));
                    v2.add(datas.getString("Vistorno"));
                    v2.add(datas.getString("Resno"));
                    v2.add(datas.getString("Timein"));
                    v2.add(datas.getString("Timeout"));
                }
                dft.addRow(v2);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void Add(Component parentComponent,String Name, String houseno, String visitorno, String resno, String timein, String timeout){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sec", "root", "");
            pst = con.prepareStatement("INSERT INTO info(Name,Houseno,Vistorno,Resno,Timein,Timeout)VALUES(?,?,?,?,?,?)");
            
            pst.setString(1, Name);
            pst.setString(2, houseno);
            pst.setString(3, visitorno);
            pst.setString(4, resno);
            pst.setString(5, timein);
            pst.setString(6, timeout);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
