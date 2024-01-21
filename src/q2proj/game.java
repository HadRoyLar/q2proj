package q2proj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.max;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//* By RoyLar GUI


public class game implements ActionListener{
    /*IDK*/
    JFrame frame;
    JLabel navback;
    RoundedButton next;
    RoundedButton previous;
    RoundedButton enter;
    JLabel gametxt;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    Font  f2  = new Font(Font.SANS_SERIF, Font.BOLD,  35);
    JButton l1, l2, l3, m1, m2, m3, r1, r2, r3;
    RoundedButton[][] button;
    int[][] sel;
    
    
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
    private static void printBoard()
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
    
    
    
    
    private game() {
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        frame = new JFrame();
        navback = new JLabel();
        gametxt = new JLabel("Tic-Tac-Gon");
        next = new RoundedButton("→", 10, 220, false);
        previous = new RoundedButton("←", 10, 220, false);
        enter = new RoundedButton("OK", 15, 220, false);
        l1 = new RoundedButton("",2,170, false);
        l2 = new RoundedButton("",2,170, false);
        l3 = new RoundedButton("",2,170, false);
        m1 = new RoundedButton("",2,170, false);
        m2 = new RoundedButton("",2,170, false);
        m3 = new RoundedButton("",2,170, false);
        r1 = new RoundedButton("",2,170, false);
        r2 = new RoundedButton("",2,170, false);
        r3 = new RoundedButton("",2,170, false);
        sel = new int[3][3];
      
       
      
       
       
       
      
       
       button = new RoundedButton[3][3];
       
       for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                button[row][col] = new RoundedButton("",4,110,true);
                button[row][col].setFont(f2);
                
               
            }
        }
       
       
    }
    
    
    
    private void setFrame() {
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
        
        
        
        
        
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int rolex = 3*row;
                int colex = 3*col;
                frame.add(button[row][col], new Rectangle(1+rolex,1+colex,3,3));
               button[row][col].addActionListener(this);
               
                
               
            }
        }
        
        
    }
    
    public static void main (String args[]) {
        
        game k = new game();
        k.setFrame();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String x = e.getActionCommand();
        
         
                
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
               if(e.getSource()==(button[row][col])) {
                    button[row][col].setText("X");
                    sel[row][col] = 2;
                    button[row][col].setEnabled(false);
                    boolean check;
                    //*CHECKPLAYER
                    
                    if (8==sel[0][0]*sel[0][1]*sel[0][2]) {
                        check=false;
                    }//*
                    else if(8==sel[0][0]*sel[1][0]*sel[2][0]) {
                        check = false;
                    }//*
                    else if(8==sel[1][0]*sel[1][1]*sel[1][2]) {
                        check = false;
                    }//*
                    else if(8==sel[2][0]*sel[2][1]*sel[2][2]) {
                        check = false;
                    }//*
                    else if(8==sel[0][1]*sel[2][1]*sel[2][2]) {
                        check = false;
                    }
                    else if(8==sel[0][2]*sel[1][2]*sel[2][2]) {
                        check = false;
                    }//*
                    else {
                        check = true;
                    }
                    
                    //*CHECKPLAYER
                    int rowrand = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                    int colrand = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                    
                    
                    button[rowrand][colrand].setText("O");
                    sel[rowrand][colrand] = 3;      
                    check = checkcomputer(sel[0][0]*sel[0][1]*sel[0][2]);
        }
               
                
               
            }
        }
        
       
        
    }
    
    public boolean checkplayer(int check) {
        int l = check;
        boolean term;
        if(l==8) {
            term=false;
        }
        else if(1!=8){
            term=true;
        }
        else {
            term=true;
        }
        
        return term;
    }
    
    public boolean checkcomputer(int check) {
        int l = check;
        boolean term;
        if(l==1) {
            term=false;
        }
        else if(1!=1){
            term=true;
        }
        else {
            term=true;
        }
        
        return term;
    }
    
    

         }
         
    
  