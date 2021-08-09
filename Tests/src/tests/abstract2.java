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
abstract class Shape{
    abstract void draw();
}
class Rectangles extends Shape{

    @Override
    void draw() {
        System.out.println("Rectangle Shape drawn");
    }
}
class Circle extends Shape{

    @Override
    void draw() {
        System.out.println("Circle Shape drawn");
    }
    
}
public class abstract2 {
    public static void main(String args[]){
        Shape shapes = new Circle();
        shapes.draw();
    }
}
