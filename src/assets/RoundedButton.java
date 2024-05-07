package assets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 * @author from internet and roycelariego
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    int r;
    int s;
    int j;

    public RoundedButton(String text, int f, int shade, boolean k) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(k);

        r = f;

        s = shade;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = r;
        int y = r;
        int j = s;
        int width = getWidth();
        int height = getHeight();
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, x, y);
        if (getModel().isArmed()) {
            g2.setColor(new Color(j, j, j)); // Color when pressed
            int p;
            p = (int) (j / 4);
            if (p < 0) {
                p = 0;
            }

            super.setForeground(new Color(p, p, p));

        } else {
            g2.setColor(getBackground());
            int t;
            t = (int) (j * 3);
            if (t > 255) {
                t = 255;
            } else ;
            super.setForeground(new Color(t, t, t));
        }
        g2.fill(roundedRectangle);
        g2.draw(roundedRectangle);
        g2.dispose();
        super.paintComponent(g);
    }
}