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
class Employee{
    String name;
    int price;
    
    void setName(String names){
        this.name = names;
    }
    void setInt(int prices){
        this.price = prices;
    }
    String getName(){
        return name;
    }
    int getPrices(){
        return price;
    }
}
public class encaps2 {
    public static void main(String args[]){
        Employee emp = new Employee();
        emp.setName("James Doe");
        emp.setInt(30000);
        System.out.println(" "+emp.getName()+" "+ emp.getPrices());
    }
}
