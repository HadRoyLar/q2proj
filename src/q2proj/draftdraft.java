/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameQuarter2;

import java.util.*;


/**
 *
 * @author ADMIN
 */
public class draftdraft {
    static String[] board;
    static String turn;

    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;
 
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("OOO")) {
                System.out.print("Yehey! You have won!");
                return "O";
            }
             
            // For O winner
            else if (line.equals("XXX")) {
                System.out.print("Oops! You have lost :( ");
                return "X";
            }
        }
         
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }

        System.out.println("Enter a slot number to place in:");
        return null;
    }
   
    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        board = new String[9];
        turn = "O";
        String winner = null;
        float ans;
        Random rn = new Random();
        int rand = rn.nextInt(100 - 3 + 1) + 3;
        int randTwo = rn.nextInt(100 - 3 + 1) + 3;
        int randThree = rn.nextInt(100 - 3 + 1) + 3;
 
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
 
        System.out.println("Welcome to Tic Tac Toe Math Edition!");
        printBoard();
 
        System.out.println( "Enter a slot number to answer questions:");
 
        while (winner == null) {
            int numInput;
            
            numInput = sc.nextInt();
            if (numInput <4){
                 System.out.println("The number of sides of polygon is " + rand + "." + " What is the interior angle of the polygon?");
                 ans = sc.nextFloat();
                 float b;
                 b = (180*(rand - 2))/rand;
                if(ans != b){
                     turn = "X";
                    }          
                }        
            else if(numInput < 7 && numInput > 3){
                System.out.println("The number of sides of polygon is " + randTwo + "." + "What is the exterior angle of the polygon?");
                ans = sc.nextFloat();
                float c;
                c = 360/rand;
                if(ans!=c){
                    turn = "X";
                }
            }
            else if(numInput < 10 && numInput > 7){
               System.out.println("How many diagonals does a polygon have if it has " + randThree + " sides? (round off if decimals)");
               ans = sc.nextFloat();
               int d;
               d = (rand*(rand-3))/2;
               if(ans!=d){
                    turn = "X";
                }
            }
            else{
                System.out.println("Already inputed, re-enter slot number:");
                continue;
            }
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
 
                printBoard();
                winner = checkWinner();
            }
        }
      sc.close();
    }

    
}

