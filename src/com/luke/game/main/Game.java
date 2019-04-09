package com.luke.game.main;

import javax.swing.*;

/**
* This class is the application's main window it creates a JFrame window
* and populates it with the GamePanel.
*
* @author Luke Maher
*
*/
public class Game {

	public static void main(String args[]) {
		JFrame window = new JFrame("Bouncing Ball");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
}
