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
public class allEven {

    static int sum(int n) {
        if(n==2){
            return 2;
        }else{
            return (n + sum(n-2));
        }
    }

    public static void main(String args[]) {
        System.out.println();
    }
}
