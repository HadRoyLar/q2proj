package q2proj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class sampleMenu implements KeyListener{
    JFrame frame;
    JLabel tiles[];
    JLabel labels[];
    int currentTile=0;
    
    ImageIcon img;
    ImageIcon icon1;
    ImageIcon bg = new ImageIcon(getClass().getResource(""));
    
    JLabel ident;
    ImageIcon image;
    
    /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e){
        //if the user presses any arrow keys, program goes here
        int keyCode = e.getKeyCode();
        int temp=currentTile;
        if(keyCode==KeyEvent.VK_UP){
            if(currentTile!=0) currentTile=currentTile-1;
        }
        else if(keyCode==KeyEvent.VK_DOWN){
            if(currentTile!=2) currentTile=currentTile+1;
        }
        if(keyCode==KeyEvent.VK_UP||keyCode==KeyEvent.VK_DOWN){
            tiles[temp].setIcon(image);
            tiles[currentTile].setIcon(image);
        }
    }
    
    public sampleMenu() {
        this.img = new ImageIcon(getClass().getResource(""));
        
        this.icon1 = new ImageIcon(getClass().getResource(""));
        frame=new JFrame("Menu   -   Group 6 Adenine");
        
        frame.setIconImage(img.getImage());
        img=new ImageIcon(bg.getImage().getScaledInstance(900, 600, Image.SCALE_FAST));
        frame.setContentPane(new JLabel(img));
        frame.setBackground(new Color(0, 0, 20));
        tiles=new JLabel[3];
        image=new ImageIcon(icon1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        for(int i=0;i<3;i++){
            tiles[i]=new JLabel();
            if(i==0) tiles[i].setIcon(image);
        }
        labels=new JLabel[3];
        labels[0]=new JLabel("Automations");
        labels[1]=new JLabel("Game");
        labels[2]=new JLabel("Exit");
        labels[0].setForeground(new Color(255, 240, 164));
        labels[0].setBackground(new Color(100, 10, 10, 90));
        labels[1].setBackground(new Color(100, 10, 10, 90));
        labels[2].setBackground(new Color(100, 10, 10, 10));
        labels[1].setForeground(new Color(255, 240, 164));
        labels[2].setForeground(new Color(255, 240, 164));
        labels[0].setFont(new Font("Verdana", Font.BOLD, 40));
        labels[1].setFont(new Font("Verdana", Font.BOLD, 40));
        labels[2].setFont(new Font("Verdana", Font.BOLD, 40));
        
    }
    
    @Override
    public void keyReleased(KeyEvent e){}

    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e){
        char typ=e.getKeyChar();
        if(typ==' '){
            switch (currentTile) {
                case 0:
                    {
                        //call automations
                        frame.dispose();
                      
                        //AUTOMATIONS GUI CALL//
                        break;
                    }
                case 1:
                    {
                        //call game GUI
                        frame.dispose();
                        frame.dispose();
                       
                        break;
                    }
                case 2:
                    frame.dispose();
                    frame.dispose();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
    
    public void setFrame(){
        frame.setLayout(new GraphPaperLayout(new Dimension(8,9)));
        int col=1, row=1, wid=2, hei=2;
        for(int i=0;i<3;i++){
            frame.add(tiles[i], new Rectangle(col,row,wid,hei));
            frame.add(labels[i], new Rectangle(3,row,3,2));
            row+=2;
            
            
        }
        
        ident = new JLabel("Group 6 Adenine  |  Q2AAPE4", SwingConstants.CENTER);
        frame.add(ident, new Rectangle(6,8,2,1));
        ident.setForeground(new Color(255,255,255));
        frame.setSize(800, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.addKeyListener(this); //this means this class
    }
    
    public static void main(String[] args) {
        
        
        sampleMenu x=new sampleMenu();
        x.setFrame();
        
        
        
    }

    
}


