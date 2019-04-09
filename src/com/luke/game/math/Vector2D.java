
package com.luke.game.math;
/**
* This is a class to represent a 2D vector for displacement of objects.
* @author Luke Maher
*
*/
public class Vector2D {
    /** The x position on the screen of the normalized vector (x,y) */
    private int x;
    /** The y position on the screen of the normalize vector (x,y) */
    private int y;
    
    /** This creates a vector setting the (x,y) position
    * to the values provided.
    *
    * @param i the x position of the normalized vector (x,y)
    * @param j the y position of the normalized vector (x,y)
    */
   
    public Vector2D(int i, int j){
        x = i;
        y =j;  
    }   
     
    public int getX(){
        return x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return y; 
    }
    
    public void setY(int y){ 
        this.y = y; 
    }
    
    /**
    * Adds the vector components provided to the current vector
    *
    * @param vector2 a normalized vector to be added
    */
    public void add(Vector2D vector2){
        x = x + vector2.getX();
        y = y + vector2.getY();
    }
    
    /**
    * Multiplies each component of the vector by the provided argument
    *
    * @param i
    */
    public void multiply(int i){
        x *= i;
        y *= i;
    }
    
}
