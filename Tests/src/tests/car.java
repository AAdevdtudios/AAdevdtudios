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
interface cars{
     public void colour();
     public void model();
 }
class CarDefined implements cars{

    @Override
    public void colour() {
        System.out.println("Red"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void model() {
        System.out.println("BMW"); //To change body of generated methods, choose Tools | Templates.
    }

}
public class car { 
    public static void main (String args[]){
        CarDefined cardefined = new CarDefined();
        cardefined.colour();
        cardefined.model();
    }
}
