/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2proj;

/**
 *
 * @author from the internet, modified a bit  by ROyLar
 */
import javax.swing.*;
import java.awt.*;

public class RegPolygon extends JPanel {
    public int sides;
    public int length;
    public int thick;
    public int rot;

    public RegPolygon (int sides, int length, int thick, int rot) {
        this.sides = sides;
        this.length = length;
        this.thick = thick;
        this.rot = rot;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D line = (Graphics2D) g;
        line.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        line.setStroke(new BasicStroke(thick));
        super.paintComponent(g);
        drawRegularPolygon(g);
        
    }

    private void drawRegularPolygon(Graphics g) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];
        
        double rotx = Math.PI/rot;
        for (int i = 0; i < sides; i++) {
            double angle = rotx + 2 * Math.PI * i / sides;
            xPoints[i] = (int) (centerX + length * Math.sin(angle));
            yPoints[i] = (int) (centerY + length * Math.cos(angle));
        }
        
       

        g.drawPolygon(xPoints, yPoints, sides);
       
    }
}
