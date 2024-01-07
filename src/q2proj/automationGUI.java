/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2proj;

/**
 *
 * @author RoyLar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class automationGUI implements ActionListener {
    JFrame frame;
    JLabel navback;
    JLabel instruct;
    JButton clear;
    JButton menu;
    RegPolygon p;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    Font  f3  = new Font(Font.SANS_SERIF, Font.BOLD,  60);
    Font  f2  = new Font(Font.SERIF, Font.TYPE1_FONT,  18);
    JLabel autotxt;
    JTextField nosides;
    JLabel arrowto;
    
    public automationGUI() {
    
        
        

        frame = new JFrame();
        navback = new JLabel();
        clear = new RoundedButton("Clear",10,220);
        menu = new RoundedButton("Menu",10,220);
        autotxt = new JLabel("Automations");
        instruct = new JLabel("Enter the number of sides of the polygon");
        nosides = new RoundTextField(5);
        arrowto = new JLabel("└");
        
}
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43, 255));
        frame.setSize(840,570);
        
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(autotxt, new Rectangle(33,26,8,1));
        
        frame.add(clear, new Rectangle(1,26,4,1));
        frame.add(menu, new Rectangle(6,26,4,1));
        clear.setBackground(Color.gray);
        clear.setFont(new Font("Arial", Font.BOLD, 13));
        menu.setFont(new Font("Arial", Font.BOLD, 13));
        menu.setBackground(Color.gray);
        
        frame.add(instruct, new Rectangle(2,2,20,2));
        instruct.setFont(f2);
        instruct.setForeground(Color.LIGHT_GRAY);
        
        //EXAMPLE = new RegPolygon (No. of Sides, Side Size, LIne Width, Rotation
        //When you want the orientation to be correct No. Sides = Rotation, integer format
        p = new RegPolygon(10, 130,3,10);
        frame.add(p, new Rectangle(22,2,17,17));
        p.setOpaque(false);
        p.setForeground(Color.LIGHT_GRAY);
        
        frame.add(navback, new Rectangle(0,25,42,3));
        navback.setBackground(new java.awt.Color(67, 67, 67, 255));
        navback.setOpaque(true);
        
        frame.add(arrowto, new Rectangle(4,4,2,2));
        
        frame.add(nosides, new Rectangle(6,5,3,2));
        nosides.setHorizontalAlignment(JTextField.CENTER);
        nosides.setFont(f1);
        nosides.setBackground(new java.awt.Color(67, 67, 67, 255));
        nosides.setForeground(Color.LIGHT_GRAY);
        
        
        
        arrowto.setFont(f3);
        arrowto.setBorder(new EmptyBorder(0, 0, 0, 0));
        arrowto.setForeground(Color.GRAY);
        
        
        
        autotxt.setForeground(Color.LIGHT_GRAY);
        autotxt.setOpaque(false);
        autotxt.setFont(f1);
        
        
       
        frame.setVisible(true);
        
        clear.addActionListener(this);
        menu.addActionListener(this);
}
    
    public static void main (String[] args) {
        automationGUI q = new automationGUI();
        q.setFrame();
    }

    public void actionPerformed(ActionEvent e) {
       String action = e.getActionCommand();
       
       if(action.equals(menu.getActionCommand())) {
           frame.dispose();
           menu x = new menu();
           x.setFrame();
           
           
       }
    }

}

