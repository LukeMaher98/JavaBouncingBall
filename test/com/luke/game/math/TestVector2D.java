package com.luke.game.math;

import org.junit.*;
import static org.junit.Assert.*;

public class TestVector2D {
    
    @Test
    public void testConstructor(){
        Vector2D displacement = new Vector2D(2, 3);
        assertTrue(displacement.getX() == 2);
        assertTrue(displacement.getY() == 3);
    }
    
    @Test
    public void testAdd(){
        Vector2D displacement = new Vector2D(2, 3);
        Vector2D vector2 = new Vector2D(-1, -1);
        displacement.add(vector2);
        assertTrue(displacement.getX() == 1);
        assertTrue(displacement.getY() == 2);
    }
    
    @Test
    public void testMuliply(){
        Vector2D displacement =  new Vector2D(2, 3);
        displacement.multiply(-1);
        assertTrue(displacement.getX() == -2);
        assertTrue(displacement.getY() == -3);
    }
    
}
