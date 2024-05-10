import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*


GAMECODE: HadRoyLar
AUTOCODE: DisisK
ASSETS: maykhai

*/


public class tutor implements ActionListener {
    /*IDK*/
    JFrame frame;
    JLabel navback;
    RoundedButton1 next;
    RoundedButton1 previous;
    RoundedButton1 enter;
    RoundedButton1 clear;
    RoundedButton1 menu;
    RoundedButton1 check;
    Font f0 = new Font("Arial", Font.BOLD, 13);
    JLabel bg;

    public tutor() {

        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)

        //*MAIN - FRAMEWORK - TEMP* navbar code
        frame = new JFrame();
        navback = new JLabel();
        next = new RoundedButton1("→", 10, 220, false);
        previous = new RoundedButton1("←", 10, 220, false);
        enter = new RoundedButton1("OK", 15, 220, false);
        clear = new RoundedButton1("Skip", 10, 255, false);
        menu = new RoundedButton1("Back", 10, 255, false);
        check = new RoundedButton1("Next", 10, 255, false);
        bg = new JLabel();
        //* END 


    }

    public static void main(String[] args) {

        tutor q = new tutor();
        q.setFrame();

    }

    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        
        //frame.setContentPane(bgm);
        
        
        frame.setSize(870, 540);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(previous, new Rectangle(1, 26, 3, 1));
        frame.add(enter, new Rectangle(5, 26, 3, 1));
        frame.add(next, new Rectangle(9, 26, 3, 1));
        previous.setBackground(Color.DARK_GRAY);
        previous.setFont(new Font("Arial", Font.BOLD, 40));
        previous.setMargin(new Insets(1, 1, 7, 1));
        next.setFont(new Font("Arial", Font.BOLD, 40));
        next.setMargin(new Insets(1, 1, 7, 1));
        enter.setFont(new Font("Arial", Font.BOLD, 15));
        enter.setMargin(new Insets(2, 1, 1, 2));
        enter.setBackground(Color.DARK_GRAY);
        next.setBackground(Color.DARK_GRAY);
        frame.add(clear, new Rectangle(1, 26, 4, 1));
        frame.add(menu, new Rectangle(11, 26, 4, 1));
        frame.add(check, new Rectangle(6, 26, 4, 1));
        check.setBackground(Color.DARK_GRAY);
        clear.setBackground(Color.DARK_GRAY);
        clear.setFont(f0);
        menu.setFont(f0);
        menu.setBackground(Color.DARK_GRAY);
        
        previous.setVisible(false);
        enter.setVisible(false);
        next.setVisible(false);
        menu.setVisible(true);

        frame.add(navback, new Rectangle(0, 25, 42, 3));
        navback.setBackground(new Color(67, 67, 67, 255));
        navback.setVisible(true);
        navback.setOpaque(true);
        navback.setBackground(new Color(200, 200, 200, 90));

        frame.setVisible(true);
        frame.add(bg, new Rectangle(0,0,40,27));
        menu.addActionListener(this);
        check.addActionListener(this);
        clear.addActionListener(this);
        shownext();
    }
    
    int shownext = 0;
    ImageIcon img;
    
    public void shownext() {
        int kj;
         kj = shownext;
       
        
        switch(kj) {
            case 0 -> {
                this.img = new ImageIcon(getClass().getResource("assets/YUT.png"));
        bg.setIcon(new ImageIcon(img.getImage().getScaledInstance(870, 540,  java.awt.Image.SCALE_AREA_AVERAGING)));
       
        frame.repaint();
        frame.invalidate();
        frame.validate();
            }
            case 1 -> {
                this.img = new ImageIcon(getClass().getResource("assets/YUT.png"));
       bg.setIcon(new ImageIcon(img.getImage().getScaledInstance(870, 540,  java.awt.Image.SCALE_AREA_AVERAGING)));
        frame.repaint();
        frame.invalidate();
        frame.validate();
            }
            
            case 2 -> {
                this.img = new ImageIcon(getClass().getResource("assets/LOG.png"));
       bg.setIcon(new ImageIcon(img.getImage().getScaledInstance(870, 540,  java.awt.Image.SCALE_AREA_AVERAGING)));
        frame.repaint();
        frame.invalidate();
        frame.validate();
            }
            
                
            
            default -> {
                if(kj>0) {
                frame.dispose();
                game x = new game();
                x.setFrame();
                }
            }
            
        }
        if(kj<=0) {
                    kj=0;
                    shownext=0;
                }
        
        shownext=kj;
         System.out.print(kj);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==(check)) {  
            
            shownext++;
            shownext();
            frame.invalidate();
        frame.validate();
        }
        else if(e.getSource()==(menu)) {
            frame.dispose();
            
        }  
        else if(e.getSource()==(clear)) {
            shownext=99;
            shownext();
        }}
    }
    
    
    
    



        
        
        
  



