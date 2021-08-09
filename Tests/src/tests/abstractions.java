/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author James
 * 
 */
abstract class Bike{
    abstract void run();
}
public class abstractions extends Bike{

    @Override
    void run() {
        System.out.println("Run class");
    }
    public static void main(String args[]){
        Bike bike = new abstractions();
        bike.run();
    }
}
