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
class Car {
    void run(){
        System.out.println("This is a BMW Car");
    }
}
public class polymorphismClass extends Car{
    @Override
    void run(){
        System.out.println("The Car is Red");
    }
    public static void main(String arg[]){
        Car poly = new polymorphismClass();
        poly.run();
    }
}
