/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2proj;

import java.util.*;

/**
 *
 * @author orig Yutig, modified as an object
 */

public class autoQ2{
    
    public int sides;
    public float ia, ea, ia_sum;
    public int dia;
    public int num;
        
  
        public int calculate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("INTERIOR AND EXTERIOR ANGLES, AND DIAGONALS OF A REGULAR POLYGON");
        num = sides;
        System.out.print("\n\nInput number of sides of the polygon:");
        num = sc.nextInt();
        ea = 360/num;
        ia_sum = (num-2)*180;
        ia = ia_sum/num; 
        dia = (num*(num-3))/2;
        System.out.print("\n   Interior angle: " + ia);
        System.out.print("\n   E(exterior angle) = " + ea);
        System.out.print("\n   d(diagonal) = " + dia );
        
    
      
        }
    
    public class computex {
        public computex() {
        System.out.print("\nComputations:");
        System.out.print("\n\nComputing for the sum of interior angles: ");
        System.out.print("\n   S(sum of interior angles) = (n-2) x 180 ");
        System.out.print("\n   S(sum of interior angles) = (" + num + "-2) x 180");
        System.out.print("\n   S(sum of interior angles) = " + ia_sum);
        System.out.print("\n   S(interior angle) = "+ia_sum+"/"+num);
        System.out.print("\n   Interior angle: " + ia);
        
        System.out.print("\n\n Computing for the exterior angle:");
        System.out.print("\n   E(exterior angle) = 360/n");
        System.out.print("\n   E(exterior angle) = 360/" +num);
        System.out.print("\n   E(exterior angle) = " + ea);
        
        System.out.print("\n\n Computing for the diagonals: ");
        System.out.print("\n   d(diagonal) = (n(n-3))/2");
        System.out.print("\n   d(diagonal) = (" + num + "(" + num + "-3" + "))/2" );
        System.out.print("\n   d(diagonal) = " + dia );
        
        }
    }
        
    }
    
