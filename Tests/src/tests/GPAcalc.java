/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Scanner;

/**
 *
 * @author James
 * unit * grade / total unit
 */
public class GPAcalc {
    public static void main(String args[]){
        int totalUnit = 9;
        Scanner sc = new Scanner(System.in);
        float Score= 0;
        float acc = 0;
        String grade[] = new String [4];
        for(int i = 1; i <= 3; i++){
            System.out.println("Grade");
            grade[i] = sc.nextLine();
            if(null != grade[i])switch (grade[i]) {
                case "A":
                    Score += 5 *3;
                    //System.out.println(Score);
                    break;
                case "B":
                    Score += 4*3;
                    //System.out.println(Score);
                    //System.out.println("B");
                    break;
                case "C":
                    Score += 3*3;
                    //System.out.println(Score);
                    //System.out.println("B");
                    break;
                case   "D":
                    Score += 2*3;
                    //System.out.println(Score);
                    //System.out.println("B");
                    break;
                case "E":
                    Score += 1*3;
                    //System.out.println(Score);
                    //System.out.println("B");
                    break;
                default:
                    break;
            }
            acc = Score/totalUnit;
        }
        System.out.println(acc);
    }
}
