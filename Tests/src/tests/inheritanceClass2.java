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
class Recipies{
    String stew = "Egusi";
    void application(){
        System.out.println("The application used in eating the food "+stew);
    }
}
class Rice extends Recipies{
    void use(){
        System.out.println("The for eating the Rice "+stew);
    }
}
public class inheritanceClass2 {
    public static void main(String args[]){
        Rice rice = new Rice();
        rice.use(); // From the Rice class
        rice.application(); // This is extended from recipes class
        System.out.println("This is extended from recipes class "+rice.stew);
    }
}
