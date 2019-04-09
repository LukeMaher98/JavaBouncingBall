
package com.luke.game.entities;

import java.awt.*;
import com.luke.game.main.*;
import com.luke.game.math.*;

/**
* This class represents a small ball that moves across the screen.
* @author Luke Maher
*
*/
public class Ball {
    /**
    * The ball's top-left position on the screen. The class uses the
 GamePanel.WIDTH and GamePanel.HEIGHT for the dimensions of the screen
    */
    private Point point;
    /**
    * The radius of the ball in pixels
    */
    private int radius;
    /**
    * The vector displacement indicating the speed and direction of the ball.
    */
    private Vector2D displacement;
    /**
    * Creates a Ball object located at position (x,y) on the screen.
    * The ball's radius is set to r pixels.
    *
    * @param x The left position on the screen ranging from
    0..GamePanel.WIDTH
    * @param y The top position on the screen ranging from
    0..GamePanel.HEIGHT
    * @param r The radius of the ball. The ball will reside in a
    rectangle of  width 2 * r
    */
    public Ball(int x, int y, int r){
        point = new Point();
        point.x = x;
        point.y = y;
        radius = r;
    }
    /**
    * Returns the x position or left-most position of the ball on the screen.
    * @return the x position
    */
    public int getX(){
        return point.x;
    }
    /**
    * Returns the y position or top-most position of the ball on the screen.
    * @return the y position
    */
    public int getY(){
        return point.y;
    }
    
    public void setX(int x){
        point.x = x;
    }
    
    public void setY(int y){
        point.y = y;
    }
    
    public int getRadius(){
        return radius;
    }
    
    public void setRadius(int r){
        this.radius = r;
    }
    
    public Vector2D getDisplacement(){
        return displacement;
    }
    
    public void setDisplacement(Vector2D d){
        this.displacement = d;
    }
    /** We update the ball's centerPoint position to always remain on the screen
    from x ranges from 0..GamePanel.WIDTH-BALL RADIUS-1
    and y ranges from 0..GamePanel.HEIGHT-BALL RADIUS-1
    */
    public void update(){
        point.x += displacement.getX();
        point.y += displacement.getY();
        
        if(getX() < 0){
            setX(0);
            displacement.setX(-displacement.getX());
        }
        
        if(getX() > GamePanel.WIDTH - ((2 * radius) - 1)){
            setX(GamePanel.WIDTH - ((2 * radius) - 1));
            displacement.setX(-displacement.getX());
        }
        
        if(getY() < 0){
            setY(0);
            displacement.setY(-displacement.getY());
        }
        
        if(getY() > GamePanel.HEIGHT - ((2 * radius) - 1)){
            setY(GamePanel.HEIGHT - ((2 * radius) - 1));
            displacement.setY(-displacement.getY());
        }
    }
    /**
    * Draws the ball on the screen and a Ball Position message
    * @param g graphics object for drawing
    */
    public void draw(Graphics2D g){
        g.setColor(Color.BLUE);
        g.fillOval(getX(), getY(), getRadius() * 2, getRadius() * 2);
        g.setColor(Color.BLACK);
        g.drawString("Ball Position: )" + getX() + "," + getY() + ")", 1140, 1100);
    }
}
