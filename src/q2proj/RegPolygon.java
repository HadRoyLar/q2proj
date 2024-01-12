/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q2proj;

/**
 * @author automations Yutig
 * @author polygon constructor from the internet, modified a bit  by ROyLar
 */
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class RegPolygon extends JPanel {
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
    public RegPolygon (int sides, int length, int thick, int rot) {
        this.sides = sides;
        sides = this.sides;
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
       if (num<=1) {  
        }
       else {
           g.drawPolygon(xPoints, yPoints, sides);
       }
    }
    public String polyname() {
        sides = s;
        polyname = "Polygon";
        if(sides==3){
                polyname = "Triangle";
            }
        else if(sides==4){
                polyname = "Square";
            }
        else if(sides==2){
                polyname = "Just a Line";
            }
        else if(sides==0){
                polyname = "Nothing";
            }
        else if(sides==1){
                polyname = "Not a polygon";
            }
            else if(sides==5){
                polyname = "Pentagon";
            }
            else if(sides==6){
                polyname = "Hexagon";
            }
            else if(sides==7){
                polyname = "Heptagon";
            }
            else if(sides==8){
                polyname = "Octagon";
            }
            else if(sides==9){
                polyname = "Nonagon";
            }
            else if(sides==10){
                polyname = "Decagon";
            }
            else if(sides==11){
                polyname = "Hendecagon";
            }
            else if(sides==12){
                polyname = "Dodecagon";
            }
            else if(sides >= 13) {
                 polyname = (String)(sides+"-gon");   
            }
            else{
                polyname = "";
            }
            return polyname;
    }
    public int[] calculate(){
        val = new int[3]; 
        System.out.println("INTERIOR AND EXTERIOR ANGLES, AND DIAGONALS OF A REGULAR POLYGON");
        num = sides;
        System.out.print("\n\nInput number of sides of the polygon:");
        ea = 360/num;
        ia_sum = (num-2)*180;
        ia = ia_sum/num; 
        dia = (num*(num-3))/2;
        if (num<=2) {
            ia = 0;
            ea = 0;
            dia = 0;
        }
        val[0] = (int) ia;
        val[1] = (int) ea;
        val[2] = dia;
        System.out.print("\n   Interior angle: " + ia);
        System.out.print("\n   E(exterior angle) = " + ea);
        System.out.print("\n   d(diagonal) = " + dia );
        return val;
        }
    public boolean draw(int ck) {
       if (ck == 0) {
           mk = false;
       }
       else if (ck == 1) {
           mk = true;
       }

       return mk;
        
    }
    
    public void reset() {
        
        this.sides = 0;
        sides = 0;
        this.length = 0;
        this.thick = 0;
        this.rot = 0;
        s = 0;
    
    
    
}

    Field[] getDeclaredFields() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
