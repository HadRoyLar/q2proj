package q2proj;

import javax.swing.*;
import java.awt.*;


public class menu {
    
    JFrame frame;
    JLabel navback;
    JLabel navup;
    JLabel mainmenutxt;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    /*ss*/
    
   
    
    public menu() {
        
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        
        //*MAIN - FRAMEWORK - TEMP* navbar code
        frame = new JFrame();
        navback = new JLabel();
        navup = new JLabel();
        mainmenutxt = new JLabel("Main Menu");
        //* END 
        
        
    }
   
  
    
    public void setFrame() {
        
        
        
        
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43, 255));
        frame.setSize(840,570);
        
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(mainmenutxt, new Rectangle(34, 26, 8, 1));
        
        
       
       
       
        
        frame.add(navback, new Rectangle(0,25,42,3));
        frame.add(navup, new Rectangle(0,0,42,1));
        navback.setBackground(new java.awt.Color(67, 67, 67, 255));
        navback.setOpaque(true);
        navup.setBackground(new java.awt.Color(67, 67, 67, 255));
        navup.setOpaque(true);
        
        mainmenutxt.setForeground(Color.LIGHT_GRAY);
        mainmenutxt.setOpaque(false);
        mainmenutxt.setFont(f1);
        
        
        
       
        frame.setVisible(true);
        
        
       
        
        
    }
    
    
    public static void main (String[] args) {
        menu q = new menu();
        q.setFrame();
    }
}
