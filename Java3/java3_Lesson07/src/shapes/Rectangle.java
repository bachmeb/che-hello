package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    private Color fillColor;
    private int width, height;
    private boolean fill;
  
    public Rectangle(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill) {
        super(x, y, lineColor);
        this.width = w;
        this.height = h;
        this.fillColor = fillColor;
        this.fill = fill;
    }
  
    public void draw(Graphics g) {
        // Be nice. Save the state of the object before changing it.
        Color oldColor = g.getColor();
        if (isFill()) {
            g.setColor(getFillColor());
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
        g.setColor(getLineColor());
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        // Set the state back when done.
        g.setColor(oldColor);
    }
  
    // Override abstract method containsLocation in the Shape class.
    public boolean containsLocation(int x, int y) {
        if (getX() <= x && getY() <= y && getX() + getWidth() >= x && getY() + getHeight() >= y) {
            return true;
        }
        return false;
    }
    
    // Getters and setters.
    public Color getFillColor() {
        return fillColor;
    }
    
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setFill(boolean fill) {
        this.fill = fill;
    }
    
    public boolean isFill() {
        return fill;
    }
    
    /**
    * Returns a String representing this object.
    */
    public String toString() {
        return "Rectangle: \n\tx = " + getX() + "\n\ty = " + getY() + 
               "\n\tw = " + getWidth() + "\n\th = " + getHeight();
    }
}