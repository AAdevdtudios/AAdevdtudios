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
class Universities{
    float getPrice(){
        return 2000;
    }
}
class Crawford extends Universities{
    @Override
    float getPrice(){
        return 400000;
    }
}
class Bells extends Universities{
    @Override
    float getPrice(){
        return 800000;
    }
}
public class poly2 {
    public static void main(String args[]){
        Universities uni;
        uni = new Crawford();
        System.out.println("Crawford university price "+uni.getPrice());
        //Crawford
        
        uni = new Bells();
        System.out.println("Bells university price "+uni.getPrice());
        ///Bells
    }
}
