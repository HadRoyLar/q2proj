/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSQ2;

import java.util.*;

/**
 *
 * @author ADMIN
 */
public class automationQ2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("INTERIOR AND EXTERIOR ANGLES, AND DIAGONALS OF A POLYGON");
        
        float sum, sum1, angle;
        int dia;
        System.out.print("\n\nInput number of sides of the polygon:");
        int num = sc.nextInt();
        sum1 = 360/num;
        sum = (num-2)*180;
        angle = sum/num; 
        dia = (num*(num-3))/2;
        
        System.out.print("\nComputations:");
        System.out.print("\n\nComputing for the sum of interior angles: ");
        System.out.print("\n   S(sum of interior angles) = (n-2) x 180 ");
        System.out.print("\n   S(sum of interior angles) = (" + num + "-2) x 180");
        System.out.print("\n   S(sum of interior angles) = " + sum);
        System.out.print("\n   Interior angle: " + angle);
        
        System.out.print("\n\n Computing for the exterior angle:");
        System.out.print("\n   S(exterior angle) = 360/n");
        System.out.print("\n   S(exterior angle) = 360/" +num);
        System.out.print("\n   S(exterior angle) = " + sum1);
        
        System.out.print("\n\n Computing for the diagonals: ");
        System.out.print("\n   d(diagonal) = (n(n-3))/2");
        System.out.print("\n   d(diagonal) = (" + num + "(" + num + "-3" + "))/2" );
        System.out.print("\n   d(diagonal) = " + dia );
        
    }
}
