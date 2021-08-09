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
public class ConstructorChain {
    {
        System.out.println("This is instanciated ");
    }
    ConstructorChain(){
        System.out.println("This is the default Code");
    }
    ConstructorChain(int x){
        System.out.println("This is "+x);
    }
    ConstructorChain(int x,int c){
        System.out.println("Multiplication "+x * c);
    }
    public static void main (String args[]){
        ConstructorChain constructorChain2 = new ConstructorChain(2);
        ConstructorChain constructorChain = new ConstructorChain(2,4);
    }
}
