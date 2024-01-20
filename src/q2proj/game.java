package q2proj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
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
    public game() {
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        frame = new JFrame();
        navback = new JLabel();
        gametxt = new JLabel("Game");
        next = new RoundedButton("→", 10, 220);
        previous = new RoundedButton("←", 10, 220);
        enter = new RoundedButton("OK", 15, 220);
        l1 = new RoundedButton("",2,110);
        l2 = new RoundedButton("",2,110);
        l3 = new RoundedButton("",2,110);
        m1 = new RoundedButton("",2,110);
        m2 = new RoundedButton("",2,110);
        m3 = new RoundedButton("",2,110);
        r1 = new RoundedButton("",2,110);
        r2 = new RoundedButton("",2,110);
        r3 = new RoundedButton("",2,110);
       try {
    Image img = ImageIO.read(getClass().getResource(""));
    l1.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }   
    }
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        frame.add(gametxt, new Rectangle(35, 26, 8, 1));
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
        gametxt.setHorizontalAlignment(2);
        
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
    }
    public static void main (String[] args) {
        game q = new game();
        q.setFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}