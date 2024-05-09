import jaco.mp3.player.MP3Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

GAMECODE: HadRoyLar
AUTOCODE: DisisK
ASSETS: maykhai

*/

public class menu implements ActionListener {

    JFrame frame;
    JLabel navback;
    JLabel menutxt;
    RoundedButton1 next;
    RoundedButton1 previous;
    RoundedButton1 enter;
     RoundedButton1 help;
    Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 21);
    Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 35);
    Font f4 = new Font(Font.SANS_SERIF, Font.PLAIN, 17);
    Font f0 = new Font(Font.DIALOG, Font.BOLD, 30);
    RoundedButton1 auto;
    RoundedButton1 game;
    RoundedButton1 exit;
    ImageIcon img;
    PlaySound clic;
    
    MP3Player press = new MP3Player();
    URL click;
    MP3Player player = new MP3Player();
    URL bgmuse;


    JLabel diakomalandi;

    public menu() {
        //RoundedButton Basics, example = new RoundedButton("text here", radius, shadeofgreywhenpressed)
        //*MAIN - FRAMEWORK - TEMP* navbar code
        frame = new JFrame("Menu");
        img = new ImageIcon(getClass().getResource("assets/inbound6425137077020396552.png"));
        frame.setIconImage(img.getImage());
        navback = new JLabel();
        next = new RoundedButton1("→", 10, 220, false);
        previous = new RoundedButton1("←", 10, 220, false);
        enter = new RoundedButton1("OK", 15, 220, false);
        menutxt = new JLabel("Main Menu");
        diakomalandi = new JLabel("GeeSix Adenine");
        //* END 
        auto = new RoundedButton1("Automations", 10, 220, false);
        help = new RoundedButton1("Help", 10, 220, false);
        game = new RoundedButton1("Game", 10, 220, false);
        exit = new RoundedButton1("Exit", 10, 220, false);
        clic = new PlaySound();
        
        try {
            bgmuse = new URL(getClass().getResource("assets/menumusic.mp3").toExternalForm());
        } catch (MalformedURLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            click = new URL(getClass().getResource("").toExternalForm());
        } catch (MalformedURLException ex) {
            Logger.getLogger(game.getName()).log(Level.SEVERE, null, ex);
        }
        
        press.addToPlayList(click);
        player.addToPlayList(bgmuse);
        player.setRepeat(true); 
        player.play();
    }

    public static void main(String[] args) {

        menu q = new menu();
        q.setFrame();
    }

    public void setFrame() {
        frame.setLayout(new GraphPaperLayout(new Dimension(40, 27)));
        frame.add(menutxt, new Rectangle(30, 26, 8, 1));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setSize(840, 570);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(previous, new Rectangle(1, 26, 3, 1));
        frame.add(enter, new Rectangle(5, 26, 3, 1));
        frame.add(next, new Rectangle(9, 26, 3, 1));

        previous.setBackground(Color.gray);
        previous.setFont(new Font("Arial", Font.BOLD, 40));
        previous.setMargin(new Insets(1, 1, 7, 1));
        next.setFont(new Font("Arial", Font.BOLD, 40));
        next.setMargin(new Insets(1, 1, 7, 1));
        enter.setFont(new Font("Arial", Font.BOLD, 15));
        enter.setMargin(new Insets(2, 1, 1, 2));
        enter.setBackground(Color.DARK_GRAY);
        next.setBackground(Color.gray);

        previous.setVisible(false);
        enter.setVisible(false);
        next.setVisible(false);


        frame.add(auto, new Rectangle(11, 2, 20, 4));
        frame.add(game, new Rectangle(11, 8, 20, 4));
        frame.add(exit, new Rectangle(11, 20, 20, 4));
        
        frame.add(help, new Rectangle(11, 14, 20, 4));
        help.setFont(f0);
        help.setBackground(Color.DARK_GRAY);
        
        auto.setFont(f0);
        auto.setBackground(Color.DARK_GRAY);
        game.setFont(f0);
        game.setBackground(Color.DARK_GRAY);
        exit.setFont(f0);
        exit.setBackground(Color.DARK_GRAY);
        game.addActionListener(this);
        
        game.setForeground(Color.WHITE);
        auto.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        help.setForeground(Color.WHITE);

        frame.add(menutxt, new Rectangle(33, 26, 8, 1));
        menutxt.setFont(f1);
        menutxt.setForeground(Color.ORANGE);
        menutxt.setHorizontalAlignment(JLabel.LEFT);
        menutxt.setVisible(true);
        menutxt.setOpaque(false);
        
       
        frame.add(diakomalandi, new Rectangle(3, 26, 8, 1));
        diakomalandi.setFont(f4);
        diakomalandi.setForeground(Color.ORANGE);
        diakomalandi.setHorizontalAlignment(JLabel.LEFT);
        diakomalandi.setVisible(true);
        diakomalandi.setOpaque(false);

        frame.add(navback, new Rectangle(0, 25, 42, 3));
        navback.setBackground(new Color(67, 67, 67, 255));
        navback.setVisible(true);
        navback.setOpaque(true);
        navback.setBackground(new Color(200, 200, 200, 90));

        frame.setVisible(true);

        exit.addActionListener(this);
        auto.addActionListener(this);
        help.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == (game)) {
            player.stop();
            clic.playEffect("src/assets/click.wav", false);
            game x = new game();
            x.setFrame();
            
             press.play();
            frame.dispose();

        } else if (e.getSource() == (auto)) {
            player.stop();
            press.play();
            clic.playEffect("src/assets/click.wav", false);
            automationGUI x = new automationGUI();
            x.setFrame();
             
            frame.dispose();
        } else if (e.getSource() == (exit)) {
            press.play();
            player.stop();
             
            clic.playEffect("src/assets/click.wav", false);
            frame.dispose();
        }
        
        else if (e.getSource() == (help)) {
             press.play();
            clic.playEffect("src/assets/click.wav", false);
            menu x = new menu();
            x.setFrame();
        }

    }

}
        
        
        
  



