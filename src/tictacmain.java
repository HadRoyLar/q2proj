/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class tictacmain {
    
    public tictacmain() {
    Scanner sc=new Scanner(System.in);
        board=new String[9];
        String winner=null;
        int ans;
 
        for (int a=0; a<9; a++) {
            board[a]=String.valueOf(a+1);
        }
 
        System.out.println("Welcome to Tic Tac Toe: Math Edition!");
        printBoard();
 
	System.out.println("Each slot number consists of a Math question. Win the game by answering the questions correctly!");
	System.out.print("\nEnter a slot number: ");
 
	while(winner==null){
		int numInput=sc.nextInt();
		Random rn=new Random();
		int rand=rn.nextInt(100-3+1)+3;

		if(numInput>0 && numInput<=9){
			if (board[numInput-1].equals(String.valueOf(numInput))){	
				if(numInput>0 && numInput<4){
					System.out.println("\nThe number of sides of a polygon is " +rand+". What is the interior angle of the polygon? (Round down to the nearest integer)");
					System.out.print("Answer: ");
                 			ans=sc.nextInt();
                 			float b=(180*(rand-2))/rand;
                			if(ans==b){
						System.out.println("Correct!");
                     				turn="O";
                    			}
					else{
						System.out.println("Wrong!");
						turn="X";
					}          
                		}        
            			else if(numInput>3 && numInput<7){
                			System.out.println("\nThe number of sides of a polygon is " +rand+". What is the exterior angle of the polygon? (Round down to the nearest integer)");
					System.out.print("Answer: ");
                			ans=sc.nextInt();
                			float c=360/rand;
                			if(ans==c){
						System.out.println("Correct!");
                     				turn="O";
                    			}
					else{
						System.out.println("Wrong!");
						turn="X";
					}          
                		}
            			else if(numInput>6 && numInput<10){
           				System.out.println("\nHow many diagonals does a polygon have if it has " +rand+" sides?");
					System.out.print("Answer: ");
               				ans=sc.nextInt();
               				int d=(rand*(rand-3))/2;
               				if(ans==d){
						System.out.println("Correct!");
                     				turn="O";
                    			}
					else{
						System.out.println("Wrong!");
						turn="X";
					}
				}
          
                		board[numInput-1]=turn;
                		printBoard();
                		winner=checkWinner();
			}
			else{
                		System.out.println("Slot already taken.");
				System.out.print("Re-enter a slot number: ");
            		}
		}
		else{
			System.out.println("Invalid Input!");
			System.out.print("Re-enter a slot number: ");
			continue;
		}
	} 
      sc.close();
}
    
}
