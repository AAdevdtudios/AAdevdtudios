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
class Carz{
    String name;
    Carz(){
        System.out.println("This is BMW");
    }
    Carz(String nam){
        this.name = nam;
        System.out.println("This is "+name);
    }
}
public class ConstructorChain2 extends Carz{
    ConstructorChain2(){
        System.out.println("This is the default Code");
    }
    ConstructorChain2(String name){
        super(name);
        System.out.println("This is "+name);
    }
    public static void main (String args[]){
        ConstructorChain2 obj = new ConstructorChain2("Audi");
    }
}
