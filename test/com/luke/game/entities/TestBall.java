package com.luke.game.entities;

import java.io.*;
import org.junit.*;
import com.luke.game.main.*;
import com.luke.game.math.*;
import static org.junit.Assert.*;

public class TestBall {
    
    @Test
    public void testConstructor(){
        Ball ball = new Ball(100, 100, 50);
        assertTrue(ball.getX() == 100);
        assertTrue(ball.getY() == 100);
    }
    
    @Test
    public void moveBall(){
        Ball ball = new Ball(100, 100, 50);
        Vector2D displacement = new Vector2D(2, 3);
        ball.setDisplacement(displacement);
        ball.update();
        assertTrue(ball.getX() == 102);
        assertTrue(ball.getY() == 103);
    }
    
    @Test
    public void moveBallOffRightScreen(){
        Ball ball = new Ball(1229, 100, 50);
        Vector2D displacement = new Vector2D(2, 3);
        ball.setDisplacement(displacement);
        ball.update();
        assertTrue(ball.getX() == GamePanel.WIDTH - ((2 * ball.getRadius()) - 1));
        assertTrue(ball.getX() == 103);
        assertTrue(ball.getDisplacement().getX() > 0);
    }
    
    @Test
    public void moveBallOffLeftScreen(){
        Ball ball = new Ball(1, 100, 50);
        Vector2D displacement = new Vector2D(-2, 3);
        ball.setDisplacement(displacement);
        ball.update();
        assertTrue(ball.getX() == 0);
        assertTrue(ball.getY() == 103);
        assertTrue(ball.getDisplacement().getX() > 0);
    }
    
    @Test
    public void moveBallOffTopScreen(){
        Ball ball = new Ball(200, 0, 50);
        Vector2D displacement = new Vector2D(2, -3);
        ball.setDisplacement(displacement);
        ball.update();
        assertTrue(ball.getY() == 0);
        assertTrue(ball.getX() == 202);
        assertTrue(ball.getDisplacement().getY() > 0);
    }
    
    @Test
    public void moveBallOffBottomScreenm(){
        Ball ball = new Ball(200, 668, 50);
        Vector2D displacement = new Vector2D(2, 3);
        ball.setDisplacement(displacement);
        ball.update();
        assertTrue(ball.getY() == GamePanel.HEIGHT - ((ball.getRadius() * 2) - 1));
        assertTrue(ball.getX() == 202);
        assertTrue(ball.getDisplacement().getY() < 0);
    }
    
}
