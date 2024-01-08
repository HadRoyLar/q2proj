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
import q2proj.RegPolygon;
import q2proj.RoundTextField;
import q2proj.RoundedButton;

public class automationGUI implements ActionListener {
    JFrame frame;
    JLabel navback;
    JLabel instruct;
    JButton clear;
    JButton menu;
    JButton check;
    RegPolygon p;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    Font  f3  = new Font(Font.SANS_SERIF, Font.BOLD,  60);
    Font  f4  = new Font(Font.SANS_SERIF, Font.BOLD,  35);
    Font  f2  = new Font(Font.SERIF, Font.TYPE1_FONT,  18);
    Font f0 = new Font("Arial", Font.BOLD, 13);
    JLabel autotxt;
    JTextField nosides;
    JLabel arrowto;
    JTextField intangle;
    JTextField extangle;
    JLabel ian;
    JLabel ean;
    JLabel intangleillus;
    JLabel extangleillus;
    
    public automationGUI() {
    
        
        

        frame = new JFrame();
        navback = new JLabel();
        clear = new RoundedButton("Clear",10,220);
        menu = new RoundedButton("Menu",10,220);
        check = new RoundedButton("Check",10,220);
        autotxt = new JLabel("Automations");
        instruct = new JLabel("Enter the number of sides of the polygon");
        nosides = new RoundTextField(10);
        arrowto = new JLabel("└");
        intangle = new RoundTextField(5);
        extangle = new RoundTextField(5);
        ian = new JLabel("Interior Angle of Polygon");
}
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43, 255));
        frame.setSize(840,570);
        
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(autotxt, new Rectangle(33,26,8,1));
        
        frame.add(clear, new Rectangle(1,26,4,1));
        frame.add(menu, new Rectangle(11,26,4,1));
        frame.add(check, new Rectangle(6,26,4,1));
        check.setBackground(Color.gray);
        clear.setBackground(Color.gray);
        clear.setFont(f0);
        menu.setFont(f0);
        menu.setBackground(Color.gray);
        
        frame.add(instruct, new Rectangle(2,2,20,2));
        instruct.setFont(f2);
        instruct.setForeground(Color.LIGHT_GRAY);
        
        //EXAMPLE = new RegPolygon (No. of Sides, Side Size, LIne Width, Rotation
        //When you want the orientation to be correct No. Sides = Rotation
        
        p = new RegPolygon(4, 130,3,4);
        frame.add(p, new Rectangle(22,2,17,17));
        p.setOpaque(false);
        p.setForeground(Color.LIGHT_GRAY);
        
        frame.add(navback, new Rectangle(0,25,42,3));
        navback.setBackground(new java.awt.Color(67, 67, 67, 255));
        navback.setOpaque(true);
        
        
        frame.add(nosides, new Rectangle(6,5,3,2));
        nosides.setHorizontalAlignment(JTextField.CENTER);
        nosides.setFont(f1);
        nosides.setBackground(new java.awt.Color(67, 67, 67, 255));
        nosides.setForeground(Color.LIGHT_GRAY);
        
        intangle.setFont(f4);
        intangle.setBackground(new java.awt.Color(54, 54, 54, 255));
        intangle.setForeground(Color.LIGHT_GRAY);
        intangle.setHorizontalAlignment(JTextField.CENTER);
        
        extangle.setFont(f4);
        extangle.setBackground(new java.awt.Color(54, 54, 54, 255));
        extangle.setForeground(Color.LIGHT_GRAY);
        extangle.setHorizontalAlignment(JTextField.CENTER);
        
        frame.add(intangle, new Rectangle(10,9,5,4));
        frame.add(extangle, new Rectangle(10,15,5,4));
        
        frame.add(ian, new Rectangle(3,12,8,1));
        
        
        frame.add(arrowto, new Rectangle(4,4,2,2));
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

