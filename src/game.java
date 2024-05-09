
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

//* By RoyLar GUI


public class game implements ActionListener{
    /*IDK*/
    JFrame frame;
    JLabel navback;
    RoundedButton1 next;
    RoundedButton1 previous;
    RoundedButton1 enter;
    JLabel gametxt;
    JLabel inst;
    JLabel manual;
    JLabel status;
    Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  21);
    Font  f2  = new Font(Font.SANS_SERIF, Font.BOLD,  35);
    Font  f4  = new Font(Font.SANS_SERIF, Font.PLAIN,  17);
    RoundedButton1[][] button;
    int[][] sel;
    boolean locking = false;
    boolean check = true;
    
    RegPolygon s;
    
    RoundTextField ans;
   
    
    
    public game() {
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        frame = new JFrame();
        navback = new JLabel();
        gametxt = new JLabel("Tic-Tac-Gon");
        next = new RoundedButton1("→", 10, 220, false);
        previous = new RoundedButton1("←", 10, 220, false);
        enter = new RoundedButton1("OK", 15, 220, false);
        status = new JLabel("Status");
        manual = new JLabel();
        sel = new int[3][3];
        inst = new JLabel();
      
       button = new RoundedButton1[3][3];
       ans = new RoundTextField(10);
       
       for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                button[row][col] = new RoundedButton1("",4,110,true);
                button[row][col].setFont(f2);  
            }
        } 
    }
    
    
    
    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        frame.add(gametxt, new Rectangle(33, 26, 8, 1));
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43, 255));
        frame.setSize(840,570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        manual.setText("<html>"+"This is a game of a tic tac toe with questions. To start the game, click on the grid on your desired position of the X. A question will then show for you to answer it. Wrong answers will not give you your turn on the tictactoe and instead give it to the computer opponent. To submit your answer, press OK."+"</html>");
        manual.setBackground(Color.DARK_GRAY);
        manual.setFont(f4);
        manual.setForeground(Color.LIGHT_GRAY);
        frame.add(manual, new Rectangle(29,8,10,15));
        
        frame.add(ans, new Rectangle(15,18,8,5));
        ans.setBackground(Color.DARK_GRAY);
        ans.setFont(f1);
        ans.setForeground(Color.LIGHT_GRAY);
        
        frame.add(inst, new Rectangle(12,1,28,9));
        inst.setFont(f1);
        inst.setHorizontalAlignment(JLabel.CENTER);
        inst.setVerticalAlignment(JLabel.CENTER);
        inst.setForeground(Color.LIGHT_GRAY);
        
        status.setFont(f1);
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setVerticalAlignment(JLabel.CENTER);
        status.setForeground(Color.LIGHT_GRAY);
        frame.add(status, new Rectangle(14,16,6,1));
        
        
        
        
        
        
        
        for (int Drow = 0; Drow < 3; Drow++) {
            for (int Dcol = 0; Dcol < 3; Dcol++) {
                int rolex = 3*Drow;
                int colex = 3*Dcol;
                frame.add(button[Drow][Dcol], new Rectangle(1+rolex,1+colex,3,3));
               button[Drow][Dcol].addActionListener(this);
               
                
               
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
        
        
        
                
        for (int row1 = 0; row1 < 3; row1++) {
            for (int col1 = 0; col1 < 3; col1++) {
                
                
               if(e.getSource()==(button[row1][col1])) {
                    button[row1][col1].setText("X");
                    sel[row1][col1] = 2;
                    button[row1][col1].setEnabled(false);
                     dothis();
                     ftir();
                               
                                }
                      
                   }
            
        }
        
           }
    
    public void dothis() {
    int questrand = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                   
                   switch (questrand) {
                       case 4:
                           {
                               int siderand = ThreadLocalRandom.current().nextInt(3, 20 + 1);
                               System.out.println("What is the interior angle of the polygon shown? (Round down to the nearest integer)");
                               inst.setText("What is the interior angle of the polygon shown?");
                                s = new RegPolygon(siderand, 85,2,siderand);
                                       s.setOpaque(true);
                                        s.setForeground(Color.LIGHT_GRAY);
                                        s.setBackground(new java.awt.Color(43, 43, 43, 255));
                                        frame.add(s, new Rectangle(2,12,10,10));
                               enter.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e)
                                   {
                                       
                                      
                                       float b=(180*(siderand-2))/siderand;
                                       String textFieldVal = ans.getText();
                                       int intang = Integer.parseInt(textFieldVal);
                                       System.out.print("Answer: "+textFieldVal);
                                       if(intang==b){
                                           System.out.println("Correct!");
                                           
                                       }
                                       else{
                                           System.out.println("Wrong!");
                                           
                                       }
                                   }
                                   
                               });
                               next.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e)
                                {
                                }
                             }); 
                               break;
                           }
                           
                           case 3:
                           {
                               int siderand = ThreadLocalRandom.current().nextInt(3, 20 + 1);
                               System.out.println("\nWhat is the exterior angle of the polygon shown?");
                               inst.setText("What is the exterior angle of the polygon shown?");
                               s = new RegPolygon(siderand, 85,2,siderand);
                                       s.setOpaque(true);
                                        s.setForeground(Color.LIGHT_GRAY);
                                        s.setBackground(new java.awt.Color(43, 43, 43, 255));
                                        frame.add(s, new Rectangle(2,12,10,10));
                               enter.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                       
                                       float c=360/siderand;
                                       String textFieldVal = ans.getText();
                                       int intang = Integer.parseInt(textFieldVal);
                                       System.out.print("Answer: "+textFieldVal); 
                                       
                                       if(intang==c){
                                           System.out.println("Correct!");
                                           
                                           
                                       }
                                       else{
                                           System.out.println("Wrong!");
                                          
                                           
                                       }
                                   }
                                   
                               });
                               next.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e)
                                {
                                }
                             }); 
                               break;
                           }
                               
                               case 2:
                           {
                               int siderand = ThreadLocalRandom.current().nextInt(3, 20 + 1);
                               System.out.println("/nHow many sides does this polygon have if it has " +siderand+" sides?");
                                s = new RegPolygon(siderand, 85,2,siderand);
                                       s.setOpaque(true);
                                        s.setForeground(Color.LIGHT_GRAY);
                                        s.setBackground(new java.awt.Color(43, 43, 43, 255));
                                        frame.add(s, new Rectangle(2,12,10,10));
                               enter.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                       
                                       String textFieldVal = ans.getText();
                                       System.out.print("Answer: "+textFieldVal);
                                       int intsid = Integer.parseInt(textFieldVal);
                                       System.out.print("Answer: "+textFieldVal);
                                       if(siderand==intsid){
                                           System.out.println("Correct!");
                                          
                                       }
                                       else{
                                           System.out.println("Wrong!");
                                           
                                      }
                                   }
                                   
                               });
                           }
                               next.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
    }
 }); 
                               break;
                               
                               
                               case 1:
                           {
                               int siderand = ThreadLocalRandom.current().nextInt(3, 20 + 1);
                               System.out.println("\nHow many diagonals does this polygon have if it has " +siderand+" sides?");
                                 s = new RegPolygon(siderand, 85,2,siderand);
                                       s.setOpaque(true);
                                        s.setForeground(Color.LIGHT_GRAY);
                                        s.setBackground(new java.awt.Color(43, 43, 43, 255));
                                        frame.add(s, new Rectangle(2,12,10,10));
                               int d=(siderand*(siderand-3))/2;
                               enter.addActionListener(new ActionListener() {
                                   public void actionPerformed(ActionEvent e)
                                   {
                                       String textFieldVal = ans.getText();
                                       int intdia = Integer.parseInt(textFieldVal);
                                       System.out.print("Answer: "+textFieldVal);
                                       if(intdia==d){
                                           System.out.println("Correct!");
                                           
                                           
                                       }
                                       else{
                                           System.out.println("Wrong!");
                                           
                                       }
                                      
                                       
                                   }
                               });
                               
                               
                           }
                           
                           next.addActionListener((ActionEvent e1) -> {
                                  
                               }); 
                   }
                           
                 
                       
                  
                   
                  //*END OF SWITCH
            
                        
                               
                               
    }
        
    
            public void ftir() {
                //*CHECKPLAYER
                               if (sel[0][0]*sel[0][1]*sel[0][2]==8 ||  sel[0][0]*sel[0][1]*sel[0][2]==27) {
                                   check=false;
                                   locking = true;;;;
                                   
                                   
                                   
                               }
                               else if(sel[0][0]*sel[1][0]*sel[2][0] == 8 || sel[0][0]*sel[1][0]*sel[2][0] == 27) {
                                   check = false;
                                   locking = true;;;;
                                 
                                   
                               }//*
                               else if(sel[0][2]*sel[1][2]*sel[2][2]==8 || sel[0][2]*sel[1][2]*sel[2][2]==27) {
                                   check = false;
                                   locking = true;;;;;
                                  
                               }//*
                               else if(sel[0][1]*sel[1][1]*sel[2][1]==8 || sel[0][1]*sel[1][1]*sel[2][1]==27) {
                                   check = false;
                                   locking = true;;;;
                                  
                               }//*
                               else if(sel[2][0]*sel[2][1]*sel[2][2] ==8 || sel[2][0]*sel[2][1]*sel[2][2]==27) {
                                   check = false;
                                   locking = true;;;;
                                   
                                   
                               }//*
                               else if(sel[1][0]*sel[1][1]*sel[1][2] ==8 || sel[1][0]*sel[1][1]*sel[1][2]==27) {
                                   check = false;
                                   locking = true;;;;
                                   
                                   
                               }//*
                               else if(sel[0][0]*sel[1][1]*sel[2][2]==8 || sel[0][0]*sel[1][1]*sel[2][2]==27) {
                                   check = false;
                                   locking = true;;;
                                   
                                   
                               }//*
                               else if(sel[0][2]*sel[1][1]*sel[2][0]==8 || sel[0][2]*sel[1][1]*sel[2][0]==27) {
                                   check = false;
                                   locking = true;;;;
                                  
                                   
                               }//*
                               
                               else {
                                   check = true;
                                   locking = false;
                               }          //*CHECKPLAYER
                               
                               if(locking==true || check==false) {
                                   for (int rowed = 0; rowed < 3; rowed++) {
                                       for (int coled = 0; coled < 3; coled++) {
                                           button[rowed][coled].setEnabled(false);
                                       }
                                   }
                                   System.out.println("WINNER");
                                   
                               }
                               else {}    boolean conf = false;
                               do {
                                   
                                   int rowrand = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                                   int colrand = ThreadLocalRandom.current().nextInt(0, 2 + 1);
                                   
                                   if(sel[rowrand][colrand]==2 || sel[rowrand][colrand]==3){
                                       conf=true;
                                   }
                                   else if (sel[rowrand][colrand]!=2 && sel[rowrand][colrand]!=3){
                                       conf=false;
                                       sel[rowrand][colrand] = 3;
                                       button[rowrand][colrand].setText("O");
                                       button[rowrand][colrand].setEnabled(false);
                                   }
                                   
                               }
                               while(conf==true);
            }
            
    }
        
  
    

    
        
      
    
    
