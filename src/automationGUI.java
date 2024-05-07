/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RoyLar
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import java.util.Random;
public class automationGUI implements ActionListener {
    RegPolygon q;
    JPanel panel; 
    int numsides;
    JFrame frame;
    JLabel navback;
    JLabel instruct;
    JButton clear;
    JButton menu;
    JButton check;
    JLabel polydef;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    Font  f3  = new Font(Font.SANS_SERIF, Font.BOLD,  60);
    Font  f4  = new Font(Font.SANS_SERIF, Font.BOLD,  35);
    Font  f2  = new Font(Font.SERIF, Font.TYPE1_FONT,  18);
    Font f0 = new Font("Arial", Font.BOLD, 13);
    Font f5 = new Font(Font.DIALOG, Font.ITALIC, 12);
    JLabel autotxt;
    JTextField nosides;
    JLabel arrowto;
    JTextField intangle;
    JTextField extangle;
    JLabel ian;
    JLabel ean;
    JLabel intangleillus;
    JLabel extangleillus;
    JLabel diaillus;
    JLabel polynames;
    JLabel diagonals;
    JTextField diagonalsnum;
    JLabel intsol;
    JLabel extsol;
    JLabel diasol;
    String s;
    public int o;
    ImageIcon windowicon = new ImageIcon(getClass().getResource(""));
    ImageIcon deficon = new ImageIcon(getClass().getResource(""));
    public automationGUI() {
        frame = new JFrame();
        frame.setIconImage(windowicon.getImage());
        navback = new JLabel();
        clear = new RoundedButton1("Clear",10,220,false);
        menu = new RoundedButton1("Menu",10,220,false);
        check = new RoundedButton1("Check",10,220,false);
        autotxt = new JLabel("Automations");
        instruct = new JLabel("Enter the number of sides of the polygon");
        nosides = new RoundTextField(10);
        arrowto = new JLabel("└");
        intangle = new RoundTextField(5);
        extangle = new RoundTextField(5);
        diagonalsnum = new RoundTextField(5);
        polynames = new JLabel("Polygon");
        ian = new JLabel("Interior Angles of Polygon");
        ean = new JLabel("Exterior Angles of Polygon");
        diagonals = new JLabel("Number of Diagonals");     
        intsol = new JLabel("");
        extsol = new JLabel("");
        diasol = new JLabel("");
}
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43, 255));
        frame.setSize(840,570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        frame.add(navback, new Rectangle(0,25,42,3));
        navback.setBackground(new java.awt.Color(67, 67, 67, 255));
        navback.setOpaque(true);
        frame.add(nosides, new Rectangle(6,4,3,2));
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
        diagonalsnum.setFont(f4);
        diagonalsnum.setBackground(new java.awt.Color(54, 54, 54, 255));
        diagonalsnum.setForeground(Color.LIGHT_GRAY);
        diagonalsnum.setHorizontalAlignment(JTextField.CENTER);
        frame.add(intangle, new Rectangle(10,7,5,4));
        frame.add(extangle, new Rectangle(10,12,5,4));
        frame.add(diagonalsnum, new Rectangle(10,17,5,4));
        frame.add(ian, new Rectangle(2,9,8,1));
        frame.add(ean, new Rectangle(2,14,8,1));
        frame.add(intsol, new Rectangle(2,10,8,1));
        frame.add(extsol, new Rectangle(2,15,8,1));
        frame.add(diasol, new Rectangle(2,20,8,1));
        intsol.setHorizontalAlignment(JTextField.CENTER);
        intsol.setFont(f5);
        extsol.setHorizontalAlignment(JTextField.CENTER);
        extsol.setFont(f5);
        diasol.setHorizontalAlignment(JTextField.CENTER);
        diasol.setFont(f5);
        ian.setHorizontalAlignment(JTextField.CENTER);
        ian.setFont(f5);
        ian.setForeground(Color.LIGHT_GRAY);
        ean.setHorizontalAlignment(JTextField.CENTER);
        ean.setFont(f5);
        ean.setForeground(Color.LIGHT_GRAY);
        frame.add(diagonals, new Rectangle(2,19,8,1));
        diagonals.setHorizontalAlignment(JTextField.CENTER);
        diagonals.setHorizontalAlignment(JTextField.CENTER);
        diagonals.setFont(f5);
        diagonals.setForeground(Color.LIGHT_GRAY);
        frame.add(arrowto, new Rectangle(4,4,2,2));
        arrowto.setFont(f3);
        arrowto.setBorder(new EmptyBorder(0, 0, 0, 0));
        arrowto.setForeground(Color.GRAY);
        frame.add(polynames, new Rectangle(25,20,13,3));
        polynames.setFont(f1);
        polynames.setForeground(Color.LIGHT_GRAY);
        polynames.setHorizontalAlignment(JLabel.CENTER);
        autotxt.setForeground(Color.LIGHT_GRAY);
        autotxt.setOpaque(false);
        autotxt.setFont(f1);  
        frame.setVisible(true);
        clear.addActionListener(this);
        menu.addActionListener(this);
        check.addActionListener(this);
        nosides.addActionListener(this);
        
        diasol.setForeground(Color.GRAY);
        intsol.setForeground(Color.GRAY);
        extsol.setForeground(Color.GRAY);
        
        
}
    public static void main(String[] args) {
            automationGUI q = new automationGUI();
        q.setFrame();
}
    public void actionPerformed(ActionEvent e) {
       String action = e.getActionCommand();
       if(action.equals(menu.getActionCommand())) {
           frame.dispose();
           menu k = new menu();
           k.setFrame();
       }
       else if(action.equals(clear.getActionCommand())) {
           intangle.setText("0°");
           extangle.setText("0°");
           diagonalsnum.setText("0");
           q.reset();
           q.repaint();   
       } 
       else if(action.equals(check.getActionCommand())) {
           Random r = new Random();
           char c = (char)(r.nextInt(26) + 'a');
           s = nosides.getText();
           numsides = Integer.parseInt(s);
           int dat[];
           q = new RegPolygon(numsides, 150,4,numsides);
           int it = 0;
           int et = 0;
           int dg = 0;
           dat = q.calculate();
           q.setOpaque(true);
        q.setForeground(Color.LIGHT_GRAY);
        q.setBackground(new java.awt.Color(43, 43, 43, 255));
           frame.add(q, new Rectangle(23,3,17,17));
        polynames.setText(q.polyname());
           for (int i = 0; i < dat.length; i++) {
            if (i==0) {
                it = dat[i];
            }
            if (i==1) {
                et = dat[i];
            }
            if (i==2) {
                dg = dat[i];
            }
           }
           intangle.setText(String.valueOf(it)+"°");
           extangle.setText(String.valueOf(et)+"°");
           diagonalsnum.setText(String.valueOf(dg)); 
           intsol.setText(s+"+-2)*180="+it+"°");
           extsol.setText("360/"+s+"="+et+"°");
           diasol.setText(s+"*("+s+"-3))/2="+dg);
       }
    }
}
       


               

                       

         





    
           


