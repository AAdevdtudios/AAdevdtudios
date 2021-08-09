/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import java.math.*;
import java.util.Scanner;
/**
 *
 * @author James
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static double Power(int i){
        
        return Math.pow(2,i);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc =  new Scanner(System.in);
        int base = sc.nextInt();
        
        System.out.println(Power(base));
    }
    
}
