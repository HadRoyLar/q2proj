package q2proj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
//* code inspired from WWW.tutorialsfield.com (TICTACTOE Game LOGIC)
//* RoyLar adaptation into 'useful' GUI
public class game extends JFrame implements ActionListener{
    /*IDK*/
    JFrame frame;
    JLabel navback;
    RoundedButton next;
    RoundedButton previous;
    RoundedButton enter;
    JLabel gametxt;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    
    //*TICTACTOE variables
    
    
    //*
    static String[] board;
    static String turn;
    // CheckWinner method will 
    // decide the combination 
    // of three box given below.
    
    RoundedButton buttons[][];
    char currentPlayer;
        
    
    public game() {
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        frame = new JFrame();
        navback = new JLabel();
        gametxt = new JLabel("Tic-Tac-Gon");
        next = new RoundedButton("→", 10, 220,false);
        previous = new RoundedButton("←", 10, 220,false);
        enter = new RoundedButton("OK", 15, 220,false);
        
        buttons = new RoundedButton[3][3];
        currentPlayer = 'X';
        
         for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                
                buttons[row][col] = new RoundedButton("",3,170,true);
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[row][col].setBackground(Color.GRAY);
                buttons[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
               
            }
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
        frame.add(navback, new Rectangle(0,25,42,3));
        navback.setBackground(new java.awt.Color(67, 67, 67, 255));
        navback.setOpaque(true);
        frame.setVisible(true);
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int rolex = row*3;
                int colex = col*3;
                frame.add(buttons[row][col], new Rectangle(1+rolex, 1+colex, 3,3));
               
            }
        }
        
        
    }
    

    
    
  
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        RoundedButton clickedButton = (RoundedButton) e.getSource();

        
        // Check if the clicked button is empty
        if (clickedButton.getText().equals("")) {
            // Set the text of the clicked button to the current player
            clickedButton.setText(String.valueOf(currentPlayer));

            // Check for a win or a draw
            if (checkWin() || checkDraw()) {
                // Display the result and reset the game
               
                resetGame();
            } else {
                // Switch to the other player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

                // Computer makes a move
                makeComputerMove();

                // Check for a win or a draw after the computer's move
                if (checkWin() || checkDraw()) {
                    // Display the result and reset the game
                    
                    resetGame();
                }
            }
        }
}

    private void makeComputerMove() {
        // Simple computer strategy: make a random move
        Random random = new Random();

        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!buttons[row][col].getText().equals(""));

        buttons[row][col].setText(String.valueOf(currentPlayer));
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true; // Row win
            }
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true; // Column win
            }
        }
        // Check diagonals
        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true; // Diagonal win
        }
        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true; // Diagonal win
        }
        return false;
    }

    private boolean checkDraw() {
        // Check if all buttons are filled (draw)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false; // Not a draw
                }
            }
        }
        return true; // Draw
    }

    private void resetGame() {
        // Clear the text on all buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        // Set the current player back to 'X'
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            game s = new game();
            s.setFrame();
            
            
        }
    }
);
        
    }
}
    
    
    
  