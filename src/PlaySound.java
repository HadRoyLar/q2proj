import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PlaySound implements ActionListener {
    Clip clip;
    int tim;
    int lim = 0;
    Timer timer;

    @Override
    public void actionPerformed(ActionEvent e) {
        tim++;
        //System.out.println(tim);
        if (tim == lim) {
            clip.start();
            timer.stop();
            //System.out.println("stopped");
        }
    }

    public void playEffect(String s, int delay) {
        try {
            //System.out.println("play effect with delay");
            File yourFile = new File(s);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            //clip.start();

            lim = delay;
            tim = 0;
            timer = new Timer(1000, this);
            timer.start();

            //clip.stop();

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException err) {
            System.out.println(err.toString());
        }
    }


    public void playEffect(String s, Boolean x) {
        try {
            //System.out.println("play effect");
            String strNew = s.replaceFirst("file:/", "");
            
            
            File yourFile = new File(strNew);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            
            
            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();

            if (x == true) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
            }


        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException err) {
            System.out.println(err.toString());
        }
    }
}
