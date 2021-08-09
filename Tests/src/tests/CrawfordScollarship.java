/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class CrawfordScollarship {
    public static void storeName(String name, int scores){
        System.out.println(name + " "+ scores);
    }
    public static void main (String args[]){
        String name[] = new String[4];
        String score[] = new String[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<=3; i++){
            System.out.println("Name");
            name[i] = sc.nextLine();
            System.out.println("Score");
            score[i]= sc.nextLine();
        }
        try {
            FileWriter writter = new FileWriter("java.txt");
            for (int i= 0; i<= 3; i++){
                writter.write(name[i]+"\n");
                writter.write(score[i]+"\n");
            }
            writter.close();
        } catch (IOException ex) {
            Logger.getLogger(CrawfordScollarship.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
