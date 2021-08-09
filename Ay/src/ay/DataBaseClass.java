/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ay;

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
 * @author Ay
 */
public class DataBaseClass {
    Connection conections;
    PreparedStatement statement;
    ResultSet results;
    String name,dept;
    int matric, score;
    
    //Check if connected to database
    public final void VerfyConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "");
            statement = conections.prepareStatement("SELECT * FROM recordinfo");
            results = statement.executeQuery();
            System.out.println("Connected");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    //Gets all the students in from Database
    public final void Students(Component component,javax.swing.JTable jTable1){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //ID, Matric, Department, Name, Score (Int), Grade
        try{
            int ammount;
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "");
            statement = conections.prepareStatement("SELECT * FROM recordinfo");
            results = statement.executeQuery();
            ResultSetMetaData resultSet = results.getMetaData();
            ammount = resultSet.getColumnCount();
            model.setRowCount(0);
            while(results.next()){
                Vector vectorData = new Vector();
                boolean res;
                for(int i = 1; i<= ammount; i++){
                    vectorData.add(results.getString("Name"));
                    vectorData.add(results.getString("Department"));
                    vectorData.add(results.getInt("Matric"));
                    vectorData.add(results.getInt("Score"));
                    vectorData.add(results.getString("Grade"));
                }
                model.addRow(vectorData);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(component, ex);
        }
    }
    
    //Delete from database By selecting
    public void DeleteStudentInfo(Component parentComponent,int matric){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "");
            statement = conections.prepareStatement("delete from recordinfo where Matric = ?");
            statement.setInt(1, matric);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Done");
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    
    //Select using matric no
    public final void SelectMat(Component component,int MatricNo){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "");
            statement = conections.prepareStatement("SELECT * from recordinfo where Matric = ?");
            statement.setInt(1, MatricNo);
            results = statement.executeQuery();
            while(results.next()){
                name = results.getString("Name");
                dept = results.getString("Department");
                matric = results.getInt("Matric");
                score = results.getInt("Score");
                System.out.println(results.getString("Name"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(component, ex);
        }
    }
    
    //Update Student
    public void UpdateStudent(Component parentComponent,int matric, String Name, String department, int score, String grade){
        //ID, Matric(Int), Department, Name, Score (Int), Grade
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "");
            statement = conections.prepareStatement("update recordinfo set Name=?,Department=?,Score=?,Grade=?,Matric=? where Matric = ?");
            
            
            statement.setString(1, Name);
            statement.setString(2, department);
            statement.setInt(3, score);
            statement.setString(4, grade);
            statement.setInt(5, matric);
            statement.setInt(6, matric);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Worked");
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
    
    //Add Student
    public void AddStudent(Component parentComponent,int matric, String Name, String department, int score, String grade){
        //ID, Matric(Int), Department, Name, Score (Int), Grade
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conections = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "");
            statement = conections.prepareStatement("INSERT INTO recordinfo(Name,Department,Grade,Matric,Score)VALUES(?,?,?,?,?)");
            
            statement.setString(1, Name);
            statement.setString(2, department);
            statement.setString(3, grade);
            statement.setInt(4, matric);
            statement.setInt(5, score);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Student information add");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parentComponent, ex);
        }
    }
}
