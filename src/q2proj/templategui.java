package q2proj;

import javax.swing.*;
import java.awt.*;


public class templategui{
    
    JFrame frame;
    JLabel navback;
    RoundedButton next;
    RoundedButton previous;
    RoundedButton enter;
    
   
    
    public templategui() {
        
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        
        //*MAIN - FRAMEWORK - TEMP* navbar code
        frame = new JFrame();
        navback = new JLabel();
        next = new RoundedButton("→", 10, 220);
        previous = new RoundedButton("←", 10, 220);
        enter = new RoundedButton("OK", 15, 220);
        //* END 
        
        
    }
   
  
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        
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
        
       
       
       
        
        frame.add(navback, new Rectangle(0,25,42,3));
        navback.setBackground(new java.awt.Color(67, 67, 67, 255));
        navback.setOpaque(true);
        
        
        
        
       
        frame.setVisible(true);
        
        
       
        
        
    }
    
    
    public static void main (String[] args) {
        templategui q = new templategui();
        q.setFrame();
    }
}
