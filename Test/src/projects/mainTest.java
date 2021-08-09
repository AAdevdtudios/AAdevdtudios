/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class mainTest {
    public static void main (String args[]){
        int n1 = 0, n2 =1, n3,i,count = 0;
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        for(i = 2; i < count; ++i){
            n3 = n1 + n2;
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
        }
    }
}
