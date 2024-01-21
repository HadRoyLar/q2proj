/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2proj;

import java.util.*;
/**
 *
 * @author ADMIN
 */
public class newdraft {
    static String[] board;
    static String turn;

    static String checkWinner(){
        for(int a=0; a<8; a++){
		String line=null;
 		
		switch (a){
		case 0:
                	line=board[0]+board[1]+board[2];
                	break;
            	case 1:
                	line=board[3]+board[4]+board[5];
                	break;
            	case 2:
                	line=board[6]+board[7]+board[8];
                	break;
            	case 3:
                	line=board[0]+board[3]+board[6];
                	break;
            	case 4:
                	line=board[1]+board[4]+board[7];
                	break;
            	case 5:
                	line=board[2]+board[5]+board[8];
                	break;
            	case 6:
                	line=board[0]+board[4]+board[8];
                	break;
            	case 7:
                	line=board[2]+board[4]+board[6];
                	break;
            }
            
            if(line.equals("OOO")){
                System.out.print("\nYehey! You have won!");
                return "O";
            }
             
            else if(line.equals("XXX")){
                System.out.print("\nOops! You have lost :( ");
                return "X";
            }
        }
         
        for(int a = 0; a < 9; a++){
            if(Arrays.asList(board).contains(String.valueOf(a+1))) {
		break;
            }
            else if(a==8){
                return "draw";
            }
        }

        System.out.print("\nEnter a slot number: ");
        return null;
    }
   
    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
        System.out.println("|-----------|");
        System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
        System.out.println("|---|---|---|");
    }
 
    public static void main(String[] args){
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
