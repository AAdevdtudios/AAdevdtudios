/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author James
 */
class Employeee{
    float salary = 4000;
    String name = "Elon musk";
}
public class inheritanceClass extends Employeee {
    public static void main(String args[]){
        inheritanceClass classes = new inheritanceClass();// You can chage the "classes" name to anything 
        
        System.out.println("Subscribers name is "+classes.name+"And Salary is "+classes.salary);
        // U can use this method insted System.out.println(classes.name);
        // U can use this method insted System.out.println(classes.salary);
    }
}
