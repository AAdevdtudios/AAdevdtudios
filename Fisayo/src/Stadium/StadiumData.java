/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stadium;

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
 * @author Fisayo
 */
public class StadiumData {
    Connection con;
    PreparedStatement pst;
    ResultSet datas;
    
    StadiumData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uefa", "root", "");
            pst = con.prepareStatement("select * from stadiums");
            System.out.println("Working");
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void DeleteStadium(Component parentComponent,String name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uefa", "root", "");
            pst = con.prepareStatement("delete from stadiums where Name = ?");
            pst.setString(1, name);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Done");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void UpdateStadium(Component parentComponent,String Name, String built, String capacity, String country, String city){
        //Name Built Capacity,Country,City
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uefa", "root", "");
            pst = con.prepareStatement("update stadiums set Name=?,Built=?,Capacity=?,Country=?,City=? where Name = ?");
            
            
            pst.setString(1, Name);
            pst.setInt(2, Integer.parseInt(built));
            pst.setInt(3, Integer.parseInt(capacity));
            pst.setString(4, country);
            pst.setString(5, city);
            pst.setString(6, Name);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    public void ViewStadium(Component parentComponent,javax.swing.JTable jTable1){
        //Name Built Capacity,Country,City
        int c;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uefa", "root", "");
            pst = con.prepareStatement("select * from stadiums");
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
                    v2.add(datas.getInt("Built"));
                    v2.add(datas.getString("Country"));
                    v2.add(datas.getString("City"));
                    v2.add(datas.getInt("Capacity"));
                }
                dft.addRow(v2);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    //Name Built Capacity,Country,City
    public void AddStadium(Component parentComponent,String Name, String Built, String Capacity, String Contry, String City){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uefa", "root", "");
            pst = con.prepareStatement("INSERT INTO stadiums(Name,Built,Capacity,Country,City)VALUES(?,?,?,?,?)");
            
            pst.setString(1, Name);
            pst.setInt(2, Integer.parseInt(Built));
            pst.setString(3, Capacity);
            pst.setString(4, Contry);
            pst.setString(5, City);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
