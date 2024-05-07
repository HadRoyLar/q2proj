/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * @author automations Yutig
 * @author polygon constructor from the internet, modified a bit  by ROyLar
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;
import javax.imageio.ImageIO;
public class RegPolygon extends JLabel{
    public int sides;
    public int length;
    public int thick;
    public int rot;
    public String polyname = "Polygon";
    public int s;
    public float ia, ea, ia_sum;
    public int dia;
    public int num;
    public int val[] = null;
    public int ck;
    public boolean mk = false;
    public int[] yPoints;
    public int[] xPoints;
    public void reset() {
        s = 0;
        xPoints = null;
        yPoints = null;
        val = null; 
}
    public BufferedImage image;
    public RegPolygon (int sides, int length, int thick, int rot) {
        this.sides = sides;
        this.length = length;
        this.thick = thick;
        this.rot = rot;
        s = sides;
     }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D line = (Graphics2D) g;
        line.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        line.setStroke(new BasicStroke(thick));
        super.paintComponent(g);
        drawRegularPolygon(g);   
    }
    public void drawRegularPolygon(Graphics g) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        xPoints = new int[s];
        yPoints = new int[s];
        double rotx = Math.PI/rot;
        for (int i = 0; i < s; i++) {
            double angle = rotx + 2 * Math.PI * i / s;
            xPoints[i] = (int) (centerX + length * Math.sin(angle));
            yPoints[i] = (int) (centerY + length * Math.cos(angle));
        } 
        g.drawPolygon(xPoints, yPoints, s);
}
    public String polyname() {
        polyname = "Polygon";
        if(s==3){
                polyname = "Triangle";
            }
        else if(s==4){
                polyname = "Square";
            }
        else if(s==2){
                polyname = "Just a Line";
            }
        else if(s==0){
                polyname = "Nothing";
            }
        else if(s==1){
                polyname = "Not a polygon";
            }
            else if(s==5){
                polyname = "Pentagon";
            }
            else if(s==6){
                polyname = "Hexagon";
            }
            else if(s==7){
                polyname = "Heptagon";
            }
            else if(s==8){
                polyname = "Octagon";
            }
            else if(s==9){
                polyname = "Nonagon";
            }
            else if(s==10){
                polyname = "Decagon";
            }
            else if(s==11){
                polyname = "Hendecagon";
            }
            else if(s==12){
                polyname = "Dodecagon";
            }
            else if(s >= 13) {
                 polyname = (String)(sides+"-gon");   
            }
            else if (s <=0 ){
                polyname = "Positive vibes always";
            }
            return polyname;
    }
    public int[] calculate(){
        val = new int[3]; 
        System.out.println("INTERIOR AND EXTERIOR ANGLES, AND DIAGONALS OF A REGULAR POLYGON");
        num = s;
        System.out.print("\n\nInput number of sides of the polygon:");
        if (num<3) {
            ia = 0;
            ea = 0;
            dia = 0;
        }
        else if (num>=3) {
            ea = 360/num;
        ia_sum = (num-2)*180;
        ia = ia_sum/num; 
        dia = (num*(num-3))/2;
        }
        val[0] = (int) ia;
        val[1] = (int) ea;
        val[2] = dia;
        System.out.print("\n   Interior angle: " + ia);
        System.out.print("\n   E(exterior angle) = " + ea);
        System.out.print("\n   d(diagonal) = " + dia );
        return val;
        }
}