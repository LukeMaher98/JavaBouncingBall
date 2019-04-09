package com.luke.game.main;

import javax.swing.*;
import java.awt.*;
import com.luke.game.entities.*;
import com.luke.game.math.*;

public class GamePanel extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    /** The screen WIDTH of the drawing panel */
    public static final int WIDTH = 1280;
    /** The screen HEIGHT of the drawing panel */
    public static final int HEIGHT = 720;
    /** The ball object we will move around on the screen */
    private Ball ball;
    /** The game thread that represents our game loop */
    private Thread thread;
    /** A boolean value indicating that our game is running */
    private boolean running;
    /** The number of frames per second we want the game to run in */
    private int FPS = 60;
    /** The time slice that should elapse before we update the screen */
    private long targetTime = 1000/FPS;

    public GamePanel() {
            super();
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            setFocusable(true);
            requestFocus();
    }
    
    /** This is invoked automatically but the AWT framework when our component
 the GamePanel is added to the screen. We tap into this method in order to
    * start up our game loop in its own thread.
    */
    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
        running = true;
    } 
    /** Initializes our game object - the ball and sets it's initial
    * direction and speed on the screen.
    */
    public void init(){
        ball = new Ball(100, 100, 10);
        Vector2D displacement = new Vector2D(2, 3);
        ball.setDisplacement(displacement);
    }
    /** Updates the ball's position. This should be called for every frame
    * or at least 60 times per second.
    */
    public void update(){
        ball.update();
    }
    /** Updates the game objects */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(ball != null){
            ball.draw((Graphics2D)g);
        }
    }
    /** The game loop:
    * This is simple game loop that only:
    * - updates the game world
    * - renders the screen (indirectly by requesting a repaint)
    *
    */
    @Override
    public void run(){
        init();
        long start;
        long elapsed;
        long wait;
        while(running){
            start = System.nanoTime();
            update();  
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            if(wait < 0){
                wait = 5;
            }
            try {
                Thread.sleep(wait);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            repaint();
        }
    }
}
