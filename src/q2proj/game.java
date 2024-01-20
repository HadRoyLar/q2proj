package q2proj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.imageio.ImageIO;
//* Code from WWW.tutorialsfield.com (TICTACTOE Game LOGIC)
//* RoyLar adaptation into 'useful' GUI
public class game implements ActionListener{
    /*IDK*/
    JFrame frame;
    JLabel navback;
    RoundedButton next;
    RoundedButton previous;
    RoundedButton enter;
    JLabel gametxt;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    JButton l1, l2, l3, m1, m2, m3, r1, r2, r3;
    
    static String[] board;
    static String turn;
   
   
    // CheckWinner method will 
    // decide the combination 
    // of three box given below.
    
    public static String checkWinner()
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
            if (line.equals("XXX")) {
                return "X";
            }
             
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
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
 
       // To enter the X Or O at the exact place on board.
        System.out.println(
            turn + "'s turn; enter a slot number to place "
            + turn + " in:");
        return null;
    }
     
    // To print out the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/
   
    public static void printBoard()
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
 
   
    
    public game() {
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        frame = new JFrame();
        navback = new JLabel();
        gametxt = new JLabel("Tic-Tac-Gon");
        next = new RoundedButton("→", 10, 220);
        previous = new RoundedButton("←", 10, 220);
        enter = new RoundedButton("OK", 15, 220);
        l1 = new RoundedButton("",2,170);
        l2 = new RoundedButton("",2,170);
        l3 = new RoundedButton("",2,170);
        m1 = new RoundedButton("",2,170);
        m2 = new RoundedButton("",2,170);
        m3 = new RoundedButton("",2,170);
        r1 = new RoundedButton("",2,170);
        r2 = new RoundedButton("",2,170);
        r3 = new RoundedButton("",2,170);
       try {
    Image img = ImageIO.read(getClass().getResource(""));
    l1.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }   
    }
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        frame.add(gametxt, new Rectangle(33, 26, 8, 1));
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43, 255));
        frame.setSize(840,570);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(previous, new Rectangle(1,26,3,1));
        frame.add(enter, new Rectangle(5,26,3,1));
        frame.add(next, new Rectangle(9,26,3,1));
        previous.setBackground(Color.gray);
        previous.setFont(new Font("Arial", Font.BOLD, 40));
        previous.setMargin(new Insets(1,1,7,1));
        next.setFont(new Font("Arial", Font.BOLD, 40));
        next.setMargin(new Insets(1,1,7,1));
        enter.setFont(new Font("Arial", Font.BOLD, 15));
        enter.setMargin(new Insets(2,1,1,2));
        enter.setBackground(Color.gray);
        next.setBackground(Color.gray);
        gametxt.setFont(f1);
        gametxt.setForeground(Color.LIGHT_GRAY);
        gametxt.setHorizontalAlignment(JLabel.LEFT);
        
        //*NEEDS IMPROVEMENT HERE:
        l1.setBorder(null);
        l1.setIcon(new ImageIcon(this.getClass().getResource("")));
        
        //*
        
        frame.add(l1, new Rectangle(1,1,3,3));
        frame.add(l2, new Rectangle(4,1,3,3));
        frame.add(l3, new Rectangle(7,1,3,3));
        frame.add(m1, new Rectangle(1,4,3,3));
        frame.add(m2, new Rectangle(4,4,3,3));
        frame.add(m3, new Rectangle(7,4,3,3));
        frame.add(r1, new Rectangle(1,7,3,3));
        frame.add(r2, new Rectangle(4,7,3,3));
        frame.add(r3, new Rectangle(7,7,3,3));
        frame.add(navback, new Rectangle(0,25,42,3));
        navback.setBackground(new java.awt.Color(67, 67, 67, 255));
        navback.setOpaque(true);
        frame.setVisible(true);
        
        l1.addActionListener(this);
        l2.addActionListener(this);
        l3.addActionListener(this);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        
        l1.setBackground(Color.GRAY);
        l2.setBackground(Color.GRAY);
        l3.setBackground(Color.GRAY);
        m1.setBackground(Color.GRAY);
        m2.setBackground(Color.GRAY);
        m3.setBackground(Color.GRAY);
        r1.setBackground(Color.GRAY);
        r2.setBackground(Color.GRAY);
        r3.setBackground(Color.GRAY);
    }
    public static void main (String[] args) {
        game q = new game();
        q.setFrame();
        //*TIC TAC TOE LOGIC
        
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
 
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
 
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
 
        System.out.println(
            "X will play first. Enter a slot number to place X in:");
 
        while (winner == null) {
            int numInput;
           
           // Exception handling.
           // numInput will take input from user like from 1 to 9.
           // If it is not in range from 1 to 9.
           // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input; re-enter slot number:");
                continue;
            }
             
            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
 
                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }
 
                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                    "Slot already taken; re-enter slot number:");
            }
        }
       
        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                "It's a draw! Thanks for playing.");
        }
       
        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                "Congratulations! " + winner
                + "'s have won! Thanks for playing.");
        }
      in.close();
 
      
      //* TIC TAC TOE LOGIC END
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}